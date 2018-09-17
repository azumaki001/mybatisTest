package javaHansya.main.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CheckUtil {
	private static CheckUtil INSTANCE = null;
	public static HashMap<String, Object[]> codeEnumMap = null;

	 public static CheckUtil getInstance() {
	       if(INSTANCE == null) {
	          INSTANCE = new CheckUtil();
	       }
	       return INSTANCE;
	    }

	 private CheckUtil() {
		try {
			getCodeEnum();
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void getCodeEnum() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// CodeEnum対象取得
		//		CodeEnum ce = new CodeEnum ();
		//		Class<?> codeEnumClazz = ce.getClass();
		Class codeEnumClazz = CodeEnum.class;
		CodeEnum ce = (CodeEnum) codeEnumClazz.newInstance();
		@SuppressWarnings("rawtypes")
		Class[] innerClazz = codeEnumClazz.getDeclaredClasses();
		if (codeEnumMap == null) {
			codeEnumMap = new HashMap<String,Object[]> ();
		}
		for (@SuppressWarnings("rawtypes")Class tempClazz : innerClazz) {
//			Method method = tempClazz.getMethod("values");
//			Object oj = method.invoke(null);
			String className = tempClazz.getName();
//			System.out.println(className.substring(className.indexOf("$")+1));
			Method[] methods = tempClazz.getDeclaredMethods();
			List<?> list = Arrays.asList(tempClazz.getEnumConstants());
			Object [] tempCodeEnumArray = new String[] {};
			List <String> tempCodeEnumList = new ArrayList<String> ();
			for(Object enu : list){
                for(Method method : methods){
                    if(method.getName().startsWith("getV")){
                    	tempCodeEnumList.add(method.invoke(enu).toString());
//                        System.out.println(method.invoke(enu));
                    }
                }
            }
            tempCodeEnumArray = tempCodeEnumList.toArray();
            codeEnumMap.put(className.substring(className.indexOf("$")+1), tempCodeEnumArray);

//			int i = tempClazz.getModifiers();
//			String s = Modifier.toString(i);
//			Class tempEnumClazz = null;
//			if (s.contains("static")) {
//				tempEnumClazz = (Class) tempClazz.getConstructor().newInstance();
//			} else {
//				tempEnumClazz = (Class) tempClazz.getConstructor(codeEnumClazz.getClass()).newInstance(codeEnumClazz);
//			}
//
//			Method method2 = tempEnumClazz.getMethod("getValue");
//			Object oj2 = method2.invoke(null);
		}

		String m = "";
		System.out.println(m);

//		Field[] codeEnumField = codeEnumClazz.getDeclaredFields();
//		String s = "";

	}

	public boolean checkCsvData(List<String[]> csvList, Object obj)
			throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException {

		// CheckFormat対象を取得
		Class<?> checkClazz = obj.getClass();
		Field[] checkField = checkClazz.getFields();

		int dataCnt = 0;
		for (String[] tempData : csvList) {
			int colCnt = 0;
			while (colCnt < tempData.length) {
				String[] colFormat = (String[]) checkField[colCnt].get(obj);
				// １．必須チェック
				if (!"".equals(colFormat[1])) {
					if (tempData[colCnt] == null || "".equals(tempData[colCnt])) {
						System.out.println(colFormat[0] + "がnull;" + (dataCnt+1) + "行目");
						colCnt++;
						continue;
					}
				}
				// ２．型・桁数チェック
				String[] typeCheck = colFormat[2].split(",");
				for (String tempTypeCheck : typeCheck) {
					switch (tempTypeCheck) {
					case "isNum":
						isNum(tempData[colCnt], colFormat[3], colFormat[4]);
						break;
					case "isNumAlp":
						isNumAlp(tempData[colCnt], colFormat[3], colFormat[4]);
						break;
					case "isKanji":
						isKanji(tempData[colCnt], colFormat[3], colFormat[4]);
						break;
					}
				}

				// ３．コード値内容チェック
				if (!"".equals(colFormat[5])) {
					Object[] codeEnumArray = codeEnumMap.get(colFormat[5]);
					boolean codeErr = true;
					for (Object oj : codeEnumArray) {
						if (tempData[colCnt].equals(oj)) {
							codeErr = false;
						}
					}
					if (codeErr)
						System.out.println("コード値がCodeNumに定義した値と一致しない。" + (dataCnt+1) + "行目");
				}

				//System.out.println(colFormat);
				colCnt++;
			}
			dataCnt++;
		}
		return false;
	}

	private void isKanji(String columData, String min, String max) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void isNumAlp(String columData, String min, String max) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void isNum(String columData, String min, String max) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
