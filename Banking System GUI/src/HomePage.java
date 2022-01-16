import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class HomePage extends JFrame
{
	JLabel lb_login,lb_signup,bg_img;
	ImageIcon i = new ImageIcon("Images\\Background4.jpg");
	
	Font f1 = new Font("Imprint MT Shadow", Font.PLAIN, 52);
	
	void frame()
	{
		super.setBounds(0, 0, 1920, 1080);
		super.setTitle("BANKING SYSTEM");
		super.setResizable(false);
		
		bg_img = new JLabel();
		bg_img.setBounds(0,0,1925,1080);
		Image img = i.getImage().getScaledInstance(bg_img.getWidth(), bg_img.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i1 = new ImageIcon(img);
		bg_img.setIcon(i1);
		super.add(bg_img);
		
//		Login
		lb_login = new JLabel("Login");
		lb_login.setBounds(1400,400,140,60);
		lb_login.setForeground(Color.BLACK);
		lb_login.setFont(f1);
		bg_img.add(lb_login);
		lb_login.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	String str = "<html><u>Login</u></html>";
            	lb_login.setText(str);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	Login l = new Login();
            	l.frame();
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_login.setText("Login");
            }
		});
		
//		Signup
		lb_signup = new JLabel("SignUp");
		lb_signup.setBounds(1380,570,175,60);
		lb_signup.setForeground(Color.BLACK);
		lb_signup.setFont(f1);
		bg_img.add(lb_signup);
		lb_signup.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	String str = "<html><u>SignUp</u></html>";
            	lb_signup.setText(str);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	SignUp s = new SignUp();
            	s.frame();
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_signup.setText("SignUp");
            }
		});
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		HomePage h = new HomePage();
		h.frame();
	}

}
