package com.cn.bank.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.cn.bank.domain.User;
import com.cn.bank.service.BankService;
import com.cn.bank.service.serviceImpl.BankServiceImpl;

public class Main extends JFrame implements ActionListener,WindowListener{
	User loginUser = null;
	JButton login = new JButton("��¼");
	
	
	Login loginFrame=null;
	
	JButton[] jb_left;
	JButton[] jb_right;
	
	JLabel[] jl;
	
	Font font1 = new Font("����", Font.BOLD, 25);
	Font font2 = new Font("����", Font.BOLD, 16);
	Font font3 = new Font("����", Font.PLAIN, 16);
	Main(){
		this.setSize(450,520);
		this.setTitle("Main");
		this.setLayout(null);
		
		jb_left = new JButton[4];
		jb_left[0] = new JButton("��ѯ");
		jb_left[1] = new JButton("���");
		jb_left[2] = new JButton("ȡ��");
		jb_left[3] = new JButton("��ʧ");

		jb_right = new JButton[4];
		jb_right[0] = new JButton("ת��");
		jb_right[1] = new JButton("����");
		jb_right[2] = new JButton("����");
		jb_right[3] = new JButton("�˿�");
		
		jl = new JLabel[3];
		jl[0] = new JLabel("JAVA����");
		jl[0].setFont(font1);
		jl[1] = new JLabel("��ӭ��");
		jl[1].setFont(font2);
		jl[2] = new JLabel("��ѡ�����");
		jl[2].setFont(font1);
		
		jb_left[0].setBounds( 0,50,90,60);   
		jb_left[1].setBounds( 0,150,90,60);
		jb_left[2].setBounds( 0,250,90,60);
		jb_left[3].setBounds(0,350,90,60);
		jb_right[0].setBounds( 354,50,90,60);
		jb_right[1].setBounds( 354,150,90,60);
		jb_right[2].setBounds( 354,250,90,60);
		jb_right[3].setBounds(354,350,90,60);
		login.setBounds(354,420,90,60);
		login.addActionListener(this);
		jb_left[0].addActionListener(this); 
		jb_left[1].addActionListener(this); 
		jb_left[2].addActionListener(this);
		jb_left[3].addActionListener(this);
		jb_right[0].addActionListener(this);
		jb_right[1].addActionListener(this);
		jb_right[2].addActionListener(this);
		jb_right[3].addActionListener(this);

		jl[0].setBounds(160,120,150,50);
        jl[1].setBounds(185,160,150,50);
        jl[2].setBounds(150,250,150,50);
        
        
        
        this.add(login);
        this.add(jb_left[0]);
        this.add(jb_left[1]);
        this.add(jb_left[2]);
        this.add(jb_left[3]);
        this.add(jb_right[0]);
        this.add(jb_right[1]);
        this.add(jb_right[2]);
        this.add(jb_right[3]);
        this.add(jl[0]);
        this.add(jl[1]);
        this.add(jl[2]);
		
		this.addWindowListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		BankService bs = new BankServiceImpl();
		switch(e.getActionCommand()) {
			case "��ѯ":{
				if(loginUser==null) {
					JOptionPane.showConfirmDialog(null,"���ȵ�¼","message",JOptionPane.DEFAULT_OPTION);
				}else {
					new Query(loginUser);
				}
				break;
			}
			case "���":{
				if(loginUser==null) {
					JOptionPane.showConfirmDialog(null,"���ȵ�¼","message",JOptionPane.DEFAULT_OPTION);
				}else {
					new Deposit(loginUser);
				}
				break;
			}
			case "ȡ��":{
				if(loginUser==null) {
				}else {
					new Withdraw(loginUser);
				}
				break;
			}
			case "��ʧ":{
				JOptionPane.showConfirmDialog(null,"�Ѿ�������˻�������","message",JOptionPane.DEFAULT_OPTION);
				break;
			}
			case "ת��":{
				new Transfer(loginUser);
				break;
			}
			case "����":{
				new Modify(loginUser);
				break;
			}
			case "����":{
				new Register();
				break;
			}
			case "�˿�":{
				System.exit(0);
				break;
			}
			case "��¼":{
				loginFrame =  new Login();
				break;
			}
			default:{
				break;
			}
		}
	}
	//���ڼ����¼�

	@Override
	public void windowActivated(WindowEvent e) {
		if(loginFrame!=null) {
			loginUser=loginFrame.getUser();
			if(loginUser!=null) {
				login.setVisible(false);
				BankService bs = new BankServiceImpl();
				try {
					loginUser = bs.findUserByCounter(loginUser);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
