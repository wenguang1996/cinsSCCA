package cn.edu.swpu.cins.dto;

/**
 * Created by melo on 16-6-5.
 * 记录某区域的企业数量
 */
public class LocationCounter {

    private String name;
    private int number;

    public LocationCounter(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "LocationCounter{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
