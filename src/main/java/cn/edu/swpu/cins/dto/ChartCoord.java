package cn.edu.swpu.cins.dto;

/**
 * Created by melo on 16-6-5.
 * 政务分析中统计图的点的坐标
 */
public class ChartCoord {

    /*次数*/
    private int number;
    /*时间戳*/
    private long time;

    public ChartCoord(int number, long time) {
        this.number = number;
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChartCoord{" +
                "number=" + number +
                ", time=" + time +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
