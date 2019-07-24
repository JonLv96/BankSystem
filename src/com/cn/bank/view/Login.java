package com.cn.bank.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.bank.domain.User;
import com.cn.bank.service.BankService;
import com.cn.bank.service.serviceImpl.BankServiceImpl;

public class Login extends JFrame implements ActionListener{



	User user = null;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	private JLabel jl1,jl2,info;
	private JTextField jtf1,jtf2;
	private JButton jb1,jb2;
	
	JPanel all = new JPanel(new GridLayout(4,1,1,1));
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();
	
	
	Font font1 = new Font("·ÂËÎ", Font.BOLD, 25);
	Font font2 = new Font("·ÂËÎ", Font.PLAIN, 16);
	Login() {
		this.setTitle("Login");
		this.setBounds(0, 0, 300, 300);
		jl1 = new JLabel("ÕËºÅ");
		jl2 = new JLabel("ÃÜÂë");
		jtf1 = new JTextField(15);
		jtf2 = new JTextField(15);
		jb1 = new JButton("µÇÂ¼");
		jb2 = new JButton("ÖØÖÃ");
		
		info = new JLabel("Login");
		info.setFont(font1);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp4.add(info);
		jp1.add(jl1);
		jp1.add(jtf1);
		jp2.add(jl2);
		jp2.add(jtf2);
		jp3.add(jb1);
		jp3.add(jb2);
		all.add(jp4);
		all.add(jp1);
		all.add(jp2);
		all.add(jp3);
		this.add(all);
		
		
		this.setLocationRelativeTo(null);		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "µÇÂ¼":{
				user = userLogin();
				break;
			}
			case "ÖØÖÃ":{
				jtf1.setText("");
				jtf2.setText("");
				break;
			}
			default:{
				
			}
		}
	}
	
	


	@Override
	public boolean isActive() {
		
		
		return super.isActive();
	}
	public  User userLogin() {
		User user = new User();
		user.setUserCounter(jtf1.getText());
		user.setUserPassword(jtf2.getText());
		BankService bs = new BankServiceImpl();
		User user2 = null;
		try {
			user2 = bs.login(user);
			if(user2.getUserCounter()!=null) {
				JOptionPane.showConfirmDialog(null, "µÇÂ½³É¹¦", "Login", JOptionPane.DEFAULT_OPTION);
				this.setVisible(false);
			}else {
				JOptionPane.showConfirmDialog(null, "ÓÃ»§ÃûÃÜÂë´íÎó£¬µÇÂ½Ê§°Ü£¡£¡£¡", "Login", JOptionPane.DEFAULT_OPTION);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user2;
	}
	
//	public static void main(String[] args) {
//		new Login();
//	}
	
}
