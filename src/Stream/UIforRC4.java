package Stream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class UIforRC4 {

	public static String key;
	public static String plain;
	public static String knownKey="";
	public static String cipher;
	private JFrame frmRc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIforRC4 window = new UIforRC4();
					window.frmRc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIforRC4() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmRc = new JFrame();
		frmRc.setTitle("RC4");
		frmRc.setBounds(100, 100, 926, 776);
		frmRc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRc.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(70, 632, 798, 82);
		frmRc.getContentPane().add(scrollPane_7);
		
		JTextArea textAreaForTime = new JTextArea();
		scrollPane_7.setViewportView(textAreaForTime);
		
		JLabel lblNewLabel_8 = new JLabel("\u72B6\u6001\u663E\u793A");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_7.setColumnHeaderView(lblNewLabel_8);
		
		JScrollPane scrollPaneforAvalancheEffect = new JScrollPane();
		scrollPaneforAvalancheEffect.setBounds(70, 502, 798, 103);
		frmRc.getContentPane().add(scrollPaneforAvalancheEffect);
		
		JTextArea textAreaForAE = new JTextArea();
		scrollPaneforAvalancheEffect.setViewportView(textAreaForAE);
		
		JLabel lblNewLabel_7 = new JLabel("\u96EA\u5D29\u6548\u5E94");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneforAvalancheEffect.setColumnHeaderView(lblNewLabel_7);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(627, 381, 241, 96);
		frmRc.getContentPane().add(scrollPane_6);
		
		JTextArea textAreaForT = new JTextArea();
		textAreaForT.setLineWrap(true);
		scrollPane_6.setViewportView(textAreaForT);
		
		JLabel lblNewLabel_6 = new JLabel("T\u76D2");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_6.setColumnHeaderView(lblNewLabel_6);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(627, 191, 241, 167);
		frmRc.getContentPane().add(scrollPane_5);
		
		JTextArea textAreaForS = new JTextArea();
		textAreaForS.setLineWrap(true);
		scrollPane_5.setViewportView(textAreaForS);
		
		JLabel lblNewLabel_5 = new JLabel("S\u76D2");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_5.setColumnHeaderView(lblNewLabel_5);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(345, 85, 241, 96);
		frmRc.getContentPane().add(scrollPane_4);
		
		JTextArea textAreaKEY = new JTextArea();
		scrollPane_4.setViewportView(textAreaKEY);
		textAreaKEY.setLineWrap(true);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(627, 84, 241, 96);
		frmRc.getContentPane().add(scrollPane_3);
		
		JTextArea textAreaKEYStream = new JTextArea();
		textAreaKEYStream.setEditable(false);
		scrollPane_3.setViewportView(textAreaKEYStream);
		textAreaKEYStream.setLineWrap(true);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(70, 84, 248, 96);
		frmRc.getContentPane().add(scrollPane_2);
		
		JTextArea textAreaText = new JTextArea();
		scrollPane_2.setViewportView(textAreaText);
		textAreaText.setLineWrap(true);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(70, 381, 516, 96);
		frmRc.getContentPane().add(scrollPane_1);
		
		JTextArea textAreaDecrypted = new JTextArea();
		scrollPane_1.setViewportView(textAreaDecrypted);
		textAreaDecrypted.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 256, 516, 103);
		frmRc.getContentPane().add(scrollPane);
		
		JTextArea afterEncryptedTextArea = new JTextArea();
		scrollPane.setViewportView(afterEncryptedTextArea);
		afterEncryptedTextArea.setLineWrap(true);
		
		JLabel lblNewLabel_2 = new JLabel("RC4\u6D41\u5BC6\u7801");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 30));
		lblNewLabel_2.setBounds(288, 10, 377, 55);
		frmRc.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButtonEncrypt = new JButton("\u52A0\u5BC6");
		btnNewButtonEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plain=textAreaText.getText();
				Long startTimeForEncrypt=System.currentTimeMillis();
				RC4test.intialize(key, plain);
				Long endTimeForEncrypt=System.currentTimeMillis();
				textAreaKEYStream.setText(RC4test.keyStream);
				textAreaKEYStream.append("\n"+"二进制密钥流为："+RC4test.realStream);
				textAreaForS.setText(RC4test.printS());
				textAreaForT.setText(RC4test.printT());
				afterEncryptedTextArea.setText(RC4test.cipherCode);
				textAreaForTime.append("加密耗时："+(endTimeForEncrypt-startTimeForEncrypt)+"ms"+"\n");
			}
		});
		btnNewButtonEncrypt.setBounds(70, 191, 115, 41);
		frmRc.getContentPane().add(btnNewButtonEncrypt);
		
		JButton btnNewButtonDecrypt = new JButton("\u89E3\u5BC6");
		btnNewButtonDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyForAE="";
				knownKey=textAreaKEY.getText();
				Long startTimeForDecrypt=System.currentTimeMillis();
				int randomNumber = (int) (Math.random() * (126 - 32 + 1)) + 32;
				keyForAE=keyForAE+(char)randomNumber;
				for(int i=1;i<knownKey.length();i++) {
					keyForAE=keyForAE+knownKey.charAt(i);
				}
				cipher=textAreaText.getText();
				textAreaDecrypted.setText(RC4test.processDecryption(knownKey,cipher.length()/2,cipher));
				Long endTimeForDecrypt=System.currentTimeMillis();
				textAreaForTime.append("解密耗时："+(endTimeForDecrypt-startTimeForDecrypt)+"ms"+"\n");
				textAreaForAE.append("错误一位的密钥:"+keyForAE+"\n");
				textAreaForAE.append("错误密钥解密结果:"+RC4test.processDecryption(keyForAE,cipher.length()/2,cipher));
			}
		});
		btnNewButtonDecrypt.setBounds(203, 191, 115, 41);
		frmRc.getContentPane().add(btnNewButtonDecrypt);
		
		JButton btnNewButtonKEY = new JButton("\u751F\u6210\u5BC6\u94A5");
		btnNewButtonKEY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key=RC4test.generateRandomKey(16);
				textAreaKEY.setText(key);
			}
		});
		btnNewButtonKEY.setBounds(345, 191, 110, 41);
		frmRc.getContentPane().add(btnNewButtonKEY);
		
		JButton btnNewButtonClear = new JButton("\u6E05\u7A7A");
		btnNewButtonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaForS.setText("");
				textAreaForT.setText("");
				textAreaKEY.setText("");
				textAreaText.setText("");
				textAreaDecrypted.setText("");
				afterEncryptedTextArea.setText("");
				textAreaKEYStream.setText("");
				textAreaForAE.setText("");
			}
		});
		btnNewButtonClear.setBounds(465, 191, 124, 41);
		frmRc.getContentPane().add(btnNewButtonClear);
		
		JLabel lblNewLabel_4 = new JLabel("\u8F93\u5165\u660E\u6587\u6216\u5BC6\u6587");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(154, 60, 91, 15);
		frmRc.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u94A5");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(434, 60, 54, 15);
		frmRc.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u5BC6\u94A5\u6D41");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(718, 60, 54, 15);
		frmRc.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel = new JLabel("\u52A0\u5BC6\u540E\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel.setBounds(6, 292, 54, 15);
		frmRc.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u89E3\u5BC6\u540E\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_1.setBounds(6, 413, 54, 15);
		frmRc.getContentPane().add(lblNewLabel_1);
		frmRc.setVisible(true);
	}
}
