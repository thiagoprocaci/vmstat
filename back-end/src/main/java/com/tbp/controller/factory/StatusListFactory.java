package com.tbp.controller.factory;


import com.tbp.domain.Audit;

import java.util.ArrayList;
import java.util.List;

public abstract class StatusListFactory<T> {

    public List<T> create(Iterable<Audit> auditList) {
        List<T> statusList = new ArrayList<>();
        if(auditList != null) {
            for(Audit a: auditList) {
                statusList.add(createInstance(a));
            }
        }
        return statusList;
    }

    public abstract T createInstance(Audit a);
}
