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
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class ChangePassword extends JFrame
{
	JLabel bg_img,back,title,lb_old,lb_new,lb_oe,lb_ne,i_old,i_new,lb_button,warn;
	JPasswordField tp_old,tp_new,tp_re;
	ImageIcon i = new ImageIcon("Images\\setting1.jpg");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
	ImageIcon white = new ImageIcon("Images\\Text Field.png");
	ImageIcon but1 = new ImageIcon("Images\\cpass1.png");
	ImageIcon but2 = new ImageIcon("Images\\cpass2.png");
	
	Font f1 = new Font("Imprint MT Shadow", Font.PLAIN, 26);
	Font f2 = new Font("Imprint MT Shadow", Font.PLAIN, 48);
	Font f3 = new Font("", Font.PLAIN, 14);
	
	String bname,newpass,oldpass,repass;
	
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
            	tp_old.setFocusable(false);
            	tp_new.setFocusable(false);
            	tp_re.setFocusable(false);
            	
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
            	OtherServices os = new OtherServices();
            	os.frame();
            }
        });
		
//		Change Password Heading
		title =  new JLabel("<html><u>CHANGE PASSWORD</u></html>");
		title.setBounds(220, 220, 530, 40);
		title.setForeground(Color.WHITE);
		bg_img.add(title);
		title.setFont(f2);

//      Old Password
		lb_old =  new JLabel("OLD PASSWORD");
		lb_old.setBounds(150, 350, 300,40);
		lb_old.setForeground(Color.WHITE);
		bg_img.add(lb_old);
		lb_old.setFont(f1);
		
		warn = new JLabel();
		warn.setBounds(505,325,300,15);
		warn.setFont(f3);
		warn.setForeground(Color.RED);
		bg_img.add(warn);
		
		
		i_old =  new JLabel();
		i_old.setBounds(490, 345, 350, 50);
		Image white1 = white.getImage().getScaledInstance(i_old.getWidth(), i_old.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon tf_icon = new ImageIcon(white1);
		i_old.setIcon(tf_icon);
		i_old.setForeground(Color.black);
		bg_img.add(i_old);
		
		tp_old = new JPasswordField();
		tp_old.setBounds(25, 5, 305, 40);
		i_old.add(tp_old);
		tp_old.setBorder(null);
		tp_old.setFont(f1);
		tp_old.setFocusable(false);
		tp_old.addMouseListener(new java.awt.event.MouseAdapter()
		{
           
			public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            		tp_old.setFocusable(true);
            		tp_old.setText("");
            		tp_old.setEchoChar('*');
                	tp_old.setForeground(Color.BLACK);
            }
        });
		tp_old.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				
			}
		});
		tp_old.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
//            		warn2.setText("");
            }
		});
		
		//New Password
		lb_new =  new JLabel("NEW PASSWORD");
		lb_new.setBounds(150, 500, 300,50);
		lb_new.setForeground(Color.WHITE);
		bg_img.add(lb_new);
		lb_new.setFont(f1);
		
		JLabel warn1 = new JLabel();
		warn1.setBounds(505,480,300,15);
		warn1.setFont(f3);
		warn1.setForeground(Color.RED);
		bg_img.add(warn1);
		
	
		i_new =  new JLabel();
		i_new.setBounds(490, 500, 350, 50);
		//Image white1 = white.getImage().getScaledInstance(i_bank.getWidth(), i_bank.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon tf_icon = new ImageIcon(white1);
		i_new.setIcon(tf_icon);
		i_new.setForeground(Color.black);
		bg_img.add(i_new);

		tp_new = new JPasswordField();
		tp_new.setBounds(25, 5, 305, 40);
		i_new.add(tp_new);
		tp_new.setBorder(null);
		tp_new.setFont(f1);
		tp_new.setFocusable(false);
		tp_new.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            		tp_new.setFocusable(true);
            		tp_new.setEchoChar('*');
                	tp_new.setForeground(Color.BLACK);
            }
        });
		tp_new.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				tp_new.setFocusable(false);
			}
		});
		tp_new.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
//            		warn2.setText("");
            }
		});
		
//		Re-Type Password
		lb_new =  new JLabel("RE-TYPE PASSWORD");
		lb_new.setBounds(150, 650, 300,50);
		lb_new.setForeground(Color.WHITE);
		bg_img.add(lb_new);
		lb_new.setFont(f1);
		
		JLabel warn2 = new JLabel();
		warn2.setBounds(505,630,300,15);
		warn2.setFont(f3);
		warn2.setForeground(Color.RED);
		bg_img.add(warn2);
		
		
		i_new =  new JLabel();
		i_new.setBounds(490, 650, 350, 50);
		//Image white1 = white.getImage().getScaledInstance(i_bank.getWidth(), i_bank.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon tf_icon = new ImageIcon(white1);
		i_new.setIcon(tf_icon);
		i_new.setForeground(Color.black);
		bg_img.add(i_new);

		tp_re = new JPasswordField();
		tp_re.setBounds(25, 5, 305, 40);
		i_new.add(tp_re);
		tp_re.setBorder(null);
		tp_re.setFont(f1);
		tp_re.setFocusable(false);
		tp_re.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            		tp_re.setFocusable(true);
            		tp_re.setEchoChar('*');
                	tp_re.setForeground(Color.BLACK);
            }
        });
		tp_re.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				tp_re.setFocusable(false);
			}
		});
		tp_re.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
//            		warn2.setText("");
            }
		});
		
//		Get Password Button
		lb_button = new JLabel();
		lb_button.setBounds(330,800,350,85);
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
			
			 @SuppressWarnings("deprecation")
			public void mouseClicked(java.awt.event.MouseEvent evt)
	         {
				 tp_old.setFocusable(false);
				 tp_new.setFocusable(false);
	             tp_re.setFocusable(false);
	             
	             oldpass = tp_old.getText();
	 			 newpass = tp_new.getText();
	 			 repass = tp_re.getText();
	 			 
	 			 warn.setText("");
	 			 warn1.setText("");
	 			 warn2.setText("");
	 			 
	 			 if(!oldpass.toString().isEmpty())
	 			 {
	 			  	 if(!newpass.isEmpty())
	 				 {
	 					 if(!repass.isEmpty())
	 					 {
	 						 if(newpass.length()>=8 && newpass.length() <= 15)
	 						 {									
	 							 if(newpass.toString().equals(repass.toString()))
	 							 {									
	 								
	 								try {
	 									applyChange();
	 								} catch (Exception e) {
	 									// TODO Auto-generated catch block
	 									e.printStackTrace();
	 								}
	 							 }
	 							 else
	 								warn2.setText("Password does not Match");
	 						 }
	 						 else
	 							warn1.setText("Password contains atleast 8-15 characters");
	 					 }
	 					 else 
	 						warn2.setText("Re-Password cannot be Empty");
	 				 }
	 				 else
	 					warn1.setText("New Password cannot be Empty");
	 			 }
	 			 else
	 				warn.setText("Old Password cannot be Empty");
	             
	             
	         }
			
		});
			
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void applyChange() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection co1 = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/bank","root","root");
		Statement st = co1.createStatement();
		Statement st1 = co1.createStatement();
		ResultSet rs = st.executeQuery("select bname from userinfo where pass = sha1('"+(oldpass)+"')");
		if(rs.next())
		{
			try
			{
				if(!rs.getString("bname").isEmpty())
				{
					st1.executeUpdate("update userinfo set pass = sha1('"+(newpass)+"') where email = '"+(Login.email)+"' and pass = sha1('"+(oldpass)+"')");
					co1.close();
					JOptionPane.showMessageDialog(this, "Password Set Successfully Change.");
					MainMenu m = new MainMenu();
					m.frame();
					super.dispose();
				}
			}
			catch(Exception e)
			{
				MainMenu m = new MainMenu();
				m.frame();
				super.dispose();
			}
		}
		else
			warn.setText("Password is Incorrect");
		
	}
	
	
	public static void main(String[] args) 
	{
		ChangePassword ce = new ChangePassword();
		ce.frame();
	}
	
}		
