import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class OtherServices extends JFrame
{

	JLabel bg_img,back,title,lb_button,lb_button1;
	
	ImageIcon i = new ImageIcon("Images\\Background3.jpg");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
	ImageIcon white = new ImageIcon("Images\\Text Field.png");
	ImageIcon but1 = new ImageIcon("Images\\ce1.png");
	ImageIcon but2 = new ImageIcon("Images\\ce2.png");
	ImageIcon but3 = new ImageIcon("Images\\cp1.png");
	ImageIcon but4 = new ImageIcon("Images\\cp2.png");
	
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
		title =  new JLabel("<html><u>OTHER SERVICES</u></html>");
		title.setBounds(1280, 240, 500, 40);
		title.setForeground(Color.WHITE);
		bg_img.add(title);
		title.setFont(f2);
		
//		 Change E-mail Button
		lb_button = new JLabel();
		lb_button.setBounds(1310,420,390,85);
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
				 ChangeEmail ce = new ChangeEmail();
				 ce.frame();
	         }
			
		});
		
//		Change Password Button
		lb_button1 = new JLabel();
		lb_button1.setBounds(1310,635,390,85);
		Image i_but3 = but3.getImage().getScaledInstance(lb_button1.getWidth(), lb_button1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_but3 = new ImageIcon(i_but3);
		Image i_but4 = but4.getImage().getScaledInstance(lb_button1.getWidth(), lb_button1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_but4 = new ImageIcon(i_but4);
		lb_button1.setIcon(ii_but3);
		bg_img.add(lb_button1);
		lb_button1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				lb_button1.setIcon(ii_but4);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt)
			{
				lb_button1.setIcon(ii_but3);
			}
			
			 public void mouseClicked(java.awt.event.MouseEvent evt)
	         {
				 ChangePassword ce = new ChangePassword();
				 ce.frame();
	         }
			
		});
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		OtherServices o = new OtherServices();
		o.frame();
		
	}
	
}
