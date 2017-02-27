package cn.edu.swpu.cins.dto;

/**
 * Created by melo on 16-6-5.
 * 正常与异常公司数量
 */
public class ComStatus {

    private int normal;
    private int error;

    @Override
    public String toString() {
        return "ComStatus{" +
                "normal=" + normal +
                ", error=" + error +
                '}';
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}
