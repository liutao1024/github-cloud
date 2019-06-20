package cn.spring.mvn.system.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;

@SuppressWarnings("unused")
public class SystemUtil {
//	public static Object getProperty(Object o, String fieldName)
//			throws IllegalAccessException, InvocationTargetException,
//			NoSuchMethodException {
//		PropertyUtil.PropertyAccessor pa = PropertyUtil.createAccessor(o);
//		if (pa == null)
//			return null;
//		return pa.getNestedProperty(fieldName);
//	}
//
//	public static void setProperty(Object o, String fieldName, Object value)
//			throws IllegalAccessException, InvocationTargetException,
//			NoSuchMethodException {
//		PropertyUtil.PropertyAccessor pa = PropertyUtil.createAccessor(o);
//		if (pa == null)
//			return;
//		pa.setNestedProperty(fieldName, value);
//	}

	public static Class<?> getPropType(Class<?> clazz, String fieldName) {
		Field field = FieldUtils.getField(clazz, fieldName);
		if (field != null)
			return field.getType();
		return null;
	}


//	public static <T extends Enum<T>> boolean isInEnum(Class<T> enumCls,
//			Object value) {
//		return EnumUtils.isInEnum(enumCls, value);
//	}

//	public static <T extends Enum<T>> T toEnum(Class<T> enumCls, Object value) {
//		return EnumUtils.toEnum(enumCls, value);
//	}

	
//	public static BigDecimal trunc(BigDecimal am) {
//		return am == null ? null : Convert.toBigDecimal(am, (BigDecimal) null);
//	}
//
//	public static BigDecimal round(BigDecimal amt, int scale) {
//		return round(amt, scale, 4);
//	}

	public static enum Operator {
		add("add", "add", "加"),
		sub("sub", "sub", "减"),
		mul("mul", "mul", "乘"),
		div("div", "div", "除");

		private String id;
		private String value;
		private String longName;

		private Operator(String id, String value, String longName) {
			this.id = id;
			this.value = value;
			this.longName = longName;
		}

		public Object add(Object data1, Object data2) {
			return null;
		}

		public Object sub(Object data1, Object data2) {
			return null;
		}

		public Object mul(Object data1, Object data2) {
			return null;
		}

		public Object div(Object data1, Object data2) {
			return null;
		}
	}

//	public static Map<String, Object> toMap(Object bean) {
//		if (bean == null)
//			return null;
//		if ((bean instanceof Map))
//			return (Map) bean;
//		throw LangUtil.wrapThrow("类型[%s]不是Map类型不能转换", new String[] { bean
//				.getClass().getName() });
//	}
//
//	public static String createGUID() {
//		RandomGUID rg = new RandomGUID();
//		return rg.getValueAfterMD5();
//	}

//	public static List<Map<String, Object>> toListMap(List<?> list) {
//		if (list == null)
//			return null;
//		List ret = new ArrayList();
//		Object o;
//		for (Iterator i$ = list.iterator(); i$.hasNext(); ret.add(toMap(o)))
//			o = i$.next();
//		return ret;
//	}

//	public static void copyProperties(Object dest, Object src) {
//		copyProperties(src, dest, true);
//	}
//
//	public static void copyPropertiesWithTypeConvert(Object dest, Object src) {
//		copyPropertiesWithTypeConvert(dest, src, true);
//	}

//	public static void copyPropertiesWithTypeConvert(Object dest, Object src,
//			boolean withNoEmpty) {
//		BeanUtil.copyProperties(src, dest, withNoEmpty, null, true);
//	}
//
//	public static void copyProperties(Object src, Object dest,
//			boolean withNoEmpty) {
//		BeanUtil.copyProperties(src, dest, withNoEmpty, null, false);
//	}
//
//	public static void copyElement(Object src, Object dest, boolean withNoEmpty) {
//		BeanUtil.copyProperties(src, dest, withNoEmpty, null, false);
//	}
//
//	public static void copyPropertyList(Object dest, Object src,
//			String[] propList) {
//		BeanUtil.copyProperties(src, dest, true, Arrays.asList(propList), false);
//	}

	public static <T> T nvl(T s, T defaultValue) {
		return isNull(s) ? defaultValue : s;
	}

	public static boolean isNull(Object o) {
//		if (StringUtil.isEmpty(o))
//			return true;
//		if ((o instanceof ByRef))
//			return ((ByRef) o).value == null;
		return false;
	}

	public static boolean isNotNull(Object o) {
		return !isNull(o);
	}

	public static String trim(String s) {
		return s == null ? null : s.trim();
	}

	public static String rtrim(String s) {
		if (s == null)
			return null;
		StringBuffer sb = new StringBuffer(s);
		for (int i = sb.length() - 1; (i >= 0) && (sb.charAt(i) == ' '); i--) {
			sb.deleteCharAt(i);
		}

		return sb.toString();
	}

	public static String ltrim(String s) {
		if (s == null)
			return null;
		String ret = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				ret = s.substring(i);
				break;
			}
		}
		return ret;
	}

	public static String lpad(String s, int i, String s1)
  {
    if (s == null)
      return null;
    if ((s1 == null) || (s1.length() <= 0))
      throw new IllegalArgumentException("进行lpad的添加字符串不能为null且长度不能为0!");
    if (i <= 0)
      throw new IllegalArgumentException("进行lpad的长度无效!");
    if (i <= s.length()) {
      return s.substring(0, i);
    }
    StringBuffer sb = new StringBuffer(s);
    char[] c1 = s1.toCharArray();
    int index = 0;

//    for (; sb.length() < i; 
//      goto 85)
//    {
      index = 0;
      if ((sb.length() < i) && (index < c1.length))
      {
        sb.insert(0, c1[(index++)]);
      }
//    }
    return sb.toString();
  }

	public static String rpad(String s, int i, String s1)
  {
    if (s == null)
      return null;
    if ((s1 == null) || (s1.length() <= 0))
      throw new IllegalArgumentException("进行Rpad的添加字符串不能为null且长度不能为0!");
    if (i <= 0)
      throw new IllegalArgumentException("进行Rpad的长度无效!");
    if (i <= s.length()) {
      return s.substring(0, i);
    }
    StringBuffer sb = new StringBuffer(s);

    char[] c1 = s1.toCharArray();
    int index = 0;

//    for (; sb.length() < i; 
//      goto 85)
//    {
      index = 0;
      if ((sb.length() < i) && (index < c1.length))
      {
        sb.append(c1[(index++)]);
      }
//    }
    return sb.toString();
  }

	public static boolean like(String s1, String s2) {
		if ((s1 == null) || (s2 == null))
			throw new IllegalArgumentException("like函数参数值无效!");
		int len = s2.length();
		boolean startWith = false;
		boolean endWith = false;

		if (s2.charAt(0) == '%') {
			startWith = true;
		}

		int p = s2.indexOf(37, 1);
		if ((p > 0) && (p < s2.length() - 1)) {
			throw new IllegalArgumentException("like函数不支持中间匹配!");
		}

		if (s2.charAt(len - 1) == '%') {
			endWith = true;
		}
		s2 = s2.replace("%", "");
		if ((startWith) && (endWith))
			return s1.indexOf(s2) >= 0;
		if (startWith)
			return s1.startsWith(s2);
		if (endWith) {
			return s1.endsWith(s2);
		}
		return s1.equals(s2);
	}

	public static boolean in(Object a, Object[] a1) {
		if (a == null)
			return false;
		if ((a1 == null) || (a1.length <= 0))
			throw new IllegalArgumentException("In函数参数值无效!");
		for (int i = 0; i < a1.length; i++) {
			if (!a.getClass().isAssignableFrom(a1[i].getClass()))
				throw new IllegalArgumentException("In函数参数类型必须相同!");
			if (compare(a, a1[i]) == 0)
				return true;
		}
		return false;
	}

	public static <T> boolean in(T object, List<T> objects) {
		return objects.indexOf(object) >= 0;
	}

	public static boolean Between(Object a, Object start, Object end) {
		if ((a == null) || (start == null) || (end == null))
			throw new IllegalArgumentException("Between函数参数值无效!");
		if ((!a.getClass().isAssignableFrom(start.getClass()))
				|| (!a.getClass().isAssignableFrom(end.getClass())))
			throw new IllegalArgumentException("Between函数参数类型必须相同!");
		if ((compare(a, start) >= 0) && (compare(a, end) <= 0)) {
			return true;
		}
		return false;
	}

	public static int compare(BigDecimal o1, BigDecimal o2) {
		if ((o1 == null) && (o2 == null))
			return 0;
		if ((o1 == null) && (o2 != null)) {
			return -1;
		}
		if ((o1 != null) && (o2 == null)) {
			return 1;
		}
		return o1.compareTo(o2);
	}

	public static int compare(String o1, String o2, boolean ignoreCase,
			boolean ignoreNullAndEmpty) {
		if ((o1 == null) && (o2 == null))
			return 0;
		if ((o1 == null) && (o2 != null)) {
			if ((ignoreNullAndEmpty) && ("".equals(o2))) {
				return 0;
			}
			return -1;
		}
		if ((o1 != null) && (o2 == null)) {
			if ((ignoreNullAndEmpty) && ("".equals(o1))) {
				return 0;
			}
			return 1;
		}
		if (ignoreCase) {
			return o1.compareToIgnoreCase(o2);
		}
		return o1.compareTo(o2);
	}

	public static int compare(Object o1, Object o2, boolean ignoreNullAndEmpty) {
		if ((o1 == null) && (o2 == null))
			return 0;
		if ((o1 == null) && (o2 != null)) {
			if ((ignoreNullAndEmpty) && ("".equals(o2))) {
				return 0;
			}
			return -1;
		}
		if ((o1 != null) && (o2 == null)) {
			if ((ignoreNullAndEmpty) && ("".equals(o1))) {
				return 0;
			}
			return 1;
		}
//		if ((o1.getClass() == o2.getClass()) && ((o1 instanceof Comparable))) {
//			return ((Comparable) o1).compareTo(o2);
//		}
//		if (Number.class.isAssignableFrom(o1.getClass())) {
//			BigDecimal b1 = Convert.toBigDecimal(o1, (BigDecimal) null);
//			BigDecimal b2 = Convert.toBigDecimal(o2, (BigDecimal) null);
//			return b1.compareTo(b2);
//		}
		if (BigDecimal.class.isAssignableFrom(o1.getClass())) {
			return ((BigDecimal) o1).compareTo((BigDecimal) o2);
		}
		if (java.util.Date.class.isAssignableFrom(o1.getClass()))
			return ((java.util.Date) o1).compareTo((java.util.Date) o2);
		if (java.sql.Date.class.isAssignableFrom(o1.getClass()))
			return ((java.sql.Date) o1).compareTo((java.sql.Date) o2);
//		if (Time.class.isAssignableFrom(o1.getClass()))
//			return ((Time) o1).compareTo((Time) o2);
//		if (Timestamp.class.isAssignableFrom(o1.getClass()))
//			return ((Timestamp) o1).compareTo((Timestamp) o2);
		if (Short.class.isAssignableFrom(o1.getClass()))
			return ((Short) o1).compareTo((Short) o2);
		if (Integer.class.isAssignableFrom(o1.getClass()))
			return ((Integer) o1).compareTo((Integer) o2);
		if (Long.class.isAssignableFrom(o1.getClass()))
			return ((Long) o1).compareTo((Long) o2);
		if (Float.class.isAssignableFrom(o1.getClass()))
			return ((Float) o1).compareTo((Float) o2);
		if (Double.class.isAssignableFrom(o1.getClass()))
			return ((Double) o1).compareTo((Double) o2);
//		if (ByRef.class.isAssignableFrom(o1.getClass())) {
//			return compare(((ByRef) o1).value, ((ByRef) o2).value);
//		}
		return String.valueOf(o1).compareTo(String.valueOf(o2));
	}

	public static int compare(Object o1, Object o2) {
		return compare(o1, o2, true);
	}

//	public static BigDecimal trunc(BigDecimal am) {
//		return am == null ? null : Convert.toBigDecimal(am, (BigDecimal) null);
//	}

	public static BigDecimal round(BigDecimal amt, int scale) {
		return round(amt, scale, 4);
	}

	public static BigDecimal round(BigDecimal amt, int scale, int roundingMode) {
		if (amt == null)
			return null;
		if (scale < 0)
			throw new IllegalArgumentException("round精度不能为负数!");
		return amt.setScale(scale, roundingMode);
	}

	public static long floor(Object val) {
		if (val == null)
			throw new IllegalArgumentException("Floor参数不能为null!");
		if ((val instanceof BigDecimal))
			return ((BigDecimal) val).longValue();
		if (((val instanceof Double)) || ((val instanceof Float)))
			return new Double(Math.floor(((Double) val).doubleValue()))
					.longValue();
		if ((val instanceof Long))
			return ((Long) val).longValue();
		return 0L;
	}

	public static long ceil(Object val) {
		if (val == null)
			throw new IllegalArgumentException("Ceil参数不能为null!");
		if ((val instanceof BigDecimal))
			return round((BigDecimal) val, 0, 2).longValue();
		if (((val instanceof Double)) || ((val instanceof Float)))
			return new Double(Math.ceil(((Double) val).doubleValue()))
					.longValue();
		return 0L;
	}

	public static boolean equals(Object o1, Object o2) {
		return compare(o1, o2) == 0;
	}

//	public static Map<String, Object> shrinkHttpParameters(
//			Map<String, String[]> parameters) {
//		boolean decode = parameters.containsKey("q:");
//		Map ret = new HashMap();
//		for (Map.Entry entry : parameters.entrySet()) {
//			String[] value = (String[]) entry.getValue();
//			String[] val = value;
//			if (val.length == 1) {
//				ret.put(entry.getKey(), convertHtmlParameter(val[0], decode));
//			} else {
//				List values = new ArrayList();
//				for (String v : val)
//					if (!StringUtil.isEmpty(v))
//						values.add(convertHtmlParameter(v, decode));
//				ret.put(entry.getKey(),
//						values.toArray(new String[values.size()]));
//			}
//		}
//		return ret;
//	}

	
	private static String convertHtmlParameter(String p, boolean decode) {
		if (decode)
			try {
				p = new String(p.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}

//		if (StringUtil.isNotEmpty(p))
//			p = p.replaceAll("(?im)<([\\s/]*(script|iframe|img))", "&lt;$1");
		return p;
	}
}