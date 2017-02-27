package cn.edu.swpu.cins.entry;

import java.util.Date;

/**
 * Created by melo on 2016/05/19.
 * Project : scca
 * entry of base_info table
 */
public class BaseInfo {

    /* company id */
    private int cmpId;
    /* company name*/
    private String cmpName;
    /* company location*/
    private String cmpLocation;
    /* activity of company in Tendering & Biding system*/
    private int cmpActivity;
    /* degree of flow for employees in company*/
    private int cmpEmployee;
    /* Medicare numbers for employees in company*/
    private int cmpHealth;
    /* status of company */
    private String cmpStatus;
    /* time of the error happened*/
    private Date errorTime;
    /* reason of the error*/
    private String reason;

    /* number of companies which grouped by cmp_status or cmp_location */
    private int number;

    public int getCmpId() {
        return cmpId;
    }

    public void setCmpId(int cmpId) {
        this.cmpId = cmpId;
    }

    public String getCmpName() {
        return cmpName;
    }

    public void setCmpName(String cmpName) {
        this.cmpName = cmpName;
    }

    public String getCmpLocation() {
        return cmpLocation;
    }

    public void setCmpLocation(String cmpLocation) {
        this.cmpLocation = cmpLocation;
    }

    public int getCmpActivity() {
        return cmpActivity;
    }

    public void setCmpActivity(int cmpActivity) {
        this.cmpActivity = cmpActivity;
    }

    public int getCmpEmployee() {
        return cmpEmployee;
    }

    public void setCmpEmployee(int cmpEmployee) {
        this.cmpEmployee = cmpEmployee;
    }

    public int getCmpHealth() {
        return cmpHealth;
    }

    public void setCmpHealth(int cmpHealth) {
        this.cmpHealth = cmpHealth;
    }

    public String getCmpStatus() {
        return cmpStatus;
    }

    public void setCmpStatus(String cmpStatus) {
        this.cmpStatus = cmpStatus;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "cmpId=" + cmpId +
                ", cmpName='" + cmpName + '\'' +
                ", cmpLocation='" + cmpLocation + '\'' +
                ", cmpActivity=" + cmpActivity +
                ", cmpEmployee=" + cmpEmployee +
                ", cmpHealth=" + cmpHealth +
                ", cmpStatus='" + cmpStatus + '\'' +
                ", errorTime=" + errorTime +
                ", reason='" + reason + '\'' +
                ", number=" + number +
                '}';
    }
}
