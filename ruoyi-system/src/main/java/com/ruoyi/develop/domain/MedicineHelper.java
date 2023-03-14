package com.ruoyi.develop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 帮助记录对象 medicine_helper
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
public class MedicineHelper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private String id;

    /** 帮助者/求助者 */
    @Excel(name = "帮助者/求助者")
    private String helperName;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechatNum;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 所需药品 */
    @Excel(name = "所需药品")
    private String medicineName;

    /** 地址 */
    private String address;

    /** 求助/帮助状态 */
    @Excel(name = "求助/帮助状态")
    private String status;

    /** 求助/帮助信息 */
    private String message;

    /** 求助/帮助者ID */
    private String helperId;

    /** 药物来源 */
    private String medicineSource;

    /** 药物图片&证明 */
    private String medicineImages;

    /** 求助/帮助 */
    private String type;

    /** 经 */
    private String longitude;

    /** 纬 */
    private String latitude;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setHelperName(String helperName) 
    {
        this.helperName = helperName;
    }

    public String getHelperName() 
    {
        return helperName;
    }
    public void setWechatNum(String wechatNum) 
    {
        this.wechatNum = wechatNum;
    }

    public String getWechatNum() 
    {
        return wechatNum;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setMedicineName(String medicineName) 
    {
        this.medicineName = medicineName;
    }

    public String getMedicineName() 
    {
        return medicineName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setHelperId(String helperId) 
    {
        this.helperId = helperId;
    }

    public String getHelperId() 
    {
        return helperId;
    }
    public void setMedicineSource(String medicineSource) 
    {
        this.medicineSource = medicineSource;
    }

    public String getMedicineSource() 
    {
        return medicineSource;
    }
    public void setMedicineImages(String medicineImages) 
    {
        this.medicineImages = medicineImages;
    }

    public String getMedicineImages() 
    {
        return medicineImages;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("helperName", getHelperName())
            .append("wechatNum", getWechatNum())
            .append("phone", getPhone())
            .append("medicineName", getMedicineName())
            .append("address", getAddress())
            .append("status", getStatus())
            .append("message", getMessage())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("helperId", getHelperId())
            .append("medicineSource", getMedicineSource())
            .append("medicineImages", getMedicineImages())
            .append("type", getType())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .toString();
    }
}
