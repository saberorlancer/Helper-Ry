package com.ruoyi.develop.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.develop.domain.MedicineHelper;
import com.ruoyi.develop.mapper.MedicineHelperMapper;
import com.ruoyi.develop.service.IMedicineHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 帮助记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
@Service
public class MedicineHelperServiceImpl implements IMedicineHelperService
{
    @Autowired
    private MedicineHelperMapper medicineHelperMapper;

    /**
     * 查询帮助记录
     * 
     * @param id 帮助记录ID
     * @return 帮助记录
     */
    @Override
    public MedicineHelper selectMedicineHelperById(String id)
    {
        return medicineHelperMapper.selectMedicineHelperById(id);
    }

    /**
     * 查询帮助记录列表
     * 
     * @param medicineHelper 帮助记录
     * @return 帮助记录
     */
    @Override
    public List<MedicineHelper> selectMedicineHelperList(MedicineHelper medicineHelper)
    {
        return medicineHelperMapper.selectMedicineHelperList(medicineHelper);
    }

    @Override
    public List<MedicineHelper> selectMedicineSeekerList(MedicineHelper medicineHelper) {
        return medicineHelperMapper.selectMedicineSeekerList(medicineHelper);
    }

    /**
     * 新增帮助记录
     * 
     * @param medicineHelper 帮助记录
     * @return 结果
     */
    @Override
    public int insertMedicineHelper(MedicineHelper medicineHelper)
    {
        medicineHelper.setCreateTime(DateUtils.getNowDate());
        return medicineHelperMapper.insertMedicineHelper(medicineHelper);
    }

    /**
     * 修改帮助记录
     * 
     * @param medicineHelper 帮助记录
     * @return 结果
     */
    @Override
    public int updateMedicineHelper(MedicineHelper medicineHelper)
    {
        medicineHelper.setUpdateTime(DateUtils.getNowDate());
        return medicineHelperMapper.updateMedicineHelper(medicineHelper);
    }

    /**
     * 删除帮助记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMedicineHelperByIds(String ids)
    {
        return medicineHelperMapper.deleteMedicineHelperByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除帮助记录信息
     * 
     * @param id 帮助记录ID
     * @return 结果
     */
    @Override
    public int deleteMedicineHelperById(String id)
    {
        return medicineHelperMapper.deleteMedicineHelperById(id);
    }
}
