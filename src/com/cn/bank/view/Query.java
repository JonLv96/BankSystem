package com.cn.bank.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.bank.domain.Money;
import com.cn.bank.domain.User;

public class Query extends JFrame {
	JLabel[] jl;
	JTextField[] jtf;
	JPanel[] jp;
	JPanel all;

	Font font1 = new Font("·ÂËÎ", Font.BOLD, 25);
	Font font2 = new Font("·ÂËÎ", Font.BOLD, 16);
	Font font3 = new Font("·ÂËÎ", Font.PLAIN, 16);
	
	Query(User user) {
		this.setBounds(0, 0, 250, 300);
		this.setTitle("Query");
		
		jl = new JLabel[4];
		jtf = new JTextField[3];
		jp = new JPanel[4];
		all = new JPanel(new GridLayout(4,1,1,1));
		
		jl[0]= new JLabel("ÐÕ    Ãû");
		jl[1]= new JLabel("Éí·ÝÖ¤ºÅÂë");
		jl[2]= new JLabel("Óà  ¶î");
		jl[3]= new JLabel("Query");
		jl[3].setFont(font1);
		jl[0].setFont(font2);
		jl[1].setFont(font2);
		jl[2].setFont(font2);
		
		jtf[0] = new JTextField(user.getUserName());
		jtf[1] = new JTextField(user.getIDCard());
		jtf[2] = new JTextField(user.getMoney().getMoney()+"");
		jtf[0].setFont(font3);
		jtf[1].setFont(font3);
		jtf[2].setFont(font3);
		
		jp[0] = new JPanel();
		jp[0].add(jl[3]);
		all.add(jp[0]);
		for(int i = 0; i<3;i++) {
			jp[i+1] = new JPanel();
			jp[i+1].add(jl[i]);
			jp[i+1].add(jtf[i]);
			jtf[i].setEditable(false);
			all.add(jp[i+1]);
		}
		this.add(all);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		
//		User user = new User("kkgs199","123456789","321","321",new Money(500));
//		new Query(user);
//	}
	
}
