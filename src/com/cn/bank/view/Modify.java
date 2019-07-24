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

public class Modify extends JFrame implements ActionListener{


	User user1;

	private JLabel jl1,jl2,info;
	private JTextField jtf1,jtf2;
	private JButton jb1,jb2;
	
	JPanel all = new JPanel(new GridLayout(4,1,1,1));
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();
	
	
	Font font1 = new Font("仿宋", Font.BOLD, 25);
	Font font2 = new Font("仿宋", Font.PLAIN, 16);
	Modify(User user) {
		user1 =user; 
		this.setTitle("Login");
		this.setBounds(0, 0, 300, 300);
		jl1 = new JLabel("新密码");
		jl2 = new JLabel("确认密码");
		jtf1 = new JTextField(15);
		jtf2 = new JTextField(15);
		jb1 = new JButton("修改");
		jb2 = new JButton("重置");
		
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
		BankService bs = new BankServiceImpl();
		switch(e.getActionCommand()) {
			case "修改":{
				if(jtf1.getText().equals(jtf2.getText())) {
					try {
						user1.setUserPassword(jtf1.getText());
						bs.modify(user1);
						JOptionPane.showMessageDialog(null, "修改成功", "Modify", JOptionPane.DEFAULT_OPTION);
						this.setVisible(false);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "修改失败", "Modify", JOptionPane.DEFAULT_OPTION);
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入！！！", "Modify", JOptionPane.DEFAULT_OPTION);
				}
				break;
			}
			case "重置":{
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
	
//	public static void main(String[] args) {
//		new Login();
//	}
	
}
