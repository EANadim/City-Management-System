import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CreateAccountPage extends JFrame implements MouseListener, ActionListener
{
	private JLabel userId,password,accountHolderName,address,userName;
	private JButton submit,back;
	private JTextField userIdF,passwordF,accountHolderNameF,addressF;
	private JPanel panel;
	private JComboBox combo;
	
	public String id,name;
	
	public CreateAccountPage(String u,String uname)
	{
		super("Create New Account Page");
		this.setSize(1200,675);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		userId=new JLabel("User ID :");
		userId.setBounds(100,100,100,20);
		panel.add(userId);
		
		userIdF=new JTextField();
		userIdF.setBounds(200,100,200,20);
		panel.add(userIdF);	
		
		password=new JLabel("Password :");
		password.setBounds(100,140,100,20);
		panel.add(password);		
		
		passwordF=new JTextField();
		passwordF.setBounds(200,140,200,20);
		panel.add(passwordF);
		
		accountHolderName=new JLabel("Account Holder :");
		accountHolderName.setBounds(100,180,100,20);
		panel.add(accountHolderName);	
		
		accountHolderNameF=new JTextField();
		accountHolderNameF.setBounds(200,180,200,20);
		panel.add(accountHolderNameF);
		
		address=new JLabel("Address :");
		address.setBounds(100,220,100,20);
		panel.add(address);
		
		addressF=new JTextField();
		addressF.setBounds(200,220,200,20);
		panel.add(addressF);
		
		submit=new JButton("Submit");
		submit.setBounds(100,280,120,40);
		submit.setOpaque(true);
		submit.setBackground(Color.BLUE.darker());
		submit.setForeground(Color.white);
		submit.addMouseListener(this);
		submit.addActionListener(this);
		panel.add(submit);
		
		back=new JButton("Back");
		back.setBounds(280,280,120,40);
		back.setOpaque(true);
		back.setBackground(Color.RED.darker());
		back.setForeground(Color.white);
		back.addMouseListener(this);
		back.addActionListener(this);
		panel.add(back);
		
		String []s={"homeOwner","desco","titas","wasa"};
		combo=new JComboBox(s);
		combo.setBounds(500,100,100,20);
		combo.addActionListener(this);
		panel.add(combo);
		
		id=u;
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
		String elementText= ae.getActionCommand();
		
		if(elementText.equals(submit.getText()))
		{
			insertIntoDB();
		}
		else if(elementText.equals(back.getText()))
		{
			AdminPage a= new AdminPage(id,name);
			a.setVisible(true);
			this.setVisible(false);
		}
	}
	public void insertIntoDB()
	{
		String query = "INSERT INTO `projectjava` (`userId`, `accountType`, `accountHolderName`, `address`, `password`, `gasLineType`, `gasBill`, `electricityLineType`, `electricityBill`, `wasaLineType`, `wasaBill`, `tiasObjection`, `descoObjection`, `wasaObjection`) VALUES ('"+userIdF.getText()+"', '"+combo.getSelectedItem().toString()+"', '"+accountHolderNameF.getText()+"', '"+addressF.getText()+"', '"+passwordF.getText()+"', '', 0, '', 0, '', 0, '', '', '');";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"New Account Created");
			
			AdminPage a=new AdminPage(id,name);
			a.setVisible(true);
			this.setVisible(false);
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			JOptionPane.showMessageDialog(this,""+ex.getMessage()+"");
        }
    }
}