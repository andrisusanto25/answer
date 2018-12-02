package com.example.demo.base;

public class BaseModel {

    /**
     * start of index for pagination
     */
    private int startIndex;

    /**
     * end of index for pagination
     */
    private int endIndex;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
