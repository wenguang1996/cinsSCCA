package cn.edu.swpu.cins.enums;

/**
 * Created by melo on 16-7-3.
 */
public enum ExcepMsg {
	NO_COMPANY("no such company"), NO_COM_NAME("no company name parameter");

	public String msg;

	ExcepMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
