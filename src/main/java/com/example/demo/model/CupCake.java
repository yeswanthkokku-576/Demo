package com.example.demo.model;

import com.example.demo.DTO.CupCakeDto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
@SqlResultSetMapping(
        name="ScheduleResult",
        classes={
                @ConstructorResult(
                        targetClass= CupCakeDto.class,
                        columns={
                                @ColumnResult(name="time"),
                                @ColumnResult(name="count"),

                        })})
@NamedNativeQuery(name="CupCake.findChildren",query ="select u.time,u.count from cup_cake u ",resultSetMapping ="ScheduleResult" )
public class CupCake {
    @Id
    private String time;

    private String count;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTouched;


    public CupCake() {

    }

    public Date getLastTouched() {
        return lastTouched;
    }

    public void setLastTouched(Date lastTouched) {
        this.lastTouched = lastTouched;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String data) {
        this.count = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
