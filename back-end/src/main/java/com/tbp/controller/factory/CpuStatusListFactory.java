package com.tbp.controller.factory;

import com.tbp.controller.dto.CpuStatus;
import com.tbp.domain.Audit;
import org.springframework.stereotype.Component;

@Component
public class CpuStatusListFactory extends StatusListFactory<CpuStatus> {

    @Override
    public CpuStatus createInstance(Audit a) {
        return new CpuStatus(a);
    }
}
