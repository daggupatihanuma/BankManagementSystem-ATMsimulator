package com.BankManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdraw,back;
	String pinnumber;
	Withdrawl(String pinnumber) {
		this.pinnumber=pinnumber;
		
		
		setLayout(null);
		String image = "C:/Users/Daggupati teja/BankManagementSystem/src/icons/atm.jpg";
		ImageIcon i1 = new ImageIcon(image);
		Image i2 = i1.getImage(). getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image1 = new JLabel(i3);
		image1.setBounds(0,0,900,900);
		add(image1);
		
		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,14));
		text.setBounds(170,300,400,20);
		image1.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,14));
		amount.setBounds(170,350,320,25);
		image1.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355,485,150,30);
		withdraw.addActionListener(this);
		image1.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image1.add(back);
		
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==withdraw) {
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "please enter the value that you want to withdraw");
			}else {
				
				try {
					Conn conn = new Conn();
					String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+"Withdrawl Succesfully");
					
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
			
			
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
			
		}
	}
	public static void main(String[] args) {
		new Withdrawl("");
	}

}
