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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin,repin;
	JButton change,back;
	String pinnumber;
	PinChange(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		String image = "C:/Users/Daggupati teja/BankManagementSystem/src/icons/atm.jpg";
		ImageIcon i1 = new ImageIcon(image);
		Image i2 = i1.getImage(). getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image1 = new JLabel(i3);
		image1.setBounds(0,0,900,900);
		add(image1);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,280,500,35);
		image1.add(text);
		
		JLabel pintext = new JLabel("NEW PIN");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(165,320,180,25);
		image1.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("System",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image1.add(pin);
		

		JLabel repintext = new JLabel("RE-ENTER NEW PIN");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(165,360,180,25);
		image1.add(repintext);
		
		
		repin = new JPasswordField();
		repin.setFont(new Font("System",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image1.add(repin);
		
		change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image1.add(change);
		
		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image1.add(back);
		
		
		
		
		
		
		
		
		
		
		setSize(900,900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==change)
		{
			try {
				String npin = pin.getText();
				String rpin = repin.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter pin");
					return;
				}
				
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new pin");
					return;
				}
				
				Conn conn = new Conn();
				String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
				String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
				String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
				
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN changed sucessfully");
				
				setVisible(false);
				new Transactions(rpin).setVisible(true);
				
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
