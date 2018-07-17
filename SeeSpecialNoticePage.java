import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SeeSpecialNoticePage extends JFrame implements MouseListener, ActionListener
{
	private JLabel userName,label;
	private JButton back;
	private JTable myTable;
	private JScrollPane tableScrollPane;
	private JPanel panel;
	
	public String u,name;
	
	public SeeSpecialNoticePage(String userId,String uname)
	{
		super("See Special Notice Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		u=userId;
		name=uname;
		
		
		back=new JButton("Back");
		back.setBounds(1000,50,70,50);
		back.setOpaque(true);
		back.setFont(new Font("Cambria",Font.BOLD,15));
		back.setBackground(Color.YELLOW.darker());
		back.setForeground(Color.white);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);	
		
		userName=new JLabel("welcome "+name);
		userName.setBounds(850,50,200,60);
		panel.add(userName);
		
		String [][]row=new String[50][50];
		String []col={"date","Notice"};
		int counter=0;
		
		String query = "SELECT * FROM `specialnotice` ORDER BY `sl` DESC;";     
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
            	row[counter][0]=rs.getString("date");
				row[counter][1]=rs.getString("notice");
				counter++;
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
		
		myTable = new JTable(row,col);
		tableScrollPane = new JScrollPane(myTable);
		tableScrollPane.setBounds(300,100,500,400);
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
					String i=rs.getString("userId");
					String aT=rs.getString("accountType");
					if(i.equals(u) && aT.equals("desco"))
					{
						DescoPage d=new DescoPage(u,name);
						d.setVisible(true);
						this.setVisible(false);
					}
					else if(i.equals(u) && aT.equals("wasa"))
					{
						WasaPage w=new WasaPage(u,name);
						w.setVisible(true);
						this.setVisible(false);
					}
					else
					{
						
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
}