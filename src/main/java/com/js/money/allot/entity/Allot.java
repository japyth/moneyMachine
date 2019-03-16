package com.js.money.allot.entity;

import com.js.money.Invest.entity.Invest;
import com.js.money.util.TimeUtils;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: JS
 * @Date: 22:50 2019/3/13
 * @Param:
 * @Return:
 * @Description: 结算总表
 */
@Entity
@Table(name = "allot")
public class Allot {
    @Id
    @Column(name = "allot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long allotId;
    @Column(name = "pump_rate")
    private double pumpRate;     //抽水比例
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "allot_id")},
            inverseJoinColumns = {@JoinColumn(name = "invest_id")}
    )
    private List<Invest> invests;
    @Column(name = "total_input")
    private double totalInput;
    @Column(name = "total_output")
    private double totalOutput;
    @Column(name = "total_pump")
    private double totalPump;
    @Column(name = "true_rate")
    private double trueRate; //实际收益比
    @Column(name = "flag")
    private boolean flag;    //结算标志

    public Allot(double pumpRate, List<Invest> invests, double totalOutput, boolean flag) {
        if (totalOutput >= 0) {
            this.pumpRate = pumpRate;
        } else {
            this.pumpRate = 0;
        }
        this.totalOutput = totalOutput;
        this.flag = flag;
        this.totalInput = invests.stream().mapToDouble(Invest::getInput).sum();
        this.totalPump = totalInput * pumpRate;
        this.invests = invests;
        this.trueRate = (totalOutput-totalPump) / totalInput;
        this.invests = invests.stream().peek(invest ->
        {
            invest.setOutput(invest.getInput() * trueRate);
            invest.setYieldRate(trueRate);
            invest.setUpdateTime(TimeUtils.getCurrentTime());
        }).collect(Collectors.toList());
    }

    public long getAllotId() {
        return allotId;
    }

    public void setAllotId(long allotId) {
        this.allotId = allotId;
    }

    public double getPumpRate() {
        return pumpRate;
    }

    public void setPumpRate(double pumpRate) {
        this.pumpRate = pumpRate;
    }

    public List<Invest> getInvests() {
        return invests;
    }

    public void setInvests(List<Invest> invests) {
        this.invests = invests;
    }

    public double getTotalInput() {
        return totalInput;
    }

    public void setTotalInput(double totalInput) {
        this.totalInput = totalInput;
    }

    public double getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(double totalOutput) {
        this.totalOutput = totalOutput;
    }

    public double getTotalPump() {
        return totalPump;
    }

    public void setTotalPump(double totalPump) {
        this.totalPump = totalPump;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public double getTrueRate() {
        return trueRate;
    }

    public void setTrueRate(double trueRate) {
        this.trueRate = trueRate;
    }
}
