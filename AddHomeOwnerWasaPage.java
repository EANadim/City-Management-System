import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddHomeOwnerWasaPage extends JFrame implements MouseListener, ActionListener
{
	
	private JLabel homeOwnerId,userName,lineType;
	private JTextField homeOwnerIdF;
	private JButton logOut,submit,back;
	private JComboBox combo;
	private JPanel panel;
	
	public boolean flag;
	public String uid,name;
	
	public AddHomeOwnerWasaPage(String u,String uname)
	{	
		super("Add Home Owner Wasa Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		homeOwnerId=new JLabel("Home Owner Id : ");
		homeOwnerId.setBounds(350,150,150,40);
		panel.add(homeOwnerId);	
		
		homeOwnerIdF=new JTextField();
		homeOwnerIdF.setBounds(530,150,150,40);
		panel.add(homeOwnerIdF);			
		
		lineType=new JLabel("Add Connection Type : ");
		lineType.setBounds(350,220,150,40);
		panel.add(lineType);
		
		String []s={"residential","commercial","industrial"};

		combo=new JComboBox(s);
		combo.setBounds(530,220,120,40);
		panel.add(combo);
		
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
		
		uid=u;
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
			WasaPage w=new WasaPage(uid,name);
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
			flag=true;
			updateInDB();
		}
	}
	public void updateInDB()
	{
		String type="";
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
				
				if(uId.equals(homeOwnerIdF.getText().toString()) && aT.equals("homeOwner"))
				{
					flag=false;
					type=combo.getSelectedItem().toString();
					System.out.println(type);
					
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
			query = "UPDATE `projectjava` SET `wasaLineType`='"+type+"' where `projectjava`.`userId` ='"+homeOwnerIdF.getText().toString()+"';";
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
			JOptionPane.showMessageDialog(this,"Connection Type Updated");
			
			WasaPage w=new WasaPage(uid,name);
			w.setVisible(true);
			this.setVisible(false);
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}