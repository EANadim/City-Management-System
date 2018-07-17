import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminPage extends JFrame implements MouseListener, ActionListener
{
	private JLabel userName;
	private JButton seeObjection,createNotice,createNewAccount,createSpecialNotice,logOut,deleteAccount;
	private JPanel panel;
	
	public String id,name;
	
	public AdminPage(String userId,String uname)
	{
		super("Admin Page");
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
		
		createNewAccount=new JButton("Create New Account");
		createNewAccount.setBounds(440,300,300,60);
		createNewAccount.setOpaque(true);
		createNewAccount.setFont(new Font("Cambria",Font.BOLD,26));
		createNewAccount.setBackground(Color.BLUE.darker());
		createNewAccount.setForeground(Color.white);
		createNewAccount.addMouseListener(this);
		createNewAccount.addActionListener(this);
		panel.add(createNewAccount);
		
		createSpecialNotice=new JButton("Create Special Notice");
		createSpecialNotice.setBounds(440,400,300,60);
		createSpecialNotice.setOpaque(true);
		createSpecialNotice.setFont(new Font("Cambria",Font.BOLD,26));
		createSpecialNotice.setBackground(Color.BLUE.darker());
		createSpecialNotice.setForeground(Color.white);
		createSpecialNotice.addMouseListener(this);
		createSpecialNotice.addActionListener(this);
		panel.add(createSpecialNotice);
		
		deleteAccount=new JButton("Delete Account");
		deleteAccount.setBounds(440,500,300,60);
		deleteAccount.setOpaque(true);
		deleteAccount.setFont(new Font("Cambria",Font.BOLD,26));
		deleteAccount.setBackground(Color.BLUE.darker());
		deleteAccount.setForeground(Color.white);
		deleteAccount.addMouseListener(this);
		deleteAccount.addActionListener(this);
		panel.add(deleteAccount);
		
		logOut=new JButton("Log Out");
		logOut.setBounds(1000,50,100,60);
		logOut.setOpaque(true);
		logOut.setFont(new Font("Cambria",Font.BOLD,15));
		logOut.setBackground(Color.RED.darker());
		logOut.setForeground(Color.white);
		logOut.addMouseListener(this);
		logOut.addActionListener(this);
		panel.add(logOut);
		
		id=userId;
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
		if(elementText.equals(createNewAccount.getText()))
		{
			CreateAccountPage c=new CreateAccountPage(id,name);
			c.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(logOut.getText()))
		{
			LogInPage l=new LogInPage();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(seeObjection.getText()))
		{
			AdminSeeObjectionPage a=new AdminSeeObjectionPage(id,name);
			a.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(deleteAccount.getText()))
		{
			DeleteAccountPage d=new DeleteAccountPage(id,name);
			d.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(createNotice.getText()))
		{
			AdminCreateNoticePage a=new AdminCreateNoticePage(id,name);
			a.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(createSpecialNotice.getText()))
		{
			AdminCreateSpecialNoticePage a=new AdminCreateSpecialNoticePage(id,name);
			a.setVisible(true);
			this.setVisible(false);
		}
	}
}