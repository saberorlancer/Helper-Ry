package com.ruoyi.web.controller.develop;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.develop.domain.MedicineHelper;
import com.ruoyi.develop.service.IMedicineHelperService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 帮助记录Controller
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
@Controller
@RequestMapping("/develop/helper")
public class MedicineHelperController extends BaseController
{
    private String prefix = "develop/helper";

    @Autowired
    private IMedicineHelperService medicineHelperService;

    @RequiresPermissions("develop:helper:view")
    @GetMapping()
    public String helper()
    {
        return prefix + "/helper";
    }

    /**
     * 查询帮助记录列表
     */
    @RequiresPermissions("develop:helper:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MedicineHelper medicineHelper)
    {
        startPage();
        List<MedicineHelper> list = medicineHelperService.selectMedicineHelperList(medicineHelper);
        return getDataTable(list);
    }

    /**
     * 导出帮助记录列表
     */
    @RequiresPermissions("develop:helper:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MedicineHelper medicineHelper)
    {
        List<MedicineHelper> list = medicineHelperService.selectMedicineHelperList(medicineHelper);
        ExcelUtil<MedicineHelper> util = new ExcelUtil<MedicineHelper>(MedicineHelper.class);
        return util.exportExcel(list, "helper");
    }

    /**
     * 新增帮助记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存帮助记录
     */
    @RequiresPermissions("develop:helper:add")
    @Log(title = "帮助记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MedicineHelper medicineHelper)
    {
        return toAjax(medicineHelperService.insertMedicineHelper(medicineHelper));
    }

    /**
     * 修改帮助记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        MedicineHelper medicineHelper = medicineHelperService.selectMedicineHelperById(id);
        mmap.put("medicineHelper", medicineHelper);
        return prefix + "/edit";
    }

    /**
     * 修改保存帮助记录
     */
    @RequiresPermissions("develop:helper:edit")
    @Log(title = "帮助记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MedicineHelper medicineHelper)
    {
        return toAjax(medicineHelperService.updateMedicineHelper(medicineHelper));
    }

    /**
     * 删除帮助记录
     */
    @RequiresPermissions("develop:helper:remove")
    @Log(title = "帮助记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(medicineHelperService.deleteMedicineHelperByIds(ids));
    }
}
