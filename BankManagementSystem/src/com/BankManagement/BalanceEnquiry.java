package com.BankManagement;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String pinnumber;
	BalanceEnquiry(String pinnumber){
		this.pinnumber = pinnumber;
		
		setLayout(null);
		String image = "C:/Users/Daggupati teja/BankManagementSystem/src/icons/atm.jpg";
		ImageIcon i1 = new ImageIcon(image);
		Image i2 = i1.getImage(). getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image1 = new JLabel(i3);
		image1.setBounds(0,0,900,900);
		add(image1);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image1.add(back);
		
		Conn c = new Conn();
		int balance = 0;
		try {
		
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));	
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		JLabel text = new JLabel("Your Current Account balance is RS"+ balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170,300,400,30);
		image1.add(text);
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

}
