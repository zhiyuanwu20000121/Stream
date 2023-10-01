package Stream;

public class LFSRtest {
	//public static int n = 5;
	public static int n = 16;//��Կǿ��2^10
	public static int twoPowerN=(int)Math.pow(2, n);
	static int[] array;
	static int[] array2;
	static int[][] state,state2;
	static int[] seq,seq2;
	static int[] initialseq,initialseq2;
	static int s_num = 0;
	static int s_num2 = 0;
	static String key,key2,keyAlphabet1;
	static String ch;
	static int binary[][];
	static int[] M;
	static int count = 0;
	static int[] cipher;
	static int[] cipherCodeDecrypt;
	static int[] keyChain;
	static int[] c_M;
	static int lengthNum=0;
	static String initialKey="";
	static int XOR1 = (int)(Math.random() * 16);
	static int XOR2=XOR1;
	static void initialPositionForXOR(){
		while(XOR2==XOR1) {
			XOR2 = (int)(Math.random() * 16);
		}
		//System.out.println(XOR2);
		//System.out.println(XOR1);
	}
	static void initialLFSR(String realKey) {
		//array2 = new int[5];
		//initialseq2 = new int[n];
		//state2 = new int[32][5];// �洢״̬���ܹ���2^5��32�ֲ�ͬ��״̬
		//seq2 = new int[32];// �������
		int codeForMinus;
		codeForMinus=realKey.charAt(realKey.length()-1)-'0';
		System.out.print("��ȥ����Ϊ��"+codeForMinus);
		int recoverCode=0;
		array2 = new int[n];
		initialseq2 = new int[n];
		state2 = new int[twoPowerN][n];// �洢״̬���ܹ���2^5��32�ֲ�ͬ��״̬
		seq2 = new int[twoPowerN];// �������
		key2 ="";
		for (int times = 0; times < n; times++) {
		//for (int times = 0; times < 5; times++) {
			initialseq2[times] = ((int)realKey.charAt(times)+15-recoverCode)-'0';
			recoverCode=recoverCode+codeForMinus;
			//System.out.print("����");
			//System.out.print(initialseq2[times]);
		}
		for (int i = 0; i < n; i++) {
			array2[i] = initialseq2[i];
		}
		get_state(array2, state2[s_num2]);
		seq2[s_num2] = array2[0];
		for (int i = 1; i < twoPowerN; i++) {
		//for (int i = 1; i < 32; i++) {
			next(array2);
			++s_num2;
			get_state(array2, state2[s_num2]);
			seq2[s_num2] = array2[0];
		}
		for (int i = 0; i < twoPowerN; i++) {
		//for (int i = 0; i < 32; i++) {
			key2 = key2 + seq2[i];
		}
		//System.out.print("��ԿΪ");
		//System.out.print(key2);
	}
	static void initialLFSR() {
		//array = new int[5];
		//initialseq = new int[n];
		//state = new int[32][5];// �洢״̬���ܹ���2^5��32�ֲ�ͬ��״̬
		//seq = new int[32];// �������
		array = new int[n];
		initialseq = new int[n];
		state = new int[twoPowerN][n];// �洢״̬���ܹ���2^5��32�ֲ�ͬ��״̬
		seq = new int[twoPowerN];// �������
		key ="";
		keyAlphabet1="";
		for (int times = 0; times < n; times++) {
		//for (int times = 0; times < 5; times++) {
			initialseq[times] = ((int) (10 * Math.random())) % 2;
			initialKey=initialKey+initialseq[times];
		}
		//System.out.print(initialKey);
		for (int i = 0; i < n; i++) {
			array[i] = initialseq[i];
		}
		get_state(array, state[s_num]);
		//System.out.print(s_num + ":");
		//print(state[s_num]);
		seq[s_num] = array[0];
		for (int i = 1; i < twoPowerN; i++) {
		//for (int i = 1; i < 32; i++) {
			next(array);
			++s_num;
			get_state(array, state[s_num]);
			//System.out.print(s_num + ":");
			//print(state[s_num]);
			seq[s_num] = array[0];
		}
		for (int i = 0; i <twoPowerN; i++) {
		//for (int i = 0; i < 32; i++) {
			key = key + seq[i];
		}
		int tempForKey=0;
		int numAddKey = (int) (Math.random() * 6 + 1);
		for(int i=0;i<n;i++) {
			keyAlphabet1=keyAlphabet1+(char)((int)initialKey.charAt(i)+tempForKey-15);
			tempForKey=tempForKey+numAddKey;
		}
		if(numAddKey==1) {
			keyAlphabet1=keyAlphabet1+'1';
		}
		else if(numAddKey==2) {
			keyAlphabet1=keyAlphabet1+'2';
		}
		else if(numAddKey==3) {
			keyAlphabet1=keyAlphabet1+'3';
		}
		else if(numAddKey==4) {
			keyAlphabet1=keyAlphabet1+'4';
		}
		else if(numAddKey==5) {
			keyAlphabet1=keyAlphabet1+'5';
		}
		else if(numAddKey==6) {
			keyAlphabet1=keyAlphabet1+'6';
		}
		/*System.out.println(numAddKey);
		System.out.print("����Ϊ��");
		System.out.print(initialKey);
		System.out.println("");
		System.out.print("�����ֵ�Ϊ��");
		System.out.print(keyAlphabet1);*/
	}

	static int LFSR(int[] arr) {//n��LFSR,��ʱΪ16��
		int temp = arr[0] ^ arr[3];
		return temp;
	}

	static void print(int[] arr) {// ��ӡ
		System.out.print("��ǰ״̬:");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
		System.out.println("���: " + arr[0]);
	}

	// �����һ״̬
	static void next(int[] arr) {
		int a5 = LFSR(arr);
		for (int i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[n - 1] = a5;
	}

	// ���״̬���洢
	static void get_state(int[] arr, int[] s) {
		for (int i = 0; i < n; i++) {
			s[i] = arr[i];
		}
	}

	// Ϊ�˻�ȡ���ڶ�״̬���бȽ�
	static int cmp_s(int[][] s) {
		for (int i = 1; i < twoPowerN; i++) {
		//for (int i = 1; i < 32; i++) {
			int j;
			for (j = 0; j < n; j++) {
			//for (j = 0; j < 5; j++) {
				if (s[0][j] != s[i][j])
					break;
				else
					continue;
			}
			if (j == n) {
			//if (j == 5) {
				return i;
			}
		}
		return 0;
	}

	static String change(char ch) {
		// String data = null;
		StringBuilder data = new StringBuilder(1000);
		for (int i = 0; i < 8; i++) {
			// data+=c&(0x01<<i);
			if (((ch >> (i - 1)) & 0x01) == 1) {
				data.append('1');
			} else {
				data.append('0');
			}
		}
		for (int a = 1; a < 5; a++) {
		//for (int a = 1; a < 5; a++) {
			char x = data.charAt(a);
			data.setCharAt(a, data.charAt(8 - a));
			data.setCharAt(8 - a, x);
		}
		return data.toString();
	}

	static void enc(int[] cipher, int[] m, int[] seq, int num) {
		int counter = 0;
		int counter_num = 0;
		int num_8 = 8 * num;// num�����ַ������ȣ���Ϊ��8λ������λ��Ϊ8*�ַ�������
		while (counter_num < num_8) {
			cipher[counter_num] = seq[counter] ^ m[counter_num];
			counter++;
			counter_num++;
			if (counter == twoPowerN)
			//if (counter == 31)
				counter = 0;
		}
	}
	static void MtoBinary(String code) {
		ch=code;
		int i = 0;
		System.out.print("����Ϊ��");
		System.out.println(ch);
		binary = new int[200][8];
		for (int j = 0; j < ch.length(); j++) {
			int[] temp;
			temp = new int[8];
			String da;
			da = change(ch.charAt(j));
			for (i = 0; i < 8; i++) {
				temp[i] = da.charAt(i);
				if (temp[i] == 48)
					temp[i] = 0;
				else
					temp[i] = 1;
			}
			for (i = 0; i < 8; i++) {
				binary[j][i] = temp[i];
			}
		}
		M = new int[1600];
		for (i = 0; i < ch.length(); i++) {
			for (int j = 0; j < 8; j++) {
				M[count] = binary[i][j];
				count++;
			}
		}
	}
	
	static String showPlainCode() {
		String tempCode="";
		for (int i = 0; i < count; i++) {
			tempCode=tempCode+M[i];
		}
		return tempCode;
	}
	
	static String getCipher() {
		String cipherCode="";
		System.out.println("");
		System.out.println("���ı�ʾΪ��");
		cipher = new int[1600];
		enc(cipher, M, seq, ch.length());
		for (int i = 0; i < count; i++) {
			cipherCode=cipherCode+cipher[i];
			System.out.print(cipher[i]);
		}
		System.out.println("");
		return cipherCode;
	}
	
	static String getOriginalPlain(String key,String secretTextCode) {
		String original="";
		System.out.println("");
		System.out.println("�����������Ϊ��");
		lengthNum=secretTextCode.length();
		System.out.println(secretTextCode.length());
		cipherCodeDecrypt=new int[secretTextCode.length()];
		keyChain=new int[key.length()];
		for(int s=0;s<secretTextCode.length();s++) {
			cipherCodeDecrypt[s]=secretTextCode.charAt(s);
		}
		for(int i=0;i<key.length();i++) {
			keyChain[i]=key.charAt(i);
		}
		c_M = new int[16000];
		enc(c_M, cipherCodeDecrypt,keyChain, cipherCodeDecrypt.length/8);
		for (int i = 0; i <cipherCodeDecrypt.length; i++) {
			original=original+c_M[i];
			System.out.print(c_M[i]);
		}
		return original;
	}
	static String getOriginalText() {
		String DecryptedPlain="";
		for (int i = 0; i <lengthNum; i++) {
			int temp_num = 0;
			int temp_i = 8 * i;
			temp_num = c_M[0 + temp_i] * 128 + c_M[1 + temp_i] * 64 + c_M[2 + temp_i] * 32 + c_M[3 + temp_i] * 16
					+ c_M[4 + temp_i] * 8 + c_M[5 + temp_i] * 4 + c_M[6 + temp_i] * 2 + c_M[7 + temp_i] * 1;
			char c_n;
			c_n = (char) temp_num;
			DecryptedPlain=DecryptedPlain+c_n;
		}
			return DecryptedPlain;
	}
	static String showCipherText() {
		String EncryptedText="";
		for (int i = 0; i < ch.length()*2; i++) {
			int temp_num = 0;
			int temp_i = 4 * i;
			temp_num = cipher[0 + temp_i] * 8+ cipher[1 + temp_i] * 4+cipher[2 + temp_i] * 2 + cipher[3 + temp_i] * 1+64;
			//System.out.println(temp_num);
			char cipherText;
			cipherText = (char) temp_num;
			EncryptedText=EncryptedText+cipherText;
			//System.out.print(cipherText);
		}
		return EncryptedText;
	}
	static String getOriginalCipherBinaryCode(String textForCipher) {
		String cipherBinaryCode="";
		for (int i = 0; i <textForCipher.length(); i++) {
			if (4 <(Integer.SIZE - Integer.numberOfLeadingZeros(textForCipher.charAt(i)-64))) {
	            throw  new RuntimeException("����sizeС��num������λ��");
	        }
	        StringBuilder binStr = new StringBuilder();
	        for(int j = 4-1;j >= 0; j--){
	            binStr.append(textForCipher.charAt(i)-64 >>> j & 1);
	        }
			cipherBinaryCode=cipherBinaryCode+binStr.toString();
		}
		System.out.print("����Ϊ�Ķ�����Ϊ��");
		System.out.print(cipherBinaryCode);
		return cipherBinaryCode;
	}

	public static void main(String[] args) {
		initialLFSR();
		System.out.println(XOR1);
		/*
		 * System.out.print("��ʼ����Ϊ��"); for(int count=0;count<5;count++) {
		 * System.out.print(initialseq[count]); System.out.print(" "); }
		 * System.out.println(""); for (int i = 0; i < n; i++) { array[i] =
		 * initialseq[i]; } get_state(array, state[s_num]); System.out.print(s_num +
		 * ":"); print(state[s_num]); seq[s_num] = array[0]; // ��һ״̬ for (int i = 1; i <
		 * 32; i++) { next(array); ++s_num; get_state(array, state[s_num]);
		 * System.out.print(s_num + ":"); print(state[s_num]); seq[s_num] = array[0]; }
		 * System.out.print("�������Ϊ:"); for (int i = 0; i < 32; i++) {
		 * System.out.print(seq[i]); }
		 */
		//System.out.println("");
		//System.out.println("����Ϊ��" + cmp_s(state));
		//String ch;// ������
		//int i = 0;
		//System.out.println("����������");
		//Scanner cin2 = new Scanner(System.in);
		//ch = cin2.nextLine();
		//System.out.print("����Ϊ��");
		//System.out.println(ch);
		// ������תΪ�����ƴ����ά����binary��
		/*int binary[][];
		binary = new int[200][8];
		for (int j = 0; j < ch.length(); j++) {
			int[] temp;
			temp = new int[8];
			String da;
			da = change(ch.charAt(j));
			for (i = 0; i < 8; i++) {
				temp[i] = da.charAt(i);
				if (temp[i] == 48)
					temp[i] = 0;
				else
					temp[i] = 1;
			}
			for (i = 0; i < 8; i++) {
				// cout << temp[i];
				binary[j][i] = temp[i];
			}
			// cout << endl;
		}

		/*
		 * for (int i = 0; i < filenum; i++) { for (int j = 0; j < 8; j++) { cout <<
		 * binary[i][j]; } cout << endl; }
		 */
		/*int[] M;
		M = new int[1600];
		int count = 0;
		for (i = 0; i < ch.length(); i++) {
			for (int j = 0; j < 8; j++) {
				M[count] = binary[i][j];
				count++;
			}
		}*/
		/*System.out.println("���ı�ʾΪ��");
		for (i = 0; i < count; i++) {
			System.out.print(M[i]);
		}*/
		/*System.out.println("");
		System.out.println("���ı�ʾΪ��");
		int[] cipher;
		cipher = new int[1600];
		enc(cipher, M, seq, ch.length());
		for (i = 0; i < count; i++) {
			System.out.print(cipher[i]);
		}
		System.out.println("");
		System.out.println("�����������Ϊ��");
		for (i = 0; i < ch.length(); i++) {
			int temp_num1 = 0;
			int temp_i1 = 8 * i;
			temp_num1 = cipher[0 + temp_i1] * 128 + cipher[1 + temp_i1] * 64 + cipher[2 + temp_i1] * 32
					+ cipher[3 + temp_i1] * 16 + cipher[4 + temp_i1] * 8 + cipher[5 + temp_i1] * 4
					+ cipher[6 + temp_i1] * 2 + cipher[7 + temp_i1] * 1;
			char cipherText;
			cipherText = (char) temp_num1;
			System.out.print(cipherText);
		}*/
		/*System.out.println("");
		System.out.println("�����������Ϊ��");
		int[] c_M;
		c_M = new int[1600];
		enc(c_M, cipher, seq, ch.length());
		for (i = 0; i < count; i++) {
			System.out.print(c_M[i]);
		}
		System.out.println("");

		System.out.println("�������ԭ��Ϊ��");
		for (i = 0; i < ch.length(); i++) {
			int temp_num = 0;
			int temp_i = 8 * i;
			temp_num = c_M[0 + temp_i] * 128 + c_M[1 + temp_i] * 64 + c_M[2 + temp_i] * 32 + c_M[3 + temp_i] * 16
					+ c_M[4 + temp_i] * 8 + c_M[5 + temp_i] * 4 + c_M[6 + temp_i] * 2 + c_M[7 + temp_i] * 1;
			char c_n;
			c_n = (char) temp_num;
			System.out.print(c_n);
		}*/
	}
}
