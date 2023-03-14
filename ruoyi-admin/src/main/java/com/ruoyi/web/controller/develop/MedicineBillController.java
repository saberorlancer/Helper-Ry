package com.ruoyi.web.controller.develop;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.develop.domain.MedicineBillBanner;
import com.ruoyi.develop.service.IMedicineBillBannerService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 海报与Banner信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-13
 */
@Controller
@RequestMapping("/develop/bill")
public class MedicineBillController extends BaseController
{
    private String prefix = "develop/bill";

    @Autowired
    private IMedicineBillBannerService medicineBillBannerService;

    @RequiresPermissions("develop:bill:view")
    @GetMapping()
    public String banner()
    {
        return prefix + "/edit";
    }

    /**
     * 查询海报与Banner信息列表
     */
    @RequiresPermissions("develop:bill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MedicineBillBanner medicineBillBanner)
    {
        startPage();
        List<MedicineBillBanner> list = medicineBillBannerService.selectMedicineBillBannerList(medicineBillBanner);
        return getDataTable(list);
    }

    /**
     * 导出海报与Banner信息列表
     */
    @RequiresPermissions("develop:bill:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MedicineBillBanner medicineBillBanner)
    {
        List<MedicineBillBanner> list = medicineBillBannerService.selectMedicineBillBannerList(medicineBillBanner);
        ExcelUtil<MedicineBillBanner> util = new ExcelUtil<MedicineBillBanner>(MedicineBillBanner.class);
        return util.exportExcel(list, "banner");
    }

    /**
     * 新增海报与Banner信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存海报与Banner信息
     */
    @RequiresPermissions("develop:bill:add")
    @Log(title = "海报与Banner信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MedicineBillBanner medicineBillBanner)
    {
        return toAjax(medicineBillBannerService.insertMedicineBillBanner(medicineBillBanner));
    }

    /**
     * 修改海报与Banner信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        MedicineBillBanner medicineBillBanner = medicineBillBannerService.selectMedicineBillBannerById(id);
        mmap.put("medicineBillBanner", medicineBillBanner);
        return prefix + "/edit";
    }

    /**
     * 修改保存海报与Banner信息
     */
    @RequiresPermissions("develop:bill:edit")
    @Log(title = "海报与Banner信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MedicineBillBanner medicineBillBanner)
    {
        return toAjax(medicineBillBannerService.updateMedicineBillBanner(medicineBillBanner));
    }

    /**
     * 删除海报与Banner信息
     */
    @RequiresPermissions("develop:bill:remove")
    @Log(title = "海报与Banner信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(medicineBillBannerService.deleteMedicineBillBannerByIds(ids));
    }

    @PostMapping("uploadImage")
    @ApiOperation(value = "上传图片")
    @ResponseBody
    public List<String> uploadImage(@RequestBody MultipartFile file){

        String url = medicineBillBannerService.uploadImage(file);
        List<String> data = new ArrayList<>();
        data.add(url);
        return data;
    }

    @PostMapping("commitBill")
    @ApiOperation(value = "提交数据")
    @ResponseBody
    public AjaxResult commitBill(String url){
        medicineBillBannerService.commitBill(url);
        return toAjax(1);
    }

    @GetMapping("getBill")
    @ApiOperation(value = "获取当前Banner")
    @ResponseBody
    public MedicineBillBanner getBill(){
      return  medicineBillBannerService.getBill();
    }
}
