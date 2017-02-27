package cn.edu.swpu.cins.entry;

/**
 * Created by melo on 2016/05/19.
 * Project : scca
 * entry for first_sys_name table
 */
public class FirstSysMap {

    /* id of first system*/
    private int firstId;
    /* name of first system*/
    private String firstName;

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "FirstSysMap{" +
                "firstId=" + firstId +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
