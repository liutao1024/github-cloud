package org.cloud.mvn.zstudy;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyTest {
	public static void main(String[] args) throws Exception {
		BigDecimal a = new BigDecimal("1000");
		BigDecimal b = new BigDecimal("100");
		BigDecimal[] arr = a.divideAndRemainder(b);
		for (BigDecimal bigDecimal : arr) {
			System.out.println(bigDecimal);
		}
		System.out.println(arr[1] != BigDecimal.ZERO);
		
		StringBuffer sb = new StringBuffer("(");
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		for (String str : list) {
			sb.append(str+"|");
		}
		sb.deleteCharAt(sb.length() - 1).append(")$");
		
		System.out.println(sb.toString());
		
		String s = "70000_001_29379_212";
		System.out.println(s.substring(0, 9));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date now = sdf.parse("19911202");
		Date bir = sdf.parse("19911203");
		Calendar ca = Calendar.getInstance();
		ca.setTime(bir);
		int bY = ca.get(Calendar.YEAR);
		int bM = ca.get(Calendar.MONTH)+1;
		int bD = ca.get(Calendar.DAY_OF_MONTH);
		System.out.println("生日:"+ca.get(Calendar.YEAR)+"年,"+(ca.get(Calendar.MONTH)+1)+"月,"+ca.get(Calendar.DAY_OF_MONTH)+"日");
		ca.setTime(now);
		int nY = ca.get(Calendar.YEAR);
		int nM = ca.get(Calendar.MONTH)+1;
		int nD = ca.get(Calendar.DAY_OF_MONTH);
		System.out.println("现在:"+ca.get(Calendar.YEAR)+"年,"+(ca.get(Calendar.MONTH)+1)+"月,"+ca.get(Calendar.DAY_OF_MONTH)+"日");
		int age = nY - bY;
		if(age > 0){
			if(nM < bM){
				age--;
			}else if(nM == bM){
				if(nD < bD){
					age--;
				}
			}
		}else {
			age = 0;
		}
		System.out.println(age);
	}
}
