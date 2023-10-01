package Stream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class UI extends JFrame {
	public static String originalCode;
	public static String originalText;
	public static String encrypted;
	public static String cipherTextDecrypt;
	public static String keyChain;
	public static String decryptCode;
	public static String cipherCodeBinary;
	public static String key;
	public static String plain;
	public static String knownKey="";
	public static String cipher;
	public JFrame frmzhiyuanwu;
	private JTextArea textAreaS0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmzhiyuanwu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		SituationRecord recording=new SituationRecord();
		recording.initialize();
		frmzhiyuanwu = new JFrame();
		frmzhiyuanwu.setTitle("5120186124ZhiyuanWu");
		frmzhiyuanwu.setResizable(false);
		frmzhiyuanwu.setBounds(100, 100, 1245, 1029);
		frmzhiyuanwu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmzhiyuanwu.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(937, 524, 241, 440);
		frmzhiyuanwu.getContentPane().add(scrollPane_6);
		
		JTextArea textAreaS1 = new JTextArea();
		textAreaS1.setLineWrap(true);
		scrollPane_6.setViewportView(textAreaS1);
		
		JLabel lblNewLabel_11 = new JLabel("S1\u76D2/T\u76D2");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_6.setColumnHeaderView(lblNewLabel_11);
		
		JScrollPane scrollPane_5 = 	new JScrollPane();
		scrollPane_5.setBounds(937, 95, 241, 413);
		frmzhiyuanwu.getContentPane().add(scrollPane_5);
		
		textAreaS0 = new JTextArea();
		textAreaS0.setLineWrap(true);
		scrollPane_5.setViewportView(textAreaS0);
		
		JLabel lblNewLabel_10 = new JLabel("S0\u76D2/S\u76D2");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_5.setColumnHeaderView(lblNewLabel_10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(636, 97, 268, 96);
		frmzhiyuanwu.getContentPane().add(scrollPane_1);
		
		JTextArea textAreaForIV = new JTextArea();
		textAreaForIV.setLineWrap(true);
		scrollPane_1.setViewportView(textAreaForIV);
		
		JLabel lblNewLabel_9 = new JLabel("IV");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblNewLabel_9);
		
		JScrollPane scrollPaneforAvalancheEffect = new JScrollPane();
		scrollPaneforAvalancheEffect.setBounds(83, 861, 821, 103);
		frmzhiyuanwu.getContentPane().add(scrollPaneforAvalancheEffect);
		
		JTextArea textAreaForAE = new JTextArea();
		scrollPaneforAvalancheEffect.setViewportView(textAreaForAE);
		
		JLabel lblNewLabel_6 = new JLabel("\u96EA\u5D29\u6548\u5E94\u540E");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneforAvalancheEffect.setColumnHeaderView(lblNewLabel_6);
		
		JScrollPane scrollPaneForTime = new JScrollPane();
		scrollPaneForTime.setBounds(636, 757, 268, 89);
		frmzhiyuanwu.getContentPane().add(scrollPaneForTime);
		
		JTextArea textAreaForTime = new JTextArea();
		scrollPaneForTime.setViewportView(textAreaForTime);
		
		JLabel labelForTime = new JLabel("\u72B6\u6001\u8017\u65F6");
		labelForTime.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneForTime.setColumnHeaderView(labelForTime);
		
		JScrollPane scrollPaneForM = new JScrollPane();
		scrollPaneForM.setBounds(636, 524, 268, 209);
		frmzhiyuanwu.getContentPane().add(scrollPaneForM);
		
		JTextArea textAreaForM = new JTextArea();
		textAreaForM.setLineWrap(true);
		scrollPaneForM.setViewportView(textAreaForM);
		
		JLabel labelForM = new JLabel("m\u5E8F\u5217/\u5BC6\u94A5\u6D41");
		labelForM.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneForM.setColumnHeaderView(labelForM);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(636, 73, 542, 14);
		frmzhiyuanwu.getContentPane().add(progressBar);
		
		JScrollPane afterEncrypted = new JScrollPane();
		afterEncrypted.setBounds(83, 635, 518, 98);
		frmzhiyuanwu.getContentPane().add(afterEncrypted);
		
		JTextArea afterEncryptedTextArea = new JTextArea();
		afterEncryptedTextArea.setLineWrap(true);
		afterEncrypted.setViewportView(afterEncryptedTextArea);
		
		JLabel lblNewLabel_5 = new JLabel("\u52A0\u5BC6\u540E");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		afterEncrypted.setColumnHeaderView(lblNewLabel_5);
		
		JScrollPane scrollPaneForKEY = new JScrollPane();
		scrollPaneForKEY.setBounds(358, 95, 243, 98);
		frmzhiyuanwu.getContentPane().add(scrollPaneForKEY);
		JTextArea textAreaKEY = new JTextArea();
		textAreaKEY.setLineWrap(true);
		scrollPaneForKEY.setViewportView(textAreaKEY);
		
		JScrollPane scrollPaneForText = new JScrollPane();
		scrollPaneForText.setBounds(83, 95, 250, 98);
		frmzhiyuanwu.getContentPane().add(scrollPaneForText);
		
		JTextArea textAreaText = new JTextArea();
		textAreaText.setLineWrap(true);
		scrollPaneForText.setViewportView(textAreaText);
		
		JScrollPane scrollPaneForPlainCode = new JScrollPane();
		scrollPaneForPlainCode.setBounds(83, 409, 518, 86);
		frmzhiyuanwu.getContentPane().add(scrollPaneForPlainCode);
		
		JTextArea textAreaForPlainCode = new JTextArea();
		textAreaForPlainCode.setLineWrap(true);
		scrollPaneForPlainCode.setViewportView(textAreaForPlainCode);
		
		JLabel lblNewLabel_8 = new JLabel("\u539F\u6587\u4E8C\u8FDB\u5236");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneForPlainCode.setColumnHeaderView(lblNewLabel_8);
		
		JScrollPane scrollPaneDecrypted = new JScrollPane();
		scrollPaneDecrypted.setBounds(83, 758, 518, 86);
		frmzhiyuanwu.getContentPane().add(scrollPaneDecrypted);
		
		JTextArea textAreaDecrypted = new JTextArea();
		textAreaDecrypted.setLineWrap(true);
		scrollPaneDecrypted.setViewportView(textAreaDecrypted);
		
		JLabel lblNewLabel = new JLabel("\u89E3\u5BC6\u540E");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneDecrypted.setColumnHeaderView(lblNewLabel);
		
		JScrollPane scrollPaneEncrypted = new JScrollPane();
		scrollPaneEncrypted.setBounds(83, 525, 518, 93);
		frmzhiyuanwu.getContentPane().add(scrollPaneEncrypted);
		
		JTextArea textAreaEncrypted = new JTextArea();
		textAreaEncrypted.setLineWrap(true);
		scrollPaneEncrypted.setViewportView(textAreaEncrypted);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u6587\u4E8C\u8FDB\u5236");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneEncrypted.setColumnHeaderView(lblNewLabel_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(636, 203, 268, 305);
		frmzhiyuanwu.getContentPane().add(scrollPane);
		JTextArea textAreaLFSRsituation = new JTextArea();
		textAreaLFSRsituation.setLineWrap(true);
		scrollPane.setViewportView(textAreaLFSRsituation);
		textAreaLFSRsituation.setEditable(false);
		
		JLabel lblNewLabel_7 = new JLabel("LFSR\u72B6\u6001");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel_7);
		JButton btnNewButtonKEY = new JButton("LFSR\u751F\u6210\u5BC6\u94A5");
		JButton btnNewButtonEncrypt = new JButton("LFSR\u52A0\u5BC6");
		btnNewButtonEncrypt.addActionListener(new ActionListener() {//加密按钮的处理
			public void actionPerformed(ActionEvent e) {
				textAreaForPlainCode.setText("");
				originalText=textAreaText.getText();
				Long startTimeForEncrypt=System.currentTimeMillis();
				LFSRtest.MtoBinary(originalText);
				originalCode=LFSRtest.showPlainCode();
				textAreaForPlainCode.setText(originalCode);
				encrypted=LFSRtest.getCipher();
				Long endTimeForEncrypt=System.currentTimeMillis();
				textAreaEncrypted.setText(encrypted);
				recording.textAreaLFSR.append("*****加密过程*****"+"\n");
				recording.textAreaLFSR.append("--------------------------------------------------------------"+"\n");
				recording.textAreaLFSR.append("明文为："+originalText+"\n");
				recording.textAreaLFSR.append("明文二进制为："+originalCode+"\n");
				recording.textAreaLFSR.append("密文二进制为："+encrypted+"\n");
				recording.textAreaLFSR.append("密文为："+LFSRtest.showCipherText()+"\n");
				afterEncryptedTextArea.setText(LFSRtest.showCipherText());
				textAreaForTime.append("加密耗时："+(endTimeForEncrypt-startTimeForEncrypt)+"ms"+"\n");
				recording.textAreaLFSR.append("加密耗时："+(endTimeForEncrypt-startTimeForEncrypt)+"ms"+"\n");
				recording.textAreaLFSR.append("--------------------------------------------------------------"+"\n");
			}
		});
		btnNewButtonEncrypt.setBounds(83, 203, 115, 41);
		frmzhiyuanwu.getContentPane().add(btnNewButtonEncrypt);
		
		JButton btnNewButtonDecrypt = new JButton("LFSR\u89E3\u5BC6");
		btnNewButtonDecrypt.addActionListener(new ActionListener() {//解密按钮的处理
			public void actionPerformed(ActionEvent e) {
				String cipherKeyForAE="";
				String decryptedForAE="";
				textAreaForPlainCode.setText("");
				cipherTextDecrypt=textAreaText.getText();
				Long startTimeForDecrypt=System.currentTimeMillis();
				cipherCodeBinary=LFSRtest.getOriginalCipherBinaryCode(cipherTextDecrypt);
				textAreaEncrypted.setText(cipherCodeBinary);
				recording.textAreaLFSR.append("*****解密过程*****"+"\n");
				recording.textAreaLFSR.append("--------------------------------------------------------------"+"\n");
				recording.textAreaLFSR.append("密文为"+cipherTextDecrypt+"\n");
				recording.textAreaLFSR.append("密文二进制为"+cipherCodeBinary+"\n");
				keyChain=textAreaKEY.getText();
				recording.textAreaLFSR.append("输入的密钥为"+keyChain+"\n");
				int randomNumber = (int) (Math.random() * (126 - 32 + 1)) + 32;
				cipherKeyForAE=cipherKeyForAE+(char)randomNumber;
				for(int i=1;i<keyChain.length();i++) {
					cipherKeyForAE=cipherKeyForAE+keyChain.charAt(i);
				}
				LFSRtest.initialLFSR(keyChain);
				decryptCode=LFSRtest.getOriginalPlain(LFSRtest.key2,cipherCodeBinary);
				Long endTimeForDecrypt=System.currentTimeMillis();
				textAreaForPlainCode.append(decryptCode);
				recording.textAreaLFSR.append("明文二进制为："+decryptCode+"\n");
				recording.textAreaLFSR.append("解密出的明文为："+LFSRtest.getOriginalText()+"\n");
				textAreaDecrypted.append(LFSRtest.getOriginalText());
				textAreaForTime.append("解密耗时："+(endTimeForDecrypt-startTimeForDecrypt)+"ms"+"\n");
				recording.textAreaLFSR.append("解密耗时："+(endTimeForDecrypt-startTimeForDecrypt)+"ms"+"\n");
				//
				LFSRtest.s_num2=0;
				LFSRtest.initialLFSR(cipherKeyForAE);
				decryptedForAE=LFSRtest.getOriginalPlain(LFSRtest.key2,cipherCodeBinary);
				textAreaForAE.append("与正确密钥差一位的密钥: "+cipherKeyForAE+"\n");
				textAreaForAE.append("结果为: "+LFSRtest.getOriginalText());
				recording.textAreaLFSR.append("--------------------------------------------------------------"+"\n");
			}
		});
		btnNewButtonDecrypt.setBounds(218, 203, 115, 41);
		frmzhiyuanwu.getContentPane().add(btnNewButtonDecrypt);
		
		JButton btnNewButtonClear = new JButton("\u6E05\u7A7A");
		btnNewButtonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaEncrypted.setText("");
				textAreaForPlainCode.setText("");
				textAreaText.setText("");
				textAreaKEY.setText("");
				textAreaLFSRsituation.setText("");
				textAreaDecrypted.setText("");
				afterEncryptedTextArea.setText("");
				textAreaForM.setText("");
				textAreaForTime.setText("");
				textAreaForAE.setText("");
				textAreaForIV.setText("");
				textAreaS0.setText("");
				textAreaS1.setText("");
				progressBar.setValue(0);
				LFSRtest.initialKey="";
				LFSRtest.s_num=0;
				LFSRtest.s_num2=0;
				LFSRtest.initialseq2=null;
				LFSRtest.count=0;
				originalText="";
				originalCode="";
				encrypted="";
				cipherTextDecrypt="";
				keyChain="";
				decryptCode="";
				cipherCodeBinary="";
				btnNewButtonKEY.setEnabled(true);
			}
		});
		btnNewButtonClear.setBounds(492, 203, 109, 181);
		frmzhiyuanwu.getContentPane().add(btnNewButtonClear);
		
		JLabel lblNewLabel_2 = new JLabel("\u6D41\u5BC6\u7801\u6F14\u793A\u5668");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(410, 8, 377, 55);
		frmzhiyuanwu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u94A5");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(438, 71, 54, 15);
		frmzhiyuanwu.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u8F93\u5165\u660E\u6587\u6216\u5BC6\u6587");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(169, 73, 91, 15);
		frmzhiyuanwu.getContentPane().add(lblNewLabel_4);
		
		btnNewButtonKEY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long startTimeForKEY=System.currentTimeMillis();
				LFSRtest.initialPositionForXOR();
				LFSRtest.initialLFSR();
				Long endTimeForKEY=System.currentTimeMillis();
				textAreaKEY.setText(LFSRtest.keyAlphabet1);
				btnNewButtonKEY.setEnabled(false);
				String situation = "";
				for (int temp = 0; temp < LFSRtest.n; temp++) {
					situation+=LFSRtest.state[0][temp]+"";
				}
				textAreaLFSRsituation.append("0:当前状态:"+situation+" 输出："+LFSRtest.state[0][0]+"\n");
				String[] situation2;
				situation2 = new String[LFSRtest.twoPowerN];
				for(int tempal=0;tempal<LFSRtest.twoPowerN;tempal++) {
					situation2[tempal]="";
				}
				System.out.print(LFSRtest.twoPowerN);
				for (int counter2 = 1; counter2 < LFSRtest.twoPowerN; counter2++) {
					progressBar.setValue(counter2);
					for (int temp = 0; temp < LFSRtest.n; temp++) {
						situation2[counter2-1]+=LFSRtest.state[counter2][temp];	
					}
					textAreaLFSRsituation.append(counter2+":当前状态:"+situation2[counter2-1]+" 输出："+LFSRtest.state[counter2][0]+"\n");
				}
				recording.textAreaLFSR.append("*****生成密钥过程*****"+"\n");
				recording.textAreaLFSR.append("--------------------------------------------------------------"+"\n");
				recording.textAreaLFSR.append("密钥为："+textAreaKEY.getText()+"\n");
				recording.textAreaLFSR.append("LFSR周期为："+(LFSRtest.twoPowerN-1)+"\n");
				recording.textAreaLFSR.append("LFSR级数为: "+LFSRtest.n+"\n");
				recording.textAreaLFSR.append("生成密钥耗时: "+(endTimeForKEY-startTimeForKEY)+"ms"+"\n");
				textAreaLFSRsituation.append("LFSR级数为: "+LFSRtest.n+"\n");
				textAreaLFSRsituation.append("LFSR周期为："+(LFSRtest.twoPowerN-1)+"\n");
				textAreaLFSRsituation.append("LFSR级数为: "+LFSRtest.n+"\n");
				textAreaLFSRsituation.append("生成密钥耗时: "+(endTimeForKEY-startTimeForKEY)+"ms"+"\n");
				textAreaForTime.append("生成密钥耗时: "+(endTimeForKEY-startTimeForKEY)+"ms"+"\n");
				textAreaForM.append(LFSRtest.key);
				recording.textAreaLFSR.append("--------------------------------------------------------------"+"\n");
			}
		});
		btnNewButtonKEY.setBounds(358, 203, 124, 41);
		frmzhiyuanwu.getContentPane().add(btnNewButtonKEY);
		
		JButton btnZuc = new JButton("ZUC\u52A0\u5BC6");
		btnZuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringKey = textAreaKEY.getText();
				String stringIV = textAreaForIV.getText();
				int[] key = new int[16];
				int[] IV = new int[16];
				for (int i = 0; i < 16; i++) {
					int value = Integer.parseInt(stringKey.substring(2 + 4 * i, 4 + 4 * i), 16);
					key[i] = value;
				}
				for (int i = 0; i < 16; i++) {
					int tempIV = Integer.parseInt(stringIV.substring(2 + 4 * i, 4 + 4 * i), 16);
					IV[i] = tempIV;
				}
				/*
				 * for(int i=0;i<16;i++) System.out.print(key[i]+" "); System.out.println("");
				 * for(int i=0;i<16;i++) System.out.print(IV[i]+" ");
				 */
				Long startTimeForEncrypt=System.currentTimeMillis();
				ZUCtest zuc = new ZUCtest(key, IV);
				int[] temp = zuc.showInitForLFSR;
				textAreaLFSRsituation.append("LFSR初始状态：" + Arrays.toString(temp) + "\n");
				String plain = textAreaText.getText();
				recording.textAreaZUC.append("*****加密过程*****"+"\n");
				recording.textAreaZUC.append("--------------------------------------------------------------"+"\n");
				recording.textAreaZUC.append("明文为："+plain+"\n");
				String encryptedMessage = zuc.encrypt(plain);
				Long endTimeForEncrypt=System.currentTimeMillis();
				textAreaForTime.append("加密耗时："+(endTimeForEncrypt-startTimeForEncrypt)+"ms"+"\n");
				recording.textAreaZUC.append("加密耗时："+(endTimeForEncrypt-startTimeForEncrypt)+"ms"+"\n");
				textAreaLFSRsituation.setText("");
				for (int i = 0; i < zuc.recordEncryptLFSR.length; i++) {
					textAreaLFSRsituation.append("LFSR工作状态" + (i + 1) + ": " + Arrays.toString(zuc.recordEncryptLFSR[i]) + "\n");
				}
				afterEncryptedTextArea.setText(encryptedMessage);
				textAreaLFSRsituation.append("\n"+"加密序列为："+ZUCtest.realStream);
				recording.textAreaZUC.append("加密序列为："+ZUCtest.realStream+"\n");
				recording.textAreaZUC.append("密文为："+encryptedMessage+"\n");
				recording.textAreaZUC.append("--------------------------------------------------------------"+"\n");
			}
		});
		btnZuc.setBounds(83, 271, 115, 41);
		frmzhiyuanwu.getContentPane().add(btnZuc);
		
		JButton btnRC4Encrypt = new JButton("RC4\u52A0\u5BC6");
		btnRC4Encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recording.textAreaRC4.append("*****加密过程*****"+"\n");
				recording.textAreaRC4.append("--------------------------------------------------------------"+"\n");
				plain=textAreaText.getText();
				recording.textAreaRC4.append("明文为："+plain+"\n");
				Long startTimeForEncrypt=System.currentTimeMillis();
				RC4test.intialize(key, plain);
				Long endTimeForEncrypt=System.currentTimeMillis();
				textAreaForM.setText(RC4test.keyStream);
				recording.textAreaRC4.append("密钥流为："+textAreaForM.getText()+"\n");
				textAreaForM.append("\n"+"二进制密钥流为："+RC4test.realStream);
				recording.textAreaRC4.append("二进制密钥流为："+RC4test.realStream+"\n");
				textAreaS0.setText(RC4test.printS());
				textAreaS1.setText(RC4test.printT());
				afterEncryptedTextArea.setText(RC4test.cipherCode);
				recording.textAreaRC4.append("密文为："+afterEncryptedTextArea.getText()+"\n");
				textAreaForTime.append("加密耗时："+(endTimeForEncrypt-startTimeForEncrypt)+"ms"+"\n");
				recording.textAreaRC4.append("加密耗时："+(endTimeForEncrypt-startTimeForEncrypt)+"ms"+"\n");
				recording.textAreaRC4.append("--------------------------------------------------------------"+"\n");
			}
		});
		btnRC4Encrypt.setBounds(83, 343, 115, 41);
		frmzhiyuanwu.getContentPane().add(btnRC4Encrypt);
		
		JButton btnZuc_1 = new JButton("ZUC\u89E3\u5BC6");
		btnZuc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String decryptStringKey = textAreaKEY.getText();
				String decryptStringIV = textAreaForIV.getText();
				int[] decryptKey = new int[16];
				int[] decryptIV = new int[16];
				int[] decryptKeyForAE=new int[16];
				for (int i = 0; i < 16; i++) {
					int value = Integer.parseInt(decryptStringKey.substring(2 + 4 * i, 4 + 4 * i), 16);
					decryptKey[i] = value;
				}
				for (int i = 0; i < 16; i++) {
					int tempIV = Integer.parseInt(decryptStringIV.substring(2 + 4 * i, 4 + 4 * i), 16);
					decryptIV[i] = tempIV;
				}
				for (int i = 0; i < 16; i++) {
					int valueAE = Integer.parseInt(decryptStringKey.substring(2 + 4 * i, 4 + 4 * i), 16);
					if(i==0) {
						decryptKeyForAE[i]=valueAE+1;
						continue;
					}
					decryptKeyForAE[i] = valueAE;
				}
				recording.textAreaZUC.append("*****解密过程*****"+"\n");
				recording.textAreaZUC.append("--------------------------------------------------------------"+"\n");
				Long startTimeForDecrypt=System.currentTimeMillis();
				ZUCtest zuc2 = new ZUCtest(decryptKey, decryptIV);
				String cipher = textAreaText.getText();
				String decryptedMessage = zuc2.decrypt(cipher);
				recording.textAreaZUC.append("需要解密的密文为："+cipher+"\n");
				recording.textAreaZUC.append("解密后明文为："+decryptedMessage+"\n");
				Long endTimeForDecrypt=System.currentTimeMillis();
				textAreaForTime.append("解密耗时："+(endTimeForDecrypt-startTimeForDecrypt)+"ms"+"\n");
				recording.textAreaZUC.append("解密耗时："+(endTimeForDecrypt-startTimeForDecrypt)+"ms"+"\n");
				recording.textAreaZUC.append("--------------------------------------------------------------"+"\n");
				textAreaLFSRsituation.setText("");
				for (int i = 0; i < zuc2.recordDecryptLFSR.length; i++) {
					textAreaLFSRsituation.append("LFSR工作状态" + (i + 1) + ": " + Arrays.toString(zuc2.recordDecryptLFSR[i]) + "\n");
				}
				textAreaDecrypted.setText(decryptedMessage);
				ZUCtest zuc3 = new ZUCtest(decryptKeyForAE, decryptIV);
				String decryptedMessageAE = zuc3.decrypt(cipher);
				textAreaForAE.append("变换后的密钥为: "+Arrays.toString(decryptKeyForAE)+"\n");
				textAreaForAE.append(decryptedMessageAE);
			}
		});
		btnZuc_1.setBounds(218, 271, 115, 41);
		frmzhiyuanwu.getContentPane().add(btnZuc_1);
		
		JButton btnRC4Decrypt = new JButton("RC4\u89E3\u5BC6");
		btnRC4Decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recording.textAreaRC4.append("*****解密过程*****"+"\n");
				recording.textAreaRC4.append("--------------------------------------------------------------"+"\n");
				String keyForAE="";
				knownKey=textAreaKEY.getText();
				recording.textAreaRC4.append("已知的密钥为："+knownKey+"\n");
				Long startTimeForDecrypt=System.currentTimeMillis();
				int randomNumber = (int) (Math.random() * (126 - 32 + 1)) + 32;
				keyForAE=keyForAE+(char)randomNumber;
				for(int i=1;i<knownKey.length();i++) {
					keyForAE=keyForAE+knownKey.charAt(i);
				}
				cipher=textAreaText.getText();
				textAreaDecrypted.setText(RC4test.processDecryption(knownKey,cipher.length()/2,cipher));
				Long endTimeForDecrypt=System.currentTimeMillis();
				recording.textAreaRC4.append("需要解密的密文为："+cipher+"\n");
				recording.textAreaRC4.append("解密出的明文为："+textAreaDecrypted.getText()+"\n");
				textAreaForTime.append("解密耗时："+(endTimeForDecrypt-startTimeForDecrypt)+"ms"+"\n");
				recording.textAreaRC4.append("解密耗时："+(endTimeForDecrypt-startTimeForDecrypt)+"ms"+"\n");
				textAreaForAE.append("错误一位的密钥:"+keyForAE+"\n");
				textAreaForAE.append("错误密钥解密结果:"+RC4test.processDecryption(keyForAE,cipher.length()/2,cipher));
			}
		});
		btnRC4Decrypt.setBounds(218, 343, 115, 41);
		frmzhiyuanwu.getContentPane().add(btnRC4Decrypt);
		
		JButton btnZuc_2 = new JButton("ZUC\u751F\u6210\u5BC6\u94A5");
		btnZuc_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaKEY.setText(ZUCtest.generateHexKey());
				textAreaForIV.setText(ZUCtest.generateHexIV());
				recording.textAreaZUC.append("*****生成密钥过程*****"+"\n");
				recording.textAreaZUC.append("--------------------------------------------------------------"+"\n");
				recording.textAreaZUC.append("密钥为："+textAreaKEY.getText()+"\n");
				recording.textAreaZUC.append("IV为："+textAreaForIV.getText()+"\n");
				recording.textAreaZUC.append("--------------------------------------------------------------"+"\n");
				String s0 = "";
				String s1 = "";
				for (int i = 0; i < 16; i++) {
					for (int j = 0; j < 16; j++) {
						s0 = s0 + String.valueOf(ZUCtest.s0[i][j]) + " ";
					}
				}
				for (int i = 0; i < 16; i++) {
					for (int j = 0; j < 16; j++) {
						s1 = s1 + String.valueOf(ZUCtest.s1[i][j]) + " ";
					}
				}
				textAreaS0.setText(s0);
				textAreaS1.setText(s1);
			}
		});
		btnZuc_2.setBounds(358, 271, 124, 41);
		frmzhiyuanwu.getContentPane().add(btnZuc_2);
		
		JButton btnRc4 = new JButton("RC4\u751F\u6210\u5BC6\u94A5");
		btnRc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key=RC4test.generateRandomKey(16);
				recording.textAreaRC4.append("*****生成密钥过程*****"+"\n");
				recording.textAreaRC4.append("--------------------------------------------------------------"+"\n");
				textAreaKEY.setText(key);
				recording.textAreaRC4.append("密钥为："+key+"\n");
				recording.textAreaRC4.append("--------------------------------------------------------------"+"\n");
			}
		});
		btnRc4.setBounds(358, 343, 124, 41);
		frmzhiyuanwu.getContentPane().add(btnRc4);
		frmzhiyuanwu.setVisible(true);
	}
}

