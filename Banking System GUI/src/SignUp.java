import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SignUp extends JFrame
{
	JLabel bg_img,back,setText,lb_fname,lb_lname,lb_email,lb_mob,lb_pass,lb_cpass,lb_button;
	JTextField fname,lname,email,mob;
	JTextArea ta_add;
	JPasswordField pass,cpass;
	
	ImageIcon i = new ImageIcon("Images\\Background1.jpg");
	ImageIcon white = new ImageIcon("Images\\Text Field.png");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
	ImageIcon but1 = new ImageIcon("Images\\Signup1.png");
	ImageIcon but2 = new ImageIcon("Images\\Signup2.png");
	
	Font f1 = new Font("Tw Cen MT", Font.PLAIN, 25);
	Font f2 = new Font("", Font.PLAIN, 14);
	Font f3 = new Font("Imprint MT Shadow", Font.PLAIN, 52);
	
	void frame() 
	{
		super.setBounds(0, 0, 1925, 1080);
		super.setTitle("Banking System");
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
            	fname.setFocusable(false);
            	lname.setFocusable(false);
            	email.setFocusable(false);
            	mob.setFocusable(false);
            	pass.setFocusable(false);
            	cpass.setFocusable(false);
            	ta_add.setFocusable(false);
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
		
//		Signup Heading
		setText = new JLabel("<html><u>SIGN UP</u></html>");
		setText.setBounds(860,100,240,50);
		setText.setFont(f3);
		bg_img.add(setText);
		setText.setForeground(Color.BLACK);
		
		
//		Warning
		JLabel warn1 = new JLabel();
		warn1.setBounds(490,252,300,15);
		warn1.setFont(f2);
		warn1.setForeground(Color.red);
		bg_img.add(warn1);
		
//		Enter First Name
		lb_fname = new JLabel();
		lb_fname.setBounds(470,270,370,50);
		Image white1 = white.getImage().getScaledInstance(lb_fname.getWidth(), lb_fname.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon tf_icon = new ImageIcon(white1);
		lb_fname.setIcon(tf_icon);
		bg_img.add(lb_fname);
		
		fname = new JTextField("First Name");
		fname.setBounds(19,3,334,43);
		fname.setBorder(null);
		fname.setFont(f1);
		fname.setFocusable(false);
		fname.setForeground(Color.GRAY);
		lb_fname.add(fname);
		fname.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				fname.setFocusable(true);
				if(fname.getText().contains("First Name"))
					fname.setText("");
            	fname.setForeground(Color.BLACK);
			}
		});
		fname.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(fname.getText().isEmpty())
				{
					fname.setText("First Name");
	            	fname.setForeground(Color.gray);
				}
				else
				{
	            	fname.setForeground(Color.black);
				}
			}
		});
		fname.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn1.setText("");
            }
		});
		
//		Warning
		JLabel warn2 = new JLabel();
		warn2.setBounds(1110,252,300,15);
		warn2.setFont(f2);
		warn2.setForeground(Color.red);
		bg_img.add(warn2);
		
//		Enter Last Name
		lb_lname = new JLabel();
		lb_lname.setBounds(1090,270,370,50);
		lb_lname.setIcon(tf_icon);
		bg_img.add(lb_lname);
		
		lname = new JTextField("Last Name");
		lname.setBounds(19,3,334,43);
		lname.setBorder(null);
		lname.setFont(f1);
		lname.setFocusable(false);
		lname.setForeground(Color.GRAY);
		lb_lname.add(lname);
		lname.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				lname.setFocusable(true);
				if(lname.getText().contains("Last Name"))
					lname.setText("");
            	lname.setForeground(Color.BLACK);
			}
		});
		lname.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(lname.getText().isEmpty())
				{
					lname.setText("Last Name");
	            	lname.setForeground(Color.gray);
				}
				else
				{
	            	lname.setForeground(Color.black);
				}
			}
		});
		lname.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn2.setText("");
            }
		});
		
//		Warning
		JLabel warn3 = new JLabel();
		warn3.setBounds(490,362,300,15);
		warn3.setFont(f2);
		warn3.setForeground(Color.red);
		bg_img.add(warn3);
		
//		Enter Email
		lb_email = new JLabel();
		lb_email.setBounds(470,380,370,50);
		lb_email.setIcon(tf_icon);
		bg_img.add(lb_email);
		
		email = new JTextField("Email");
		email.setBounds(19,3,334,43);
		email.setBorder(null);
		email.setFont(f1);
		email.setFocusable(false);
		email.setForeground(Color.GRAY);
		lb_email.add(email);
		email.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				email.setFocusable(true);
				if(email.getText().contains("Email"))
					email.setText("");
            	email.setForeground(Color.BLACK);
			}
		});
		email.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(email.getText().isEmpty())
				{
					email.setText("Email");
	            	email.setForeground(Color.gray);
				}
				else if(!email.getText().contains("@") || !email.getText().endsWith(".com"))
				{
					warn3.setText("Please enter valid Email");
				}
				else
				{
	            	email.setForeground(Color.black);
				}
			}
		});
		email.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn3.setText("");
            }
		});
		
//		Warning
		JLabel warn4 = new JLabel();
		warn4.setBounds(1110,362,300,15);
		warn4.setFont(f2);
		warn4.setForeground(Color.red);
		bg_img.add(warn4);
		
//		Enter Mobile Number
		lb_mob = new JLabel();
		lb_mob.setBounds(1090,380,370,50);
		lb_mob.setIcon(tf_icon);
		bg_img.add(lb_mob);
		
		mob = new JTextField("Mobile No.");
		mob.setBounds(19,3,334,43);
		mob.setBorder(null);
		mob.setFont(f1);
		mob.setFocusable(false);
		mob.setForeground(Color.GRAY);
		lb_mob.add(mob);
		mob.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				mob.setFocusable(true);
				if(mob.getText().contains("Mobile No."))
            	mob.setText("");
            	mob.setForeground(Color.BLACK);
			}
		});
		mob.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(mob.getText().isEmpty())
				{
					mob.setText("Mobile No.");
	            	mob.setForeground(Color.gray);
				}
				else if(!(mob.getText().length() == 10) || (mob.getText().startsWith("9") && mob.getText().startsWith("8") && mob.getText().startsWith("7") && mob.getText().startsWith("6")))
				{
					warn4.setText("Please enter valid Number");
					warn4.setForeground(Color.RED);
				}
				else
				{
	            	mob.setForeground(Color.black);
				}
			}
		});
		mob.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn4.setText("");
            		try 
    				{
    					Long.parseLong(mob.getText());
    					warn4.setText("");
    				}
    				catch (NumberFormatException e) 
    				{
    					warn4.setText("Please enter valid Number");
    					warn4.setForeground(Color.RED);
    				}
            }
		});
		
//		Warning
		JLabel warn5 = new JLabel();
		warn5.setBounds(490,472,300,15);
		warn5.setFont(f2);
		warn5.setForeground(Color.red);
		bg_img.add(warn5);
		
//		Enter Password
		lb_pass = new JLabel();
		lb_pass.setBounds(470,490,370,50);
		lb_pass.setIcon(tf_icon);
		bg_img.add(lb_pass);
		
		pass = new JPasswordField("Password");
		pass.setBounds(19,3,334,43);
		pass.setBorder(null);
		pass.setFont(f1);
		pass.setFocusable(false);
		pass.setEchoChar((char)0);
		pass.setForeground(Color.GRAY);
		lb_pass.add(pass);
		pass.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@SuppressWarnings("deprecation")
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				pass.setFocusable(true);
				if(pass.getText().contains("Password"))
					pass.setText("");
            	pass.setForeground(Color.BLACK);
            	pass.setEchoChar('*');
			}
		});
		pass.addFocusListener(new java.awt.event.FocusAdapter()
		{
			@SuppressWarnings("deprecation")
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(pass.getText().isEmpty() || pass.getText().contains("Password"))
				{
					pass.setText("Password");
					pass.setEchoChar((char)0);
	            	pass.setForeground(Color.gray);
				}
				else
				{
					pass.setEchoChar('*');
	            	pass.setForeground(Color.black);
				}
			}
		});
		pass.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn5.setText("");
            }
		});
		
//		Warning
		JLabel warn6 = new JLabel();
		warn6.setBounds(1110,472,300,15);
		warn6.setFont(f2);
		warn6.setForeground(Color.red);
		bg_img.add(warn6);
		
//		Enter Confirm Password
		lb_cpass = new JLabel();
		lb_cpass.setBounds(1090,490,370,50);
		lb_cpass.setIcon(tf_icon);
		bg_img.add(lb_cpass);
		
		cpass = new JPasswordField("Confirm Password");
		cpass.setBounds(19,3,334,43);
		cpass.setBorder(null);
		cpass.setFont(f1);
		cpass.setFocusable(false);
		cpass.setEchoChar((char)0);
		cpass.setForeground(Color.GRAY);
		lb_cpass.add(cpass);
		cpass.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@SuppressWarnings("deprecation")
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				cpass.setFocusable(true);
				if(cpass.getText().contains("Confirm Password"))
					cpass.setText("");
            	cpass.setForeground(Color.BLACK);
            	cpass.setEchoChar('*');
			}
		});
		cpass.addFocusListener(new java.awt.event.FocusAdapter()
		{
			@SuppressWarnings("deprecation")
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(cpass.getText().isEmpty() || cpass.getText().contains("Confirm Password"))
				{
					cpass.setText("Confirm Password");
					cpass.setEchoChar((char)0);
	            	cpass.setForeground(Color.gray);
				}
				else
				{
					cpass.setEchoChar('*');
	            	cpass.setForeground(Color.black);
				}
			}
		});
		cpass.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn6.setText("");
            }
		});
		
//		Warning
		JLabel warn7 = new JLabel();
		warn7.setBounds(810,582,300,15);
		warn7.setFont(f2);
		warn7.setForeground(Color.red);
		bg_img.add(warn7);
		
//		Enter Address
		ta_add = new JTextArea("Address");
		ta_add.setBounds(800, 600, 330, 150);
		ta_add.setFocusable(false);
		ta_add.setFont(f1);
		ta_add.setForeground(Color.GRAY);
		bg_img.add(ta_add);
		ta_add.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            		ta_add.setFocusable(true);
            		if(ta_add.getText().contains("Address"))
            			ta_add.setText("");
                	ta_add.setForeground(Color.BLACK);  	
            }
        });
		ta_add.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				if(ta_add.getText().isEmpty())
				{
					ta_add.setText("Address");
	            	ta_add.setForeground(Color.gray);
				}
				else
				{
	            	ta_add.setForeground(Color.black);
				}
			}
		});
		ta_add.addKeyListener(new java.awt.event.KeyAdapter()
		{
			public void keyPressed(java.awt.event.KeyEvent evt)
            {
            		warn7.setText("");
            }
		});
		
//		Button For Signup
		lb_button = new JLabel();
		lb_button.setBounds(860, 790, 220, 65);
		
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
            	fname.setFocusable(false);
            	lname.setFocusable(false);
            	email.setFocusable(false);
            	mob.setFocusable(false);
            	pass.setFocusable(false);
            	cpass.setFocusable(false);
            	ta_add.setFocusable(false);
            	if(fname.getText().contains("First Name") || fname.getText().isEmpty())
            	{
            		warn1.setText("First Name cannot be empty");
            		fname.setFocusable(false);
                }
            	else 
            	{
            		if(lname.getText().contains("Last Name") || lname.getText().isEmpty())
                	{
            			warn2.setText("Last Name cannot be empty");
                		lname.setFocusable(false);
            		}
            		else
            		{
                		if(email.getText().contains("Email") || email.getText().isEmpty())
                    	{
                			warn3.setText("Email cannot be empty");
                    		email.setFocusable(false);
                    	}
            			else 
            			{
            				if(mob.getText().contains("Mobile No.") || mob.getText().isEmpty())
                        	{
            					warn4.setText("Mobile No. cannot be empty");
            					mob.setFocusable(false);
                        	}
            				else
            				{
            					if(pass.getText().contains("Password") || pass.getText().isEmpty())
                            	{
            						warn5.setText("Password cannot be empty");
                					mob.setFocusable(false);
                            	}
                				else
                				{
                					if(cpass.getText().contains("Confirm Password") || cpass.getText().isEmpty())
                                	{
                						warn6.setText("Confirm Password cannot be empty");
                    					mob.setFocusable(false);
                                	}
                    				else
                    				{
                    					if(!(pass.getText().length()>=8 && pass.getText().length()<=15))
                    					{
                    						warn5.setText("Password have atleast 8-15 characters");
                    					}
                    					else if(pass.getText().equals(cpass.getText()))
                    					{
                    						if(ta_add.getText().contains("Address") || ta_add.getText().isEmpty())
                                        	{
                        						warn7.setText("Address cannot be empty");
                            					mob.setFocusable(false);
                                        	}
                    						else
                    						{
                    							if(warn1.getText().isEmpty() || warn2.getText().isEmpty() || warn3.getText().isEmpty() || warn4.getText().isEmpty() || warn5.getText().isEmpty() || warn6.getText().isEmpty())
                        						{
                        							String name = fname.getText() + " " +lname.getText();
                        							try {
    													inputEntry(name);
    												} catch (Exception e) {
    													//System.out.println("fghjbklm");
    												}
                        						}
                    						}
                    					}
                    					else
                    					{
                    						warn6.setText("Password does not match");
                    					}
                    				}
                					
                				}
            				}
            			}
                	}
            	}
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_button.setIcon(ii_but_img1);
            }
		});
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("deprecation")
	void inputEntry(String name) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/bank","root","root");
		Statement st = co.createStatement();
		st.executeUpdate
		("insert into userinfo(name,email,mobile,pass,address) values" 
		+ "('"+name+"','"+email.getText()+"','"+mob.getText()+"',sha1('"+(pass.getText())+"'),'"+ta_add.getText()+"')");
		co.close();
		JOptionPane.showMessageDialog(this, "Successfully SignUp\nWe are redirecting to Login Page.");
		Login l = new Login();
		l.frame();
		super.dispose();
	}
	
	public static void main(String[] args) 
	{
		SignUp s = new SignUp();
		s.frame();
	}
}
