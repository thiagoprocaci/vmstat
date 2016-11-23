package com.tbp.controller.dto;


import java.util.List;

public class StatusGroup {

    List<MemoryStatus> memoryStatusList;
    List<PagesStatus> pagesStatusList;
    List<CpuStatus> cpuStatusList;

    public StatusGroup(List<MemoryStatus> memoryStatusList, List<PagesStatus> pagesStatusList, List<CpuStatus> cpuStatusList) {
        this.memoryStatusList = memoryStatusList;
        this.pagesStatusList = pagesStatusList;
        this.cpuStatusList = cpuStatusList;
    }

    public List<MemoryStatus> getMemoryStatusList() {
        return memoryStatusList;
    }

    public List<PagesStatus> getPagesStatusList() {
        return pagesStatusList;
    }

    public List<CpuStatus> getCpuStatusList() {
        return cpuStatusList;
    }
}
