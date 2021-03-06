package com.cwb.platform.biz.mapper;

import com.cwb.platform.biz.model.BizWj;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BizWjMapper extends Mapper<BizWj> {
    @Select({ "<script> " +
    " INSERT INTO gxxc.biz_wj (ID, YH_ID, WJ_TPDZ, WJ_SX, WJ_SBZT, WJ_BW, CJSJ, WJ_SFYX) VALUES  "+
    " <foreach collection='list' item='item' open='(' close=')' separator='),('> " +
    "  #{item.id} ,#{item.yhId} ,#{item.wjTpdz} ,#{item.wjSx} ,#{item.wjSbzt} ,'' ,#{item.cjsj} ,#{item.wjSfyx} " +
    " </foreach> " +
    " </script>"})
    void insertBatch(@Param("list") List<BizWj> list);

    @Delete("<script>" +
            "DELETE FROM BIZ_WJ WHERE YH_ID = #{yhId} AND WJ_SX IN " +
            " <foreach collection='list' item='item' open='(' close=')' separator=','> " +
            "  #{item} " +
            " </foreach> " +
            "</script>")
    void deleteBatch(@Param("yhId") String yhId, @Param("list") List<String> list);

}
