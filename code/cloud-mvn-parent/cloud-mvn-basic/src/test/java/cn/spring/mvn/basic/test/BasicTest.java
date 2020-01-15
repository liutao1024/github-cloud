package cn.spring.mvn.basic.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//import java.util.Map;

//import cn.spring.mvn.basic.entity.SystemDate;
//import cn.spring.mvn.basic.tools.BasicReflection;

//import javax.persistence.Table;

//import cn.spring.mvn.basic.util.BasicUtil;

public class BasicTest {
	/**
	 * @author LiuTao @date 2020年1月10日 下午5:01:34 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] bubbleArr = new int[10];
//		for (int i = 0; i < bubbleArr.length; i++) {
//			bubbleArr[i] = (int) (Math.random()*100+1);
//		}
//		int[] selectArr = bubbleArr.clone();
//		int[] arr = {3,4,2,1,6,0,9,5,8,7};
//		SelectionSort(arr);
//		InsertionSort(arr);
//		BubbleSort(bubbleArr);
//		System.out.println("--------------------------------------------------------------------");
//		SelectionSort(selectArr);
//		StackY();
//		JieXISuanShuBiaoDaSi();
		try {
			LinkX();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author LiuTao @date 2020年1月13日 上午9:29:09 
	 * @throws ParseException 
	 * @Title: LinkX 
	 * @Description: 链表
	 */
	public static void LinkX() throws ParseException{
		Long l = System.currentTimeMillis();
		System.out.println(l);
		Date date = new Date(1471883254888095768L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDDHHmmss");
		System.out.println(sdf.format(date));
		System.out.println(sdf.parse("10000-12-31 23:59:59"));
		Long year = 99999L;
		Long mouth = 12L;
		Long day = 31L;
		Long hour = 23L;
		Long minut = 59L;
		Long second = 59L;
		Date d = sdf.parse(year+""+mouth+""+day+""+hour+""+minut+""+second);
		
		Long timeString = year*365*24*60*60*1000 +mouth*30*24*60*60*1000+day*24*60*60*1000+hour*60*60*1000+minut*60*1000+second*1000;
		System.out.println(timeString);
//		System.out.println(Calendar );
		System.out.println(d.getTime());
		LinkedList<Integer> linkedList;
		ArrayList<Integer> arrayList;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> listTemp = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(34);
		list.add(34);
		list.add(44);
		listTemp.add(14);
		listTemp.add(44);
		System.out.println(list.toString());
//		list.f
		list.remove(3);
		System.out.println(list.toString());
	}
	/**
	 * @author LiuTao @date 2020年1月10日 下午3:49:19 
	 * @Title: JieXISuanShuBiaoDaSi 
	 * @Description: 解析算数表达式--后缀表达式及其计算
	 */
	public static void JieXISuanShuBiaoDaSi(){
//		int x = 5+4/2+3-1+2*3;// --5423123/*++-+
		/**
		 * 1.定义:
		 * 后缀表达式,指的是不包含括号,----运算符放在两个运算对象的后面,
		 * 所有的计算按运算符出现的顺序,严格从左向右进行(不再考虑运算符的优先规则)
		 * 例如 5+(2+3)*4 转换为后缀表达式为 5 2 3 + 4 * +
		 * 2.计算:
		 * 后缀表达式的计算
		 * 从左向右扫描,遇到数字压栈,遇到操作符,弹出栈顶的两个元素,先弹出的元素在右边,后弹出来的在左边,
		 * 进行计算后,将结果压栈,再往后扫描,直到扫描结束,输出栈顶元素,即为最终结果
		 * 3.例如:
		 * 后缀表达式"15 2 3 + 4 * +":
		 * 从左往右,
		 * 15压栈,2压栈,3压栈,遇到+号,弹出3 2,计算2+3=5,
		 * 将5压栈,此时栈为15 5,将4压栈,遇到*号,弹出4 5,计算5*4=20,
		 * 将20压栈 此时栈为15 20,遇到+号,计算15+20=35,将35压栈,
		 * 扫描结束,输出35
		 * 
		 * 将A+B*(C-D)转换成后缀表达式
		 * 		ABCD-*+
		 */
		String str = "15 2 3 + 4 * +";//Postfix expression 后缀表达式
		String[] array = str.split(" ");
		Stack<Integer> stack = new Stack<Integer>();
		Integer x,y,temp;
		for (int i = 0; i < array.length; i++) {
			String string = array[i];
			switch (string) {
			case "+":
				y = stack.pop();
				x = stack.pop();
				temp = x + y;
				stack.push(temp);
				break;
			case "-":
				y = stack.pop();
				x = stack.pop();
				temp = x - y;
				stack.push(temp);
				break;
			case "*":
				y = stack.pop();
				x = stack.pop();
				temp = x * y;
				stack.push(temp);
				break;
			case "/":
				y = stack.pop();
				x = stack.pop();
				temp = x / y;
				stack.push(temp);
				break;
				
			default:
				temp = Integer.valueOf(string);
				stack.push(temp);
				break;
			}
		}
		System.out.println(stack.peek());
	}
	/**
	 * @author LiuTao @date 2020年1月10日 下午3:49:13 
	 * @Title: StackX 
	 * @Description: 栈
	 */
	public static void StackX(){
		/**
		 * 栈
		 * Stack<E> 这里的E表示为对象的类
		 */
		Stack<Long> stack = new Stack<Long>();
		Long[] array = new Long[4];
		stack.add(1L);
		stack.add(2, 2L);
		stack.addAll(stack);
		stack.addAll(5, stack);
		stack.addElement(9L);
		stack.capacity();
		stack.clear();
		stack.clone();
		stack.contains(2L);
		stack.containsAll(stack);
		stack.copyInto(array);
		stack.elementAt(2);
		stack.elements();
		stack.empty();
		stack.ensureCapacity(3);
		stack.forEach(null);
		stack.iterator();
		stack.peek();
		stack.pop();
		stack.push(10L);
		stack.remove(2);
		stack.remove(array);
	}
	
	public static void StackY(){
		Stack<Integer> stack = new Stack<Integer>();
//		stack.setSize(10);
		stack.push(20);
		stack.push(21);
		stack.push(22);
		stack.push(23);
		stack.push(24);
		stack.push(25);
		stack.push(26);
		stack.push(27);
		stack.push(28);
		stack.push(29);
		stack.push(30);
		
		for (Integer integer : stack) {
			System.out.print(integer+" ");
		}
	}
	/**
	 * @author LiuTao @date 2020年1月10日 上午10:09:24 
	 * @Title: QueueX 
	 * @Description: 队列------优先级队列
	 */
	public static void QueueX(){
		Queue<Integer> queue = new Queue<Integer>() {
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<Integer> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Integer> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean add(Integer e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean offer(Integer e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Integer remove() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer poll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer element() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer peek() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		queue.add(23);
	}	
	/**
	 * @author LiuTao @date 2019年12月31日 上午9:51:45 
	 * @Title: BubbleSort 
	 * @Description: 冒泡排序
	 */
	public static void BubbleSort(int[] arr){
		System.out.println("最初的数组是:"+print(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j+1]){
					int c = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = c;
				}
			}
			System.out.println("第 "+(i+1)+"次冒泡后:"+print(arr));
		}
		System.out.println("数组冒泡排序:"+print(arr));
//		print(arr);
	}
	
	/**
	 * @author LiuTao @date 2019年12月31日 上午9:57:27 
	 * @Title: SelectionSort 
	 * @Description: 选择排序
	 */
	public static void SelectionSort(int[] arr) {
		System.out.println("最初的数组是:"+print(arr));
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i; j < arr.length-1; j++) {
				if (arr[min] > arr[j + 1]) {
					min = j + 1;
                }
			}
			swap(arr, i, min);
			System.out.println("第 "+(i+1)+"次选择后:"+print(arr));
		}
		System.out.println("数组选择排序:"+print(arr));
	} 
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	/**
	 * @author LiuTao @date 2020年1月3日 下午3:00:46 
	 * @Title: InsertionSort 
	 * @Description: 插入排序 ------对象排序
	 */
	public static void InsertionSort(int[] arr) {
		System.out.println("最初的数组是:" + print(arr));
		for (int i = 1; i < arr.length; i++) {
			int preIndex = i - 1;
			int current = arr[i];
			while (preIndex >= 0 && arr[preIndex] > current) {
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex + 1] = current;
			System.out.println("第 "+(i)+"次插入后:"+print(arr));
		}
		System.out.println("最初的数组是:" + print(arr));
	}
	
	public static String print(int[] arrary){
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < arrary.length; i++) {
			if(i == 0)
				sb.append(arrary[i]);
			else
				sb.append(", "+arrary[i]);
		}
		sb.append("]");
		return sb.toString();
	}
	/**
	 * @author LiuTao @date 2020年1月10日 上午11:21:54 
	 * @Title: Test 
	 * @Description: TODO(Describe)
	 */
	public static void Test(){
		int[] arrary = new int[10];
		arrary[0] = 12;
		arrary[1] = 4;
		arrary[2] = 22;
		arrary[3] = 15;
		arrary[4] = 24;
		arrary[5] = 23;
		arrary[6] = 8;
		arrary[7] = 6;
		arrary[8] = 21;
		arrary[9] = 13;
		System.out.println(arrary.length);
		print(arrary);
		for (int i = 0; i < arrary.length; i++) {
			for (int j = 0; j < arrary.length - 1; j++) {
				int o;
				if(arrary[i] > arrary[i+1]){
					o = arrary[i+1];
					arrary[i+1] = arrary[i];
					arrary[i] = o;
				}
			}
			print(arrary);
		}
		print(arrary);
	}

	public static void test001() {
		String str = "";
		StringBuilder result = new StringBuilder();
		if (str != null && str.length() > 0) {
			// 将第一个字符处理成大写
			result.append(str.substring(0, 1)/* .toLowerCase() */);
			// 循环处理其余字符
			for (int i = 1; i < str.length(); i++) {
				String s = str.substring(i, i + 1);
				// 在大写字母前添加下划线除首字母大写外
				if (s.equals(s.toUpperCase())
						&& !Character.isDigit(s.charAt(0))) {
					result.append("_");
				}
				// 其他字符直接转成大写
				result.append(s/* .toLowerCase() */);
			}
		}
		System.out.println(result.toString().toLowerCase());
	}

	public static void test002() {
		String s = "M";
		Character c = s.charAt(0);
		System.out.println(c);
		// Class<?> clazz = Table.class;
		// Table annotation = (Table)
		// BasicUtil.getClassAnnotationByReflectAnnotationClass(this.entity,
		// clazz);
	}

	public static void test003() {
		// SystemDate date = new SystemDate();
		// date.setDateType("1213");
		// date.setToday("20181114");
		// Map<String, Object> map =
		// BasicReflection.getPKMapByReflectObejct(date);
		// System.out.println(map);
	}
}




class postfix {
	
	/**
	 * @author LiuTao @date 2020年1月10日 下午4:44:05 
	 * @Title: outPostfix 
	 * @Description: TODO(Describe) 
	 * @param infix
	 * @return
	 */
    public static String[] outPostfix(String[] infix){
        String[] postfix = new String[100];
        int index = 0;
        int bracket = 0; //标记括号的对数
        Map<String, Object> operatorMap = new HashMap<String, Object>(); // 用hashmap存储每个运算符的优先度
        operatorMap.put("+", 1);
        operatorMap.put("-", 1);
        operatorMap.put("*", 2);
        operatorMap.put("/", 2);
        Stack<String> postfixStack = new Stack<>(); //用于存储后缀算法的运算符
        for (int i = 0; i < infix.length && infix[i] != null; i++) {
            String current = infix[i];
            if (current.charAt(0) >= '0' && current.charAt(0) <= '9'){ //遇到数字直接放入后缀数组
                postfix[index++] = current;
            }else {
                if (postfixStack.isEmpty()){ //保证后缀运算符栈不为空
                    postfixStack.push(current);
                }
                /**
                 * 如果括号已经全部处理，而且当前字符不是括号，
                 * 后缀运算符栈顶不是括号，并且栈顶运算符优先度小于当前运算符优先度，
                 * 将当前遍历运算符后边的数字放入后缀数组中，再将当前运算符放入后缀数组中。
                 */
                else if (bracket == 0 && !isBracket(current) &&
                        !isBracket(postfixStack.peek()) &&
                        Integer.parseInt(String.valueOf(operatorMap.get(postfixStack.peek()))) < Integer.parseInt(String.valueOf(operatorMap.get(current)))){
                    postfix[index++] = infix[i + 1];
                    postfix[index++] = infix[i];
                    i++;
                }
                /**
                 * 同理 栈顶运算符优先度大于等于当前运算符优先度,
                 * 将栈顶运算符放入后缀数组中，再将当前遍历的运算符放入栈中
                 */
                else if (bracket == 0 && !isBracket(current) &&
                        !isBracket(postfixStack.peek()) &&
                        Integer.parseInt(String.valueOf(operatorMap.get(postfixStack.peek()))) >= Integer.parseInt(String.valueOf(operatorMap.get(current)))){
                    postfix[index++] = postfixStack.pop();
                    postfixStack.push(current);
                }
                else {
                    if (current.equals("(")) bracket++; // 若遇到左括号，bracket加1
                    postfixStack.push(current);
                    if (postfixStack.peek().equals(")")){ //遇到右括号，bracket减1，同时将栈中括号间的运算符出栈
                        bracket--;
                        postfixStack.pop();
                        while (!postfixStack.peek().equals("(")){
                            postfix[index++] = postfixStack.pop();
                        }
                        postfixStack.pop();
                    }
                }
            }
        }
        while (!postfixStack.isEmpty()) postfix[index++] = postfixStack.pop();
        return postfix;
    }
    public static double result(String[] postfix){
        double result = 0;
        Stack<Double> computeStack = new Stack<Double>();
        for (int i = 0; i < postfix.length && postfix[i] != null; i++) {
            String current = postfix[i];
            //当前字符为数字，则入栈
            if (current.charAt(0) >= '0' && current.charAt(0) <= '9'){
                computeStack.push(todouble(current));
            }
            //当前字符为运算符，从栈顶取出两个数字运算出结果，并放入栈中
            else {
                switch (current){
                    case "+": result = computeStack.pop() + computeStack.pop();
                    computeStack.push(result);break;
                    case "-": result = -(computeStack.pop() - computeStack.pop());
                    computeStack.push(result);break;
                    case "*": result = computeStack.pop() * computeStack.pop();
                    computeStack.push(result);break;
                    case "/": result = 1 / (computeStack.pop() / computeStack.pop());
                    computeStack.push(result);break;
                    default: break;
                }
            }
        }
        return result;
    }
    public static double todouble(String str){
        double num = 0;
        num = Double.valueOf(Integer.parseInt(str));
        return num;
    }
    public static boolean isBracket(String str){
        if (str.equals("(") || str.equals(")")) return true;
        else return false;
    }
    public static void main(String[] args){
        String[] infix = new String[]{"9", "+", "(", "3",  "-", "1", ")", "*", "3", "+", "10", "/", "2"};
        String[] infix1 = new String[100];
        int i = 0;
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            infix1[i++] = in.nextLine();
        }
        in.close();
        infix = outPostfix(infix1);
        for (i = 0; i < infix.length && infix[i] != null; i++) {
            System.out.print(infix[i] + " ");
        }
        System.out.print("\n");
        System.out.println(result(infix));
    }
    
    public static void xiPaiSuanFa(){
//    	for (var i = this.rowCount * this.colCount - 1; i >= 0 ; i--){
//    		  var iX = parseInt(i / this.colCount);
//    		  var iY = i % this.colCount;
//
//    		  var randNumber = this.rangeRandom(0, i + 1);
//
//    		  var randX = parseInt(randNumber / this.colCount);
//    		  var randY = randNumber % this.colCount;
//
//    		 //交换两个位置
//    		  var temp = tmpMineMap[iX][iY];
//    		  tmpMineMap[iX][iY] = tmpMineMap[randX][randY];
//    		  tmpMineMap[randX][randY] = temp;
//    		}
    }
}

