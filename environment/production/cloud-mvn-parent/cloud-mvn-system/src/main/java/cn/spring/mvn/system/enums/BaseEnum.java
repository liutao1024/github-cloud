package cn.spring.mvn.system.enums;

public abstract interface BaseEnum<T>{
	public abstract String getId();
	public abstract T getValue();
	public abstract String getLongName();
	public abstract String toString();
}
