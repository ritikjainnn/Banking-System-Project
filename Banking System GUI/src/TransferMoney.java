import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TransferMoney extends JFrame
{
	JLabel bg_img,back,title,lb_bank,lb_acc,i_bank,i_acc,lb_bname,lb_bacc,lb_button,lb_enter,lb_amnt;
	@SuppressWarnings("rawtypes")
	JComboBox box;
	JTextField amnt,acc;
	
	ImageIcon i = new ImageIcon("Images\\Background3.jpg");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
	ImageIcon white = new ImageIcon("Images\\Text Field.png");
	ImageIcon but1 = new ImageIcon("Images\\money3.png");
	ImageIcon but2 = new ImageIcon("Images\\money4.png");
	
	Font f1 = new Font("Imprint MT Shadow", Font.PLAIN, 32);
	Font f2 = new Font("Imprint MT Shadow", Font.PLAIN, 48);
	Font f3 = new Font("", Font.PLAIN, 16);
	
	float amount,rc_balance = 0,sd_balance = 0;
	String bname,accno;
	int flag = 0,rc_sts = 0,sd_sts = 0;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
            	acc.setFocusable(false);
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
		title =  new JLabel("<html><u>TRANSFER MONEY</u></html>");
		title.setBounds(1215, 90, 500, 40);
		title.setForeground(Color.WHITE);
		bg_img.add(title);
		title.setFont(f2);
		
		title =  new JLabel("<html><u>TRANSFER FROM</u></html>");
		title.setBounds(1300, 180, 500, 40);
		title.setForeground(Color.WHITE);
		bg_img.add(title);
		title.setFont(f1);
		
//		Sender's Bank Name 
		lb_bank =  new JLabel("Bank Name");
		lb_bank.setBounds(1150, 270, 200,40);
		lb_bank.setForeground(Color.WHITE);
		bg_img.add(lb_bank);
		lb_bank.setFont(f1);
		
		i_bank =  new JLabel();
		i_bank.setBounds(1400, 270, 350, 50);
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
		
//		Sender's Account Number
		lb_acc =  new JLabel("Account No.");  
		lb_acc.setBounds(1150, 375, 200,40);
		lb_acc.setForeground(Color.WHITE);
		bg_img.add(lb_acc);
		lb_acc.setFont(f1);

		i_acc =  new JLabel();
		i_acc.setBounds(1400, 370, 350, 50);
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
		
		
		
		title =  new JLabel("<html><u>TRANSFER TO</u></html>");
		title.setBounds(1320, 470, 500, 40);
		title.setForeground(Color.WHITE);
		bg_img.add(title);
		title.setFont(f1);
		
//		Reciever's Bank Name
		lb_bank =  new JLabel("Bank Name");
		lb_bank.setBounds(1150, 560, 200,40);
		lb_bank.setForeground(Color.WHITE);
		bg_img.add(lb_bank);
		lb_bank.setFont(f1);
		
		JLabel warn = new JLabel();
		warn.setBounds(1420,540,300,15);
		warn.setFont(f3);
		warn.setForeground(Color.RED);
		bg_img.add(warn);
		
		String[] bnames = {" ----Select Bank----","SBI","PNB","BOI","HDFC"};
		box = new JComboBox(bnames);
		box .setBounds(1400,560,350,50);
		bg_img.add(box);
		box.setFont(f1);
	
		
//		Reciever's Account Number
		lb_acc =  new JLabel("Account No.");
		lb_acc.setBounds(1150, 665, 200,40);
		lb_acc.setForeground(Color.WHITE);
		bg_img.add(lb_acc);
		lb_acc.setFont(f1);

		JLabel warn1 = new JLabel();
		warn1.setBounds(1420,640,300,15);
		warn1.setFont(f3);
		warn1.setForeground(Color.RED);
		bg_img.add(warn1);
		
		i_acc =  new JLabel();
		i_acc.setBounds(1400, 660, 350, 50);
		//Image white1 = white.getImage().getScaledInstance(i_bank.getWidth(), i_bank.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon tf_icon = new ImageIcon(white1);
		i_acc.setIcon(tf_icon);
		bg_img.add(i_acc);
		
		acc=  new JTextField();
		acc.setBounds(18,3,314,43);
		acc.setForeground(Color.black);
		acc.setBorder(null);
		acc.setFont(f1);
		i_acc.add(acc);
		acc.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				acc.setFocusable(true);
			}
		});
		
//		Enter Amount	
		lb_enter =  new JLabel("Amount");
		lb_enter.setBounds(1150, 770, 250, 40);
		lb_enter.setForeground(Color.WHITE);
		bg_img.add(lb_enter);
		lb_enter.setFont(f1);
		
		JLabel warn2 = new JLabel();
		warn2.setBounds(1420,750,300,15);
		warn2.setFont(f3);
		warn2.setForeground(Color.RED);
		bg_img.add(warn2);
		
		lb_amnt = new JLabel();
		lb_amnt.setBounds(1400, 770, 350, 50);
		//Image i_white = white.getImage().getScaledInstance(lb_amnt.getWidth(), lb_amnt.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon ii_white = new ImageIcon(i_white);
		lb_amnt.setIcon(tf_icon);
		bg_img.add(lb_amnt);
		
		amnt =  new JTextField("");
		amnt.setBounds(18,3,314,43);
		amnt.setBorder(null);
		amnt.setForeground(Color.black);
		amnt.setFont(f1);
		lb_amnt.add(amnt);
		amnt.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
			{
				try 
				{
					amount = Float.parseFloat(amnt.getText());
					warn2.setText("");
				}
				catch (NumberFormatException e) 
				{
					warn2.setText("Amount must be a Number");
				}
			}
		});
		amnt.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				amnt.setFocusable(true);
			}
		});
		
//		Button
		lb_button = new JLabel();
		lb_button.setBounds(1280,880,320,80);
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
				warn2.setText("");
				
				if(box.getSelectedItem().toString().trim().contains("Select"))
					warn.setText("Please select a bank");
				else if(acc.getText().isEmpty())
					warn1.setText("Account cannot be empty");
				else if(amnt.getText().isEmpty())
					warn2.setText("Amount cannot be empty");
				else 
				{
					try
					{
						amount = Float.parseFloat(amnt.getText());
						bname = box.getSelectedItem().toString().trim();
						accno = acc.getText();
						if(amount < 0)
						{
							amount = -amount;
							//tf2.setText();
						}
						try {
							transfer();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}							
					}
					catch(Exception e)
					{
						warn2.setText("Amount must be a Number");
					}						
				}
			}			
		});
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void transfer() throws Exception
	{
		
		Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank","root","root");
		Statement stt1 = co.createStatement();
		Statement stt2 = co.createStatement();
		ResultSet sd = stt1.executeQuery("select amnt,status from "+(Login.bname)+" where accno = '"+(Login.accno)+"'");
		ResultSet rc = stt2.executeQuery("select amnt,status from "+bname+" where accno = '"+accno+"'");
		
		if(sd.next())
		{	
			sd_balance = Float.parseFloat(sd.getString("amnt"));
			sd_sts = Integer.parseInt(sd.getString("status"));
		}
		
		if(rc.next())
		{	
			rc_balance = Float.parseFloat(rc.getString("amnt"));
			rc_sts = Integer.parseInt(rc.getString("status"));
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Reciever Not Found");
			return;
		}
		
		co.close();
		if(rc_sts == 1 && sd_sts == 1)
		{
			if(sd_balance>=amount)
			{
				sd_balance = sd_balance-amount;
				rc_balance = rc_balance+amount;
				Class.forName("com.mysql.jdbc.Driver");
				Connection co1 = DriverManager.getConnection
						("jdbc:mysql://127.0.0.1:3306/bank","root","root");
				Statement st1 = co1.createStatement();
				Statement st2 = co1.createStatement();
				st1.executeUpdate("update "+Login.bname+" set amnt = '"+sd_balance+"' where accno = '"+Login.accno+"'");
				st2.executeUpdate("update "+bname+" set amnt = '"+rc_balance+"' where accno = '"+accno+"'");
				co1.close();
				JOptionPane.showMessageDialog(this, "Amount has been Transfered.\nWe are redirecting to Menu Menu.");
				MainMenu m = new MainMenu();
				m.frame();
				super.dispose();
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "Unsufficient balance");
				return;
			}		
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Your account has been Freezed.\nWe are redirecting to Home Page.");
			HomePage h = new HomePage();
			h.frame();
			super.dispose();
		}
	}
	
	public static void main(String[] args)
	{
		TransferMoney t = new TransferMoney();
    	t.frame();
	}
}
