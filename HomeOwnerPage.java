import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HomeOwnerPage extends JFrame implements MouseListener, ActionListener
{
	
	private JLabel id,homeOwnerName,address,type,gasBill,electricityBill,wasaBill,electricityLineType,gasLineType,wasaLineType,createObjection,userName;
	private JTextField objection;
	private JButton logOut,submit;
	private JComboBox combo;
	private JPanel panel;

	public String uid;
	public boolean flag=true;
	
	public HomeOwnerPage(String u,String p,String t,String ahn,String a,String glt,String elt,String wlt,int gb,int eb,int wb)
	{	
		super("Home Owner Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		id=new JLabel("ID : "+u);
		id.setBounds(50,60,300,20);
		panel.add(id);
		
		homeOwnerName=new JLabel("Owner name : "+ahn);
		homeOwnerName.setBounds(50,80,300,20);
		panel.add(homeOwnerName);
		
		address=new JLabel("Address : "+a);
		address.setBounds(50,100,300,20);
		panel.add(address);
		
		type=new JLabel("Type : "+t);
		type.setBounds(50,120,300,20);
		panel.add(type);
		
		gasLineType=new JLabel("Gas Line Type : "+glt);
		gasLineType.setBounds(50,140,300,20);
		panel.add(gasLineType);
		
		gasBill=new JLabel("GasBill : "+gb);
		gasBill.setBounds(50,160,300,20);
		panel.add(gasBill);
		
		electricityLineType=new JLabel("Electricity Line Type : "+elt);
		electricityLineType.setBounds(50,180,300,20);
		panel.add(electricityLineType);
		
		electricityBill=new JLabel("Electricity Bill : "+eb);
		electricityBill.setBounds(50,200,300,20);
		panel.add(electricityBill);
		
		wasaLineType=new JLabel("Wasa Line Type : "+wlt);
		wasaLineType.setBounds(50,220,300,20);
		panel.add(wasaLineType);
		
		wasaBill=new JLabel("Wasa Bill : "+wb);
		wasaBill.setBounds(50,240,300,20);
		panel.add(wasaBill);

		createObjection=new JLabel("Create Objection : ");
		createObjection.setBounds(50,500,150,20);
		panel.add(createObjection);
		
		objection=new JTextField();
		objection.setBounds(210,493,400,40);
		panel.add(objection);
		
		logOut=new JButton("Log Out");
		logOut.setBounds(1000,50,120,40);
		logOut.setOpaque(true);
		logOut.setBackground(Color.red.darker());
		logOut.setForeground(Color.white);
		logOut.addMouseListener(this);
		logOut.addActionListener(this);
		panel.add(logOut);
		
		submit=new JButton("Submit");
		submit.setBounds(493,570,120,40);
		submit.setOpaque(true);
		submit.setBackground(Color.blue.darker());
		submit.setForeground(Color.white);
		submit.addMouseListener(this);
		submit.addActionListener(this);
		panel.add(submit);
		
		String []s={"desco","wasa","titas"};
		combo=new JComboBox(s);
		combo.setBounds(620,493,120,40);
		panel.add(combo);
		
		uid=u;
		
		userName=new JLabel("welcome "+ahn);
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
		else if(elementText.equals(submit.getText()))
		{
			flag=false;
			updateInDB();
		}
	}
	public void updateInDB()
	{
		String obj=objection.getText().toString();
		String query = "SELECT `userId`, `accountType`, `accountHolderName`,`address`,`password`,`gasLineType`,`gasBill`,`electricityLineType`,`electricityBill`,`wasaLineType`,`wasaBill`,`tiasObjection`,`descoObjection`,`wasaObjection` FROM `projectjava`;";   
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
					
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			if(combo.getSelectedItem().toString().equals("desco"))
			{
				query = "UPDATE `projectjava` SET `descoObjection`='"+obj+"' where `projectjava`.`userId` = '"+uid+"';";
			}
			else if(combo.getSelectedItem().toString().equals("wasa"))
			{
				query = "UPDATE `projectjava` SET `wasaObjection`='"+obj+"' where `projectjava`.`userId` = '"+uid+"';";
			}
			else if(combo.getSelectedItem().toString().equals("titas"))
			{
				query = "UPDATE `projectjava` SET `tiasObjection`='"+obj+"' where `projectjava`.`userId` = '"+uid+"';";
			} 
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
			flag=true;
		}
		catch(Exception e){System.out.println(e.getMessage());}
		if(flag){JOptionPane.showMessageDialog(this,"Objection Updated");}
	}
}