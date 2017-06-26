package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.view.*;
import com.hxqh.eam.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService mobileService;


    @RequestMapping(value = "/mobile87", method = RequestMethod.GET)
    public String mobile87() {
        return "mobile/mobile87";
    }

    @ResponseBody
    @RequestMapping(value = "/vMob87Data", method = RequestMethod.GET)
    public List<VMob87> vMob87Data() {
        List<VMob87> dig13List = mobileService.vMob87Data();
        return dig13List;
    }

    @ResponseBody
    @RequestMapping(value = "/vMob87ClassData", method = RequestMethod.GET)
    public List<VMob87Class> vMob87ClassData() {
        List<VMob87Class> dig13List = mobileService.vMob87ClassData();
        return dig13List;
    }

    @RequestMapping(value = "/mobile86", method = RequestMethod.GET)
    public String mobile86() {
        return "mobile/mobile86";
    }

    @ResponseBody
    @RequestMapping(value = "/vMob86Data", method = RequestMethod.GET)
    public List<VMob86> vMob86Data() {
        List<VMob86> dig13List = mobileService.vMob86Data();
        return dig13List;
    }

    @RequestMapping(value = "/mobile88", method = RequestMethod.GET)
    public String mobile88() {
        return "mobile/mobile88";
    }

    @ResponseBody
    @RequestMapping(value = "/vMob88Data", method = RequestMethod.GET)
    public List<VMob88> vMob88Data() {
        List<VMob88> dig13List = mobileService.vMob88Data();
        return dig13List;
    }

    @RequestMapping(value = "/mobile89", method = RequestMethod.GET)
    public String mobile89() {
        return "mobile/mobile89";
    }

    @RequestMapping(value = "/mobile91", method = RequestMethod.GET)
    public String mobile91() {
        return "mobile/mobile91";
    }

    @ResponseBody
    @RequestMapping(value = "/vMob91Data", method = RequestMethod.GET)
    public List<VMob91> vMob91Data() {
        List<VMob91> dig13List = mobileService.vMob91Data();
        return dig13List;
    }

    @RequestMapping(value = "/mobile92", method = RequestMethod.GET)
    public String mobile92() {
        return "mobile/mobile92";
    }


    @ResponseBody
    @RequestMapping(value = "/vMob92Data", method = RequestMethod.GET)
    public List<VMob92> vMob92Data() {
        List<VMob92> dig13List = mobileService.vMob92Data();
        return dig13List;
    }


}
