package com.ruoyi.develop.service;

import com.ruoyi.develop.domain.MedicineBillBanner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 海报与Banner信息Service接口
 * 
 * @author ruoyi
 * @date 2023-03-13
 */
public interface IMedicineBillBannerService 
{
    /**
     * 查询海报与Banner信息
     * 
     * @param id 海报与Banner信息ID
     * @return 海报与Banner信息
     */
    public MedicineBillBanner selectMedicineBillBannerById(String id);

    /**
     * 查询海报与Banner信息列表
     * 
     * @param medicineBillBanner 海报与Banner信息
     * @return 海报与Banner信息集合
     */
    public List<MedicineBillBanner> selectMedicineBillBannerList(MedicineBillBanner medicineBillBanner);

    /**
     * 新增海报与Banner信息
     * 
     * @param medicineBillBanner 海报与Banner信息
     * @return 结果
     */
    public int insertMedicineBillBanner(MedicineBillBanner medicineBillBanner);

    /**
     * 修改海报与Banner信息
     * 
     * @param medicineBillBanner 海报与Banner信息
     * @return 结果
     */
    public int updateMedicineBillBanner(MedicineBillBanner medicineBillBanner);

    /**
     * 批量删除海报与Banner信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMedicineBillBannerByIds(String ids);

    /**
     * 删除海报与Banner信息信息
     * 
     * @param id 海报与Banner信息ID
     * @return 结果
     */
    public int deleteMedicineBillBannerById(String id);

    String uploadImage(MultipartFile file);

    void commit(String url);

    void commitBill(String url);

    MedicineBillBanner getBanner();

    MedicineBillBanner getBill();
}
