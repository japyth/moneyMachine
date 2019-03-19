package com.js.money.Invest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.js.money.user.entity.User;
import com.js.money.util.TimeUtils;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity
@Table(name="invest")
public class Invest {
    @Id
    @Column(name="invest_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long investId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name="input")
    private double input;
    @Column(name="output")
    private double output;
    @Column(name="yield_rate")
    private double yieldRate;
    @Column(name="poker_date")
    private Date pokerDate;
    @Column(name="update_date")
    private Date updateTime;

    public Invest() {
    }

    public Invest(User user, double input) {
        this.user = user;
        this.input = input;
        this.pokerDate = TimeUtils.getCurrentTime();
        this.updateTime = TimeUtils.getCurrentTime();
    }

    public long getInvestId() {
        return investId;
    }

    public void setInvestId(long investId) {
        this.investId = investId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public double getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(double yieldRate) {
        this.yieldRate = yieldRate;
    }

    public Date getPokerDate() {
        return pokerDate;
    }

    public void setPokerDate(Date pokerDate) {
        this.pokerDate = pokerDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
