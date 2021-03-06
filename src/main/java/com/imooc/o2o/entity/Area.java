package com.imooc.o2o.entity;



import java.util.Date;

public class Area {

    //区域ID
    private Integer areaId;
    //名称
    private String areaName;
    //创建时间
    private Date createTime;
    //最后一次修改时间
    private Date lastEditTime;
    //权重
    private Integer priority;

    public Integer getAreaID() {
        return areaId;
    }

    public void setAreaID(Integer areaID) {
        this.areaId = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
