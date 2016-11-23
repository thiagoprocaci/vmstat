package com.tbp.controller.factory;

import com.tbp.controller.dto.MemoryStatus;
import com.tbp.domain.Audit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryStatusListFactory extends StatusListFactory {

    @Override
    public Object createInstance(Audit a) {
        return new MemoryStatus(a);
    }

}
