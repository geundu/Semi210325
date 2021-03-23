package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInView extends JFrame {

	JLabel			label_id		= null;
	JLabel			label_pw		= null;
	JTextField		textField_id	= null;
	JPasswordField	pwField_pw		= null;
	JButton			jbtn_signIn		= null;
	JButton			jbtn_signUp		= null;

	public SignInView() {
		initDisplay();
	}

	public void initDisplay() {
		Font font = new Font("맑은 고딕", Font.PLAIN, 12);
		label_id = new JLabel("ID");
		textField_id = new JTextField();
		label_pw = new JLabel("PASSWORD");
		pwField_pw = new JPasswordField();
		jbtn_signIn = new JButton("Sign in");
		jbtn_signUp = new JButton("Sign up");
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
		// 로그인 버튼
		jbtn_signIn.setFont(font);
		jbtn_signIn.setBounds(40, 70, 90, 30);
		jbtn_signIn.addActionListener(null);
		this.add(jbtn_signIn);
		// 회원가입 버튼
		jbtn_signUp.setFont(font);
		jbtn_signUp.setBounds(150, 70, 90, 30);
		jbtn_signUp.addActionListener(null);
		this.add(jbtn_signUp);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("SignInView");
		this.setSize(300, 150);
		this.setResizable(false);
		this.setVisible(true);
	}

//	public static void main(String[] args) {
//		new SignInView();
//	}
}
