package com.tbp.controller.dto;


import com.tbp.AuditBuilder;
import com.tbp.controller.factory.PagesStatusListFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PagesStatusListFactoryTest {

    @Test
    public void testCreateInstance() {
        PagesStatusListFactory pagesStatusListFactory = new PagesStatusListFactory();
        assertNotNull(pagesStatusListFactory.createInstance(AuditBuilder.build()));
    }
}
