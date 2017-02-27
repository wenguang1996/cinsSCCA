package cn.edu.swpu.cins.dto;

/**
 * Created by melo on 16-6-7.
 * 政务机构交互记录
 */
public class OrgRecord {

	private String uploadOrg;
	private String acceptOrg;
	private long uploadTime;
	private int uploadNumber;

	public OrgRecord(long uploadTime, int uploadNumber) {
		this.uploadTime = uploadTime;
		this.uploadNumber = uploadNumber;
	}

	public OrgRecord(String uploadOrg, String acceptOrg, long uploadTime, int uploadNumber) {
		this.uploadOrg = uploadOrg;
		this.acceptOrg = acceptOrg;
		this.uploadTime = uploadTime;
		this.uploadNumber = uploadNumber;
	}

	public String getUploadOrg() {
		return uploadOrg;
	}

	public void setUploadOrg(String uploadOrg) {
		this.uploadOrg = uploadOrg;
	}

	public String getAcceptOrg() {
		return acceptOrg;
	}

	public void setAcceptOrg(String acceptOrg) {
		this.acceptOrg = acceptOrg;
	}

	public long getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(long uploadTime) {
		this.uploadTime = uploadTime;
	}

	public int getUploadNumber() {
		return uploadNumber;
	}

	public void setUploadNumber(int uploadNumber) {
		this.uploadNumber = uploadNumber;
	}
}
