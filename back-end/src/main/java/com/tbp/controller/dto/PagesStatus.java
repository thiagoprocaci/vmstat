package com.tbp.controller.dto;


import com.tbp.domain.Audit;

public class PagesStatus extends Status {

    private Long pagesPagedIn;
    private Long pagesPagedOut;
    private Long pagesSwappedIn;
    private Long pagesSwappedOut;

    public PagesStatus(Audit audit) {
        super(audit);
        this.pagesPagedIn = audit.getPagesPagedIn();
        this.pagesPagedOut = audit.getPagesPagedOut();
        this.pagesSwappedIn = audit.getPagesSwappedIn();
        this.pagesSwappedOut = audit.getPagesSwappedOut();
    }

    public Long getPagesPagedIn() {
        return pagesPagedIn;
    }

    public Long getPagesPagedOut() {
        return pagesPagedOut;
    }

    public Long getPagesSwappedIn() {
        return pagesSwappedIn;
    }

    public Long getPagesSwappedOut() {
        return pagesSwappedOut;
    }
}
