import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class WasaBillPage extends JFrame implements MouseListener, ActionListener
{
	
	private JLabel addBill,addUserId,userName;
	private JTextField bill,userIdF;
	private JButton logOut,submit,back;
	private JPanel panel;
	
	public boolean flag;
	public String u,name;
	
	public WasaBillPage(String ui,String uname)
	{	
		super("Wasa Bill Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		addUserId=new JLabel("User ID : ");
		addUserId.setBounds(350,200,100,20);
		panel.add(addUserId);
		
		addBill=new JLabel("Set Bill : ");
		addBill.setBounds(350,250,100,20);
		panel.add(addBill);
		
		userIdF=new JTextField();
		userIdF.setBounds(470,200,120,20);
		userIdF.addMouseListener(this);
		userIdF.addActionListener(this);
		panel.add(userIdF);
		
		bill=new JTextField();
		bill.setBounds(470,250,120,20);
		bill.addMouseListener(this);
		bill.addActionListener(this);
		panel.add(bill);
		
		submit=new JButton("Submit");
		submit.setBounds(510,320,80,40);
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
		
		u=ui;
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
		else if(elementText.equals(submit.getText()))
		{
			flag=true;
			updateInDB();
		}
		else if(elementText.equals(logOut.getText()))
		{
			LogInPage l=new LogInPage();
			l.setVisible(true);
			this.setVisible(false);
		}
	}
	public void updateInDB()
	{
		int newBill=0;
		String query = "SELECT * FROM `projectjava`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
					
			while(rs.next())
			{
                String uId = rs.getString("userId");
				String aT=rs.getString("accountType");
				
				if(uId.equals(userIdF.getText().toString()) && aT.equals("homeOwner"))
				{
					flag=false;
					newBill=Integer.parseInt(bill.getText().toString());
					System.out.println(newBill);
					
				}
			}
			if(flag)
			{
				JOptionPane.showMessageDialog(this,"User ID is invalid");
				return;
			}
		}
		catch(Exception e){}
		try
		{
			System.out.println("."); 
			query = "UPDATE `projectjava` SET `wasaBill`='"+newBill+"' where `projectjava`.`userId` ='"+userIdF.getText().toString()+"';";
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
			JOptionPane.showMessageDialog(this,"Bill is updated");
			
			WasaPage w=new WasaPage(u,name);
			w.setVisible(true);
			this.setVisible(false);
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}