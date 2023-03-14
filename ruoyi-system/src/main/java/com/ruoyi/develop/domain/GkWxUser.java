package com.ruoyi.develop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 gk_wx_user
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
public class GkWxUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** OPEN_ID */
    private String openId;

    /** SESSION_KEY */
    private String sessionKey;

    /** 头像 */
    private String avatarUrl;

    /** 城市 */
    private String city;

    /** 国家 */
    private String country;

    /** 性别 */
    private String gender;

    /** 语言 */
    private String language;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 真实姓名 */
    private String realName;

    /** 省份 */
    private String province;

    /** STU_ID */
    private Long stuId;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** ID */
    @Excel(name = "ID")
    private String id;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechatNum;

    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setSessionKey(String sessionKey) 
    {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() 
    {
        return sessionKey;
    }
    public void setAvatarUrl(String avatarUrl) 
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() 
    {
        return avatarUrl;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setLanguage(String language) 
    {
        this.language = language;
    }

    public String getLanguage() 
    {
        return language;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setStuId(Long stuId) 
    {
        this.stuId = stuId;
    }

    public Long getStuId() 
    {
        return stuId;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setWechatNum(String wechatNum) 
    {
        this.wechatNum = wechatNum;
    }

    public String getWechatNum() 
    {
        return wechatNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("openId", getOpenId())
            .append("sessionKey", getSessionKey())
            .append("avatarUrl", getAvatarUrl())
            .append("city", getCity())
            .append("country", getCountry())
            .append("gender", getGender())
            .append("language", getLanguage())
            .append("nickName", getNickName())
            .append("realName", getRealName())
            .append("province", getProvince())
            .append("stuId", getStuId())
            .append("phone", getPhone())
            .append("id", getId())
            .append("wechatNum", getWechatNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
