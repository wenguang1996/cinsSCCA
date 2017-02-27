package cn.edu.swpu.cins.dto;

/**
 * Created by melo on 16-6-7.
 * 企业行为刻画第二个折线图的数据
 */
public class AimLogger {

	private int sysId;
	private long date;

	public AimLogger(int sysId, long date) {
		this.sysId = sysId;
		this.date = date;
	}

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
}
