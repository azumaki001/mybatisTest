package javaHansya.main.test;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static List<String[]> csvList;

	public static void main(String[] args) {

//		String ty = "01";
//		if (ty == CodeEnum.YOMIURI_SB.getValue())
//			System.out.println("OK");
//		else
//			System.out.println("NG");
//		System.out.println(CodeEnum.getCodeEnum("SB"));


		// csvデータ初期化
		initCsv();

		// java反射テスト
		CheckUtil ck = CheckUtil.getInstance();
		CsvDataCheckFormat cf = new CsvDataCheckFormat ();
		try {
			ck.checkCsvData (csvList, cf);
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private static void initCsv() {
		// TODO 自動生成されたメソッド・スタブ
		String [] s1 = new String[] {"","0","漢字"};
		String [] s2 = new String[] {"01","9",""};
		String [] s3 = new String[] {"05","","一二三四五六"};
		csvList = new ArrayList<String[]> ();
		csvList.add(s1);
		csvList.add(s2);
		csvList.add(s3);
	}

}
