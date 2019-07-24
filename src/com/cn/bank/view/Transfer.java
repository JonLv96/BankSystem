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

import com.cn.bank.domain.Money;
import com.cn.bank.domain.User;
import com.cn.bank.service.BankService;
import com.cn.bank.service.serviceImpl.BankServiceImpl;

public class Transfer extends JFrame implements ActionListener{
	User user_current;
	JLabel info;
	JLabel jl[];
	JTextField jtf[];
	JButton jb1,jb2;
	JPanel all;
	JPanel[] jp;
	
	Font font1 = new Font("仿宋", Font.BOLD, 25);
	Font font2 = new Font("仿宋", Font.BOLD, 16);
	Font font3 = new Font("仿宋", Font.PLAIN, 16);
	
	Transfer(User user){
		user_current = user;
		this.setBounds(0,0,300,400);
		
		info = new JLabel("Transfer");
		info.setFont(font1);
		jl = new JLabel[3];
		jl[0] = new JLabel("对方姓名");
		jl[0].setFont(font2);
		jl[1] = new JLabel("对方账号");
		jl[1].setFont(font2);
		jl[2] = new JLabel("转账金额");
		jl[2].setFont(font2);
		
		jtf = new JTextField[3];
		for(int i= 0;i<3;i++) {
			jtf[i] = new JTextField(15);
			jtf[i].setFont(font3);
		}
		
		jb1 = new JButton("确定");
		jb1.setFont(font2);
		jb1.addActionListener(this);
		jb2 = new JButton("重置");
		jb2.setFont(font2);
		jb2.addActionListener(this);
		
		jp = new JPanel[5];
		for(int i= 0;i<5;i++) {
			jp[i] = new JPanel();
		}
		jp[0].add(info);
		for(int i= 1;i<4;i++) {
			jp[i].add(jl[i-1]);
			jp[i].add(jtf[i-1]);
		}
		jp[4].add(jb1);
		jp[4].add(jb2);
		
		
		all = new JPanel(new GridLayout(5,1,1,1));
		for(int i= 0;i<5;i++) {
			all.add(jp[i]);
		}
		this.add(all);
		this.setLocationRelativeTo(null);		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		BankService bs = new BankServiceImpl();
		switch(e.getActionCommand()) {
			case "确定":{
				User user_target = new User();
				user_target.setUserName(jtf[0].getText());
				user_target.setUserCounter(jtf[1].getText());
				double money = Double.parseDouble(jtf[2].getText());
				try {
					bs.tansfer(user_current,user_target,money);
					JOptionPane.showMessageDialog(null, "转账成功", "Transfer", JOptionPane.DEFAULT_OPTION);
					this.setVisible(false);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "转账失败", "Transfer", JOptionPane.DEFAULT_OPTION);
					
				}
				break;
			}
			case "重置":{
				for(int i= 0;i<3;i++) {
					jtf[i].setText("");
				}
				break;
			}
			default:{
				break;
			}
		}
	}


//	public static void main(String[] args) {
//		User user = new User("kkgs199","123456789","321","321",new Money(500));
//		new Transfer(user);
//	}
}
