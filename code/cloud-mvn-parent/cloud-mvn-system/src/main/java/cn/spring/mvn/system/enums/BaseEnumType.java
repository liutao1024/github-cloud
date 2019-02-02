package cn.spring.mvn.system.enums;

import cn.spring.mvn.comm.util.CommUtil;


public enum BaseEnumType implements BaseEnum<String> {
	BENH("BENH", "0", "按本行"), ZDH("ZDH", "1", "按指定行");

	private String id;
	private String value;
	private String longName;

	private BaseEnumType(String id, String value, String longName) {
		this.id = id;
		this.value = value;
		this.longName = longName;
	}

	public String getId() {
		return this.id;
	}

	public String getValue() {
		return this.value;
	}

	public String getLongName() {
		return this.longName;
	}

	public String toString() {
		return String.valueOf(this.value);
	}

	public static boolean isIn(Object value) {
		return CommUtil.isInEnum(BaseEnumType.class, value);
	}

//	public static BaseEnumType get(Object value) {
//		return (BaseEnumType) CommUtil.toEnum(Integer.class, value);
//	}
}
