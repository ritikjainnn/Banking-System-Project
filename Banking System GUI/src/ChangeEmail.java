import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChangeEmail extends JFrame
{
	JLabel bg_img,back,title,lb_old,lb_new,lb_oe,lb_ne,i_old,i_new,lb_button;
	JTextField amnt;
	ImageIcon i = new ImageIcon("Images\\setting1.jpg");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
	ImageIcon white = new ImageIcon("Images\\Text Field.png");
	ImageIcon but1 = new ImageIcon("Images\\cemail1.png");
	ImageIcon but2 = new ImageIcon("Images\\cemail2.png");
	
	Font f1 = new Font("Imprint MT Shadow", Font.PLAIN, 26);
	Font f2 = new Font("Imprint MT Shadow", Font.PLAIN, 48);
	Font f3 = new Font("", Font.PLAIN, 14);
	
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
            	OtherServices os = new OtherServices();
            	os.frame();
            }
        });
		
//		Change E-mail Heading
		title =  new JLabel("<html><u>CHANGE E-MAIL</u></html>");
		title.setBounds(300, 220, 500, 40);
		title.setForeground(Color.WHITE);
		bg_img.add(title);
		title.setFont(f2);

//      Old E-mail
		lb_old =  new JLabel("OLD E-MAIL");
		lb_old.setBounds(200, 390, 200,40);
		lb_old.setForeground(Color.WHITE);
		bg_img.add(lb_old);
		lb_old.setFont(f1);
		
		i_old =  new JLabel();
		i_old.setBounds(450, 385, 350, 50);
		Image white1 = white.getImage().getScaledInstance(i_old.getWidth(), i_old.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon tf_icon = new ImageIcon(white1);
		i_old.setIcon(tf_icon);
		i_old.setForeground(Color.black);
		bg_img.add(i_old);
		
		lb_oe =  new JLabel();
		lb_oe.setBounds(20, 0, 350, 50);
		lb_oe.setForeground(Color.black);
		i_old.add(lb_oe);
		lb_oe.setText(Login.bname);
		lb_oe.setFont(f1);
		
		
		//New E-mail
		lb_new =  new JLabel("NEW E-MAIL");
		lb_new.setBounds(200, 560, 200,40);
		lb_new.setForeground(Color.WHITE);
		bg_img.add(lb_new);
		lb_new.setFont(f1);
		
		JLabel warn = new JLabel();
		warn.setBounds(465,540,300,15);
		warn.setFont(f3);
		warn.setForeground(Color.RED);
		bg_img.add(warn);
		
		i_new =  new JLabel();
		i_new.setBounds(450, 560, 350, 50);
		//Image white1 = white.getImage().getScaledInstance(i_bank.getWidth(), i_bank.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon tf_icon = new ImageIcon(white1);
		i_new.setIcon(tf_icon);
		i_new.setForeground(Color.black);
		bg_img.add(i_new);
		
//		lb_ne =  new JLabel();
//		lb_ne.setBounds(20, 0, 350, 50);
//		lb_ne.setForeground(Color.black);
//		i_new.add(lb_ne);
//		lb_ne.setText(Login.bname);
//		lb_ne.setFont(f1);
		
		amnt =  new JTextField("");
		amnt.setBounds(25, 5, 305, 40);
		amnt.setBorder(null);
		amnt.setForeground(Color.black);
		amnt.setFont(f1);
		i_new.add(amnt);
		amnt.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				amnt.setFocusable(true);
			}
		});
		
//		Get OTP Button
		lb_button = new JLabel();
		lb_button.setBounds(330,750,330,85);
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
				 amnt.setFocusable(false);
	      		  try {
					//
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
	
	public static void main(String[] args) 
	{
		ChangeEmail ce = new ChangeEmail();
		ce.frame();
	}
	
}		
