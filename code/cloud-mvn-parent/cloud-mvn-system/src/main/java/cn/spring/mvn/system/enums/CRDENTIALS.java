package cn.spring.mvn.system.enums;

/**
 * @author LiuTao @date 2019年2月1日 下午5:02:00
 * @ClassName: CRDENTIALS 
 * @Description: 证件枚举
 */
public enum CRDENTIALS {
	SHENGFENZHENG("身份证", "IdentityCard", "001"),
	HUKOUBO("户口薄", "HouseholdRegister", "002"),
	JUZHUZHENG("居住证", "ResidencePermit", "003"),
	ZHANZHUZHENG("暂住证", "TemporaryResidentialPermit", "004"),
	HUZHAO("护照", "Passport", "005"),
	JIASHIZHENG("驾驶证", "DrivingLicence", "006");
	private String nameCN;
	private String nameUS;
	private Object value;
	/**
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param nameCN
	 * @param nameUS
	 * @param value
	 */
	private CRDENTIALS(String nameCN, String nameUS, Object value){
		this.nameCN = nameCN;
		this.nameUS = nameUS;
		this.value = value;
	}
	//
	public static CRDENTIALS getVlue(Object obj){
		for (CRDENTIALS crdential : values()) {
			if(crdential.getValue() == obj){
				return crdential;
			}
		}
		return null;
	}
	
	public String getNameCN() {
		return nameCN;
	}
	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}
	public String getNameUS() {
		return nameUS;
	}
	public void setNameUS(String nameUS) {
		this.nameUS = nameUS;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	} 
	@Override
	public String toString(){
		return "CRDENTIALS[nameCN="+this.nameCN+",nameUS="+this.nameUS+",value="+this.value+"]";
	}
	public boolean equals(CRDENTIALS crdentials){
		boolean b = false;
		if(this.compareTo(crdentials) == 0){
			b = true;
		}
		return b;
	}
}
