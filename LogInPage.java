import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LogInPage extends JFrame implements MouseListener, ActionListener
{
	private JTable myTablel1,myTablel2,myTablel3;
	private JScrollPane tableScrollPane1,tableScrollPane2,tableScrollPane3;
	private JLabel notice,homeOwnerAddress,id,password,accountType;
	private JTextField logInTf,searchTf;
	private JPasswordField pf;
	private JButton search,logIn,exit;
	private JPanel panel;
	private JComboBox combo;
	
	public boolean flag,flag2;
	
	public LogInPage()
	{	
		super("Log in Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		accountType=new JLabel("Account type : ");
		accountType.setBounds(870,270,100,20);
		panel.add(accountType);
		
		String []s={"homeOwner","desco","titas","wasa","admin"};
		combo=new JComboBox(s);
		combo.setBounds(1030,270,120,20);
		combo.addActionListener(this);
		panel.add(combo);
		
		id=new JLabel("ID : ");
		id.setBounds(870,300,70,20);
		panel.add(id);
		
		password=new JLabel("Password : ");
		password.setBounds(870,330,70,20);
		panel.add(password);

		logInTf=new JTextField();
		logInTf.setBounds(1030,300,120,20);
		panel.add(logInTf);
		
		pf=new JPasswordField();
		pf.setBounds(1030,330,120,20);
		panel.add(pf);
		
		logIn=new JButton("Log in");
		logIn.setBounds(870,380,70,40);
		logIn.setOpaque(true);
		logIn.setBackground(Color.blue.darker());
		logIn.setForeground(Color.white);
		logIn.addMouseListener(this);
		logIn.addActionListener(this);
		panel.add(logIn);
		
		exit=new JButton("Exit");
		exit.setBounds(1080,380,70,40);
		exit.setOpaque(true);
		exit.setBackground(Color.red.darker());
		exit.setForeground(Color.white);
		exit.addMouseListener(this);
		exit.addActionListener(this);
		panel.add(exit);
		
		homeOwnerAddress=new JLabel("Home Owner address :");
		homeOwnerAddress.setBounds(50,500,170,20);
		panel.add(homeOwnerAddress);

		searchTf=new JTextField();
		searchTf.setBounds(200,500,120,20);
		panel.add(searchTf);
		
		search=new JButton("Search");
		search.setBounds(350,490,120,40);
		search.setOpaque(true);
		search.setBackground(Color.blue.darker());
		search.setForeground(Color.white);
		search.addMouseListener(this);
		search.addActionListener(this);
		panel.add(search);
		
		notice=new JLabel("Notice : ");
		notice.setBounds(50,30,100,20);
		panel.add(notice);
		
		String [][]row1=new String[50][50];
		String []col1 = {"Date", "Mayor Notice"};	
		int counter1=0;
		
        String query1 = "SELECT * FROM `adminnoticetable` order by `sl` DESC;";     
        Connection con1=null;//for connection
        Statement st1 = null;//for query execution
		ResultSet rs1 = null;//to get row by row result from DB
		System.out.println(query1);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");//connection with database established
			st1 = con1.createStatement();//create statement
			System.out.println("statement created");
			rs1 = st1.executeQuery(query1);//getting result
			System.out.println("results received");
					
			while(rs1.next())
			{
                String adminN= rs1.getString("adminNotice");
                String dateN= rs1.getString("date");		
					
				row1[counter1][0]=dateN;
				row1[counter1][1]=adminN;
				counter1++;
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
                if(rs1!=null)
					rs1.close();

                if(st1!=null)
					st1.close();

                if(con1!=null)
					con1.close();
            }
            catch(Exception ex){}
        }
				
		myTablel1 = new JTable(row1,col1);
		tableScrollPane1 = new JScrollPane(myTablel1);
		tableScrollPane1.setBounds(50,70,400,102);
		panel.add(tableScrollPane1);
		
		String [][]row2=new String[50][50];
		String []col2 = {"Date", "Desco Notice"};	
		int counter2=0;
		
        String query2 = "SELECT * FROM `desconoticetable` ORDER BY `sl` DESC;";     
        Connection con2=null;//for connection
        Statement st2 = null;//for query execution
		ResultSet rs2 = null;//to get row by row result from DB
		System.out.println(query2);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");//connection with database established
			st2 = con2.createStatement();//create statement
			System.out.println("statement created");
			rs2 = st2.executeQuery(query2);//getting result
			System.out.println("results received");
					
			while(rs2.next())
			{
                String descoN= rs2.getString("descoNotice");
                String date2N= rs2.getString("date");		
					
				row2[counter2][0]=date2N;
				row2[counter2][1]=descoN;
				counter2++;
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
                if(rs2!=null)
					rs2.close();

                if(st2!=null)
					st2.close();

                if(con2!=null)
					con2.close();
            }
            catch(Exception ex){}
        }
				
		myTablel2 = new JTable(row2,col2);
		tableScrollPane2 = new JScrollPane(myTablel2);
		tableScrollPane2.setBounds(50,180,400,102);
		panel.add(tableScrollPane2);
		
		String [][]row3=new String[50][50];
		String []col3 = {"Date", "Wasa Notice"};	
		int counter3=0;
		
        String query3 = "SELECT * FROM `wasanoticetable` ORDER BY `sl` DESC;";     
        Connection con3=null;//for connection
        Statement st3 = null;//for query execution
		ResultSet rs3 = null;//to get row by row result from DB
		System.out.println(query3);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");//connection with database established
			st3 = con3.createStatement();//create statement
			System.out.println("statement created");
			rs3 = st3.executeQuery(query3);//getting result
			System.out.println("results received");
					
			while(rs3.next())
			{
                String wasaN= rs3.getString("wasaNotice");
                String date3N= rs3.getString("date");		
					
				row3[counter3][0]=date3N;
				row3[counter3][1]=wasaN;
				counter3++;
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
                if(rs3!=null)
					rs3.close();

                if(st3!=null)
					st3.close();

                if(con3!=null)
					con3.close();
            }
            catch(Exception ex){}
        }
				
		myTablel3 = new JTable(row3,col3);
		tableScrollPane3 = new JScrollPane(myTablel3);
		tableScrollPane3.setBounds(50,290,400,102);
		panel.add(tableScrollPane3);
		
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
		if(elementText.equals(logIn.getText()))
		{
			System.out.println("hello");
			flag=true;
			check();
		}
		else if(elementText.equals(exit.getText()))
		{
			System.exit(0);
		}
		else if(elementText.equals(search.getText()))
		{
			//flag2=true;
			String ss=searchTf.getText();
			SearchHomeOwnerPage s=new SearchHomeOwnerPage(ss);
			s.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	
	public void check()
	{
        String query = "SELECT `userId`, `accountType`,`accountHolderName`,`address`,`password`,`gasLineType`,`gasBill`,`electricityLineType`,`electricityBill`,`wasaLineType`,`wasaBill` FROM `projectjava`;";     
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
                String userId = rs.getString("userID");
                String password = rs.getString("password");
				String accountType=rs.getString("accountType");
				String ahn=rs.getString("accountHolderName");
				String address=rs.getString("address");
				String glt=rs.getString("gasLineType");
				String elt=rs.getString("electricityLineType");
				String wlt=rs.getString("wasaLineType");
				int gb=rs.getInt("gasBill");
				int wb=rs.getInt("wasaBill");
				int eb=rs.getInt("electricityBill");
				System.out.println(userId+" "+password+" "+accountType+" "+ahn);
				if(userId.equals(logInTf.getText().toString()) && password.equals(pf.getText().toString()) && accountType.equals(combo.getSelectedItem().toString()))
				{
					System.out.println(logInTf.getText().toString()+" "+pf.getText().toString()+" "+combo.getSelectedItem().toString());
					if(combo.getSelectedItem().toString().equals("admin"))
					{
						flag=false;
						AdminPage a = new AdminPage(userId,ahn);
						this.setVisible(false);
						a.setVisible(true);
					} 
					else if(combo.getSelectedItem().toString().equals("desco"))
					{
						flag=false;
						DescoPage d = new DescoPage(userId,ahn);
						this.setVisible(false);
						d.setVisible(true);
					}
					else if(combo.getSelectedItem().toString().equals("wasa"))
					{
						flag=false;
						WasaPage w = new WasaPage(userId,ahn);
						this.setVisible(false);
						w.setVisible(true);
					}
					else if(combo.getSelectedItem().toString().equals("homeOwner"))
					{
						flag=false;
						HomeOwnerPage h = new HomeOwnerPage(userId,password,accountType,ahn,address,glt,elt,wlt,gb,eb,wb);
						this.setVisible(false);
						h.setVisible(true);
					}
					else{}
					break;
				}
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid name,password or account type"); } 
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
