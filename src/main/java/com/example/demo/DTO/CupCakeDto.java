package com.example.demo.DTO;

import javax.persistence.Id;

public class CupCakeDto {
    @Id
    private String time;

    private String count;

    public CupCakeDto(String time, String data) {
        this.time = time;
        this.count=data;
    }

    public String getData() {
        return count;
    }

    public void setData(String data) {
        this.count = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
