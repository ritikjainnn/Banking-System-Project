import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class CheckBalance extends JFrame
{
	JLabel bg_img,back,title,lb_bank,lb_acc,i_bank,i_acc,lb_bname,lb_bacc,lb_button;
	
	ImageIcon i = new ImageIcon("Images\\Background3.jpg");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
	ImageIcon white = new ImageIcon("Images\\Text Field.png");
	ImageIcon but1 = new ImageIcon("Images\\check3.png");
	ImageIcon but2 = new ImageIcon("Images\\check4.png");
	
	Font f1 = new Font("Imprint MT Shadow", Font.PLAIN, 32);
	Font f2 = new Font("Imprint MT Shadow", Font.PLAIN, 48);
	//Font f3 = new Font("", Font.PLAIN, 14);
	
	String bname;
	
	void frame()
	{
		super.setBounds(0, 0, 1920,1080);
		super.setTitle("BANKING SYSTEM");
		super.setResizable(false);
		
		bg_img = new JLabel();
		bg_img.setBounds(0,0,1925,1080);
		Image img = i.getImage().getScaledInstance(bg_img.getWidth(), bg_img.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i1 = new ImageIcon(img);
		bg_img.setIcon(i1);
		super.add(bg_img);
		bg_img.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	
            }
        });
		
//		Back Button
		back = new JLabel();
		back.setBounds(0,0,60,60);
		Image back_img = b.getImage().getScaledInstance(back.getWidth(), back.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_back_but = new ImageIcon(back_img);
		back.setIcon(ii_back_but);
		bg_img.add(back);
		back.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            		  MainMenu m = new MainMenu();
            		  m.frame();
            }
        });
		
//		New Account Heading
		title =  new JLabel("<html><u>CHECK BALANCE</u></html>");
		title.setBounds(1250, 240, 500, 40);
		title.setForeground(Color.WHITE);
		bg_img.add(title);
		title.setFont(f2);

//		Bank Name
		lb_bank =  new JLabel("Bank Name");
		lb_bank.setBounds(1150, 420, 200,40);
		lb_bank.setForeground(Color.WHITE);
		bg_img.add(lb_bank);
		lb_bank.setFont(f1);
		
		i_bank =  new JLabel();
		i_bank.setBounds(1420, 415, 350, 50);
		Image white1 = white.getImage().getScaledInstance(i_bank.getWidth(), i_bank.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon tf_icon = new ImageIcon(white1);
		i_bank.setIcon(tf_icon);
		i_bank.setForeground(Color.black);
		bg_img.add(i_bank);
		
		lb_bname=  new JLabel();
		lb_bname.setBounds(20, 0, 350, 50);
		lb_bname.setForeground(Color.black);
		i_bank.add(lb_bname);
		lb_bname.setText(Login.bname);
		lb_bname.setFont(f1);
		
//		Account Number
		lb_acc =  new JLabel("Account No.");
		lb_acc.setBounds(1150, 565, 200,40);
		lb_acc.setForeground(Color.WHITE);
		bg_img.add(lb_acc);
		lb_acc.setFont(f1);

		i_acc =  new JLabel();
		i_acc.setBounds(1420, 560, 350, 50);
		//Image white1 = white.getImage().getScaledInstance(i_bank.getWidth(), i_bank.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon tf_icon = new ImageIcon(white1);
		i_acc.setIcon(tf_icon);
		bg_img.add(i_acc);
		
		lb_bacc=  new JLabel();
		lb_bacc.setBounds(20, 0, 350, 50);
		lb_bacc.setForeground(Color.black);
		i_acc.add(lb_bacc);
		lb_bacc.setText(Login.accno);
		lb_bacc.setFont(f1);
		
//		Button
		lb_button = new JLabel();
		lb_button.setBounds(1300,740,330,75);
		Image i_but1 = but1.getImage().getScaledInstance(lb_button.getWidth(), lb_button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_but1 = new ImageIcon(i_but1);
		Image i_but2 = but2.getImage().getScaledInstance(lb_button.getWidth(), lb_button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_but2 = new ImageIcon(i_but2);
		lb_button.setIcon(ii_but1);
		bg_img.add(lb_button);
		lb_button.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				lb_button.setIcon(ii_but2);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt)
			{
				lb_button.setIcon(ii_but1);
			}
			
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				try {
					applyCheckBalance();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void applyCheckBalance() throws Exception
	{
		int sts = 0;
		float balance = 0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/bank","root","root");
		Statement st = co.createStatement();
		ResultSet rs = st.executeQuery("select amnt,status from "+(Login.bname)+" where accno = '"+(Login.accno)+"'");
		if(rs.next())
		{
			balance = Float.parseFloat(rs.getString("amnt"));
			sts = Integer.parseInt(rs.getString("status"));
		}
		co.close();
		if(sts == 1)
			JOptionPane.showMessageDialog(this,"Your Balance is "+balance+" ");
		else
			JOptionPane.showMessageDialog(this,"Your Account has been Freezed.");
		MainMenu m = new MainMenu();
		m.frame();
		super.dispose();
	}
	 
	
	public static void main(String[] args)
	{
    	CheckBalance c = new CheckBalance();
    	c.frame();
	}
}
