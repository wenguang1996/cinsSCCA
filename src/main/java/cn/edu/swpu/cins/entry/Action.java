package cn.edu.swpu.cins.entry;

import java.util.Date;

/**
 * Created by melo on 2016/05/20.
 * Project : scca
 * merge fapiao, jiaoshui, nianshen, shebao and toubiao tables into one entry
 */
public class Action {
    /* company id*/
    private int cmpId;
    /* first system id*/
    private int institution;
    /* action time */
    private Date handinTime;

    /* one-to-many, one first system name to many actions */
//    private FirstSysMap firstSysName;
    private String firstName;

    private int number;

    public int getCmpId() {
        return cmpId;
    }

    public void setCmpId(int cmpId) {
        this.cmpId = cmpId;
    }

    public int getInstitution() {
        return institution;
    }

    public void setInstitution(int institution) {
        this.institution = institution;
    }

    public Date getHandinTime() {
        return handinTime;
    }

    public void setHandinTime(Date handinTime) {
        this.handinTime = handinTime;
    }

//    public FirstSysMap getFirstSysName() {
//        return firstSysName;
//    }

//    public void setFirstSysName(FirstSysMap firstSysName) {
//        this.firstSysName = firstSysName;
//    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Action{" +
                "cmpId=" + cmpId +
                ", institution=" + institution +
                ", handinTime=" + handinTime +
//                ", firstSysName=" + firstSysName +
                ", firstName=" + firstName +
                ", number=" + number +
                '}';
    }
}
