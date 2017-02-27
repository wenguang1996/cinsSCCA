package cn.edu.swpu.cins.entry;

import java.sql.Date;

/**
 * Created by melo on 16-6-5.
 * data_records表映射
 */
public class DataRecords {

    private int uploadId;
    private int acceptId;
    private Date uploadTime;
    private int uploadNum;

    public int getUploadId() {
        return uploadId;
    }

    public void setUploadId(int uploadId) {
        this.uploadId = uploadId;
    }

    public int getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(int acceptId) {
        this.acceptId = acceptId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getUploadNum() {
        return uploadNum;
    }

    public void setUploadNum(int uploadNum) {
        this.uploadNum = uploadNum;
    }
}
