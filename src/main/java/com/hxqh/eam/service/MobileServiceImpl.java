package com.hxqh.eam.service;

import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */
@Service("mobileService")
public class MobileServiceImpl implements MobileService {


    private static final String[] RF = {"RADIO ACCESS", "FO ACCESS"};
    private static final String[] RFS = {"RADIO ACCESS", "FO ACCESS", "SL_D"};

    @Autowired
    private VMob86Dao vMob86Dao;
    @Autowired
    private VMob87Dao vMob87Dao;
    @Autowired
    private VMob91Dao vMob91Dao;
    @Autowired
    private VMob92Dao vMob92Dao;
    @Autowired
    private VMob88MttiDao mob88MttiDao;
    @Autowired
    private VMob88MttrDao mob88MttrDao;
    @Autowired
    private VMob88PerformanceDao mob88PerformanceDao;


    @Override
    public Mob91Dto vMob91Data() {
        List<VMob91> vMob91List = vMob91Dao.findAll();

        List<VMob91> mob91LeftList = new LinkedList<>();
        List<VMob91> mob91RightList = new LinkedList<>();
        for (int i = 0; i < vMob91List.size(); i++) {
            if (i < 8) {
                mob91LeftList.add(vMob91List.get(i));
            } else {
                mob91RightList.add(vMob91List.get(i));
            }
        }
        Mob91Dto mob91Dto = new Mob91Dto(mob91LeftList, mob91RightList);
        return mob91Dto;
    }

    @Override
    public Mob92Dto vMob92Data() {
        List<VMob92> mob92List = vMob92Dao.findAll();
        // 百分比
        List<Mob92PercentDto> percentMob92List = new LinkedList<>();
        for (VMob92 mob92 : mob92List) {
            Double sum = mob92.getGreennum().doubleValue()+ mob92.getOrangenum().doubleValue()+mob92.getRednum().doubleValue();
            Mob92PercentDto vMob92 = new Mob92PercentDto(mob92.getGreennum().doubleValue()/sum*1000, mob92.getId(),
                     mob92.getOrangenum().doubleValue()/sum*1000,mob92.getRednum().doubleValue()/sum*1000);
            percentMob92List.add(vMob92);
        }

        //原始数据
        List<BigDecimal> green = new LinkedList<>();
        List<BigDecimal> orange = new LinkedList<>();
        List<BigDecimal> red = new LinkedList<>();
        for (VMob92 mob92 : mob92List) {
            green.add(mob92.getGreennum());
            orange.add(mob92.getOrangenum());
            red.add(mob92.getRednum());
        }
        // 百分比数据
        List<Double> greenPercent = new LinkedList<>();
        List<Double> orangePercent = new LinkedList<>();
        List<Double> redPercent = new LinkedList<>();
        for (Mob92PercentDto mob92 : percentMob92List) {
            greenPercent.add(mob92.getGreennum());
            orangePercent.add(mob92.getOrangenum());
            redPercent.add(mob92.getRednum());
        }
        Mob92Dto mob92Dto = new Mob92Dto(green,orange,red,greenPercent,orangePercent,redPercent);
        return mob92Dto;
    }

    @Override
    public List<VMob86> vMob86Data() {
        return vMob86Dao.findAll();
    }

    @Override
    public VMob87Dto vMob87Data() {
        List<VMob87> mob87List = vMob87Dao.findAll();

        // 进行分组
        Map<String, List<VMob87>> map = GroupListUtil.group(mob87List, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VMob87 d = (VMob87) obj;
                return d.getRegional();    // 分组依据为Regional
            }
        });

        VMob87Dto vMob87Dto = new VMob87Dto(map);
        return vMob87Dto;
    }

    @Override
    public Mob88Dto getMob88Data() {
        List<VMob88Mtti> mob88Mtti = mob88MttiDao.findAll();
        List<VMob88Mttr> mob88Mttr = mob88MttrDao.findAll();
        List<VMob88Performance> mob88Performance = mob88PerformanceDao.findAll();
        Mob88Dto mob88Dto = new Mob88Dto(mob88Mtti, mob88Mttr, mob88Performance);
        return mob88Dto;
    }
}
