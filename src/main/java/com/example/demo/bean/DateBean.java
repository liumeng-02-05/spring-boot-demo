package com.example.demo.bean;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBean {
    private static final SimpleDateFormat DF =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String currentDate;

    public DateBean init() {
        this.currentDate = DF.format(new Date());
        return this;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}

