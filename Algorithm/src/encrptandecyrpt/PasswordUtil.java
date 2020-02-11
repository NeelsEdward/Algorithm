package encrptandecyrpt;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class PasswordUtil {

	private static final String KEY = "saloni12345@&*(%neha#$%345454salne";
	private static final Random random = new SecureRandom();
	private static final String INVALID_KEY = "Invalid key";
	private static final String INVALID_ENCODED_STRING = "Invalid encoded string";
	private static final Map<String, List<String>> keyMap = new LinkedHashMap<String, List<String>>();
	
	public static  String getRandomString(int length){
		StringBuilder returnVal = new StringBuilder(length);
		
		for(int i=0;i<length;i++){
			returnVal.append(KEY.charAt(random.nextInt(KEY.length())));
		}
		return new String(returnVal);
	}

	public static String getSecurePassword(String password, String key) throws Exception {

		String encodedString = Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
		if (!isKeyExist(key)) {
			List<String> list = new ArrayList<String>();
			list.add(encodedString);
			keyMap.put(key, list);
		} else {
			keyMap.get(key).add(encodedString);
		}
		return encodedString;
	}

	public static String decrypt(String strEncrypted, String key) throws UnsupportedEncodingException {

		if (!isKeyExist(key)) {
			return INVALID_KEY;
		}
		if (!isEncodedStringExist(strEncrypted, key)) {
			return INVALID_ENCODED_STRING;
		}
		byte[] decodeStr = Base64.getDecoder().decode(strEncrypted);
		return new String(decodeStr, "utf-8");
	}

	private static boolean isKeyExist(String key) {

		return keyMap.containsKey(key);
	}

	private static boolean isEncodedStringExist(String strEncrypted, String key) {

		List<String> list = keyMap.get(key);
		if (list.size() == 0) {
			return false;
		}
		for (String str : list) {
			if (str.equals(strEncrypted)) {
				return true;
			}
		}

		return false;
	}
}
