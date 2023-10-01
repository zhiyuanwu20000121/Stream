package Stream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class UIforZUC {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIforZUC window = new UIforZUC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public UIforZUC() {
		//initialize();
		// ZUCtest.generateHexKey();
		// ZUCtest.generateHexIV();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 921, 993);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(77, 822, 810, 108);
		frame.getContentPane().add(scrollPane_9);
		
		JTextArea textAreaForTime = new JTextArea();
		scrollPane_9.setViewportView(textAreaForTime);
		
		JLabel lblNewLabel_9 = new JLabel("\u72B6\u6001\u8017\u65F6");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_9.setColumnHeaderView(lblNewLabel_9);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(77, 682, 810, 122);
		frame.getContentPane().add(scrollPane_8);
		
		JTextArea textAreaForAE = new JTextArea();
		scrollPane_8.setViewportView(textAreaForAE);
		
		JLabel lblNewLabel_8 = new JLabel("\u96EA\u5D29\u6548\u5E94");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_8.setColumnHeaderView(lblNewLabel_8);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(78, 529, 809, 131);
		frame.getContentPane().add(scrollPane_7);

		JTextArea textAreaForLFSR = new JTextArea();
		textAreaForLFSR.setLineWrap(true);
		scrollPane_7.setViewportView(textAreaForLFSR);

		JLabel lblNewLabel_7 = new JLabel("LFSR\u72B6\u6001");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_7.setColumnHeaderView(lblNewLabel_7);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(646, 189, 241, 169);
		frame.getContentPane().add(scrollPane_5);

		JTextArea textAreaS0 = new JTextArea();
		textAreaS0.setLineWrap(true);
		scrollPane_5.setViewportView(textAreaS0);

		JLabel lblNewLabel_5 = new JLabel("S0\u76D2");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_5.setColumnHeaderView(lblNewLabel_5);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(646, 392, 241, 108);
		frame.getContentPane().add(scrollPane_6);

		JTextArea textAreaS1 = new JTextArea();
		textAreaS1.setLineWrap(true);
		scrollPane_6.setViewportView(textAreaS1);

		JLabel lblNewLabel_6 = new JLabel("S1\u76D2");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_6.setColumnHeaderView(lblNewLabel_6);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(78, 392, 539, 108);
		frame.getContentPane().add(scrollPane_3);

		JTextArea textAreaDecrypted = new JTextArea();
		scrollPane_3.setViewportView(textAreaDecrypted);
		textAreaDecrypted.setLineWrap(true);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(78, 250, 539, 108);
		frame.getContentPane().add(scrollPane_2);

		JTextArea afterEncryptedTextArea = new JTextArea();
		scrollPane_2.setViewportView(afterEncryptedTextArea);
		afterEncryptedTextArea.setLineWrap(true);

		JLabel lblNewLabel_2 = new JLabel("ZUC\u6D41\u5BC6\u7801");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 30));
		lblNewLabel_2.setBounds(293, 0, 377, 55);
		frame.getContentPane().add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 75, 267, 94);
		frame.getContentPane().add(scrollPane);

		JTextArea textAreaText = new JTextArea();
		scrollPane.setViewportView(textAreaText);
		textAreaText.setLineWrap(true);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(376, 75, 241, 96);
		frame.getContentPane().add(scrollPane_4);

		JTextArea textAreaForKey = new JTextArea();
		textAreaForKey.setLineWrap(true);
		scrollPane_4.setViewportView(textAreaForKey);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(646, 75, 239, 94);
		frame.getContentPane().add(scrollPane_1);

		JTextArea textAreaForIV = new JTextArea();
		scrollPane_1.setViewportView(textAreaForIV);
		textAreaForIV.setLineWrap(true);

		JLabel lblNewLabel_4 = new JLabel("\u8F93\u5165\u660E\u6587\u6216\u5BC6\u6587");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(154, 50, 91, 15);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u94A5");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(471, 50, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("IV");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(739, 50, 54, 15);
		frame.getContentPane().add(lblNewLabel_3_1);

		JButton btnNewButtonEncrypt = new JButton("\u52A0\u5BC6");
		btnNewButtonEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringKey = textAreaForKey.getText();
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
				textAreaForLFSR.append("LFSR初始状态：" + Arrays.toString(temp) + "\n");
				String plain = textAreaText.getText();
				String encryptedMessage = zuc.encrypt(plain);
				Long endTimeForEncrypt=System.currentTimeMillis();
				textAreaForTime.append("加密耗时："+(endTimeForEncrypt-startTimeForEncrypt)+"ms"+"\n");
				textAreaForLFSR.setText("");
				for (int i = 0; i < zuc.recordEncryptLFSR.length; i++) {
					textAreaForLFSR.append("LFSR工作状态" + (i + 1) + ": " + Arrays.toString(zuc.recordEncryptLFSR[i]) + "\n");
				}
				afterEncryptedTextArea.setText(encryptedMessage);
				textAreaForLFSR.append("\n"+"加密序列为："+ZUCtest.realStream);

			}
		});
		btnNewButtonEncrypt.setBounds(78, 185, 115, 41);
		frame.getContentPane().add(btnNewButtonEncrypt);

		JButton btnNewButtonDecrypt = new JButton("\u89E3\u5BC6");
		btnNewButtonDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String decryptStringKey = textAreaForKey.getText();
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
				Long startTimeForDecrypt=System.currentTimeMillis();
				ZUCtest zuc2 = new ZUCtest(decryptKey, decryptIV);
				String cipher = textAreaText.getText();
				String decryptedMessage = zuc2.decrypt(cipher);
				Long endTimeForDecrypt=System.currentTimeMillis();
				textAreaForTime.append("解密耗时："+(endTimeForDecrypt-startTimeForDecrypt)+"ms"+"\n");
				textAreaForLFSR.setText("");
				for (int i = 0; i < zuc2.recordDecryptLFSR.length; i++) {
					textAreaForLFSR.append("LFSR工作状态" + (i + 1) + ": " + Arrays.toString(zuc2.recordDecryptLFSR[i]) + "\n");
				}
				textAreaDecrypted.setText(decryptedMessage);
				ZUCtest zuc3 = new ZUCtest(decryptKeyForAE, decryptIV);
				String decryptedMessageAE = zuc3.decrypt(cipher);
				textAreaForAE.append("变换后的密钥为: "+Arrays.toString(decryptKeyForAE)+"\n");
				textAreaForAE.append(decryptedMessageAE);
			}
		});
		btnNewButtonDecrypt.setBounds(228, 185, 115, 41);
		frame.getContentPane().add(btnNewButtonDecrypt);

		JButton btnNewButtonKEY = new JButton("\u751F\u6210\u5BC6\u94A5");
		btnNewButtonKEY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaForKey.setText(ZUCtest.generateHexKey());
				textAreaForIV.setText(ZUCtest.generateHexIV());
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
		btnNewButtonKEY.setBounds(376, 185, 110, 41);
		frame.getContentPane().add(btnNewButtonKEY);

		JButton btnNewButtonClear = new JButton("\u6E05\u7A7A");
		btnNewButtonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaS0.setText("");
				textAreaS1.setText("");
				textAreaText.setText("");
				textAreaForKey.setText("");
				afterEncryptedTextArea.setText("");
				textAreaDecrypted.setText("");
				textAreaForIV.setText("");
				textAreaForLFSR.setText("");
				textAreaForAE.setText("");
			}
		});
		btnNewButtonClear.setBounds(493, 185, 124, 41);
		frame.getContentPane().add(btnNewButtonClear);

		JLabel lblNewLabel = new JLabel("\u52A0\u5BC6\u540E\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel.setBounds(14, 289, 54, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u89E3\u5BC6\u540E\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_1.setBounds(14, 440, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setVisible(true);
	}
}
