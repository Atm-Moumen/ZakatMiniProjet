package Zakat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Bétail  implements MouseListener
{
	JFrame fen;
	Container cont;
	JButton btn_ret, btnCalc, btnRest, btnCham, btnBov, btnOv ;
	Font  policeBtn, police, policeText;
	JLabel label, l_Sai, l_res, image;
	JTextField t_sai, t_res;
	JPanel panel;
	Image img;
	private int choix;
	private boolean isNumeric(JTextField t_sai) 
	{
		try{ double a = Double.valueOf(t_sai.getText()); }
		catch (NumberFormatException e){return false;}
		return true;
	}
	public String ZakatOvin(int a)
	{
		String quote_part;
		if(a >= 40 & a <= 120) 
			quote_part = "1C";
		else
		{
			if (a >= 121 & a <= 200)
				quote_part = "2C";
			else
			{
				if (a >= 201 & a <= 399)
					quote_part = "3C";
				else
				{
					if (a > 399)
					{
						int quotient = a / 100;
						quote_part = Integer.toString(quotient) +"C";
					}
					else
						quote_part = "0";
				}
			}
				
			
		}
	return quote_part;
	}

	public String ZakatBovin(int a)
	{
		String quote_part;
		if(a >= 30 & a <= 39) 
			quote_part = "T";
		else
		{
			if (a >= 40 & a <= 59)
				quote_part = "Mo";
			else
			{
				if (a >= 60 & a <= 69)
					quote_part = "2T";
				else
				{
					if(a >= 70 & a <= 79) 
						quote_part = "Mo + T";
					else
					{
						if (a >= 80 & a <= 89)
							quote_part = "2Mo";
						else
						{
							if (a >= 90 & a <= 99)
								quote_part = "3T";
							else
							{
								if (a >= 100 & a <= 119)
									quote_part = "Mo + 2T";
								else
									{
										if (a >= 120 & a <= 129)
											quote_part = "3Mo ou 4T";
										else
										{
											if(a >= 120)
											{
												int quotient= a / 40;
												int reste = (a % 40) / 30;
												quote_part = Integer.toString(quotient) +"Mo" + " + " + Integer.toString(reste) +"T";
											}
											else
											{
												quote_part = "0";
											}
										}
												
									}
								}
										
						  	}
						}
				}
			}
		}
		
		return quote_part;
	}

	public String ZakatChameaux(int a)
	{
		String quote_part;
		if(a >= 5 & a <= 24)
			quote_part = Integer.toString(a / 5) + "C";
		else
		{
			if(a >= 25 & a <= 35)
				quote_part = "M";
			else
			{
				if(a >= 36 & a <= 45)
					quote_part = "L";
				else
				{
					if(a >= 46 & a <= 60)
						quote_part = "H";
					else
					{
						if(a >= 61 & a <= 75)
							quote_part = "J";
						else
						{
							if(a >= 76 & a <= 90)
								quote_part = "2L";
							else
							{
								if(a >= 91 & a <= 120)
									quote_part = "2H";
								else
								{
									if(a > 120)
									{
										int quotient = a / 50;
										int reste = a % 50;
										int res = reste / 40;
										if(quotient == 0)
											quote_part = Integer.toString(res)+"L";
										else
										{
											if(res == 0)
												quote_part = Integer.toString(quotient)+"H";
											else
												quote_part = Integer.toString(quotient) +"H" +" + "+Integer.toString(res)+"L";
										}
									}
									else
										quote_part = "0";
								}
							}
						}
					}
				}
					
			}
		}
			
		
		
		return quote_part;
	}
	public Bétail()
	{
		// TODO Auto-generated constructor stub
		
		fen = new JFrame();

		cont = fen.getContentPane();
		cont.setBackground(Color.white);
		cont.setLayout(null);
		
		label = new JLabel("Bétail");
		label.setBounds(360,20,200,40);
		label.setForeground(Color.green.darker());  
		police = new Font("Papyrus", Font.BOLD, 28);
		label.setFont(police); 
		
		
		image = new JLabel();
		image.setBounds(0, 0, 720, 550);
		img = new ImageIcon("img/back_white.png").getImage().getScaledInstance(720, 550, Image.SCALE_FAST);
		image.setIcon(new ImageIcon(img));
		image.add(label);
		cont.add(image);
		
		policeBtn = new Font("Papyrus",Font.ITALIC, 18);
		policeText = new Font("Papyrus", Font.BOLD, 14);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 180, 550);
		panel.setBackground(new Color(210, 210, 210));
		panel.setLayout(null);
		image.add(panel);
		
		btn_ret = new JButton("Allez au Menu");
		btn_ret.setBounds(15, 10, 150, 50);
		btn_ret.setBackground(new Color(200, 200, 200));
		btn_ret.setBorder(BorderFactory.createEmptyBorder());
		btn_ret.setFocusable(false);
		btn_ret.setFont(policeBtn);
		btn_ret.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				new Menu();
				fen.dispose();
			}
		});
		panel.add(btn_ret);
		
		btnCham = new JButton("Chameaux");
		btnCham.setBounds(15, 110, 150, 100);
		btnCham.setBackground(new Color(200, 200, 200));
		btnCham.setBorder(BorderFactory.createEmptyBorder());
		btnCham.setFocusable(false);
		btnCham.setFont(policeBtn);
		btnCham.addMouseListener(this);
		panel.add(btnCham);
		
		btnBov = new JButton("Bovins");
		btnBov.setBounds(15, 230, 150, 100);
		btnBov.setBackground(new Color(200, 200, 200));
		btnBov.setBorder(BorderFactory.createEmptyBorder());
		btnBov.setFocusable(false);
		btnBov.setFont(policeBtn);
		btnBov.addMouseListener(this);
		panel.add(btnBov);
		
		btnOv = new JButton("Ovins");
		btnOv.setBounds(15, 350, 150, 100);
		btnOv.setBackground(new Color(200, 200, 200));
		btnOv.setBorder(BorderFactory.createEmptyBorder());
		btnOv.setFocusable(false);
		btnOv.setFont(policeBtn);
		btnOv.addMouseListener(this);
		panel.add(btnOv);
		
		l_Sai = new JLabel("Saisis ton biens: ");
		l_Sai.setBounds(230, 100, 170, 50);
		l_Sai.setFont(policeText);
		l_Sai.setForeground(Color.green.darker());
		image.add(l_Sai);
		
		t_sai = new JTextField();
		t_sai.setBounds(360, 100, 250, 50);
		t_sai.setEnabled(false);
		t_sai.setFont(policeText);
		t_sai.setForeground(Color.green.darker());
		image.add(t_sai);
		
		l_res = new JLabel("Votre zakat est : ");
		l_res.setBounds(230, 240, 220, 50);
		l_res.setFont(policeText);
		l_res.setForeground(Color.green.darker());
		image.add(l_res);
		
		t_res = new JTextField();
		t_res.setBounds(360, 240, 250, 50);
		t_res.setEnabled(false);
		t_res.setFont(policeText);
		t_res.setForeground(Color.green.darker());
		image.add(t_res);
		
		btnCalc = new JButton("Calculer");
		btnCalc.setBounds(510, 170, 100, 50);
		btnCalc.setBackground(new Color(200, 200, 200));
		btnCalc.setBorder(BorderFactory.createEmptyBorder());
		btnCalc.setFocusable(false);
		btnCalc.setFont(policeBtn);
		btnCalc.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				if (t_sai.getText().isEmpty())
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(null, " Veuillez Saisir un Nombre ", "Message",
					JOptionPane.INFORMATION_MESSAGE);
				}
				else
					{
						if( !isNumeric(t_sai))
						{
							JOptionPane msg1=new JOptionPane();
							msg1.showMessageDialog(null, "Erreur de Typage: Veuillez saisir une valeur Numérique", 
									"ERROR", JOptionPane.ERROR_MESSAGE);
							t_sai.setText("");
							t_sai.requestFocus();
						}
						else
						{
							if (choix == 1)
								t_res.setText(String.valueOf( ZakatChameaux(Integer.valueOf(t_sai.getText()))));
							else
							{
								if(choix == 2)
									t_res.setText(String.valueOf( ZakatBovin(Integer.valueOf(t_sai.getText()))));
								else
									t_res.setText(String.valueOf( ZakatOvin(Integer.valueOf(t_sai.getText()))));
							}
						}
					}

				

				
			}
		});

		image.add(btnCalc);
		
		btnRest = new JButton("Effacer");
		btnRest.setBounds(510, 310, 100, 50);
		btnRest.setBackground(new Color(200, 200, 200));
		btnRest.setBorder(BorderFactory.createEmptyBorder());
		btnRest.setFocusable(false);
		btnRest.setFont(policeBtn);
		btnRest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				t_res.setText("");
				t_sai.setText("");
				}
		});
		image.add(btnRest);
		
		
		fen.setTitle("Bétail");
		fen.setSize(720, 550);
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setLayout(null);
		fen.setResizable(false);
		fen.setUndecorated(true);
		fen.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		t_sai.setEnabled(true);
		t_res.setText("");
		t_sai.setText("");
		if(e.getSource() == btnCham)
			{
				choix = 1;
				img = new ImageIcon("img/camel.png").getImage().getScaledInstance(720, 550, Image.SCALE_FAST);
			
			}
		if(e.getSource() == btnBov)
			 {
				choix = 2;
				img = new ImageIcon("img/cow.png").getImage().getScaledInstance(720, 550, Image.SCALE_FAST);
				
			 }
		if(e.getSource() == btnOv)
			 {
				choix = 3;
				img = new ImageIcon("img/sheep.png").getImage().getScaledInstance(720, 550, Image.SCALE_FAST);
				
			 }
		image.setIcon(new ImageIcon(img));
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
