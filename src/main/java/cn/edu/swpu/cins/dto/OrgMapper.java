package cn.edu.swpu.cins.dto;

/**
 * Created by melo on 16-6-7.
 * 政务机构的映射dto
 */
public class OrgMapper {

	private int id;
	private String name;

	public OrgMapper(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
