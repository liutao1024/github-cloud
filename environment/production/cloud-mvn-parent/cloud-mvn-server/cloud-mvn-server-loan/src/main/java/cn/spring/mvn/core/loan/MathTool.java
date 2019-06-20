package cn.spring.mvn.core.loan;

import java.math.BigDecimal;
import java.math.BigInteger;
/**
 * @author LiuTao @date 2019年2月2日 下午5:59:54
 * @ClassName: MathTool 
 * @Description: 研究一下数学公式 运用于各种公式的实现
 */
public class MathTool {
	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal(4.01);
		BigInteger bigInteger = new BigInteger("21");
		double a = 12.08;
		double b = 3.5;
		System.out.println(Math.ceil(a));
		System.out.println(Math.pow(a, b));
		System.out.println(bigDecimal);
		System.out.println(bigInteger);
		System.out.println(Math.ceil(a));
		System.out.println(Math.ceil(a));
		System.out.println(Math.ceil(a));
		System.out.println(Math.ceil(a));
		System.out.println(Math.ceil(a));
		System.out.println(Math.ceil(a));
	}
}
