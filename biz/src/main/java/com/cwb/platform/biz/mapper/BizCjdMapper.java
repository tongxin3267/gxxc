package com.cwb.platform.biz.mapper;

import com.cwb.platform.biz.model.BizCjd;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface BizCjdMapper extends Mapper<BizCjd> {
    @Update("<script>" +
            " UPDATE BIZ_USER " +
            " SET XY_ZT = (SELECT CASE LENGTH(group_concat(KM_BM)) WHEN 7 THEN '0' ELSE group_concat(KM_BM) END as ssva FROM biz_cjd WHERE XY_SFHG='1' AND XY_ID =#{yhid} group by XY_ID) " +
            " WHERE YH_ID = #{yhid} " +
            "</script>")
    void updateBizUserZt(String yhid);
}