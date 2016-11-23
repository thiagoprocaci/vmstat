package com.tbp.controller.factory;

import com.tbp.controller.dto.CpuStatus;
import com.tbp.controller.dto.MemoryStatus;
import com.tbp.controller.dto.PagesStatus;
import com.tbp.controller.dto.StatusGroup;
import com.tbp.domain.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class StatusGroupFactory {

    @Autowired
    CpuStatusListFactory cpuStatusListFactory;
    @Autowired
    MemoryStatusListFactory memoryStatusListFactory;
    @Autowired
    PagesStatusListFactory pagesStatusListFactory;

    public StatusGroup create(Iterable<Audit> auditList) {
        List<CpuStatus> cpuStatusList = cpuStatusListFactory.create(auditList);
        Collections.reverse(cpuStatusList);
        List<MemoryStatus> memoryStatusList = memoryStatusListFactory.create(auditList);
        Collections.reverse(memoryStatusList);
        List<PagesStatus> pagesStatusList = pagesStatusListFactory.create(auditList);
        Collections.reverse(pagesStatusList);
        return new StatusGroup(memoryStatusList, pagesStatusList, cpuStatusList);
    }

}
