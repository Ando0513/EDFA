package edfacontroller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Label;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;

public class Screen extends JFrame {
	final String PORT_NAME = "/dev/ttyUSB0";
	//final String PORT_NAME = "COM3"; // for debag
	final int SPEED = 115200;

	private static TwoWaySerialComm twsc;
	private JPanel contentPane;
	private JPanel starting;
	private JPanel pumpinfo;
	private JPanel setting;
	private JPanel input;
	private JPanel output;

	private JTextField errorCodeStart;
	private JTextField textFieldPump1;
	private JTextField textFieldPump2;
	private JTextField textFieldPump3;
	private JTextField textFieldPump4;
	private JTextField textFieldPump5;
	private JTextField textFieldPump6;
	private JTextField textFieldPump7;
	private JTextField textFieldPump8;
	private JTextField textFieldSetting1_1;
	private JTextField textFieldSetting1_2;
	private JTextField textFieldSetting2_1;
	private JTextField textFieldSetting2_2;
	private JTextField textFieldSetting3_1;
	private JTextField textFieldSetting3_2;
	private JTextField textFieldSetting4_1;
	private JTextField textFieldSetting4_2;
	private JTextField textFieldSetting5_1;
	private JTextField textFieldSetting5_2;
	private JTextField textFieldSetting6_1;
	private JTextField textFieldSetting6_2;
	private JTextField textFieldSetting7_1;
	private JTextField textFieldSetting7_2;
	private JTextField textFieldSetting8_1;
	private JTextField textFieldSetting8_2;
	private JTextField textFieldIn1;
	private JTextField textFieldIn2;
	private JTextField textFieldIn3;
	private JTextField textFieldIn4;
	private JTextField textFieldIn5;
	private JTextField textFieldIn6;
	private JTextField textFieldIn7;
	private JTextField textFieldIn8;
	private JTextField textFieldOut1;
	private JTextField textFieldOut2;
	private JTextField textFieldOut3;
	private JTextField textFieldOut4;
	private JTextField textFieldOut5;
	private JTextField textFieldOut6;
	private JTextField textFieldOut7;
	private JTextField textFieldOut8;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private final ButtonGroup buttonGroup_7 = new ButtonGroup();
	private JTextField textFieldSetting1_3;
	private JTextField textFieldSetting2_3;
	private JTextField textFieldSetting3_3;
	private JTextField textFieldSetting4_3;
	private JTextField textFieldSetting5_3;
	private JTextField textFieldSetting6_3;
	private JTextField textFieldSetting7_3;
	private JTextField textFieldSetting8_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
					GraphicsDevice gd = ge.getDefaultScreenDevice();
					frame.setLocationRelativeTo(null); //センタリング
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //最大化
					//gd.setFullScreenWindow(frame);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
					//System.exit(1);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		setTitle("EDFA Controller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 432);
		this.contentPane = new JPanel();
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new CardLayout(0, 0));

		this.starting = new JPanel();
		this.contentPane.add(this.starting, "starting");
		this.starting.setLayout(null);

		JButton btnNewButton = new JButton("Connect");
		btnNewButton.setBounds(286, 144, 190, 99);
		this.starting.add(btnNewButton);

		Label label_2 = new Label("EDFA Controller v3.6α");
		label_2.setBounds(10, 321, 300, 56);
		this.starting.add(label_2);

		errorCodeStart = new JTextField();
		errorCodeStart.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		errorCodeStart.setHorizontalAlignment(SwingConstants.CENTER);
		//errorCodeStart.setForeground(Color.RED);
		errorCodeStart.setBounds(256, 253, 264, 40);
		this.starting.add(errorCodeStart);
		errorCodeStart.setColumns(10);

		this.pumpinfo = new JPanel();
		contentPane.add(this.pumpinfo, "pumpInfo");
		this.pumpinfo.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pump Info");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 8, 112, 17);
		pumpinfo.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Setting");
		btnNewButton_1.setBounds(671, 69, 91, 21);
		pumpinfo.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Input");
		btnNewButton_2.setBounds(671, 7, 91, 21);
		pumpinfo.add(btnNewButton_2);

		textFieldPump1 = new JTextField();
		textFieldPump1.setBounds(195, 19, 441, 36);
		pumpinfo.add(textFieldPump1);
		textFieldPump1.setColumns(10);

		textFieldPump2 = new JTextField();
		textFieldPump2.setBounds(195, 65, 441, 36);
		pumpinfo.add(textFieldPump2);
		textFieldPump2.setColumns(10);

		textFieldPump3 = new JTextField();
		textFieldPump3.setBounds(195, 111, 441, 36);
		pumpinfo.add(textFieldPump3);
		textFieldPump3.setColumns(10);

		textFieldPump4 = new JTextField();
		textFieldPump4.setBounds(195, 157, 441, 36);
		pumpinfo.add(textFieldPump4);
		textFieldPump4.setColumns(10);

		textFieldPump5 = new JTextField();
		textFieldPump5.setBounds(195, 203, 441, 36);
		pumpinfo.add(textFieldPump5);
		textFieldPump5.setColumns(10);

		textFieldPump6 = new JTextField();
		textFieldPump6.setBounds(195, 249, 441, 36);
		pumpinfo.add(textFieldPump6);
		textFieldPump6.setColumns(10);

		textFieldPump7 = new JTextField();
		textFieldPump7.setBounds(195, 295, 441, 36);
		pumpinfo.add(textFieldPump7);
		textFieldPump7.setColumns(10);

		textFieldPump8 = new JTextField();
		textFieldPump8.setBounds(195, 341, 441, 36);
		pumpinfo.add(textFieldPump8);
		textFieldPump8.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"EOL", "ILD", "TMP", "VTC", "ISP"}));
		comboBox.setBounds(32, 41, 135, 36);
		pumpinfo.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String data = (String)comboBox.getSelectedItem();
				String res = twsc.sendPump(data);
				String[] split = res.split("\n");
				for(int i = 0; i < split.length; i++){
					setTextFieldPump(split[i], i+1);
				}
			}
		});


		JButton btnNewButton_29 = new JButton("Output");
		btnNewButton_29.setBounds(671, 38, 91, 21);
		pumpinfo.add(btnNewButton_29);

		JButton powerButton = new JButton("Power Off");
		powerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		powerButton.setBounds(659, 313, 103, 64);
		pumpinfo.add(powerButton);

		this.setting = new JPanel();
		contentPane.add(this.setting, "setting");
		this.setting.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Setting");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 7, 86, 19);
		setting.add(lblNewLabel_1);

		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setBounds(695, 6, 68, 21);
		setting.add(btnNewButton_3);

		JPanel panel = new JPanel();
		panel.setBounds(12, 30, 750, 347);
		setting.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton_5 = new JButton("ON");
		btnNewButton_5.setBounds(12, 35, 91, 21);
		panel_3.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("OFF");
		btnNewButton_6.setForeground(Color.RED);
		btnNewButton_6.setBounds(12, 60, 91, 21);
		panel_3.add(btnNewButton_6);

		JRadioButton rdbtnNewRadioButtonS1_1 = new JRadioButton("Gain");
		rdbtnNewRadioButtonS1_1.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButtonS1_1);
		rdbtnNewRadioButtonS1_1.setBounds(108, 10, 70, 20);
		panel_3.add(rdbtnNewRadioButtonS1_1);

		JRadioButton rdbtnNewRadioButtonS1_2 = new JRadioButton("Output");
		buttonGroup.add(rdbtnNewRadioButtonS1_2);
		rdbtnNewRadioButtonS1_2.setBounds(108, 35, 69, 20);
		panel_3.add(rdbtnNewRadioButtonS1_2);

		JRadioButton rdbtnNewRadioButtonS1_3 = new JRadioButton("Manual");
		buttonGroup.add(rdbtnNewRadioButtonS1_3);
		rdbtnNewRadioButtonS1_3.setBounds(108, 60, 69, 21);
		panel_3.add(rdbtnNewRadioButtonS1_3);

		textFieldSetting1_1 = new JTextField();
		textFieldSetting1_1.setBounds(180, 10, 70, 19);
		panel_3.add(textFieldSetting1_1);
		textFieldSetting1_1.setColumns(10);

		textFieldSetting1_2 = new JTextField();
		textFieldSetting1_2.setBounds(180, 35, 70, 19);
		panel_3.add(textFieldSetting1_2);
		textFieldSetting1_2.setColumns(10);

		JButton btnNewButtonS1 = new JButton("SET");
		btnNewButtonS1.setBounds(285, 35, 80, 21);
		panel_3.add(btnNewButtonS1);

		JLabel lblNewLabel_2 = new JLabel("EDFA1");
		lblNewLabel_2.setBounds(12, 10, 50, 13);
		panel_3.add(lblNewLabel_2);

		textFieldSetting1_3 = new JTextField();
		textFieldSetting1_3.setColumns(10);
		textFieldSetting1_3.setBounds(180, 60, 70, 19);
		panel_3.add(textFieldSetting1_3);

		JLabel lblNewLabel_10 = new JLabel("dBm");
		lblNewLabel_10.setBounds(250, 14, 50, 13);
		panel_3.add(lblNewLabel_10);

		JLabel lblNewLabel_10_1 = new JLabel("dBm");
		lblNewLabel_10_1.setBounds(250, 39, 50, 13);
		panel_3.add(lblNewLabel_10_1);

		JLabel lblNewLabel_10_24 = new JLabel("mV");
		lblNewLabel_10_24.setBounds(250, 66, 50, 13);
		panel_3.add(lblNewLabel_10_24);
		btnNewButtonS1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButtonS1_1.isSelected()) {
					twsc.gain("A1",Double.parseDouble(textFieldSetting1_1.getText()));
				}else if(rdbtnNewRadioButtonS1_2.isSelected()) {
					twsc.output("A1", Double.parseDouble(textFieldSetting1_2.getText()));
				}else {
					twsc.current("A1", Double.parseDouble(textFieldSetting1_3.getText()));
				}
			}
		});

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JButton btnNewButton_8 = new JButton("ON");
		btnNewButton_8.setBounds(12, 35, 91, 21);
		panel_5.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("OFF");
		btnNewButton_9.setForeground(Color.RED);
		btnNewButton_9.setBounds(12, 60, 91, 21);
		panel_5.add(btnNewButton_9);

		JRadioButton rdbtnNewRadioButtonS2_1 = new JRadioButton("Gain");
		rdbtnNewRadioButtonS2_1.setSelected(true);
		buttonGroup_1.add(rdbtnNewRadioButtonS2_1);
		rdbtnNewRadioButtonS2_1.setBounds(108, 10, 70, 20);
		panel_5.add(rdbtnNewRadioButtonS2_1);

		JRadioButton rdbtnNewRadioButtonS2_2 = new JRadioButton("Output");
		buttonGroup_1.add(rdbtnNewRadioButtonS2_2);
		rdbtnNewRadioButtonS2_2.setBounds(108, 35, 62, 21);
		panel_5.add(rdbtnNewRadioButtonS2_2);

		JRadioButton rdbtnNewRadioButtonS2_3 = new JRadioButton("Manual");
		buttonGroup_1.add(rdbtnNewRadioButtonS2_3);
		rdbtnNewRadioButtonS2_3.setBounds(108, 60, 69, 21);
		panel_5.add(rdbtnNewRadioButtonS2_3);

		textFieldSetting2_1 = new JTextField();
		textFieldSetting2_1.setBounds(180, 9, 70, 19);
		panel_5.add(textFieldSetting2_1);
		textFieldSetting2_1.setColumns(10);

		textFieldSetting2_2 = new JTextField();
		textFieldSetting2_2.setBounds(180, 35, 70, 19);
		panel_5.add(textFieldSetting2_2);
		textFieldSetting2_2.setColumns(10);

		JButton btnNewButtonS2 = new JButton("SET");
		btnNewButtonS2.setBounds(285, 35, 80, 21);
		panel_5.add(btnNewButtonS2);

		JLabel lblNewLabel_3 = new JLabel("EDFA2");
		lblNewLabel_3.setBounds(12, 10, 50, 13);
		panel_5.add(lblNewLabel_3);

		textFieldSetting2_3 = new JTextField();
		textFieldSetting2_3.setColumns(10);
		textFieldSetting2_3.setBounds(180, 60, 70, 19);
		panel_5.add(textFieldSetting2_3);

		JLabel lblNewLabel_10_2 = new JLabel("dBm");
		lblNewLabel_10_2.setBounds(250, 14, 50, 13);
		panel_5.add(lblNewLabel_10_2);

		JLabel lblNewLabel_10_3 = new JLabel("dBm");
		lblNewLabel_10_3.setBounds(250, 39, 50, 13);
		panel_5.add(lblNewLabel_10_3);

		JLabel lblNewLabel_10_24_1 = new JLabel("mV");
		lblNewLabel_10_24_1.setBounds(250, 66, 50, 13);
		panel_5.add(lblNewLabel_10_24_1);
		btnNewButtonS2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButtonS2_1.isSelected()) {
					twsc.gain("A2",Double.parseDouble(textFieldSetting2_1.getText()));
				}else if(rdbtnNewRadioButtonS2_2.isSelected()) {
					twsc.output("A2", Double.parseDouble(textFieldSetting2_2.getText()));
				}else {
					twsc.current("A2", Double.parseDouble(textFieldSetting2_3.getText()));
				}
			}
		});

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		JButton btnNewButton_11 = new JButton("ON");
		btnNewButton_11.setBounds(12, 35, 91, 21);
		panel_7.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("OFF");
		btnNewButton_12.setForeground(Color.RED);
		btnNewButton_12.setBounds(12, 60, 91, 21);
		panel_7.add(btnNewButton_12);

		JRadioButton rdbtnNewRadioButtonS3_1 = new JRadioButton("Gain");
		rdbtnNewRadioButtonS3_1.setSelected(true);
		buttonGroup_2.add(rdbtnNewRadioButtonS3_1);
		rdbtnNewRadioButtonS3_1.setBounds(108, 10, 70, 20);
		panel_7.add(rdbtnNewRadioButtonS3_1);

		JRadioButton rdbtnNewRadioButtonS3_2 = new JRadioButton("Output");
		buttonGroup_2.add(rdbtnNewRadioButtonS3_2);
		rdbtnNewRadioButtonS3_2.setBounds(108, 35, 69, 21);
		panel_7.add(rdbtnNewRadioButtonS3_2);

		JRadioButton rdbtnNewRadioButtonS3_3 = new JRadioButton("Manual");
		buttonGroup_2.add(rdbtnNewRadioButtonS3_3);
		rdbtnNewRadioButtonS3_3.setBounds(108, 60, 69, 21);
		panel_7.add(rdbtnNewRadioButtonS3_3);

		textFieldSetting3_1 = new JTextField();
		textFieldSetting3_1.setBounds(180, 11, 70, 19);
		panel_7.add(textFieldSetting3_1);
		textFieldSetting3_1.setColumns(10);

		textFieldSetting3_2 = new JTextField();
		textFieldSetting3_2.setBounds(180, 35, 70, 19);
		panel_7.add(textFieldSetting3_2);
		textFieldSetting3_2.setColumns(10);

		JButton btnNewButtonS3 = new JButton("SET");
		btnNewButtonS3.setBounds(285, 35, 80, 21);
		panel_7.add(btnNewButtonS3);

		JLabel lblNewLabel_4 = new JLabel("EDFA3");
		lblNewLabel_4.setBounds(12, 10, 50, 13);
		panel_7.add(lblNewLabel_4);

		textFieldSetting3_3 = new JTextField();
		textFieldSetting3_3.setColumns(10);
		textFieldSetting3_3.setBounds(180, 60, 70, 19);
		panel_7.add(textFieldSetting3_3);

		JLabel lblNewLabel_10_4 = new JLabel("dBm");
		lblNewLabel_10_4.setBounds(250, 14, 50, 13);
		panel_7.add(lblNewLabel_10_4);

		JLabel lblNewLabel_10_5 = new JLabel("dBm");
		lblNewLabel_10_5.setBounds(250, 39, 50, 13);
		panel_7.add(lblNewLabel_10_5);

		JLabel lblNewLabel_10_24_2 = new JLabel("mV");
		lblNewLabel_10_24_2.setBounds(250, 66, 50, 13);
		panel_7.add(lblNewLabel_10_24_2);
		btnNewButtonS3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButtonS3_1.isSelected()) {
					twsc.gain("A3",Double.parseDouble(textFieldSetting3_1.getText()));
				}else if(rdbtnNewRadioButtonS3_2.isSelected()) {
					twsc.output("A3", Double.parseDouble(textFieldSetting3_2.getText()));
				}else {
					twsc.current("A3", Double.parseDouble(textFieldSetting3_3.getText()));
				}
			}
		});

		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		panel_9.setLayout(null);

		JButton btnNewButton_14 = new JButton("ON");
		btnNewButton_14.setBounds(12, 35, 91, 21);
		panel_9.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("OFF");
		btnNewButton_15.setForeground(Color.RED);
		btnNewButton_15.setBounds(12, 60, 91, 21);
		panel_9.add(btnNewButton_15);

		JRadioButton rdbtnNewRadioButtonS4_1 = new JRadioButton("Gain");
		rdbtnNewRadioButtonS4_1.setSelected(true);
		buttonGroup_3.add(rdbtnNewRadioButtonS4_1);
		rdbtnNewRadioButtonS4_1.setBounds(108, 10, 70, 20);
		panel_9.add(rdbtnNewRadioButtonS4_1);

		JRadioButton rdbtnNewRadioButtonS4_2 = new JRadioButton("Output");
		buttonGroup_3.add(rdbtnNewRadioButtonS4_2);
		rdbtnNewRadioButtonS4_2.setBounds(108, 35, 69, 21);
		panel_9.add(rdbtnNewRadioButtonS4_2);

		JRadioButton rdbtnNewRadioButtonS4_3 = new JRadioButton("Manual");
		buttonGroup_3.add(rdbtnNewRadioButtonS4_3);
		rdbtnNewRadioButtonS4_3.setBounds(108, 60, 69, 21);
		panel_9.add(rdbtnNewRadioButtonS4_3);

		textFieldSetting4_1 = new JTextField();
		textFieldSetting4_1.setBounds(180, 11, 70, 19);
		panel_9.add(textFieldSetting4_1);
		textFieldSetting4_1.setColumns(10);

		textFieldSetting4_2 = new JTextField();
		textFieldSetting4_2.setBounds(180, 35, 70, 19);
		panel_9.add(textFieldSetting4_2);
		textFieldSetting4_2.setColumns(10);

		JButton btnNewButtonS4 = new JButton("SET");
		btnNewButtonS4.setBounds(285, 35, 80, 21);
		panel_9.add(btnNewButtonS4);

		JLabel lblNewLabel_5 = new JLabel("EDFA4");
		lblNewLabel_5.setBounds(12, 10, 50, 13);
		panel_9.add(lblNewLabel_5);

		textFieldSetting4_3 = new JTextField();
		textFieldSetting4_3.setColumns(10);
		textFieldSetting4_3.setBounds(180, 60, 70, 19);
		panel_9.add(textFieldSetting4_3);

		JLabel lblNewLabel_10_6 = new JLabel("dBm");
		lblNewLabel_10_6.setBounds(249, 14, 50, 13);
		panel_9.add(lblNewLabel_10_6);

		JLabel lblNewLabel_10_7 = new JLabel("dBm");
		lblNewLabel_10_7.setBounds(249, 39, 50, 13);
		panel_9.add(lblNewLabel_10_7);

		JLabel lblNewLabel_10_24_3 = new JLabel("mV");
		lblNewLabel_10_24_3.setBounds(249, 66, 50, 13);
		panel_9.add(lblNewLabel_10_24_3);
		btnNewButtonS4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButtonS4_1.isSelected()) {
					twsc.gain("A4",Double.parseDouble(textFieldSetting4_1.getText()));
				}else if(rdbtnNewRadioButtonS4_2.isSelected()) {
					twsc.output("A4", Double.parseDouble(textFieldSetting4_2.getText()));
				}else {
					twsc.current("A4", Double.parseDouble(textFieldSetting4_3.getText()));
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton_17 = new JButton("ON");
		btnNewButton_17.setBounds(12, 35, 91, 21);
		panel_4.add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton("OFF");
		btnNewButton_18.setForeground(Color.RED);
		btnNewButton_18.setBounds(12, 60, 91, 21);
		panel_4.add(btnNewButton_18);

		JRadioButton rdbtnNewRadioButtonS5_1 = new JRadioButton("Gain");
		rdbtnNewRadioButtonS5_1.setSelected(true);
		buttonGroup_4.add(rdbtnNewRadioButtonS5_1);
		rdbtnNewRadioButtonS5_1.setBounds(108, 10, 70, 20);
		panel_4.add(rdbtnNewRadioButtonS5_1);

		JRadioButton rdbtnNewRadioButtonS5_2 = new JRadioButton("Output");
		buttonGroup_4.add(rdbtnNewRadioButtonS5_2);
		rdbtnNewRadioButtonS5_2.setBounds(108, 35, 61, 21);
		panel_4.add(rdbtnNewRadioButtonS5_2);

		JRadioButton rdbtnNewRadioButtonS5_3 = new JRadioButton("Manual");
		buttonGroup_4.add(rdbtnNewRadioButtonS5_3);
		rdbtnNewRadioButtonS5_3.setBounds(108, 60, 68, 21);
		panel_4.add(rdbtnNewRadioButtonS5_3);

		textFieldSetting5_1 = new JTextField();
		textFieldSetting5_1.setBounds(180, 11, 70, 19);
		panel_4.add(textFieldSetting5_1);
		textFieldSetting5_1.setColumns(10);

		textFieldSetting5_2 = new JTextField();
		textFieldSetting5_2.setBounds(180, 35, 70, 19);
		panel_4.add(textFieldSetting5_2);
		textFieldSetting5_2.setColumns(10);

		JButton btnNewButtonS5 = new JButton("SET");
		btnNewButtonS5.setBounds(285, 35, 80, 21);
		panel_4.add(btnNewButtonS5);

		JLabel lblNewLabel_6 = new JLabel("EDFA5");
		lblNewLabel_6.setBounds(12, 10, 50, 13);
		panel_4.add(lblNewLabel_6);

		textFieldSetting5_3 = new JTextField();
		textFieldSetting5_3.setColumns(10);
		textFieldSetting5_3.setBounds(180, 60, 70, 19);
		panel_4.add(textFieldSetting5_3);

		JLabel lblNewLabel_10_8 = new JLabel("dBm");
		lblNewLabel_10_8.setBounds(250, 14, 50, 13);
		panel_4.add(lblNewLabel_10_8);

		JLabel lblNewLabel_10_9 = new JLabel("dBm");
		lblNewLabel_10_9.setBounds(250, 39, 50, 13);
		panel_4.add(lblNewLabel_10_9);

		JLabel lblNewLabel_10_24_4 = new JLabel("mV");
		lblNewLabel_10_24_4.setBounds(250, 66, 50, 13);
		panel_4.add(lblNewLabel_10_24_4);
		btnNewButtonS5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButtonS5_1.isSelected()) {
					twsc.gain("A5",Double.parseDouble(textFieldSetting5_1.getText()));
				}else if(rdbtnNewRadioButtonS5_2.isSelected()) {
					twsc.output("A5", Double.parseDouble(textFieldSetting5_2.getText()));
				}else {
					twsc.current("A5", Double.parseDouble(textFieldSetting5_3.getText()));
				}
			}
		});

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(null);

		JButton btnNewButton_20 = new JButton("ON");
		btnNewButton_20.setBounds(12, 35, 91, 21);
		panel_6.add(btnNewButton_20);

		JButton btnNewButton_21 = new JButton("OFF");
		btnNewButton_21.setForeground(Color.RED);
		btnNewButton_21.setBounds(12, 60, 91, 21);
		panel_6.add(btnNewButton_21);

		JRadioButton rdbtnNewRadioButtonS6_1 = new JRadioButton("Gain");
		rdbtnNewRadioButtonS6_1.setSelected(true);
		buttonGroup_5.add(rdbtnNewRadioButtonS6_1);
		rdbtnNewRadioButtonS6_1.setBounds(108, 10, 70, 20);
		panel_6.add(rdbtnNewRadioButtonS6_1);

		JRadioButton rdbtnNewRadioButtonS6_2 = new JRadioButton("Output");
		buttonGroup_5.add(rdbtnNewRadioButtonS6_2);
		rdbtnNewRadioButtonS6_2.setBounds(108, 35, 68, 21);
		panel_6.add(rdbtnNewRadioButtonS6_2);

		JRadioButton rdbtnNewRadioButtonS6_3 = new JRadioButton("Manual");
		buttonGroup_5.add(rdbtnNewRadioButtonS6_3);
		rdbtnNewRadioButtonS6_3.setBounds(108, 60, 68, 21);
		panel_6.add(rdbtnNewRadioButtonS6_3);

		textFieldSetting6_1 = new JTextField();
		textFieldSetting6_1.setBounds(180, 11, 70, 19);
		panel_6.add(textFieldSetting6_1);
		textFieldSetting6_1.setColumns(10);

		textFieldSetting6_2 = new JTextField();
		textFieldSetting6_2.setBounds(180, 35, 70, 19);
		panel_6.add(textFieldSetting6_2);
		textFieldSetting6_2.setColumns(10);

		JButton btnNewButtonS6 = new JButton("SET");
		btnNewButtonS6.setBounds(285, 35, 80, 21);
		panel_6.add(btnNewButtonS6);

		JLabel lblNewLabel_7 = new JLabel("EDFA6");
		lblNewLabel_7.setBounds(12, 10, 50, 13);
		panel_6.add(lblNewLabel_7);

		textFieldSetting6_3 = new JTextField();
		textFieldSetting6_3.setColumns(10);
		textFieldSetting6_3.setBounds(180, 60, 70, 19);
		panel_6.add(textFieldSetting6_3);

		JLabel lblNewLabel_10_10 = new JLabel("dBm");
		lblNewLabel_10_10.setBounds(250, 14, 50, 13);
		panel_6.add(lblNewLabel_10_10);

		JLabel lblNewLabel_10_11 = new JLabel("dBm");
		lblNewLabel_10_11.setBounds(250, 39, 50, 13);
		panel_6.add(lblNewLabel_10_11);

		JLabel lblNewLabel_10_24_5 = new JLabel("mV");
		lblNewLabel_10_24_5.setBounds(250, 66, 50, 13);
		panel_6.add(lblNewLabel_10_24_5);
		btnNewButtonS6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButtonS6_1.isSelected()) {
					twsc.gain("A6",Double.parseDouble(textFieldSetting6_1.getText()));
				}else if(rdbtnNewRadioButtonS6_2.isSelected()) {
					twsc.output("A6", Double.parseDouble(textFieldSetting6_2.getText()));
				}else {
					twsc.current("A6", Double.parseDouble(textFieldSetting6_3.getText()));
				}
			}
		});

		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(null);

		JButton btnNewButton_23 = new JButton("ON");
		btnNewButton_23.setBounds(12, 35, 91, 21);
		panel_8.add(btnNewButton_23);

		JButton btnNewButton_24 = new JButton("OFF");
		btnNewButton_24.setForeground(Color.RED);
		btnNewButton_24.setBounds(12, 60, 91, 21);
		panel_8.add(btnNewButton_24);

		JRadioButton rdbtnNewRadioButtonS7_1 = new JRadioButton("Gain");
		rdbtnNewRadioButtonS7_1.setSelected(true);
		buttonGroup_6.add(rdbtnNewRadioButtonS7_1);
		rdbtnNewRadioButtonS7_1.setBounds(108, 10, 70, 20);
		panel_8.add(rdbtnNewRadioButtonS7_1);

		JRadioButton rdbtnNewRadioButtonS7_2 = new JRadioButton("Output");
		buttonGroup_6.add(rdbtnNewRadioButtonS7_2);
		rdbtnNewRadioButtonS7_2.setBounds(108, 35, 70, 21);
		panel_8.add(rdbtnNewRadioButtonS7_2);

		JRadioButton rdbtnNewRadioButtonS7_3 = new JRadioButton("Manual");
		buttonGroup_6.add(rdbtnNewRadioButtonS7_3);
		rdbtnNewRadioButtonS7_3.setBounds(108, 60, 65, 21);
		panel_8.add(rdbtnNewRadioButtonS7_3);

		textFieldSetting7_1 = new JTextField();
		textFieldSetting7_1.setBounds(180, 11, 70, 19);
		panel_8.add(textFieldSetting7_1);
		textFieldSetting7_1.setColumns(10);

		textFieldSetting7_2 = new JTextField();
		textFieldSetting7_2.setBounds(180, 35, 70, 19);
		panel_8.add(textFieldSetting7_2);
		textFieldSetting7_2.setColumns(10);

		JButton btnNewButtonS7 = new JButton("SET");
		btnNewButtonS7.setBounds(285, 35, 80, 21);
		panel_8.add(btnNewButtonS7);

		JLabel lblNewLabel_8 = new JLabel("EDFA7");
		lblNewLabel_8.setBounds(12, 10, 50, 13);
		panel_8.add(lblNewLabel_8);

		textFieldSetting7_3 = new JTextField();
		textFieldSetting7_3.setColumns(10);
		textFieldSetting7_3.setBounds(180, 60, 70, 19);
		panel_8.add(textFieldSetting7_3);

		JLabel lblNewLabel_10_12 = new JLabel("dBm");
		lblNewLabel_10_12.setBounds(250, 14, 50, 13);
		panel_8.add(lblNewLabel_10_12);

		JLabel lblNewLabel_10_13 = new JLabel("dBm");
		lblNewLabel_10_13.setBounds(250, 39, 50, 13);
		panel_8.add(lblNewLabel_10_13);

		JLabel lblNewLabel_10_24_6 = new JLabel("mV");
		lblNewLabel_10_24_6.setBounds(250, 66, 50, 13);
		panel_8.add(lblNewLabel_10_24_6);
		btnNewButtonS7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButtonS7_1.isSelected()) {
					twsc.gain("A7",Double.parseDouble(textFieldSetting7_1.getText()));
				}else if(rdbtnNewRadioButtonS7_2.isSelected()) {
					twsc.output("A7", Double.parseDouble(textFieldSetting7_2.getText()));
				}else {
					twsc.current("A7", Double.parseDouble(textFieldSetting7_3.getText()));
				}
			}
		});

		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(null);

		JButton btnNewButton_25 = new JButton("ON");
		btnNewButton_25.setBounds(12, 35, 91, 21);
		panel_10.add(btnNewButton_25);

		JButton btnNewButton_26 = new JButton("OFF");
		btnNewButton_26.setForeground(Color.RED);
		btnNewButton_26.setBounds(12, 60, 91, 21);
		panel_10.add(btnNewButton_26);

		JRadioButton rdbtnNewRadioButtonS8_1 = new JRadioButton("Gain");
		rdbtnNewRadioButtonS8_1.setSelected(true);
		buttonGroup_7.add(rdbtnNewRadioButtonS8_1);
		rdbtnNewRadioButtonS8_1.setBounds(108, 10, 70, 20);
		panel_10.add(rdbtnNewRadioButtonS8_1);

		JRadioButton rdbtnNewRadioButtonS8_2 = new JRadioButton("Output");
		buttonGroup_7.add(rdbtnNewRadioButtonS8_2);
		rdbtnNewRadioButtonS8_2.setBounds(108, 35, 68, 21);
		panel_10.add(rdbtnNewRadioButtonS8_2);

		JRadioButton rdbtnNewRadioButtonS8_3 = new JRadioButton("Manual");
		buttonGroup_7.add(rdbtnNewRadioButtonS8_3);
		rdbtnNewRadioButtonS8_3.setBounds(108, 60, 68, 21);
		panel_10.add(rdbtnNewRadioButtonS8_3);

		textFieldSetting8_1 = new JTextField();
		textFieldSetting8_1.setBounds(180, 11, 70, 19);
		panel_10.add(textFieldSetting8_1);
		textFieldSetting8_1.setColumns(10);

		textFieldSetting8_2 = new JTextField();
		textFieldSetting8_2.setBounds(180, 35, 70, 19);
		panel_10.add(textFieldSetting8_2);
		textFieldSetting8_2.setColumns(10);

		JButton btnNewButtonS8 = new JButton("SET");
		btnNewButtonS8.setBounds(285, 35, 80, 21);
		panel_10.add(btnNewButtonS8);

		JLabel lblNewLabel_9 = new JLabel("EDFA8");
		lblNewLabel_9.setBounds(12, 12, 50, 13);
		panel_10.add(lblNewLabel_9);

		textFieldSetting8_3 = new JTextField();
		textFieldSetting8_3.setColumns(10);
		textFieldSetting8_3.setBounds(180, 60, 70, 19);
		panel_10.add(textFieldSetting8_3);

		JLabel lblNewLabel_10_14 = new JLabel("dBm");
		lblNewLabel_10_14.setBounds(250, 14, 50, 13);
		panel_10.add(lblNewLabel_10_14);

		JLabel lblNewLabel_10_15 = new JLabel("dBm");
		lblNewLabel_10_15.setBounds(250, 39, 50, 13);
		panel_10.add(lblNewLabel_10_15);

		JLabel lblNewLabel_10_24_7 = new JLabel("mV");
		lblNewLabel_10_24_7.setBounds(250, 66, 50, 13);
		panel_10.add(lblNewLabel_10_24_7);

		JLabel errorCode = new JLabel("");
		errorCode.setForeground(Color.RED);
		errorCode.setBounds(110, 11, 470, 13);
		setting.add(errorCode);
		btnNewButtonS8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButtonS8_1.isSelected()) {
					twsc.gain("A8",Double.parseDouble(textFieldSetting8_1.getText()));
				}else if(rdbtnNewRadioButtonS8_2.isSelected()) {
					twsc.output("A8", Double.parseDouble(textFieldSetting8_2.getText()));
				}else {
					twsc.current("A8", Double.parseDouble(textFieldSetting8_3.getText()));
				}
			}
		});

		this.input = new JPanel();
		contentPane.add(this.input, "input");
		this.input.setLayout(null);

		Label label = new Label("Input");
		label.setFont(new Font("Arial", Font.BOLD, 18));
		label.setBounds(10, 8, 64, 23);
		this.input.add(label);

		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setBounds(703, 10, 68, 21);
		this.input.add(btnNewButton_4);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(10, 40, 752, 337);
		this.input.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));

		JPanel panel_13 = new JPanel();
		panel_11.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS));

		JPanel panel_20 = new JPanel();
		panel_13.add(panel_20);
		panel_20.setLayout(new BoxLayout(panel_20, BoxLayout.X_AXIS));

		textFieldIn1 = new JTextField();
		textFieldIn1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_20.add(textFieldIn1);
		textFieldIn1.setColumns(10);

		JPanel panel_19 = new JPanel();
		panel_13.add(panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.X_AXIS));

		textFieldIn2 = new JTextField();
		textFieldIn2.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_19.add(textFieldIn2);
		textFieldIn2.setColumns(10);

		JPanel panel_18 = new JPanel();
		panel_13.add(panel_18);
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.X_AXIS));

		textFieldIn3 = new JTextField();
		textFieldIn3.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_18.add(textFieldIn3);
		textFieldIn3.setColumns(10);

		JPanel panel_17 = new JPanel();
		panel_13.add(panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.X_AXIS));

		textFieldIn4 = new JTextField();
		textFieldIn4.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_17.add(textFieldIn4);
		textFieldIn4.setColumns(10);

		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));

		JPanel panel_22 = new JPanel();
		panel_12.add(panel_22);
		panel_22.setLayout(new BoxLayout(panel_22, BoxLayout.X_AXIS));

		textFieldIn8 = new JTextField();
		textFieldIn8.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_22.add(textFieldIn8);
		textFieldIn8.setColumns(10);

		JPanel panel_21 = new JPanel();
		panel_12.add(panel_21);
		panel_21.setLayout(new BoxLayout(panel_21, BoxLayout.X_AXIS));

		textFieldIn7 = new JTextField();
		textFieldIn7.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_21.add(textFieldIn7);
		textFieldIn7.setColumns(10);

		JPanel panel_23 = new JPanel();
		panel_12.add(panel_23);
		panel_23.setLayout(new BoxLayout(panel_23, BoxLayout.X_AXIS));

		textFieldIn6 = new JTextField();
		textFieldIn6.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_23.add(textFieldIn6);
		textFieldIn6.setColumns(10);

		JPanel panel_24 = new JPanel();
		panel_12.add(panel_24);
		panel_24.setLayout(new BoxLayout(panel_24, BoxLayout.X_AXIS));

		textFieldIn5 = new JTextField();
		textFieldIn5.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_24.add(textFieldIn5);
		textFieldIn5.setColumns(10);

		JButton btnNewButton_32 = new JButton("Reload");
		btnNewButton_32.setBounds(169, 10, 91, 21);
		input.add(btnNewButton_32);

		btnNewButton_32.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					iniTextFieldIn();
					String res = twsc.sendSpin();
					String[] split = res.split("\n");
					for(int i = 0; i < split.length; i++) {
						setTextFieldIn(split[i], i+1);
					}
				}
				catch(Exception ex) {}
			}
		});

		this.output = new JPanel();
		contentPane.add(output, "output");
		this.output.setLayout(null);

		JButton btnNewButton_30 = new JButton("Back");
		btnNewButton_30.setBounds(703, 10, 68, 21);
		this.output.add(btnNewButton_30);

		Label label_1 = new Label("Output");
		label_1.setFont(new Font("Arial", Font.BOLD, 18));
		label_1.setBounds(10, 8, 69, 23);
		this.output.add(label_1);

		JPanel panel_14 = new JPanel();
		panel_14.setBounds(10, 40, 752, 347);
		this.output.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));

		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.Y_AXIS));

		JPanel panel_28 = new JPanel();
		panel_16.add(panel_28);
		panel_28.setLayout(new BoxLayout(panel_28, BoxLayout.X_AXIS));

		textFieldOut1 = new JTextField();
		textFieldOut1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_28.add(textFieldOut1);
		textFieldOut1.setColumns(10);

		JPanel panel_27 = new JPanel();
		panel_16.add(panel_27);
		panel_27.setLayout(new BoxLayout(panel_27, BoxLayout.X_AXIS));

		textFieldOut2 = new JTextField();
		textFieldOut2.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_27.add(textFieldOut2);
		textFieldOut2.setColumns(10);

		JPanel panel_26 = new JPanel();
		panel_16.add(panel_26);
		panel_26.setLayout(new BoxLayout(panel_26, BoxLayout.X_AXIS));

		textFieldOut3 = new JTextField();
		textFieldOut3.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_26.add(textFieldOut3);
		textFieldOut3.setColumns(10);

		JPanel panel_25 = new JPanel();
		panel_16.add(panel_25);
		panel_25.setLayout(new BoxLayout(panel_25, BoxLayout.X_AXIS));

		textFieldOut4 = new JTextField();
		textFieldOut4.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_25.add(textFieldOut4);
		textFieldOut4.setColumns(10);

		JPanel panel_15 = new JPanel();
		panel_14.add(panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.Y_AXIS));

		JPanel panel_32 = new JPanel();
		panel_15.add(panel_32);
		panel_32.setLayout(new BoxLayout(panel_32, BoxLayout.X_AXIS));

		textFieldOut5 = new JTextField();
		textFieldOut5.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_32.add(textFieldOut5);
		textFieldOut5.setColumns(10);

		JPanel panel_31 = new JPanel();
		panel_15.add(panel_31);
		panel_31.setLayout(new BoxLayout(panel_31, BoxLayout.X_AXIS));

		textFieldOut6 = new JTextField();
		textFieldOut6.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_31.add(textFieldOut6);
		textFieldOut6.setColumns(10);

		JPanel panel_30 = new JPanel();
		panel_15.add(panel_30);
		panel_30.setLayout(new BoxLayout(panel_30, BoxLayout.X_AXIS));

		textFieldOut7 = new JTextField();
		textFieldOut7.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_30.add(textFieldOut7);
		textFieldOut7.setColumns(10);

		JPanel panel_29 = new JPanel();
		panel_15.add(panel_29);
		panel_29.setLayout(new BoxLayout(panel_29, BoxLayout.X_AXIS));

		textFieldOut8 = new JTextField();
		textFieldOut8.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		panel_29.add(textFieldOut8);
		textFieldOut8.setColumns(10);

		JButton btnNewButton_31 = new JButton("Reload");
		btnNewButton_31.setBounds(168, 10, 91, 21);
		this.output.add(btnNewButton_31);

		btnNewButton_31.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					iniTextFieldOut();
					String res = twsc.sendSpout();
					String[] split = res.split("\n");
					for(int i = 0; i < split.length; i++) {
						setTextFieldOut(split[i], i+1);
					}
				}
				catch(Exception ex){}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				CardLayout cl = (CardLayout)(Screen.this.contentPane.getLayout());
				//	    		cl.show(Screen.this.contentPane, "pumpInfo");
				try{
					
					twsc = new TwoWaySerialComm();
					twsc.connect(SPEED, PORT_NAME);
					
					twsc.sendVer();
					System.out.println(TwoWaySerialComm.readResponse());
					System.out.println(TwoWaySerialComm.readResponse());
					
					BootingThread bt = new BootingThread();
			        Thread t = new Thread(bt);
			        t.start();
					bootCount();
					
				}
				catch(Exception e1) {
					errorCodeStart.setText("Error");
					System.out.print(e1.toString());
				}
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "setting");   
				Runtime runtime = Runtime.getRuntime();
				try {
					String[] command = {
							"sh",
							"-c",
							"matchbox-keyboard"};
					Process p = runtime.exec(command);
					p.waitFor();
				} catch (IOException | InterruptedException e1) {
					e1.printStackTrace();
				}
				
			}
		});

		powerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					//runtime.exec("sudo shutdown now");
					String[] command = {
							"sh",
							"-c",
							"sudo shutdown now | echo raspberry"};
					Process p = runtime.exec(command);
					p.waitFor();
				} catch (IOException | InterruptedException e1) {
					e1.printStackTrace();
				}finally {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "input");
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "pumpInfo");
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "pumpInfo");
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a1 a\n");
				btnNewButton_5.setForeground(Color.RED);
				btnNewButton_6.setForeground(Color.BLACK);
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a1 n\n");
				btnNewButton_6.setForeground(Color.RED);
				btnNewButton_5.setForeground(Color.BLACK);
			}
		});
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a2 a\n");
				btnNewButton_8.setForeground(Color.RED);
				btnNewButton_9.setForeground(Color.BLACK);
			}
		});
		btnNewButton_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a2 n\n");
				btnNewButton_9.setForeground(Color.RED);
				btnNewButton_8.setForeground(Color.BLACK);
			}
		});

		btnNewButton_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a3 a\n");
				btnNewButton_11.setForeground(Color.RED);
				btnNewButton_12.setForeground(Color.BLACK);
			}
		});
		btnNewButton_12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a3 n\n");
				btnNewButton_12.setForeground(Color.RED);
				btnNewButton_11.setForeground(Color.BLACK);
			}
		});

		btnNewButton_14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a4 a\n");
				btnNewButton_14.setForeground(Color.RED);
				btnNewButton_15.setForeground(Color.BLACK);
			}
		});
		btnNewButton_15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a4 n\n");
				btnNewButton_15.setForeground(Color.RED);
				btnNewButton_14.setForeground(Color.BLACK);
			}
		});

		btnNewButton_17.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a5 a\n");
				btnNewButton_17.setForeground(Color.RED);
				btnNewButton_18.setForeground(Color.BLACK);
			}
		});
		btnNewButton_18.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a5 n\n");
				btnNewButton_18.setForeground(Color.RED);
				btnNewButton_17.setForeground(Color.BLACK);
			}
		});

		btnNewButton_20.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButton_20.setForeground(Color.RED);
				btnNewButton_21.setForeground(Color.BLACK);
				twsc.sendCommand("slos a6 a\n");
			}
		});
		btnNewButton_21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a6 n\n");
				btnNewButton_21.setForeground(Color.RED);
				btnNewButton_20.setForeground(Color.BLACK);
			}
		});

		btnNewButton_23.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a7 a\n");
				btnNewButton_23.setForeground(Color.RED);
				btnNewButton_24.setForeground(Color.BLACK);
			}
		});
		btnNewButton_24.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a7 n\n");
				btnNewButton_24.setForeground(Color.RED);
				btnNewButton_23.setForeground(Color.BLACK);
			}
		});

		btnNewButton_25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a8 a\n");
				btnNewButton_25.setForeground(Color.RED);
				btnNewButton_26.setForeground(Color.BLACK);
			}
		});
		btnNewButton_26.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				twsc.sendCommand("slos a8 n\n");
				btnNewButton_26.setForeground(Color.RED);
				btnNewButton_25.setForeground(Color.BLACK);
			}
		});
		btnNewButton_29.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "output");
			}
		});
		btnNewButton_30.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, "pumpInfo");
			}
		});
	}
	
	class BootingThread extends Thread {
	    public void run() {
	    	try {
	    	twsc.sendCommand((byte)0x01);//SOH
            twsc.sendCommand((byte)0x18);//CAN
            System.out.println(TwoWaySerialComm.readResponse());
			
			String res = twsc.sendSpin();
			String[] split = res.split("\n");
			for(int i = 0; i < split.length; i++) {
				setTextFieldIn(split[i], i+1);
			}
			res = twsc.sendSpout();
			String[] split1 = res.split("\n");
			for(int i = 0; i < split1.length; i++) {
				setTextFieldOut(split1[i], i+1);
			}
			res = twsc.sendPump("EOL");
			String[] split2 = res.split("\n");
			for(int i = 0; i < split2.length; i++){
				setTextFieldPump(split2[i], i+1);
			}
			twsc.sendCommand("rst\n");
			System.out.println(TwoWaySerialComm.readResponse());
			
			twsc.sendCommand((byte)0x01);//SOH
            twsc.sendCommand((byte)0x18);//CAN
	    	}catch(Exception e1) {
				errorCodeStart.setText("Could not communicate with EDFA");
				System.out.print(e1.toString());
			}
	    }
	}

	public void bootCount() throws Exception {
		int delay = 100; //milliseconds
		ActionListener taskPerformer = new ActionListener() {
			int cnt = 100;
			String str;
			public void actionPerformed(ActionEvent evt) {
				//...Perform a task...
				if (cnt > 0) {
					switch(cnt%4) {
					case 0:
						str = "Starting -";
						break;
					case 1:
						str = "Starting \\";
						break;
					case 2:
						str = "Starting |";
						break;
					case 3: 
						str = "Starting /";
						break;
					}
					errorCodeStart.setText(str);
					cnt--;
					if (cnt == 0){
						CardLayout cl = (CardLayout)(Screen.this.contentPane.getLayout());
						cl.show(Screen.this.contentPane, "pumpInfo");
					}
				}
			}
		};
		new Timer(delay, taskPerformer).start();
	}

	public void iniTextFieldIn(){
		this.textFieldIn1.setText("");
		this.textFieldIn2.setText("");
		this.textFieldIn3.setText("");
		this.textFieldIn4.setText("");
		this.textFieldIn5.setText("");
		this.textFieldIn6.setText("");
		this.textFieldIn7.setText("");
		this.textFieldIn8.setText("");
	}

	public void setTextFieldIn(String str, int i){
		switch(i){
		case 1:
			this.textFieldIn1.setText(str);
			break;
		case 2:
			this.textFieldIn2.setText(str);
			break;
		case 3:
			this.textFieldIn3.setText(str);
			break;
		case 4:
			this.textFieldIn4.setText(str);
			break;
		case 5:
			this.textFieldIn5.setText(str);
			break;
		case 6:
			this.textFieldIn6.setText(str);
			break;
		case 7:
			this.textFieldIn7.setText(str);
			break;
		case 8:
			this.textFieldIn8.setText(str);
			break;
		}
	}

	public void iniTextFieldPump(){
		this.textFieldPump1.setText("");
		this.textFieldPump2.setText("");
		this.textFieldPump3.setText("");
		this.textFieldPump4.setText("");
		this.textFieldPump5.setText("");
		this.textFieldPump6.setText("");
		this.textFieldPump7.setText("");
		this.textFieldPump8.setText("");
	}

	public void setTextFieldPump(String str, int i){
		switch(i){
		case 1:
			this.textFieldPump1.setText(str);
			break;
		case 2:
			this.textFieldPump2.setText(str);
			break;
		case 3:
			this.textFieldPump3.setText(str);
			break;
		case 4:
			this.textFieldPump4.setText(str);
			break;
		case 5:
			this.textFieldPump5.setText(str);
			break;
		case 6:
			this.textFieldPump6.setText(str);
			break;
		case 7:
			this.textFieldPump7.setText(str);
			break;
		case 8:
			this.textFieldPump8.setText(str);
			break;
		}
	}

	public void iniTextFieldOut(){
		this.textFieldOut1.setText("");
		this.textFieldOut2.setText("");
		this.textFieldOut3.setText("");
		this.textFieldOut4.setText("");
		this.textFieldOut5.setText("");
		this.textFieldOut6.setText("");
		this.textFieldOut7.setText("");
		this.textFieldOut8.setText("");
	}

	public void setTextFieldOut(String str, int i){
		switch(i){
		case 1:
			this.textFieldOut1.setText(str);
			break;
		case 2:
			this.textFieldOut2.setText(str);
			break;
		case 3:
			this.textFieldOut3.setText(str);
			break;
		case 4:
			this.textFieldOut4.setText(str);
			break;
		case 5:
			this.textFieldOut5.setText(str);
			break;
		case 6:
			this.textFieldOut6.setText(str);
			break;
		case 7:
			this.textFieldOut7.setText(str);
			break;
		case 8:
			this.textFieldOut8.setText(str);
			break;
		}
	}
}