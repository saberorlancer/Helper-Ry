package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/testsss")
public class TestsssController extends BaseController {

    @GetMapping("/data")
    @ResponseBody
    public String[] user() {
        String[] keys = {"123","234","2423","324","2432"};
        return keys;
    }
}
