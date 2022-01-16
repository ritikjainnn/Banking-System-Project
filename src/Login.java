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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame
{
	JLabel bg_img,lb_button,forget,signup,lb_logo,back,tf,pas;
	JTextField tfemail;
	JPasswordField tfpass;
	
	static String bname = null,accno = null,name = null,email = null;
	
	Font f1 = new Font("Tw Cen MT", Font.PLAIN, 25);
	Font f2 = new Font("", Font.PLAIN, 14);
	//Font f3 = new Font("", Font.PLAIN, 14);
	
	ImageIcon i = new ImageIcon("Images\\Background1.jpg");
	ImageIcon white = new ImageIcon("Images\\Text Field.png");
	ImageIcon but1 = new ImageIcon("Images\\Login11.png");
	ImageIcon but2 = new ImageIcon("Images\\Login12.png");
	ImageIcon l = new ImageIcon("Images\\Logo.png");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
		
	void frame()
	{
		super.setBounds(0, 0, 1925, 1080);
		super.setTitle("BANKING SYSTEM");
		super.setResizable(false);
		
		//background-image
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
            	tfemail.setFocusable(false);
            	tfpass.setFocusable(false);
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
            	HomePage h = new HomePage();
            	h.frame();
            }
        });
		
//		Logo On Login
		lb_logo = new JLabel();
		lb_logo.setBounds(925,240,120,120);
		Image lg = l.getImage().getScaledInstance(lb_logo.getWidth(), lb_logo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(lg);
		lb_logo.setIcon(logo);
		bg_img.add(lb_logo);
		
//		Warning
		JLabel warn1 = new JLabel();
		warn1.setBounds(810,383,300,15);
		warn1.setFont(f2);
		warn1.setForeground(Color.red);
		bg_img.add(warn1);
		
//		Email
		tf = new JLabel();
		tf.setBounds(800,400,370,47);
		Image white1 = white.getImage().getScaledInstance(tf.getWidth(), tf.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon tf_icon = new ImageIcon(white1);
		tf.setIcon(tf_icon);
		bg_img.add(tf);
		
		tfemail = new JTextField("Email");
		tfemail.setBounds(18,3,334,41);
		tfemail.setBorder(null);
		tfemail.setFont(f1);
		tfemail.setFocusable(false);
		tfemail.setForeground(Color.gray);
		tf.add(tfemail);
		tfemail.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            		tfemail.setFocusable(true);
            		if(tfemail.getText().contains("Email"))
            			tfemail.setText("");
                	tfemail.setForeground(Color.BLACK);
            }
        });
		tfemail.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(tfemail.getText().isEmpty())
				{
					tfemail.setText("Email");
	            	tfemail.setForeground(Color.gray);
				}
				else
				{
	            	tfemail.setForeground(Color.black);
				}
			}
		});
		tfemail.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn1.setText("");
            }
		});
		
//		Warning
		JLabel warn2 = new JLabel();
		warn2.setBounds(815,478,300,15);
		warn2.setFont(f2);
		warn2.setForeground(Color.red);
		bg_img.add(warn2);
		
//		Set Password
		pas = new JLabel();
		pas.setBounds(800,495,370,47);
		pas.setIcon(tf_icon);		
		bg_img.add(pas);

		tfpass = new JPasswordField("Password");
		tfpass.setBounds(18,3,334,41);
		pas.add(tfpass);
		tfpass.setBorder(null);
		tfpass.setFont(f1);
		tfpass.setFocusable(false);
		tfpass.setForeground(Color.gray);
		tfpass.setEchoChar((char)0);
		tfpass.addMouseListener(new java.awt.event.MouseAdapter()
		{
            @SuppressWarnings("deprecation")
			public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            		tfpass.setFocusable(true);
            		if(tfpass.getText().contains("Password"))
            			tfpass.setText("");
            		tfpass.setEchoChar('*');
                	tfpass.setForeground(Color.BLACK);
            }
        });
		tfpass.addFocusListener(new java.awt.event.FocusAdapter()
		{
			@SuppressWarnings("deprecation")
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(tfpass.getText().isEmpty() || tfpass.getText().contains("Password"))
				{
					tfpass.setText("Password");
					tfpass.setEchoChar((char)0);
	            	tfpass.setForeground(Color.gray);
				}
				else
				{
					tfpass.setEchoChar('*');
	            	tfpass.setForeground(Color.black);
				}
			}
		});
		tfpass.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn2.setText("");
            }
		});
			
//		Forgot Password
		forget = new JLabel("FORGET PASSWORD ?");
		forget.setBounds(815,550,130,18);
		forget.setForeground(Color.white);
		bg_img.add(forget);
		forget.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                forget.setForeground(Color.BLACK);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	forget.setForeground(Color.white);
            }
        });
		
//		Login Button
		lb_button = new JLabel();
		lb_button.setBounds(880,610,220,65);
		
		Image but_img1 = but1.getImage().getScaledInstance(lb_button.getWidth(), lb_button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_but_img1 = new ImageIcon(but_img1);
		
		Image but_img2 = but2.getImage().getScaledInstance(lb_button.getWidth(), lb_button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_but_img2 = new ImageIcon(but_img2);
		
		lb_button.setIcon(ii_but_img1);
		bg_img.add(lb_button);
		lb_button.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	lb_button.setIcon(ii_but_img2);
            }
            @SuppressWarnings("deprecation")
			public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	if(tfemail.getText().contains("Email") || tfemail.getText().isEmpty())
            	{
            		warn1.setText("Email cannot be empty");
            		tfemail.setFocusable(false);
            	}
            	else if(tfpass.getText().contains("Password") || tfpass.getText().isEmpty())
            	{
	            	warn2.setText("Password cannot be empty");
	            	tfpass.setFocusable(false);
            	}
            	else
            	{
            		email = tfemail.getText();
            		if(warn1.getText().isEmpty() && warn2.getText().isEmpty() && !tfemail.getText().contains("Email"))
            		{
            				try {
								verifyAccount(tfemail.getText(),tfpass.getText());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
            		}
            	}
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_button.setIcon(ii_but_img1);
            }
        });
		
		
//		New on Banking System
		signup = new JLabel("New on Banking-System?");
		signup.setBounds(905,690,180,20);
		signup.setForeground(Color.WHITE);
		signup.setFont(f2);
		bg_img.add(signup);
		signup.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	signup.setForeground(Color.BLACK);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	SignUp s = new SignUp();
            	s.frame();
            	
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	signup.setForeground(Color.WHITE);
            }
        });
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void verifyAccount(String email,String pass) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/bank","root","root");
		Statement st = co.createStatement();
		ResultSet rs = st.executeQuery("select * from userinfo where email = '"+email+"' and pass = sha1('"+(pass)+"')");
		if(rs.next())
		{
			try
			{
				if(!rs.getString("bname").isEmpty() && !rs.getString("accno").isEmpty())
				{
					System.out.println("if");
					name = rs.getString("name");
					bname = rs.getString("bname");
					accno = rs.getString("accno");
					Login.email = rs.getString("email");
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
				System.out.println("else");
			}
		}
		else
			JOptionPane.showMessageDialog(this, "Invalid Credentials");
		co.close();
	}
	
	public static void main(String[] args) 
	{
		Login l = new Login();
		l.frame();
	}
}