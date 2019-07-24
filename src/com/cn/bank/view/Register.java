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

public class Register extends JFrame implements ActionListener {

	JLabel title;
	JLabel[] jl = null;
	JTextField[] jtf = null;
	JButton[] jb = null;

	JPanel all = new JPanel(new GridLayout(7, 1, 1, 1));
	JPanel[] jp;

	Font font1 = new Font("����", Font.BOLD, 25);
	Font font2 = new Font("����", Font.PLAIN, 16);

	public Register() {

		this.setBounds(0, 0, 400, 500);
		this.setTitle("Register");
		
		title = new JLabel("Register");
		title.setFont(font1);


		jl = new JLabel[5];
		jl[0] = new JLabel("��            ��");
		jl[1] = new JLabel("���֤����");
		jl[2] = new JLabel("��            ��");
		jl[3] = new JLabel("��            ��");
		jl[4] = new JLabel("��            ��");
		
		jtf = new JTextField[5];
		for (int i = 0; i < 5; i++) {
			jtf[i] = new JTextField(15);
		}

		
		jb = new JButton[2];
		jb[0] = new JButton("ȷ��");
		jb[1] = new JButton("����");
		jb[0].addActionListener(this);
		jb[1].addActionListener(this);

		jp = new JPanel[7];
		for (int i = 0; i < 7; i++) {
			jp[i] = new JPanel();
		}
		
		jp[0].add(title);
		for (int i = 0; i < 5; i++) {
			jp[i+1].add(jl[i]);
			jp[i+1].add(jtf[i]);
		}
		jp[6].add(jb[0]);
		jp[6].add(jb[1]);
		
		for (int i = 0; i < 7; i++) {
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
			case "ȷ��":{
				User user = new User();
				user.setUserName(jtf[0].getText());
				user.setIDCard(jtf[1].getText());
				user.setUserCounter(jtf[2].getText());
				user.setUserPassword(jtf[3].getText());
				Money money = new Money(Double.parseDouble(jtf[4].getText()));
				user.setMoney(money);
				BankService bs = new BankServiceImpl();
				try {
					bs.register(user);
					JOptionPane.showConfirmDialog(null, "ע��ɹ�������", "ע��", JOptionPane.DEFAULT_OPTION); 
					this.setVisible(false);
					new Main();
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(null, "ע��ʧ�ܣ�����", "ע��", JOptionPane.DEFAULT_OPTION); 
				}
				break;
			}
			case "����":{
				for (int i = 0; i < 5; i++) {
					jtf[i].setText("");
				}
				break;
			}
			default :{
				break;
			}
		}
	}
//	public static void main(String[] args) {
//		new Register();
//	}
}
