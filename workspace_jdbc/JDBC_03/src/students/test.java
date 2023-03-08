package students;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class test {

	public static String getSHA512(String input) {
		String toReturn = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public static String sha256(String msg) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		StringBuilder builder = new StringBuilder();
		for (byte b : md.digest()) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
	
	public static void main(String[] args) throws Exception {

		// 단반향 암호화 SHA 연습

		String result = getSHA512("Test");
		System.out.println(result);
		System.out.println(result.length());
		String result2 = sha256("Test");
		System.out.println(result2);
		System.out.println(result2.length());
		String result3 = sha256("Tesu");
		System.out.println(result3);
		
		Object o = new Object();
		
		String value1 = "Hello";
		System.out.println(value1);
		
		ArrayList<String> value2 = new ArrayList<>();
		value2.add("Apple");
		value2.add("Orange");
		System.out.println(value2);
		System.out.println(o);
	}
}
