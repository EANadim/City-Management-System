import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class WasaPage extends JFrame implements MouseListener, ActionListener
{
	private JLabel userName;
	private JButton seeObjection,createNotice,seeSpecialNotice,bill,addHomeOwner,logOut;
	private JPanel panel;
	
	public String u,name;
	
	public WasaPage(String userId,String uname)
	{
		super("Wasa Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		seeObjection=new JButton("See Objection");
		seeObjection.setBounds(440,100,300,60);
		seeObjection.setOpaque(true);
		seeObjection.setFont(new Font("Cambria",Font.BOLD,26));
		seeObjection.setBackground(Color.BLUE.darker());
		seeObjection.setForeground(Color.white);
		seeObjection.addMouseListener(this);
		seeObjection.addActionListener(this);
		panel.add(seeObjection);
		
		createNotice=new JButton("Create Notice");
		createNotice.setBounds(440,200,300,60);
		createNotice.setOpaque(true);
		createNotice.setFont(new Font("Cambria",Font.BOLD,26));
		createNotice.setBackground(Color.BLUE.darker());
		createNotice.setForeground(Color.white);
		createNotice.addMouseListener(this);
		createNotice.addActionListener(this);
		panel.add(createNotice);
		
		seeSpecialNotice=new JButton("See Special Notice");
		seeSpecialNotice.setBounds(440,300,300,60);
		seeSpecialNotice.setOpaque(true);
		seeSpecialNotice.setFont(new Font("Cambria",Font.BOLD,26));
		seeSpecialNotice.setBackground(Color.BLUE.darker());
		seeSpecialNotice.setForeground(Color.white);
		seeSpecialNotice.addMouseListener(this);
		seeSpecialNotice.addActionListener(this);
		panel.add(seeSpecialNotice);
		
		bill=new JButton("Bill");
		bill.setBounds(440,400,300,60);
		bill.setOpaque(true);
		bill.setFont(new Font("Cambria",Font.BOLD,26));
		bill.setBackground(Color.BLUE.darker());
		bill.setForeground(Color.white);
		bill.addMouseListener(this);
		bill.addActionListener(this);
		panel.add(bill);
		
		addHomeOwner=new JButton("Add Home Owner");
		addHomeOwner.setBounds(440,500,300,60);
		addHomeOwner.setOpaque(true);
		addHomeOwner.setFont(new Font("Cambria",Font.BOLD,26));
		addHomeOwner.setBackground(Color.BLUE.darker());
		addHomeOwner.setForeground(Color.white);
		addHomeOwner.addMouseListener(this);
		addHomeOwner.addActionListener(this);
		panel.add(addHomeOwner);
		
		logOut=new JButton("Log Out");
		logOut.setBounds(1000,50,100,60);
		logOut.setOpaque(true);
		logOut.setFont(new Font("Cambria",Font.BOLD,15));
		logOut.setBackground(Color.RED.darker());
		logOut.setForeground(Color.white);
		logOut.addMouseListener(this);
		logOut.addActionListener(this);
		panel.add(logOut);
		
		u=userId;
		name=uname;
		
		userName=new JLabel("welcome "+name);
		userName.setBounds(850,50,200,60);
		panel.add(userName);
		
		this.add(panel);
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void actionPerformed(ActionEvent ae)
	{
		String elementText=ae.getActionCommand();
		if(elementText.equals(logOut.getText()))
		{
			LogInPage l=new LogInPage();
			this.setVisible(false);
			l.setVisible(true);
		}
		else if(elementText.equals(bill.getText()))
		{
			WasaBillPage wbp=new WasaBillPage(u,name);
			wbp.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(seeObjection.getText()))
		{
			WasaSeeObjectionPage w=new WasaSeeObjectionPage(u,name);
			w.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(addHomeOwner.getText()))
		{
			AddHomeOwnerWasaPage a=new AddHomeOwnerWasaPage(u,name);
			a.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(createNotice.getText()))
		{
			WasaCreateNoticePage w=new WasaCreateNoticePage(u,name);
			w.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(seeSpecialNotice.getText()))
		{
			SeeSpecialNoticePage s=new SeeSpecialNoticePage(u,name);
			s.setVisible(true);
			this.setVisible(false);
		}
		else{} 
	}
}