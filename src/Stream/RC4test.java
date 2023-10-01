package Stream;

import java.util.Scanner;
import java.util.Random;

public class RC4test {
	static String keyStream = "";
	static Integer S[] = new Integer[256];// S琛�
	static Integer T[] = new Integer[256];// T琛�
	static String cipherCode = "";
	static String trueKey = "";
	static String realStream="";

	public static void main(String[] args) {
	}

	public static String printS() {
		String Scode = "";
		for (int i = 0; i < S.length; i++) {
			Scode = Scode + S[i] + " ";
		}
		return Scode;
	}

	public static String printT() {
		String Tcode = "";
		for (int i = 0; i < T.length; i++) {
			Tcode = Tcode + T[i] + " ";
		}
		return Tcode;
	}

	public static String generateRandomKey(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder(length);
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}

	public static String processDecryption(String decryptKey, int length, String decryptCipher) {
		char[] originalCipher = new char[length];
		int keyLength = decryptKey.length();
		char[] tempKey = new char[keyLength];
		for (int i = 0; i < keyLength; i++) {
			tempKey[i] = decryptKey.charAt(i);
		}
		// 处理密文
		int tempal;
		int counter = 0;
		for (int i = 0; i < 2 * length; i = i + 2) {
			if ((int) decryptCipher.charAt(i + 1) - 48 == 9) {
				tempal = (int) decryptCipher.charAt(i) - 50;
				originalCipher[counter] = (char) tempal;
			} else {
				tempal = ((int) decryptCipher.charAt(i + 1) - 48) * 50 + (int) decryptCipher.charAt(i);
				originalCipher[counter] = (char) tempal;
			}
			counter++;
		}
		// 处理密钥
		permutateS(S, T, tempKey);
		char keyValue[] = new char[2 * length];
		trueKey = GenerateKeys(S, length, keyValue);
		char[] authenticKey = new char[length];
		authenticKey = getRealKey(trueKey);
		System.out.print(authenticKey);
		String trueCode = "";
		trueCode = decrypt(authenticKey, length, originalCipher);
		return trueCode;

	}

	public static void intialize(String k1, String plain) {
		System.out.println("密钥为:" + k1);
		int m = k1.length();// 瀵嗛挜闀垮害
		char K[] = new char[m];// 瀵嗛挜绌洪棿

		for (int i = 0; i < m; i++) {
			K[i] = k1.charAt(i);
		}

		permutateS(S, T, K);// S琛ㄦ帓搴�
		System.out.println("明文为");
		int n = plain.length();
		char plainToExcute[] = new char[n];// 鏄庢枃绌洪棿锛�
		for (int i = 0; i < n; i++) {
			plainToExcute[i] = plain.charAt(i);
		}
		char keys[] = new char[2 * n];// 瀵嗛挜娴侊紱
		keyStream = GenerateKeys(S, n, keys);// 浜х敓瀵嗛挜娴�
		char realKey[] = new char[n];
		realKey = getRealKey(keyStream);
		System.out.print(realKey);
		char C[] = new char[2 * n];// 瀵嗘枃绌洪棿锛�
		System.out.println();
		// cipherCode = encrypt(keys, n, plainToExcute, C);
		cipherCode = encrypt(realKey, n, plainToExcute, C);
		System.out.println("密文为：");
		System.out.print(cipherCode);

	}

	public static void permutateS(Integer S[], Integer T[], char K[]) {// 鍒濆鎺掑垪S琛紱
		for (int i = 0; i < 256; i++) {

			S[i] = i;
		}
		int t[] = new int[256];
		for (int i = 0; i < 256; i++) {
			t[i] = K[i % K.length];
			T[i] = t[i];
		}
		int j = 0;
		for (int i = 0; i < 255; i++) {
			j = (j + S[i] + T[i]) % 256;
			int temp;
			temp = S[i];
			S[i] = S[j];
			S[j] = temp;
		}
	}

	public static String GenerateKeys(Integer S[], int n, char keys[]) {// 生成密钥
		int i = 0, j = 0, r = 0;
		String tempKEY = "";
		int keyForint[] = new int[2 * n];// 鏄庢枃绌洪棿
		int keyStreamReal[] = new int[n];
		int binaryStringLength;
		int padding;
		String binaryString="";
		String paddedBinaryString="";
		for (int u = 0; u < 2 * n; u++) {
			i = (i + 1) % 256;
			j = (j + S[i]) % 256;
			int temp;
			int tempVal = 0;
			temp = S[i];
			S[i] = S[j];
			S[j] = temp;
			r = (S[i] + S[j]) % 256;
			if (u % 2 == 0||u==0) {
				keyStreamReal[u/2] = S[r].intValue();
			}
			keyForint[u] = S[r].intValue();
			if (keyForint[u] > 126) {
				for (tempVal = 0; keyForint[u] > 126; tempVal++) {
					keyForint[u] = keyForint[u] - 50;
				}
			} else if (keyForint[u] < 32) {
				keyForint[u] = keyForint[u] + 50;
				tempVal = 6;
			}
			keys[u] = (char) keyForint[u];
			keyForint[u + 1] = tempVal;
			keys[u + 1] = (char) (tempVal + '0');
			tempKEY = tempKEY + keys[u] + keys[u + 1];
			u++;
		}
		System.out.println("密钥流为");
		System.out.println(keys);
		for(int h=0;h<keyStreamReal.length;h++) {
			System.out.print(keyStreamReal[h]);
			binaryString=Integer.toBinaryString(keyStreamReal[h]);
			binaryStringLength = binaryString.length();
			padding = 8-binaryStringLength;
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < padding; x++) {
			    sb.append("0");
			}
			sb.append(binaryString);
			paddedBinaryString = sb.substring(Math.max(0, binaryStringLength - 8));
			realStream=realStream+paddedBinaryString;
		}
		System.out.println("");
		return tempKEY;
	}

	public static char[] getRealKey(String fakeKey) {
		int tempIndex;
		char realKey[] = new char[fakeKey.length() / 2];
		int rK[] = new int[fakeKey.length() / 2];
		int count = 0;
		for (int i = 0; i < fakeKey.length(); i = i + 2) {
			if ((int) fakeKey.charAt(i + 1) - 48 == 6) {
				tempIndex = (int) fakeKey.charAt(i) - 50;
				rK[count] = tempIndex;
			} else {
				tempIndex = ((int) fakeKey.charAt(i + 1) - 48) * 50 + (int) fakeKey.charAt(i);
				realKey[count] = (char) tempIndex;
				rK[count] = tempIndex;
			}
			count++;
		}
		/*
		 * System.out.println("整数："); for(int k=0;k<rK.length;k++) {
		 * System.out.print(rK[k]+" "); }
		 */
		return realKey;
	}

	public static String encrypt(char keys[], int n, char P[], char C[]) {// 加密
		int temp = 0;
		int tempVal = 0;
		System.out.println("密钥对应的整数：");
		for (int i = 0; i < keys.length; i++) {
			System.out.print((int) keys[i] + " ");
		}
		System.out.println("");
		System.out.println("明文对应的整数：");
		for (int i = 0; i < P.length; i++) {
			System.out.print((int) P[i] + " ");
		}
		System.out.println("");
		System.out.println("密文对应的整数：");
		String cipherText = "";
		for (int i = 0; i < n; i++) {
			int op;
			op = P[i] ^ keys[i];
			System.out.print(op + " ");
			tempVal = 0;
			if (op > 126) {
				for (tempVal = 0; op > 126; tempVal++) {
					op = op - 50;
				}
			} else if (op < 32) {
				op = op + 50;
				tempVal = 9;
			}
			C[temp] = (char) op;
			C[temp + 1] = (char) (tempVal + '0');
			cipherText = cipherText + C[temp] + C[temp + 1];
			temp++;
			// System.out.println("op"+op);
			// System.out.println("C[i]"+C[i]);

		}
		System.out.println("");
		return cipherText;
	}

	public static String decrypt(char keys[], int n, char C[]) {// 解密
		char D[] = new char[256];
		String plain = "";
		System.out.println("");
		System.out.println("密钥对应的整数：");
		for (int i = 0; i < keys.length; i++) {
			System.out.print((int) keys[i] + " ");
		}
		System.out.println("密文对应的整数：");
		for (int i = 0; i < C.length; i++) {
			System.out.print((int) C[i] + " ");
		}
		System.out.println("明文对应的整数：");
		for (int i = 0; i < n; i++) {
			int op;
			op = C[i] ^ keys[i];
			D[i] = (char) op;
			System.out.print(op + " ");
			plain = plain + D[i];
		}

		return plain;
	}
}
