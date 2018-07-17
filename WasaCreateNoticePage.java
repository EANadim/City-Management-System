import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class WasaCreateNoticePage extends JFrame implements MouseListener, ActionListener
{
	private JLabel createNotice,userName;
	private JTextField createNoticeF;
	private JButton back,logOut,submit;
	private JPanel panel;
	
	public String u,name;
	
	public WasaCreateNoticePage(String userId,String uname)
	{
		super("Wasa Create Notice Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		createNotice=new JLabel("Create Notice : ");
		createNotice.setBounds(350,250,120,20);
		panel.add(createNotice);
		
		createNoticeF=new JTextField();
		createNoticeF.setBounds(500,250,150,20);
		createNoticeF.addMouseListener(this);
		createNoticeF.addActionListener(this);
		panel.add(createNoticeF);
		
		submit=new JButton("Submit");
		submit.setBounds(530,320,120,40);
		submit.setOpaque(true);
		submit.setBackground(Color.BLUE.darker());
		submit.setForeground(Color.white);
		submit.addMouseListener(this);
		submit.addActionListener(this);
		panel.add(submit);
		
		logOut=new JButton("Log Out");
		logOut.setBounds(1000,50,120,40);
		logOut.setOpaque(true);
		logOut.setBackground(Color.red.darker());
		logOut.setForeground(Color.white);
		logOut.addMouseListener(this);
		logOut.addActionListener(this);
		panel.add(logOut);

		back=new JButton("Back");
		back.setBounds(350,320,80,40);
		back.setOpaque(true);
		back.setBackground(Color.YELLOW.darker());
		back.setForeground(Color.white);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);

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
		if(elementText.equals(back.getText()))
		{
			WasaPage w=new WasaPage(u,name);
			w.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(logOut.getText()))
		{
			LogInPage l=new LogInPage();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(submit.getText()))
		{
			insertIntoDB();
		}
	}
	public void insertIntoDB()
	{
		Date date=new Date();
		String query = "INSERT INTO `wasanoticetable` (`date`,`wasaNotice`) VALUES ('"+date.toString()+"','"+createNoticeF.getText()+"');";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Notice Created");
			WasaPage w=new WasaPage(u,name);
			w.setVisible(true);
			this.setVisible(false);			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}