package com.ruoyi.web.controller.develop;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.develop.domain.GkWxUser;
import com.ruoyi.develop.service.IGkWxUserService;
import com.ruoyi.develop.utils.DateUtils;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2023-03-12
 */
@Controller
@RequestMapping("/develop/user")
public class GkWxUserController extends BaseController
{
    private String prefix = "develop/user";

    @Autowired
    private IGkWxUserService gkWxUserService;

    @RequiresPermissions("develop:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("develop:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GkWxUser gkWxUser)
    {
        startPage();
        List<GkWxUser> list = gkWxUserService.selectGkWxUserList(gkWxUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("develop:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GkWxUser gkWxUser)
    {
        List<GkWxUser> list = gkWxUserService.selectGkWxUserList(gkWxUser);
        ExcelUtil<GkWxUser> util = new ExcelUtil<GkWxUser>(GkWxUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("develop:user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GkWxUser gkWxUser)
    {
        return toAjax(gkWxUserService.insertGkWxUser(gkWxUser));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{openId}")
    public String edit(@PathVariable("openId") String openId, ModelMap mmap)
    {
        GkWxUser gkWxUser = gkWxUserService.selectGkWxUserById(openId);
        mmap.put("gkWxUser", gkWxUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("develop:user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GkWxUser gkWxUser)
    {
        return toAjax(gkWxUserService.updateGkWxUser(gkWxUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("develop:user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gkWxUserService.deleteGkWxUserByIds(ids));
    }



    /**
     * 用户数据统计
     */
    @GetMapping( "/statistics")
    @ResponseBody
    public List<LinkedHashMap<String,BigDecimal>> statistics(String startCreateTime, String endCreateTime, String lastStartCreateTime, String lastEndCreateTime)
    {
        List<LinkedHashMap<String, BigDecimal>> date = gkWxUserService.statistics(startCreateTime,endCreateTime,lastStartCreateTime,lastEndCreateTime);
        return date;
    }

    /**
     * 用户数据统计
     */
    @GetMapping( "/getCountByUser")
    @ResponseBody
    public LinkedHashMap<String,BigDecimal> getCountByUser(String dateTime)
    {
        LinkedHashMap<String,BigDecimal> data = gkWxUserService.getCountByUser(dateTime);
        return data;
    }
}
