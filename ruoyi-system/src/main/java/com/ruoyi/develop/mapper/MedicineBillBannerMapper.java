package com.ruoyi.develop.mapper;

import com.ruoyi.develop.domain.MedicineBillBanner;

import java.util.List;

/**
 * 海报与Banner信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-13
 */
public interface MedicineBillBannerMapper 
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
     * 删除海报与Banner信息
     * 
     * @param id 海报与Banner信息ID
     * @return 结果
     */
    public int deleteMedicineBillBannerById(String id);

    /**
     * 批量删除海报与Banner信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMedicineBillBannerByIds(String[] ids);

    MedicineBillBanner getBanner();

    MedicineBillBanner getBill();
}
