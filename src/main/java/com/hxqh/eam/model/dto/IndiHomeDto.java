package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VHomeImpact;
import com.hxqh.eam.model.view.VHomeRegular;
import com.hxqh.eam.model.view.VHomeTotal;

import java.util.List;

/**
 * Created by Ocean lin on 2017/6/30.
 */
public class IndiHomeDto {
    private List<VHomeImpact> homeImpactList;

    private List<VHomeRegular> homeRegularList;

    private List<VHomeTotal> homeTotalList;

    public IndiHomeDto(List<VHomeImpact> homeImpactList, List<VHomeRegular> homeRegularList, List<VHomeTotal> homeTotalList) {
        this.homeImpactList = homeImpactList;
        this.homeRegularList = homeRegularList;
        this.homeTotalList = homeTotalList;
    }

    public List<VHomeImpact> getHomeImpactList() {
        return homeImpactList;
    }

    public void setHomeImpactList(List<VHomeImpact> homeImpactList) {
        this.homeImpactList = homeImpactList;
    }

    public List<VHomeRegular> getHomeRegularList() {
        return homeRegularList;
    }

    public void setHomeRegularList(List<VHomeRegular> homeRegularList) {
        this.homeRegularList = homeRegularList;
    }

    public List<VHomeTotal> getHomeTotalList() {
        return homeTotalList;
    }

    public void setHomeTotalList(List<VHomeTotal> homeTotalList) {
        this.homeTotalList = homeTotalList;
    }
}
