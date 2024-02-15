package com.BankManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
	String pinnumber;
	Transactions(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		String image = "C:/Users/Daggupati teja/BankManagementSystem/src/icons/atm.jpg";
		ImageIcon i1 = new ImageIcon(image);
		Image i2 = i1.getImage(). getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image1 = new JLabel(i3);
		image1.setBounds(0,0,900,900);
		add(image1);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image1.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image1.add(deposit);
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(355,415,150,30);
		withdrawl.addActionListener(this);
		image1.add(withdrawl);
		
		fastcash = new JButton("FastCash");
		fastcash.setBounds(170,450,150,30);
		fastcash.addActionListener(this);
		image1.add(fastcash);
		
		ministatement = new JButton("MiniStatement");
		ministatement.setBounds(355,450,150,30);
		ministatement.addActionListener(this);
		image1.add(ministatement);
		
		pinchange = new JButton("PinChange");
		pinchange.setBounds(170,485,150,30);
		pinchange.addActionListener(this);
		image1.add(pinchange);
		
		balanceenquiry = new JButton("BalanceEnquiy");
		balanceenquiry.setBounds(355,485,150,30);
		balanceenquiry.addActionListener(this);
		image1.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image1.add(exit);
		
		
		setSize(900,900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(ae.getSource()==withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}else if(ae.getSource()==fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}else if(ae.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}else if(ae.getSource()==balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}else if(ae.getSource()==ministatement) {
			
			new MiniStatement(pinnumber).setVisible(true);
		}
			}

	public static void main(String[] args) {
		new Transactions("");
	}

}
