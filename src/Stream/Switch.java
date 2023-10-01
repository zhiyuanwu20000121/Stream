package Stream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Switch extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Switch window = new Switch();
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
	UI v1=new UI();
	SituationRecord v4=new SituationRecord();
	public Switch() {
		initialize(v1,v4);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(UI v1,SituationRecord v4) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 708, 360);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton buttonForLFSR = new JButton("\u8FDB\u5165\u52A0\u63A5\u5BC6\u7CFB\u7EDF");
		buttonForLFSR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v1.initialize();
				//buttonForLFSR.setEnabled(false);
			}
		});
		buttonForLFSR.setBounds(137, 77, 428, 126);
		frame.getContentPane().add(buttonForLFSR);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 27));
		lblNewLabel.setBounds(164, 23, 383, 30);
		frame.getContentPane().add(lblNewLabel);
	}
}
