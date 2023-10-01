package Stream;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class SituationRecord {

	public JFrame frame;
	public JTextArea textAreaRC4;
	public JTextArea textAreaLFSR;
	public JTextArea textAreaZUC;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SituationRecord window = new SituationRecord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SituationRecord() {
		//initialize();
	}
	public static void writeStringToFile(String filename, String data) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 995, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 42, 273, 597);
		frame.getContentPane().add(scrollPane);
		
		textAreaLFSR = new JTextArea();
		textAreaLFSR.setLineWrap(true);
		scrollPane.setViewportView(textAreaLFSR);
		
		JLabel lblNewLabel = new JLabel("\u57FA\u4E8ELFSR\u540C\u6B65\u6D41\u5BC6\u7801\u7684\u72B6\u6001\u8BB0\u5F55");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(360, 42, 266, 597);
		frame.getContentPane().add(scrollPane_1);
		
		textAreaRC4 = new JTextArea();
		textAreaRC4.setLineWrap(true);
		scrollPane_1.setViewportView(textAreaRC4);
		
		JLabel lblNewLabel_1 = new JLabel("RC4\u72B6\u6001\u8BB0\u5F55");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblNewLabel_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(679, 42, 267, 597);
		frame.getContentPane().add(scrollPane_2);
		
		textAreaZUC = new JTextArea();
		textAreaZUC.setLineWrap(true);
		scrollPane_2.setViewportView(textAreaZUC);
		
		JLabel lblNewLabel_2 = new JLabel("ZUC\u72B6\u6001\u8BB0\u5F55");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setColumnHeaderView(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu opreation = new JMenu("\u5DE5\u5177");
		opreation.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(opreation);
		
		JButton btnNewButton = new JButton("\u6E05\u7A7A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaLFSR.setText("");
				textAreaRC4.setText("");
				textAreaZUC.setText("");
			}
		});
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		opreation.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FDD\u5B58");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeStringToFile("D:/recordLFSR.txt",textAreaLFSR.getText());
				writeStringToFile("D:/recordRC4.txt",textAreaRC4.getText());
				writeStringToFile("D:/recordZUC.txt",textAreaZUC.getText());
			}
		});
		btnNewButton_1.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		opreation.add(btnNewButton_1);
		frame.setVisible(true);
	}
}
