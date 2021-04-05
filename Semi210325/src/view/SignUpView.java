package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpView extends JDialog implements ActionListener {

	JLabel			label_id			= null;
	JLabel			label_pw			= null;
	JLabel			label_nickname		= null;
	JTextField		textField_id		= null;
	JPasswordField	pwField_pw			= null;
	JTextField		textField_nickname	= null;
	JButton			button_signUp		= null;
	JButton			button_close		= null;

	public SignUpView() {
		initDisplay();
	}

	public void initDisplay() {
		Font font = new Font("맑은 고딕", Font.PLAIN, 12);
		label_id = new JLabel("ID");
		textField_id = new JTextField();
		label_pw = new JLabel("PASSWORD");
		pwField_pw = new JPasswordField();
		label_nickname = new JLabel("NICKNAME");
		textField_nickname = new JTextField();
		button_signUp = new JButton("Sign up");
		button_close = new JButton("Close");
		this.setLayout(null);
		// 아이디 레이블
		label_id.setFont(font);
		label_id.setBounds(40, 10, 100, 20);
		this.add(label_id);
		// 아이디 텍스트필드
		textField_id.setBounds(150, 10, 100, 20);
		this.add(textField_id);
		// 비밀번호 레이블
		label_pw.setFont(font);
		label_pw.setBounds(40, 40, 100, 20);
		this.add(label_pw);
		// 비밀번호 패스워드필드
		pwField_pw.setBounds(150, 40, 100, 20);
		this.add(pwField_pw);
		// 닉네임 레이블
		label_nickname.setFont(font);
		label_nickname.setBounds(40, 70, 100, 20);
		this.add(label_nickname);
		// 닉네임 텍스트필드
		textField_nickname.setBounds(150, 70, 100, 20);
		this.add(textField_nickname);
		// 회원가입 버튼
		button_signUp.setFont(font);
		button_signUp.setBounds(40, 110, 90, 30);
		button_signUp.addActionListener(this);
		this.add(button_signUp);
		// 취소 버튼
		button_close.setFont(font);
		button_close.setBounds(150, 110, 90, 30);
		button_close.addActionListener(this);
		this.add(button_close);

		this.getContentPane().setBackground(Color.ORANGE);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("SignUpView");
		this.setSize(300, 200);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == button_signUp) {

			if ("".equals(textField_id.getText()) || "".equals(pwField_pw.getText())
										|| "".equals(textField_nickname.getText())) {
				JOptionPane.showMessageDialog(this, "입력되지 않은 칸이 있습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		else if (obj == button_close) {
			this.dispose();
		}
	}
}
