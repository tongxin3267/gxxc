package com.cwb.platform.biz.model;

import com.cwb.platform.sys.model.BizPtyh;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 用户实名制表
 */
@Table(name = "biz_user")
public class BizUser implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "YH_ID")
    private String yhId;

    /**
     * 身份证号
     */
    @Column(name = "YH_ZJHM")
    private String yhZjhm;

    /**
     * 手机号
     */
    @Column(name = "YH_SJHM")
    private String yhSjhm;

    /**
     * 是否有驾驶证(1:有 2:没有)
     */
    @Column(name = "YH_SFJSZ")
    private String yhSfjsz;

    /**
     * 姓名
     */
    @Column(name = "YH_XM")
    private String yhXm;

    /**
     * 创建时间
     */
    @Column(name = "CJSJ")
    private String cjsj;

    /**
     * 上级ID
     */
    @Column(name = "YH_SJID")
    private String yhSjid;

    /**
     * 上上级ID
     */
    @Column(name = "YH_SSJID")
    private String yhSsjid;

    /**
     * 用户等级
     * 1、一级用户   2、二级用户
     */
    @Transient
    private String userGrade;
    /**
     * 用户信息
     */
    @Transient
    private BizPtyh userDetail;


    private static final long serialVersionUID = 1L;

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public BizPtyh getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(BizPtyh userDetail) {
        this.userDetail = userDetail;
    }

    /**
     * 获取用户id
     *
     * @return YH_ID - 用户id
     */
    public String getYhId() {
        return yhId;
    }

    /**
     * 设置用户id
     *
     * @param yhId 用户id
     */
    public void setYhId(String yhId) {
        this.yhId = yhId;
    }

    /**
     * 获取身份证号
     *
     * @return YH_ZJHM - 身份证号
     */
    public String getYhZjhm() {
        return yhZjhm;
    }

    /**
     * 设置身份证号
     *
     * @param yhZjhm 身份证号
     */
    public void setYhZjhm(String yhZjhm) {
        this.yhZjhm = yhZjhm;
    }

    /**
     * 获取手机号
     *
     * @return YH_SJHM - 手机号
     */
    public String getYhSjhm() {
        return yhSjhm;
    }

    /**
     * 设置手机号
     *
     * @param yhSjhm 手机号
     */
    public void setYhSjhm(String yhSjhm) {
        this.yhSjhm = yhSjhm;
    }

    /**
     * 获取是否有驾驶证(1:有 2:没有)
     *
     * @return YH_SFJSZ - 是否有驾驶证(1:有 2:没有)
     */
    public String getYhSfjsz() {
        return yhSfjsz;
    }

    /**
     * 设置是否有驾驶证(1:有 2:没有)
     *
     * @param yhSfjsz 是否有驾驶证(1:有 2:没有)
     */
    public void setYhSfjsz(String yhSfjsz) {
        this.yhSfjsz = yhSfjsz;
    }

    /**
     * 获取姓名
     *
     * @return YH_XM - 姓名
     */
    public String getYhXm() {
        return yhXm;
    }

    /**
     * 设置姓名
     *
     * @param yhXm 姓名
     */
    public void setYhXm(String yhXm) {
        this.yhXm = yhXm;
    }

    /**
     * 获取创建时间
     *
     * @return CJSJ - 创建时间
     */
    public String getCjsj() {
        return cjsj;
    }

    /**
     * 设置创建时间
     *
     * @param cjsj 创建时间
     */
    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    /**
     * 获取上级ID
     *
     * @return YH_SJID - 上级ID
     */
    public String getYhSjid() {
        return yhSjid;
    }

    /**
     * 设置上级ID
     *
     * @param yhSjid 上级ID
     */
    public void setYhSjid(String yhSjid) {
        this.yhSjid = yhSjid;
    }

    /**
     * 获取上上级ID
     *
     * @return YH_SSJID - 上上级ID
     */
    public String getYhSsjid() {
        return yhSsjid;
    }

    /**
     * 设置上上级ID
     *
     * @param yhSsjid 上上级ID
     */
    public void setYhSsjid(String yhSsjid) {
        this.yhSsjid = yhSsjid;
    }

    public enum InnerColumn {
        yhId("YH_ID"),
        yhZjhm("YH_ZJHM"),
        yhSjhm("YH_SJHM"),
        yhSfjsz("YH_SFJSZ"),
        yhXm("YH_XM"),
        cjsj("CJSJ"),
        yhSjid("YH_SJID"),
        yhSsjid("YH_SSJID");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        InnerColumn(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}