package com.messagemedia.api.models;

import java.util.*;

public class AsyncReportBuilder {
    //the instance to build
    private AsyncReport asyncReport;

    /**
     * Default constructor to initialize the instance
     */
    public AsyncReportBuilder() {
        asyncReport = new AsyncReport();
    }

    /**
     * Unique ID for this reply
     */
    public AsyncReportBuilder id(String id) {
        asyncReport.setId(id);
        return this;
    }

    public AsyncReportBuilder messageType(MessageTypeEnum messageType) {
        asyncReport.setMessageType(messageType);
        return this;
    }

    public AsyncReportBuilder type(TypeEnum type) {
        asyncReport.setType(type);
        return this;
    }

    public AsyncReportBuilder reportStatus(ReportStatusEnum reportStatus) {
        asyncReport.setReportStatus(reportStatus);
        return this;
    }

    /**
     * Date time at which this report was created.
     */
    public AsyncReportBuilder createdDatetime(String createdDatetime) {
        asyncReport.setCreatedDatetime(createdDatetime);
        return this;
    }

    /**
     * Date time at which this report was last modified.
     */
    public AsyncReportBuilder lastModifiedDatetime(String lastModifiedDatetime) {
        asyncReport.setLastModifiedDatetime(lastModifiedDatetime);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public AsyncReport build() {
        return asyncReport;
    }
}