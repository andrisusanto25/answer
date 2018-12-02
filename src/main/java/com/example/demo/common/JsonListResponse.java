package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class JsonListResponse<E> {

    /**
     * Status of response
     */
    private int status;

    /**
     * Message of response
     */
    private String message;

    /**
     * Current page
     */
    private int currentPage;

    /**
     * Per Page
     */
    private int perPage;

    /**
     * Count of page
     */
    private int pageCount;

    /**
     * Data
     */
    private List<E> data;

    public JsonListResponse() {
    }

    public JsonListResponse(int status, String message) {
        this.status  = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty(value = "current_page")
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int page) {
        this.currentPage = page;
    }

    @JsonProperty(value = "page_count")
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @JsonProperty(value = "per_page")
    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
