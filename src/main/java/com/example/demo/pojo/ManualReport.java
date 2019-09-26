package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: G08ProductionLine
 * @description 手动上报记录实体类
 * @author: X.Gao
 * @create: 2019-07-23 16:41
 **/

@Component
public class ManualReport implements Serializable {

    //记录的ID，数据表主键
    private Long id;
    //阅读器IP
    private String ip;
    //阅读器位置，根据ip到阅读器表中查找
    private String location;
    //epc码
    private String epc;
    //进入工位时间（标签被识别的时间）
    private Date enterDate;
    //离开工位时间（标签被识别的时间）
    private Date exitDate;
    //上报状态标志位
    private ReportStatus reportStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public ReportStatus getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(ReportStatus reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }
}
