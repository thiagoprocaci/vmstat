package com.tbp.controller.factory;


import com.tbp.AuditBuilder;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CpuStatusListFactoryTest {

    @Test
    public void testCreateInstance() {
        CpuStatusListFactory cpuStatusListFactory = new CpuStatusListFactory();
        assertNotNull(cpuStatusListFactory.createInstance(AuditBuilder.build()));
    }

}
