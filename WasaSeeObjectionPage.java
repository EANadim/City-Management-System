import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class WasaSeeObjectionPage extends JFrame implements MouseListener, ActionListener
{
	private JLabel objection,userName;
	private JTable myTable;
	private JScrollPane tableScrollPane;
	private JButton back,logOut;
	private JPanel panel;
	
	public String u,name;
	
	public WasaSeeObjectionPage(String userId,String uname)
	{
		super("Wasa See Objection Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		int counter=0;
		String [][]row=new String[100][4];
		String []col={"UserID","AccountHolderName","Address","ObjectionAgainstWasa"};
		
		objection=new JLabel("Objection Against Wasa");
		objection.setBounds(100,50,1000,50);
		panel.add(objection);
		
		u=userId;
		name=uname;

		back=new JButton("Back");
		back.setBounds(1020,520,80,40);
		back.setOpaque(true);
		back.setBackground(Color.YELLOW.darker());
		back.setForeground(Color.white);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);
		
		userName=new JLabel("welcome "+name);
		userName.setBounds(850,50,200,60);
		panel.add(userName);
		
		String s="",temp;
		
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
                String accountType = rs.getString("accountType");
				String accountHolderName = rs.getString("accountHolderName");
				String address=rs.getString("address");
				String wasaObjection=rs.getString("wasaObjection");
				if(accountType.equals("homeOwner"))
				{
					row[counter][0]=uId;
					row[counter][1]=accountHolderName;
					row[counter][2]=address;
					row[counter][3]=wasaObjection;
					counter++;
				}
			}

		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
		
		myTable=new JTable(row,col);
		tableScrollPane=new JScrollPane(myTable);
		tableScrollPane.setBounds(100,100,800,400);
		panel.add(tableScrollPane);
		
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
			check();
		}
	}
	public void check()
	{
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
                String accountType = rs.getString("accountType");
				if(accountType.equals("admin") && uId.equals(u))
				{
					AdminSeeObjectionPage a=new AdminSeeObjectionPage(u,name);
					a.setVisible(true);
					this.setVisible(false);
				}
				else if(accountType.equals("wasa") && uId.equals(u))
				{
					WasaPage w=new WasaPage(u,name);
					w.setVisible(true);
					this.setVisible(false);
				}
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
}