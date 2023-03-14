package com.ruoyi.develop.mapper;

import com.ruoyi.develop.domain.MedicineHelper;

import java.util.List;

/**
 * 帮助记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
public interface MedicineHelperMapper 
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
     * 删除帮助记录
     * 
     * @param id 帮助记录ID
     * @return 结果
     */
    public int deleteMedicineHelperById(String id);

    /**
     * 批量删除帮助记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMedicineHelperByIds(String[] ids);

    List<MedicineHelper> selectMedicineSeekerList(MedicineHelper medicineHelper);
}
