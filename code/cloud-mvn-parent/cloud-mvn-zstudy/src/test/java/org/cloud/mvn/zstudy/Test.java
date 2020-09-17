package org.cloud.mvn.zstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	/**
	 * @Author LiuTao @Date 2020年3月24日 下午4:04:27 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 * @throws IOException
	 */
	 public static void main(String[] args) throws IOException {
	        int s = 0;
	        String output = "";
	        
	        BufferedReader stadin = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("请输入a的值:");
	        String a = stadin.readLine();
	        System.out.println();
	        System.out.print("请输入n的值:");
	        String n = stadin.readLine();
	        System.out.println();
	        
	        for (int i = 1; i <= Integer.parseInt(n); i++) {
	            output += a;
	            int x = Integer.parseInt(output);
	            s += x;
	        }
	        System.out.println(s);
	 }

	 public static void Test20200916(){
		 int con = 0;
		 while (con < 5) {
			System.out.println(con);
			con++;
		}
		 
		do{
			System.out.println(con);
			con++;
		 }while(con < 5);
	 }
}
