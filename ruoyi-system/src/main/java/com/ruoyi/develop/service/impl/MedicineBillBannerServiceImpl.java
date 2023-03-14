package com.ruoyi.develop.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.develop.domain.MedicineBillBanner;
import com.ruoyi.develop.mapper.MedicineBillBannerMapper;
import com.ruoyi.develop.service.IMedicineBillBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 海报与Banner信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-13
 */
@Service
public class MedicineBillBannerServiceImpl implements IMedicineBillBannerService
{
    @Autowired
    private MedicineBillBannerMapper medicineBillBannerMapper;

    @Value("${image.path}")
    private String path;

    @Value("${image.location}")
    private String location;

    /**
     * 查询海报与Banner信息
     * 
     * @param id 海报与Banner信息ID
     * @return 海报与Banner信息
     */
    @Override
    public MedicineBillBanner selectMedicineBillBannerById(String id)
    {
        return medicineBillBannerMapper.selectMedicineBillBannerById(id);
    }

    /**
     * 查询海报与Banner信息列表
     * 
     * @param medicineBillBanner 海报与Banner信息
     * @return 海报与Banner信息
     */
    @Override
    public List<MedicineBillBanner> selectMedicineBillBannerList(MedicineBillBanner medicineBillBanner)
    {
        return medicineBillBannerMapper.selectMedicineBillBannerList(medicineBillBanner);
    }

    /**
     * 新增海报与Banner信息
     * 
     * @param medicineBillBanner 海报与Banner信息
     * @return 结果
     */
    @Override
    public int insertMedicineBillBanner(MedicineBillBanner medicineBillBanner)
    {
        medicineBillBanner.setCreateTime(DateUtils.getNowDate());
        return medicineBillBannerMapper.insertMedicineBillBanner(medicineBillBanner);
    }

    /**
     * 修改海报与Banner信息
     * 
     * @param medicineBillBanner 海报与Banner信息
     * @return 结果
     */
    @Override
    public int updateMedicineBillBanner(MedicineBillBanner medicineBillBanner)
    {
        medicineBillBanner.setUpdateTime(DateUtils.getNowDate());
        return medicineBillBannerMapper.updateMedicineBillBanner(medicineBillBanner);
    }

    /**
     * 删除海报与Banner信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMedicineBillBannerByIds(String ids)
    {
        return medicineBillBannerMapper.deleteMedicineBillBannerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除海报与Banner信息信息
     * 
     * @param id 海报与Banner信息ID
     * @return 结果
     */
    @Override
    public int deleteMedicineBillBannerById(String id)
    {
        return medicineBillBannerMapper.deleteMedicineBillBannerById(id);
    }

    @Override
    public String uploadImage(MultipartFile uploadFile) {
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //如果这个文件夹不存在的话,就创建这个文件
            file.mkdirs();
        }
        //获取上传文件名称
        String filename = uploadFile.getOriginalFilename();
        //把文件名称设置成唯一值 uuid 以防止文件名相同覆盖
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //新文件名
        filename = uuid + "_" + filename;
        System.out.println(filename);
        //完成文件上传
        try {
            uploadFile.transferTo(new File(path, filename));

        }catch (Exception e){

        }
        String filePath = location + filename;
        return filePath;
    }

    @Override
    public void commit(String url) {
        MedicineBillBanner medicineBillBanner = new MedicineBillBanner();
        medicineBillBanner.setFileName(url.substring(url.lastIndexOf("/"),url.length()));
        medicineBillBanner.setStatus("YES");
        medicineBillBanner.setId(UUID.randomUUID().toString().replace("-", ""));
        medicineBillBanner.setFilePath(url);
        medicineBillBanner.setFileType("BANNER");
        medicineBillBanner.setCreateTime(new Date());
        medicineBillBanner.setUpdateTime(new Date());
        MedicineBillBanner oldMedicineBillBanner = new MedicineBillBanner();
        oldMedicineBillBanner.setStatus("NO");
        oldMedicineBillBanner.setFileType("BANNER");
        medicineBillBannerMapper.updateMedicineBillBanner(oldMedicineBillBanner);
        medicineBillBannerMapper.insertMedicineBillBanner(medicineBillBanner);
    }

    @Override
    public void commitBill(String url) {
        MedicineBillBanner medicineBillBanner = new MedicineBillBanner();
        medicineBillBanner.setFileName(url.substring(url.lastIndexOf("/"),url.length()));
        medicineBillBanner.setStatus("YES");
        medicineBillBanner.setId(UUID.randomUUID().toString().replace("-", ""));
        medicineBillBanner.setFilePath(url);
        medicineBillBanner.setFileType("BILL");
        medicineBillBanner.setCreateTime(new Date());
        medicineBillBanner.setUpdateTime(new Date());
        MedicineBillBanner oldMedicineBillBanner = new MedicineBillBanner();
        oldMedicineBillBanner.setStatus("NO");
        oldMedicineBillBanner.setFileType("BILL");
        medicineBillBannerMapper.updateMedicineBillBanner(oldMedicineBillBanner);
        medicineBillBannerMapper.insertMedicineBillBanner(medicineBillBanner);
    }

    @Override
    public MedicineBillBanner getBanner() {
       return medicineBillBannerMapper.getBanner();
    }

    @Override
    public MedicineBillBanner getBill() {
        return medicineBillBannerMapper.getBill();    }
}
