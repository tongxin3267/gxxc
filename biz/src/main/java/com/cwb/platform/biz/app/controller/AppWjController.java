package com.cwb.platform.biz.app.controller;

import com.cwb.platform.biz.app.AppUserBaseController;
import com.cwb.platform.biz.model.BizWj;
import com.cwb.platform.biz.service.PtyhService;
import com.cwb.platform.biz.service.WjService;
import com.cwb.platform.sys.model.BizPtyh;
import com.cwb.platform.util.bean.ApiResponse;
import com.cwb.platform.util.commonUtil.SnowflakeIdWorker;
import com.cwb.platform.util.exception.RuntimeCheck;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/wj")
public class AppWjController extends AppUserBaseController {
    @Autowired
    private WjService service;
    @Autowired
    private PtyhService ptyhService;
    //证件上传地址
    @Value("${credentialsPath}")
    private String credentialsPath;
    @Autowired
    private StringRedisTemplate redisDao;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;


    @PostMapping("/uploadWj")
    public ApiResponse<String> uploadWj(@RequestParam("file") MultipartFile file, String  userId){
        RuntimeCheck.ifBlank(userId, "请上传用户id");
        //  上传学生证
        String fileName = DateTime.now().toString("yyyy-MM-dd") + "/" +  userId  + "-"  + file.getOriginalFilename();
        try {
            InputStream stream = file.getInputStream();
            FileUtils.copyInputStreamToFile(stream, new File(fileName));
            BizWj bizWj = new BizWj();
            bizWj.setId(snowflakeIdWorker.nextId() + "");
            bizWj.setCjsj(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
            bizWj.setWjTpdz(fileName);
            bizWj.setWjSx("31");
            service.save(bizWj);
        } catch (IOException e) {
            RuntimeCheck.ifTrue(true, "文件上传失败");
        }
        return  ApiResponse.success();
    }

    /**
     * 根据对象字段值查询数据
     * @return
     */
    @RequestMapping(value="/getCondition", method={RequestMethod.POST})
    public ApiResponse<List<Boolean>> getCondition(){
        BizPtyh bizPtyh= getAppCurrentUser();

        List<Boolean> retlise=new ArrayList<Boolean>();

        BizPtyh ptyh= ptyhService.findById(bizPtyh.getId());
        String yhZt=ptyh.getYhZt();
        if(StringUtils.equals("2",yhZt)){
            retlise.add(false);
            retlise.add(false);
            retlise.add(false);
            retlise.add(false);
            return ApiResponse.success(retlise);
        }
        RuntimeCheck.ifNull(ptyh,"当前登录用户未空！");
        BizWj entity=new BizWj();
        entity.setYhId(bizPtyh.getId());
        entity.setWjSfyx("1");
        List<BizWj> list=service.findByEntity(entity);
        Map<String,String> bizWjMap=new HashMap<String,String>();

        if(list!=null&&list.size()>0){
            for(BizWj l:list){
                l.setWjTpdz("");//将文件地址给去掉
                String wjSxKey=l.getWjSx();//文件属性 10、 身份证正面 11、 身份证反面  20、 驾照正面 21、 驾照背面
                if(StringUtils.equals(l.getWjSx(),"10")){
                    wjSxKey="0";
                }else if(StringUtils.equals(l.getWjSx(),"11")){
                    wjSxKey="1";
                }else if(StringUtils.equals(l.getWjSx(),"20")){
                    wjSxKey="2";
                }else if(StringUtils.equals(l.getWjSx(),"21")){
                    wjSxKey="3";
                }
                bizWjMap.put(wjSxKey,l.getWjSx());
            }
        }
        for(int i=0;i<4;i++){
            String wjsx=bizWjMap.get(i+"");
            Boolean wjzt=false;
            if(StringUtils.isNotEmpty(wjsx)){
                wjzt=true;
            }
            retlise.add(wjzt);
        }
        return ApiResponse.success(retlise);
    }

    @RequestMapping(value="zjck", method={RequestMethod.GET}, produces={MediaType.IMAGE_JPEG_VALUE})
    public void fileDownload(HttpServletResponse response,@RequestParam(name = "fileType") String fileType){
        BizPtyh bizPtyh= getAppCurrentUser();
        String path = "";
        if(!StringUtils.equals(bizPtyh.getYhZt(),"1")){
            path =  credentialsPath+redisDao.boundValueOps("zjupload_"+bizPtyh.getId()+"_"+fileType).get();
            path=path.replaceAll("//","/");
        }else{
            BizWj bizWj=new BizWj();
            bizWj.setYhId(bizPtyh.getId());
            bizWj.setWjSx(fileType);
            List<BizWj> list=service.findByEntity(bizWj);
            if(list!=null&&list.size()>0){
                path=credentialsPath+list.get(0).getWjTpdz();
            }
        }
        System.out.println("path:"+path);

        //获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
        if(StringUtils.isNotEmpty(path)){
            ServletOutputStream out=null;
            FileInputStream inputStream=null;
            //通过文件路径获得File对象(假如此路径中有一个 zms.jpg 文件)
            File file = new File(path );
            try {
                inputStream  = new FileInputStream(file);
                //3.通过response获取ServletOutputStream对象(out)
                out = response.getOutputStream();
                int b = 0;
                byte[] buffer = new byte[512];
                while (b != -1){
                    b = inputStream.read(buffer);
                    if(b != -1){
                        out.write(buffer,0,b);//4.写到输出流(out)中
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                try{
                    if(inputStream!=null){
                        inputStream.close();
                    }
                    if(out!=null){
                        out.close();
                        out.flush();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
