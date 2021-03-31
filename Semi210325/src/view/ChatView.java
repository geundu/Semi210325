package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatView extends JFrame {

	JTextArea	chatArea			= null;
	JLabel		roomName			= null;
	JScrollPane	scrollPane_chatArea	= null;
	JPanel		panel_message		= null;
	JTextField	textField_send		= null;
	JButton		button_send			= null;

	public ChatView() {
		initDisplay();
	}

	public void initDisplay() {
		Font	titleFont	= new Font("맑은 고딕", Font.BOLD, 18);
		Font	buttonFont	= new Font("맑은 고딕", Font.PLAIN, 12);

		this.setLayout(new BorderLayout());
		panel_message = new JPanel();
		panel_message.setBackground(Color.ORANGE);
		textField_send = new JTextField(22);
		button_send = new JButton("Send");
		button_send.setFont(buttonFont);
//		button_send.addActionListener(null);
		panel_message.add(textField_send);
		panel_message.add(button_send);
		roomName = new JLabel("채팅방 이름");
		roomName.setFont(titleFont);

		chatArea = new JTextArea();
		chatArea.setEditable(false);
		scrollPane_chatArea = new JScrollPane(chatArea);
		this.add("North", roomName);
		this.add("Center", scrollPane_chatArea);
		this.add("South", panel_message);
//		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("ChatView");
		this.setSize(350, 600);
		this.setResizable(false);
		this.setVisible(true);
	}

//	public static void main(String[] args) {
//		new ChatView();
//	}
}
