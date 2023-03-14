package com.ruoyi.develop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 海报与Banner信息对象 medicine_bill_banner
 * 
 * @author ruoyi
 * @date 2023-03-13
 */
public class MedicineBillBanner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 文件目录 */
    @Excel(name = "文件目录")
    private String filePath;

    /** 上传人 */
    @Excel(name = "上传人")
    private String uploader;

    /** 是否生效 */
    @Excel(name = "是否生效")
    private String status;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setUploader(String uploader) 
    {
        this.uploader = uploader;
    }

    public String getUploader() 
    {
        return uploader;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("fileType", getFileType())
            .append("filePath", getFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("uploader", getUploader())
            .append("status", getStatus())
            .toString();
    }
}
