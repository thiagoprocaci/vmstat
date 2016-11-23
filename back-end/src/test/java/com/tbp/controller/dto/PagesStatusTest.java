package com.tbp.controller.dto;


import com.tbp.AuditBuilder;
import com.tbp.domain.Audit;
import org.junit.Test;

import static org.junit.Assert.*;

public class PagesStatusTest {


    @Test
    public void testPagesStatus() {
        Audit a = AuditBuilder.build();
        PagesStatus pagesStatus = new PagesStatus(a);
        assertEquals(a.getPagesPagedIn(), pagesStatus.getPagesPagedIn());
        assertEquals(a.getPagesPagedOut(), pagesStatus.getPagesPagedOut());
        assertEquals(a.getPagesSwappedIn(), pagesStatus.getPagesSwappedIn());
        assertEquals(a.getPagesSwappedOut(), pagesStatus.getPagesSwappedOut());
        assertEquals(a.getIpRunnerMachine(), pagesStatus.getIpRunnerMachine());
    }

}
