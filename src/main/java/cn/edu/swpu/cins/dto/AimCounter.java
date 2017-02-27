package cn.edu.swpu.cins.dto;

import cn.edu.swpu.cins.enums.Tables;

/**
 * Created by melo on 16-5-30.
 * 公司行为次数统计，按行为目的分组
 */
public class AimCounter {

    /*行为目的名称，发票等五个*/
    private String name;
    private int number;

    public AimCounter(Tables table, int number) {
        this.name = table.getChineseName();
        this.number = number;
    }

    @Override
    public String toString() {
        return "AimCounter{" +
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
