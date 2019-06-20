package cn.spring.mvn.comm.tools;

/**
 * 字符工具类
 */
public class CharacterTool {

	/**
	 * 特殊字符转义处理
	 * @param c
	 * @return
	 */
	public static String convertChar(String c) {
		String ret = null;
		switch (c) {
		case "|":
			ret = "\\|";
			break;
		default:
			ret = c;
		}

		return ret;
	}
}
