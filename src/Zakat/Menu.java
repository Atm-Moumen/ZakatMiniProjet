package Zakat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu 
{
	JFrame fen;
	Container cont;
	JLabel label, image;
	JButton btn1, btn2, btn3, btn4;
	Font police, policeBtn;
	Image img;
	public Menu()
	{
		fen = new JFrame();

		
		cont = fen.getContentPane();
		cont.setBackground(Color.white);
		cont.setLayout(null);
		
		label = new JLabel("Menu de zakat");
		label.setBounds(720/2-100,10,200,40);
		label.setForeground(Color.green.darker());  
		police = new Font("Papyrus", Font.BOLD, 28);
		label.setFont(police); 
		
		image = new JLabel();
		image.setBounds(0, 0, 720, 550);
		img = new ImageIcon("img/back_white.png").getImage().getScaledInstance(720, 550, Image.SCALE_FAST);
		image.setIcon(new ImageIcon(img));
		image.setBounds(0,0,720,550);
		image.add(label);
		cont.add(image);
		
		policeBtn = new Font("Papyrus",Font.ITALIC, 20);
		
		btn1 = new JButton("Bétail");
		btn1.setBounds(250, 120, 250, 50);
		btn1.setBackground(new Color(200, 200, 200));
		btn1.setBorder(BorderFactory.createEmptyBorder());
		btn1.setFont(policeBtn);
		btn1.setFocusable(false);
		btn1.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				new Bétail();
				fen.dispose();
			}
		});
		image.add(btn1);
	
		btn2 = new JButton("Produits Agricoles");
		btn2.setBounds(250, 190, 250, 50);
		btn2.setBackground(new Color(200, 200, 200));
		btn2.setBorder(BorderFactory.createEmptyBorder());
		btn2.setFont(policeBtn);
		btn2.setFocusable(false);
		btn2.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				new Prod_Agr();
				fen.dispose();
			}
		});
		image.add(btn2);
		
		btn3 = new JButton("L'or et L'argent");
		btn3.setBounds(250, 260, 250, 50);
		btn3.setBackground(new Color(200, 200, 200));
		btn3.setBorder(BorderFactory.createEmptyBorder());
		btn3.setFont(policeBtn);
		btn3.setFocusable(false);
		btn3.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				new Or_Arg();
				fen.dispose();
			}
		});
		image.add(btn3);
		
		btn4 = new JButton("Numéraires");
		btn4.setBounds(250, 330, 250, 50);
		btn4.setBackground(new Color(200, 200, 200));
		btn4.setBorder(BorderFactory.createEmptyBorder());
		btn4.setFont(policeBtn);
		btn4.setFocusable(false);
		btn4.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				new Numéraires();
				fen.dispose();
			}
		});
		image.add(btn4);
		
		fen.setTitle("Menu");
		fen.setSize(720, 550);
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setLayout(null);
		fen.setResizable(false);
		fen.setVisible(true);
	}

}
