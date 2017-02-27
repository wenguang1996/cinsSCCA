package cn.edu.swpu.cins.dto;

import java.util.List;

/**
 * Created by melo on 16-6-7.
 * 封装政务机构交互记录，保存页数等信息
 */
public class RecordList {

	private List<OrgRecord> records;
	private int pages;
	private int number;

	public RecordList() {}

	public RecordList(List<OrgRecord> records, int pages, int number) {
		this.records = records;
		this.pages = pages;
		this.number = number;
	}

	public List<OrgRecord> getRecords() {
		return records;
	}

	public void setRecords(List<OrgRecord> records) {
		this.records = records;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
