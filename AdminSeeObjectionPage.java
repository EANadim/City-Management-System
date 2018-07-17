import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminSeeObjectionPage extends JFrame implements MouseListener, ActionListener
{
	private JLabel userName;
	private JButton backButton,desco,wasa,titas,logOut,back;
	private JPanel panel;

	public String uid,name;
	
	public AdminSeeObjectionPage(String u,String uname)
	{	
		super("Admin See Objection Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);	
		
		desco=new JButton("See Objection against Desco");
		desco.setBounds(440,100,300,60);
		desco.setOpaque(true);
		desco.setFont(new Font("Cambria",Font.BOLD,20));
		desco.setBackground(Color.BLUE.darker());
		desco.setForeground(Color.white);
		desco.addMouseListener(this);
		desco.addActionListener(this);
		panel.add(desco);
		
		wasa=new JButton("See Objection against Wasa");
		wasa.setBounds(440,200,300,60);
		wasa.setOpaque(true);
		wasa.setFont(new Font("Cambria",Font.BOLD,20));
		wasa.setBackground(Color.BLUE.darker());
		wasa.setForeground(Color.white);
		wasa.addMouseListener(this);
		wasa.addActionListener(this);
		panel.add(wasa);
		
		titas=new JButton("See Objection against Titas");
		titas.setBounds(440,300,300,60);
		titas.setOpaque(true);
		titas.setFont(new Font("Cambria",Font.BOLD,20));
		titas.setBackground(Color.BLUE.darker());
		titas.setForeground(Color.white);
		titas.addMouseListener(this);
		titas.addActionListener(this);
		panel.add(titas);
		
		back=new JButton("Back");
		back.setBounds(900,450,100,60);
		back.setOpaque(true);
		back.setFont(new Font("Cambria",Font.BOLD,20));
		back.setBackground(Color.YELLOW.darker());
		back.setForeground(Color.white);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);
		
		logOut=new JButton("Log Out");
		logOut.setBounds(1000,50,120,40);
		logOut.setOpaque(true);
		logOut.setBackground(Color.red.darker());
		logOut.setForeground(Color.white);
		logOut.addMouseListener(this);
		logOut.addActionListener(this);
		panel.add(logOut);
		
		uid=u;
		name=uname;
		
		userName=new JLabel("welcome "+uname);
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
		if(elementText.equals(desco.getText()))
		{
			DescoSeeObjectionPage d=new DescoSeeObjectionPage(uid,name);
			d.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(wasa.getText()))
		{
			WasaSeeObjectionPage w=new WasaSeeObjectionPage(uid,name);
			w.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(titas.getText()))
		{
			
		}
		else if(elementText.equals(logOut.getText()))
		{
			LogInPage l=new LogInPage();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(back.getText()))
		{
			AdminPage a=new AdminPage(uid,name);
			a.setVisible(true);
			this.setVisible(false);
		}
	}
}