import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewAccount extends JFrame
{
	JLabel bg_img,back,title,lb_amnt,lnote,lb_button;
	JTextField amnt;
	@SuppressWarnings("rawtypes")
	JComboBox box;
	ImageIcon i = new ImageIcon("Images\\Background3.jpg");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
	ImageIcon white = new ImageIcon("Images\\Text Field.png");
	ImageIcon but1 = new ImageIcon("Images\\new3.png");
	ImageIcon but2 = new ImageIcon("Images\\new4.png");
	
	Font f1 = new Font("Imprint MT Shadow", Font.PLAIN, 25);
	Font f2 = new Font("Imprint MT Shadow", Font.PLAIN, 44);
	Font f3 = new Font("", Font.PLAIN, 14);
	Font f4 = new Font("Imprint MT Shadow", Font.PLAIN, 18);
	@SuppressWarnings("unused")
	private float amount;
	String bname;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void frame()
	
	{
		super.setBounds(0, 0, 1925, 1080);
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
            	amnt.setFocusable(false);
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
		title =  new JLabel("<html><u>NEW ACCOUNT</u></html>");
		title.setBounds(1340, 180, 400, 40);
		title.setForeground(Color.WHITE);
		bg_img.add(title);
		title.setFont(f2);

//		Selection Of Banks
		
		JLabel warn1 = new JLabel();
		warn1.setBounds(1325,302,300,15);
		warn1.setFont(f3);
		warn1.setForeground(Color.red);
		bg_img.add(warn1);
		
		String[] bnames = {" ----Select Bank----","SBI","PNB","BOI","HDFC"};
		box = new JComboBox(bnames);
		box .setBounds(1320,320,400,45);
		bg_img.add(box);
		box.setFont(f2);
		
//		Enter Amount
		JLabel warn = new JLabel();
		warn.setBounds(1335,412,300,15);
		warn.setFont(f3);
		warn.setForeground(Color.red);
		bg_img.add(warn);
		
		lb_amnt = new JLabel();
		lb_amnt.setBounds(1320, 430, 400, 47);
		Image i_white = white.getImage().getScaledInstance(lb_amnt.getWidth(), lb_amnt.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_white = new ImageIcon(i_white);
		lb_amnt.setIcon(ii_white);
		bg_img.add(lb_amnt);
		
		amnt =  new JTextField("Enter Amount");
		amnt.setBounds(18,3,364,41);
		amnt.setBorder(null);
		amnt.setForeground(Color.gray);
		amnt.setFont(f1);
		lb_amnt.add(amnt);
		amnt.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            		amnt.setFocusable(true);
            		if(amnt.getText().contains("Enter Amount"))
            			amnt.setText("");
                	amnt.setForeground(Color.BLACK);
            }
        });
		amnt.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
			{
				try 
				{
					amount = Float.parseFloat(amnt.getText());
					warn.setText("");
				}
				catch (NumberFormatException e) 
				{
					warn.setText("Amount must be a Number *");
					warn.setForeground(Color.RED);
				}
			}
		});
		
//		Button For Create Account
		lb_button = new JLabel();
		lb_button.setBounds(1370, 560, 300, 70);
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
				warn.setText("");
				warn1.setText("");
				
				if(box.getSelectedItem().toString().trim().contains("Select"))
            	{
            		warn1.setText("Please select a Bank");
                }
				else if(amnt.getText().isEmpty())
            	{
            		warn.setText("Amount cannot be empty");
                }		
				else 
				{
					try
					{
						amount = Float.parseFloat(amnt.getText());
						bname = box.getSelectedItem().toString().trim();
						
							try {
								checkMinimum();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
					}
					catch(Exception e)
					{
						warn.setText("Amount must be a Number");
					}						
				}
					
			}
			
		});
		
		lnote = new JLabel();
		lnote.setBounds(1320,670,350,150);
		bg_img.add(lnote);
		lnote.setFont(f1);
		lnote.setForeground(Color.WHITE);
		lnote.setText("Note :-");
		
		lnote = new JLabel();
		lnote.setBounds(1320,690,350,150);
		bg_img.add(lnote);
		lnote.setFont(f4);
		lnote.setForeground(Color.WHITE);
		lnote.setText("i) In SBI, minimum balance must be 1000.");
		
		
		lnote = new JLabel();
		lnote.setBounds(1320,710,350,150);
		bg_img.add(lnote);
		lnote.setFont(f4);
		lnote.setForeground(Color.WHITE);
		lnote.setText("ii) In PNB, minimum balance must be 2500.");
		lnote = new JLabel();
		lnote.setBounds(1320,730,350,150);
		bg_img.add(lnote);
		lnote.setFont(f4);
		lnote.setForeground(Color.WHITE);
		lnote.setText("iii) In BOI, minimum balance must be 5000.");
		lnote = new JLabel();
		lnote.setBounds(1320,750,360,150);
		bg_img.add(lnote);
		lnote.setFont(f4);
		lnote.setForeground(Color.WHITE);
		lnote.setText("iv) In HDFC, minimum balance must be 500.");
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void createAccount() throws Exception
	{
		Random r = new Random();
		int start4 = r.nextInt(10000);
		int last4 = r.nextInt(10000);
		String new_accno = bname+"_"+start4+last4;
		Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/bank","root","root");
		Statement st = co.createStatement();
		st.executeUpdate
		("insert into "+(bname)+" values" 
		+ "('"+new_accno+"','"+amount+"','1')");
		st.executeUpdate("update userinfo set bname = '"+bname+"' , accno = '"+new_accno+"' where email = '"+Login.email+"'");
		co.close();
		Login.bname = bname;
		Login.accno = new_accno;
		JOptionPane.showMessageDialog(this, "Account Created Successfully\nYour Account no. is "+new_accno+".\nPlease note down for further use.\n     Thank You");
		MainMenu m = new MainMenu();
		m.frame();
		super.dispose();
	}
	
	void checkMinimum() throws Exception
	{
		if(bname.equalsIgnoreCase("SBI"))
		{
			if(amount<1000)
				JOptionPane.showMessageDialog(this, "In SBI, Minimum Balance must be 1000.");
			else 
				createAccount();
		}
		else if(bname.equalsIgnoreCase("PNB"))
		{
			if(amount<2500)
				JOptionPane.showMessageDialog(this, "In PNB, Minimum Balance must be 2500.");
			else 
				createAccount();
		}
		else if(bname.equalsIgnoreCase("BOI"))
		{
			if(amount<5000)
				JOptionPane.showMessageDialog(this, "In BOI, Minimum Balance must be 5000.");
			else 
				createAccount();
		}
		else if(bname.equalsIgnoreCase("HDFC"))
		{
			if(amount<500)
				JOptionPane.showMessageDialog(this, "In HDFC, Minimum Balance must be 500.");
			else 
				createAccount();
		}
		
	}
	
	public static void main(String[] args)
	{
		NewAccount n = new NewAccount();
		n.frame();
	}
}
