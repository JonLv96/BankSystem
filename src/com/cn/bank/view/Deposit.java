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

public class Deposit extends JFrame implements ActionListener{
	User user1;
	
	JLabel info,jl1,jl2;
	JTextField jtf1,jtf2;
	JButton jb1,jb2;
	JPanel all;
	JPanel[] jp;
	

	Font font1 = new Font("仿宋", Font.BOLD, 25);
	Font font2 = new Font("仿宋", Font.BOLD, 16);
	Font font3 = new Font("仿宋", Font.PLAIN, 16);

	
	Deposit(User user){
		user1 = user;
		
		this.setBounds(0, 0, 250, 300);
		this.setTitle("Qeposit");
		
		info = new JLabel("Deposit");
		info.setFont(font1);
		
		jl1 = new JLabel("存款：");
		jl1.setFont(font2);
		jtf1 = new JTextField(15);
		jtf1.setFont(font3);
		
		jb1 = new JButton("确定");
		jb1.addActionListener(this);
		jb2 = new JButton("重置");
		jb2.addActionListener(this);
		jb1.setFont(font2);
		jb2.setFont(font2);
		
		jl2 = new JLabel("余额：");
		jl2.setFont(font2);
		jtf2 = new JTextField(15);
		jtf2.setFont(font3);
		jtf2.setText(user.getMoney().getMoney()+"");
		jtf2.setEditable(false);
		
		
		all = new JPanel(new GridLayout(4,1,1,1));
		jp = new JPanel[4];
		for(int i=0;i<4;i++) {
			jp[i] = new JPanel();
		}
		jp[0].add(info);
		jp[1].add(jl1);
		jp[1].add(jtf1);
		jp[2].add(jb1);
		jp[2].add(jb2);
		jp[3].add(jl2);
		jp[3].add(jtf2);
		for(int i=0;i<4;i++) {
			all.add(jp[i]);
		}
		this.add(all);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "确定":{
				double money = Double.parseDouble(jtf1.getText()) + user1.getMoney().getMoney();
				user1.getMoney().setMoney(money);
				BankService bs = new BankServiceImpl();
				try {
					bs.deposit(user1);
					JOptionPane.showConfirmDialog(null, "存款成功", "Deposit", JOptionPane.DEFAULT_OPTION);
					this.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(null, "存款失败", "Deposit", JOptionPane.DEFAULT_OPTION);
					e1.printStackTrace();
				}
				break;
			}
			case "重置":{
				jtf1.setText("");
				break;
			}
			
		}
	}
	
//	public static void main(String[] args) {
//		User user = new User("kkgs199","123456789","321","321",new Money(500));
//		new Deposit(user);
//	}
	
}
