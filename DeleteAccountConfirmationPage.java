import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteAccountConfirmationPage extends JFrame implements MouseListener, ActionListener
{
	
	private JLabel id,accountHolderName,address,type,userName,label;
	private JButton yes,no;
	private JPanel panel;

	public String deleteId;
	public String uid,name;
	public boolean flag=true;
	public String s1="",s2="",s3="",s4="";
	
	public DeleteAccountConfirmationPage(String u,String uname,String idno)
	{	
		super("Delete Account Confirmation Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
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
				String idNumber=rs.getString("userId");
				if(idNumber.equals(idno))
				{
					s1 = rs.getString("userId");
					s4 = rs.getString("accountType");
					s2= rs.getString("accountHolderName");
					s3=rs.getString("address");
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
		
		id=new JLabel("User ID : "+s1);
		id.setBounds(100,100,200,50);
		panel.add(id);
		
		accountHolderName=new JLabel("User Name : "+s2);
		accountHolderName.setBounds(100,150,200,50);
		panel.add(accountHolderName);
		
		address=new JLabel("Address : "+s3);
		address.setBounds(100,200,200,50);
		panel.add(address);
		
		type=new JLabel("Type : "+s4);
		type.setBounds(100,250,200,50);
		panel.add(type);		
		
		label=new JLabel("Are you sure you want to delete this account ?");
		label.setBounds(440,400,400,60);
		label.setOpaque(true);
		label.setFont(new Font("Cambria",Font.BOLD,19));
		label.setBackground(Color.white);
		label.setForeground(Color.RED.darker());
		panel.add(label);
		
		yes=new JButton("Yes");
		yes.setBounds(440,470,80,40);
		yes.setOpaque(true);
		yes.setFont(new Font("Cambria",Font.BOLD,15));
		yes.setBackground(Color.BLUE.darker());
		yes.setForeground(Color.WHITE);
		yes.addMouseListener(this);
		yes.addActionListener(this);
		panel.add(yes);
		
		no=new JButton("No");
		no.setBounds(760,470,80,40);
		no.setOpaque(true);
		no.setFont(new Font("Cambria",Font.BOLD,15));
		no.setBackground(Color.BLUE.darker());
		no.setForeground(Color.WHITE);
		no.addMouseListener(this);
		no.addActionListener(this);
		panel.add(no);
		
		uid=u;
		name=uname;
		deleteId=idno;
		
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
		if(elementText.equals(yes.getText()))
		{
			deleteFromDB();
		}
		else if(elementText.equals(no.getText()))
		{
			DeleteAccountPage d=new DeleteAccountPage(uid,name);
			d.setVisible(true);
			this.setVisible(false);
		}
	}
	public void deleteFromDB()
	{
		String query = "DELETE from `projectjava` where `projectjava`.`userId`=\'"+deleteId+"\';";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);

			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"User Account is deleted successfully");
			DeleteAccountPage dap=new DeleteAccountPage(uid,name);
			dap.setVisible(true);
			this.setVisible(false);
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}