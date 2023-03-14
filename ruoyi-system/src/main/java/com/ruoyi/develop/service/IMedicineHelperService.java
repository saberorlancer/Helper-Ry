package com.ruoyi.develop.service;

import com.ruoyi.develop.domain.MedicineHelper;

import java.util.List;

/**
 * 帮助记录Service接口
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
public interface IMedicineHelperService 
{
    /**
     * 查询帮助记录
     * 
     * @param id 帮助记录ID
     * @return 帮助记录
     */
    public MedicineHelper selectMedicineHelperById(String id);

    /**
     * 查询帮助记录列表
     * 
     * @param medicineHelper 帮助记录
     * @return 帮助记录集合
     */
    public List<MedicineHelper> selectMedicineHelperList(MedicineHelper medicineHelper);

    /**
     * 查询帮助记录列表
     *
     * @param medicineHelper 帮助记录
     * @return 帮助记录集合
     */
    public List<MedicineHelper> selectMedicineSeekerList(MedicineHelper medicineHelper);

    /**
     * 新增帮助记录
     * 
     * @param medicineHelper 帮助记录
     * @return 结果
     */
    public int insertMedicineHelper(MedicineHelper medicineHelper);

    /**
     * 修改帮助记录
     * 
     * @param medicineHelper 帮助记录
     * @return 结果
     */
    public int updateMedicineHelper(MedicineHelper medicineHelper);

    /**
     * 批量删除帮助记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMedicineHelperByIds(String ids);

    /**
     * 删除帮助记录信息
     * 
     * @param id 帮助记录ID
     * @return 结果
     */
    public int deleteMedicineHelperById(String id);
}
