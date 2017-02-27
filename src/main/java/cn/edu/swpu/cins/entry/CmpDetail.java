package cn.edu.swpu.cins.entry;

import java.util.Date;

/**
 * Created by melo on 2016/05/19.
 * Project : scca
 * entry for cmp_detail table
 */
public class CmpDetail {

    /* company id */
    private int cmpId;
    /* first system id */
    private int firstSys;
    /* second system name */
    private String secondSys;
    /* action description for company */
    private String cmpAction;
    /* action time */
    private Date handinTime;

    private int number;

    /* one-to-many, one first system name to many actions// */
//    private FirstSysMap firstSysName;
    private String firstName;

    public int getCmpId() {
        return cmpId;
    }

    public void setCmpId(int cmpId) {
        this.cmpId = cmpId;
    }

    public int getFirstSys() {
        return firstSys;
    }

    public void setFirstSys(int firstSys) {
        this.firstSys = firstSys;
    }

    public String getSecondSys() {
        return secondSys;
    }

    public void setSecondSys(String secondSys) {
        this.secondSys = secondSys;
    }

    public String getCmpAction() {
        return cmpAction;
    }

    public void setCmpAction(String cmpAction) {
        this.cmpAction = cmpAction;
    }

    public Date getHandinTime() {
        return handinTime;
    }

    public void setHandinTime(Date handinTime) {
        this.handinTime = handinTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

//    public FirstSysMap getFirstSysName(//) {
//        return firstSysName;
//    }

//    public void setFirstSysName(FirstSysMap firstSysName//) {
//        this.firstSysName = firstSysName;
//    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "CmpDetail{" +
                "cmpId=" + cmpId +
                ", firstSys=" + firstSys +
                ", secondSys='" + secondSys + '\'' +
                ", cmpAction='" + cmpAction + '\'' +
                ", handinTime=" + handinTime +
                ", number=" + number +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
