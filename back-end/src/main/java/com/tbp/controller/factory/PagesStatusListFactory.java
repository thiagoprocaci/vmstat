package com.tbp.controller.factory;


import com.tbp.controller.dto.PagesStatus;
import com.tbp.domain.Audit;
import org.springframework.stereotype.Component;

@Component
public class PagesStatusListFactory extends StatusListFactory<PagesStatus>{

    @Override
    public PagesStatus createInstance(Audit a) {
        return new PagesStatus(a);
    }
}
