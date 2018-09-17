package javaHansya.main.test;

public final class CodeEnum {

	// 読売新聞本社コード
	public static enum YOMIURI {
		YOMIURI_TY("TY","01"),
		YOMIURI_OS("OS","02"),
		YOMIURI_SB("SB","03");

		private String key;
		private String value;

		YOMIURI (String key, String value) {
			this.key = key;
			this.value = value;
		}

		public static YOMIURI getYomiuri (String key) {
			for (YOMIURI ce : YOMIURI.values()) {
				if (ce.getKey() == key) {
					return ce;
				}
			}
			return null;
		}

		public String getKey() { return key;}
		public String getValue() { return value;}
	}

	// テスト用コード1
	public static enum TESTCODE {
		TESTCODE_TY("TY","0"),
		TESTCODE_OS("OS","N"),
		TESTCODE_SB("SB","8");

		private String key;
		private String value;

		TESTCODE (String key, String value) {
			this.key = key;
			this.value = value;
		}

		public static TESTCODE getTestCode (String key) {
			for (TESTCODE ce : TESTCODE.values()) {
				if (ce.getKey() == key) {
					return ce;
				}
			}
			return null;
		}

		public String getKey() { return key;}
		public String getValue() { return value;}
	}

}
