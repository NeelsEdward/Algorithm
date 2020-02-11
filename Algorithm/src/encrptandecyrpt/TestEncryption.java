package encrptandecyrpt;

import java.util.Scanner;
public class TestEncryption {

	private static String KEY = "";
	private static String PASSWORD = "";
	private static String ENCODED_STR = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter password: ");
		PASSWORD = sc.nextLine();
		KEY = PasswordUtil.getRandomString(30);
		System.out.println("--------------Encoded Password--------------------");
		getEncodedString();
		System.out.println("--------------Decrypt With Invalid Key --------------------");		
		decryptionWhenKeyIsInvalid();
		System.out.println("--------------Decrypt With Invalid String --------------------");
		decryptionWhenStringIsInvalid();
		System.out.println("--------------Decrypt the password --------------------");
		decryptThePassword();
	}
	public static void getEncodedString(){
		try {
			ENCODED_STR = PasswordUtil.getSecurePassword(PASSWORD, KEY);
			System.out.println("Secure Password : " + ENCODED_STR);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void decryptionWhenKeyIsInvalid(){
		try {
			String keyAlter = KEY+"123";
			String result = PasswordUtil.decrypt(PASSWORD, keyAlter);
			System.out.println("Result : " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void decryptionWhenStringIsInvalid(){
		try {
			String strAltered = PASSWORD+"123";
			String result = PasswordUtil.decrypt(strAltered, KEY);
			System.out.println("Result : " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void decryptThePassword(){
		try {
			String result = PasswordUtil.decrypt(ENCODED_STR, KEY);
			System.out.println("Result : " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
