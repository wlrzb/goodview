package goodview.data.util;

import java.util.Properties;

public class GoodviewConfig extends Properties{
	private static final GoodviewConfig s_config = new GoodviewConfig();
	
	public static String get(String key) {
		return s_config.getProperty(key);
	}
}
