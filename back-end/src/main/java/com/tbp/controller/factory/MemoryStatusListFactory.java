package com.tbp.controller.factory;

import com.tbp.controller.dto.MemoryStatus;
import com.tbp.domain.Audit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryStatusListFactory {

    public List<MemoryStatus> create(Iterable<Audit> auditList) {
        List<MemoryStatus> memoryStatusList = new ArrayList<>();
        if(auditList != null) {
            for(Audit a: auditList) {
                memoryStatusList.add(new MemoryStatus(a));
            }
        }
        return memoryStatusList;
    }

}
