import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteAccountPage extends JFrame implements MouseListener, ActionListener
{
	private JLabel id,userName;
	private JTextField userIdF;
	private JButton back,logOut,deleteButton;
	private JPanel panel;
	
	public String u,name;
	public int flag;
	
	public DeleteAccountPage(String userId,String uname)
	{
		super("Delete Account Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		u=userId;
		name=uname;
		
		id=new JLabel("User ID : ");
		id.setBounds(500,200,100,20);
		panel.add(id);
		
		userIdF=new JTextField();
		userIdF.setBounds(650,200,150,20);
		panel.add(userIdF);
		
		deleteButton=new JButton("Delete Account");
		deleteButton.setBounds(660,300,140,50);
		deleteButton.setOpaque(true);
		deleteButton.setFont(new Font("Cambria",Font.BOLD,15));
		deleteButton.setBackground(Color.RED.darker());
		deleteButton.setForeground(Color.white);
		deleteButton.addMouseListener(this);
		deleteButton.addActionListener(this);
		panel.add(deleteButton);
		
		back=new JButton("Back");
		back.setBounds(500,300,70,50);
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
			AdminPage a=new AdminPage(u,name);
			a.setVisible(true);
			this.setVisible(false);
		}
		else if(elementText.equals(deleteButton.getText()))
		{
			flag=1;
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
                String userId = rs.getString("userId");
				System.out.println(userId);
				if(userId.equals(userIdF.getText().toString()))
				{
					flag=2;
					if(!userId.equals(u))
					{
						flag=3;
						DeleteAccountConfirmationPage d =new DeleteAccountConfirmationPage(u,name,userId);
						d.setVisible(true);
						this.setVisible(false);
						System.out.println(userId);
					}
				}
			}
			if(flag==1){JOptionPane.showMessageDialog(this,"User id does not exist in the Database"); }
			else if(flag==2){JOptionPane.showMessageDialog(this,"You can't delete your own account");}
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