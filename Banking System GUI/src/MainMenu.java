import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainMenu extends JFrame
{
	
	ImageIcon i = new ImageIcon("Images\\Background2.jpg");
	ImageIcon b = new ImageIcon("Images\\Back Button.png");
	ImageIcon new1 = new ImageIcon("Images\\new1.png");
	ImageIcon new2 = new ImageIcon("Images\\new2.png");
	ImageIcon money1 = new ImageIcon("Images\\money1.png");
	ImageIcon money2 = new ImageIcon("Images\\money2.png");
	ImageIcon dep1 = new ImageIcon("Images\\dep1.png");
	ImageIcon dep2 = new ImageIcon("Images\\dep2.png");
	ImageIcon other1 = new ImageIcon("Images\\other1.png");
	ImageIcon other2 = new ImageIcon("Images\\other2.png");
	ImageIcon dec1 = new ImageIcon("Images\\dec1.png");
	ImageIcon dec2 = new ImageIcon("Images\\dec2.png");
	ImageIcon check1 = new ImageIcon("Images\\check1.png");
	ImageIcon check2 = new ImageIcon("Images\\check2.png");
	ImageIcon with1 = new ImageIcon("Images\\with1.png");
	ImageIcon with2 = new ImageIcon("Images\\with2.png");
	
	Font f1 = new Font("Tw Cen MT", Font.PLAIN, 25);
	Font f2 = new Font("Imprint MT Shadow", Font.PLAIN, 52);
	
	JLabel bg_img,back,lb_new,lb_money,lb_dep,lb_other,lb_dec,lb_check,lb_with;
	
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
		

//		New Account
		lb_new = new JLabel();
		lb_new.setBounds(140,270,415,80);
		Image i_new1 = new1.getImage().getScaledInstance(lb_new.getWidth(), lb_new.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_new1 = new ImageIcon(i_new1);
		Image i_new2 = new2.getImage().getScaledInstance(lb_new.getWidth(), lb_new.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_new2 = new ImageIcon(i_new2);
		lb_new.setIcon(ii_new1);
		bg_img.add(lb_new);
		lb_new.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	lb_new.setIcon(ii_new2);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	if(Login.bname == null)
        		{
        			NewAccount n = new NewAccount();
        			n.frame();
        		}
            	
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_new.setIcon(ii_new1);
            }
		});
		
//		Check Balance
		lb_check = new JLabel();
		lb_check.setBounds(140,480,415,80);
		Image i_check1 = check1.getImage().getScaledInstance(lb_check.getWidth(), lb_check.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_check1 = new ImageIcon(i_check1);
		Image i_check2 = check2.getImage().getScaledInstance(lb_check.getWidth(), lb_check.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_check2 = new ImageIcon(i_check2);
		lb_check.setIcon(ii_check1);
		bg_img.add(lb_check);
		lb_check.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	lb_check.setIcon(ii_check2);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	if(Login.bname != null)
        		{
        			CheckBalance c = new CheckBalance();
        			c.frame();
        		}   
            	else 
            	{
            		
            	}
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_check.setIcon(ii_check1);
            }
		});
		
//		Money Transfer
		lb_money = new JLabel();
		lb_money.setBounds(140,690,415,80);
		Image i_money1 = money1.getImage().getScaledInstance(lb_money.getWidth(), lb_money.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_money1 = new ImageIcon(i_money1);
		Image i_money2 = money2.getImage().getScaledInstance(lb_money.getWidth(), lb_money.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_money2 = new ImageIcon(i_money2);
		lb_money.setIcon(ii_money1);
		bg_img.add(lb_money);
		lb_money.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	lb_money.setIcon(ii_money2);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	if(Login.bname != null)
        		{
        			TransferMoney t = new TransferMoney();
        			t.frame();
        		}
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_money.setIcon(ii_money1);
            }
		});
		
//		Deposite
		lb_dep = new JLabel();
		lb_dep.setBounds(1350,270,415,80);
		Image i_dep1 = dep1.getImage().getScaledInstance(lb_dep.getWidth(), lb_dep.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_dep1 = new ImageIcon(i_dep1);
		Image i_dep2 = dep2.getImage().getScaledInstance(lb_dep.getWidth(), lb_dep.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_dep2 = new ImageIcon(i_dep2);
		lb_dep.setIcon(ii_dep1);
		bg_img.add(lb_dep);
		lb_dep.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	lb_dep.setIcon(ii_dep2);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	if(Login.bname != null)
        		{
        			Deposit d = new Deposit();
        			d.frame();
        		}
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_dep.setIcon(ii_dep1);
            }
		});
		
//		Withdrawl
		lb_with = new JLabel();
		lb_with.setBounds(1350,480,415,80);
		Image i_with1 = with1.getImage().getScaledInstance(lb_with.getWidth(), lb_with.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_with1 = new ImageIcon(i_with1);
		Image i_with2 = with2.getImage().getScaledInstance(lb_with.getWidth(), lb_with.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_with2 = new ImageIcon(i_with2);
		lb_with.setIcon(ii_with1);
		bg_img.add(lb_with);
		lb_with.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	lb_with.setIcon(ii_with2);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	if(Login.bname != null)
        		{
        			Withdrawl w = new Withdrawl();
        			w.frame();
        		}
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_with.setIcon(ii_with1);
            }
		});
		
		
//		Deactivate Account
		lb_dec = new JLabel();
		lb_dec.setBounds(1350,690,415,80);
		Image i_dec1 = dec1.getImage().getScaledInstance(lb_dec.getWidth(), lb_dec.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_dec1 = new ImageIcon(i_dec1);
		Image i_dec2 = dec2.getImage().getScaledInstance(lb_dec.getWidth(), lb_dec.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_dec2 = new ImageIcon(i_dec2);
		lb_dec.setIcon(ii_dec1);
		bg_img.add(lb_dec);
		lb_dec.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	lb_dec.setIcon(ii_dec2);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
        		if(Login.bname != null)
        		{
        			Deactivate d = new Deactivate();
        			d.frame();
        		}
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_dec.setIcon(ii_dec1);
            }
		});
		
//		Other Service
		lb_other = new JLabel();
		lb_other.setBounds(745,870,415,80);
		Image i_other1 = other1.getImage().getScaledInstance(lb_other.getWidth(), lb_other.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_other1 = new ImageIcon(i_other1);
		Image i_other2 = other2.getImage().getScaledInstance(lb_other.getWidth(), lb_other.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ii_other2 = new ImageIcon(i_other2);
		lb_other.setIcon(ii_other1);
		bg_img.add(lb_other);
		lb_other.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
            	lb_other.setIcon(ii_other2);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
            	OtherServices o = new OtherServices();
        		o.frame();
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
            	lb_other.setIcon(ii_other1);
            }
		});
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		MainMenu m = new MainMenu();
		m.frame();
	}
}

