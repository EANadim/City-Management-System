import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchHomeOwnerPage extends JFrame implements MouseListener, ActionListener
{
	private JTable myTable;
	private JScrollPane tableScrollPane;
	private JButton backButton;
	private JPanel panel;

	
	public SearchHomeOwnerPage(String ss)
	{	
		super("Search Home Owner Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		int counter=0;
		String [][]row=new String[100][6];
		String []col={"User ID","Home Owner Name","Address","Electricity Line Type","Gas Line Type","Wasa Line Type"};

        
		String query = "SELECT * FROM `projectjava` WHERE `projectjava`.`address` like '%"+ss+"%';";     
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
				String add=rs.getString("address");
				String type=rs.getString("accountType");
				String userId=rs.getString("userId");
				String ahn=rs.getString("accountHolderName");
				String elt=rs.getString("electricityLineType");
				String glt=rs.getString("gasLineType");
				String wlt=rs.getString("wasaLineType");
				if(type.equals("homeOwner"))
				{
					row[counter][0]=userId;
					row[counter][1]=ahn;
					row[counter][2]=add;
					row[counter][3]=elt;
					row[counter][4]=glt;
					row[counter][5]=wlt;
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
		tableScrollPane.setBounds(150,200,900,300);
		panel.add(tableScrollPane);

		backButton=new JButton("Back");
		backButton.setBounds(1000,50,80,40);
		backButton.setOpaque(true);
		backButton.setBackground(Color.YELLOW.darker());
		backButton.setForeground(Color.white);
		backButton.addMouseListener(this);
		backButton.addActionListener(this);
		panel.add(backButton);
		
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
		if(elementText.equals(backButton.getText()))
		{
			LogInPage l=new LogInPage();
			l.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
}