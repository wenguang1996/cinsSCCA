package cn.edu.swpu.cins.dto;

/**
 * Created by melo on 16-5-30.
 * 公司行为对象
 */
public class ComBehaviour {

    /*公司id*/
    private int id;
    /*行为时间戳*/
    private long time;
    /*一级系统名称*/
    private int sysId;

    public ComBehaviour(int id, long time, int sysId) {
        this.id = id;
        this.time = time;
        this.sysId = sysId;
    }

    @Override
    public String toString() {
        return "ComBehaviour{" +
                "id=" + id +
                ", time=" + time +
                ", sysId='" + sysId + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSysName() {
        return sysId;
    }

    public void setSysName(int sysId) {
        this.sysId = sysId;
    }
}
