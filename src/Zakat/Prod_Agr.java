package Zakat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Prod_Agr implements MouseListener
{
	JFrame fen;
	private Container cont;
	JButton btn_ret, btnBlé, btnAut, btnCalc, btnRest;
	Font policeBtn, police, policeText;
	JLabel label, l_Sai, l_res, image;
	JPanel panel;
	JTextField t_sai, t_res;
	Image img;
	private int choix = 0;
	private boolean IA;
	private JComboBox comb;
	
	private boolean isNumeric(JTextField t_sai) 
	{
		try{ double a = Double.valueOf(t_sai.getText()); }
		catch (NumberFormatException e){return false;}
		return true;
	}
	public double ZakatArgent(double a)
	{
		final double quorum = 595;
		double quote_part = 0;
		if(a >= quorum)
			quote_part = (a * 2.5) / 100;
		return quote_part;
		 
	}
	public double ZakatOr(double a, int carat)
	
	{
		double quote_part = 0;
		switch(carat)
		{
			case 24: { if(a >= 85)
						quote_part = (a * 2.5) / 100;};break;
			case 21: { if (a >= 97)
						quote_part = (a * 2.5) / 100;};break;
			case 18:{ if (a >= 113)
						quote_part = (a * 2.5) / 100;};break;
		}
		return quote_part;
	}
	public double ZakatAgricole(double a, boolean IA)
	{
		double quote_part = 0;
		if (IA)
			quote_part = (a * 10) / 100;
		else
			quote_part = (a * 5) / 100;
		return quote_part;
	}

	public double ZakatBlé(double a, boolean IA)
	{
		final double quorum = 675;
		double quote_part = 0;
		if(a >= quorum)
		{
			if (IA)
				quote_part = (a * 10) / 100;
			else
				quote_part = (a * 5) / 100;
		}
		return quote_part;
	}

	public Prod_Agr() 
	{
		// TODO Auto-generated constructor stub
		fen = new JFrame();

		
		cont = fen.getContentPane();
		cont.setBackground(Color.white);
		cont.setLayout(null);
		
		label = new JLabel("Produits Agricoles");
		label.setBounds(360,20,300,40);
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
		
		btnBlé = new JButton("Blé");
		btnBlé.setBounds(15, 110, 150, 100);
		btnBlé.setBackground(new Color(200, 200, 200));
		btnBlé.setBorder(BorderFactory.createEmptyBorder());
		btnBlé.setFocusable(false);
		btnBlé.setFont(policeBtn);
		btnBlé.addMouseListener(this);
		panel.add(btnBlé);
		
		btnAut = new JButton("Autre");
		btnAut.setBounds(15, 230, 150, 100);
		btnAut.setBackground(new Color(200, 200, 200));
		btnAut.setBorder(BorderFactory.createEmptyBorder());
		btnAut.setFocusable(false);
		btnAut.setFont(policeBtn);
		btnAut.addMouseListener(this);
		panel.add(btnAut);
		
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
							if(choix == 2)
								t_res.setText(String.valueOf( ZakatAgricole(Double.valueOf(t_sai.getText()), IA)));
							else
							{
								if (choix == 1)
									t_res.setText(String.valueOf( ZakatBlé(Double.valueOf(t_sai.getText()), IA)));
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
		
		String[] tab = {"Irrigation artificielle", "Irrigation naturelle"};
		comb = new JComboBox(tab);
		comb.setBounds(360, 170, 140, 30);
		comb.setBackground(new Color(120,160,63).brighter());
		comb.setForeground(Color.white);
		comb.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(comb))
				{
					 if(comb.getSelectedItem().equals("Irrigation artificielle"))
						 IA = false;
					 else
						 if(comb.getSelectedItem().equals("Irrigation naturelle"))
							 IA = true;
				}
				
			}
		});
		
		
		image.add(comb);
		
		fen.setTitle("Or et Argent");
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
		if(e.getSource() == btnBlé)
			{
				choix = 1;
				img = new ImageIcon("img/blé.png").getImage().getScaledInstance(720, 550, Image.SCALE_FAST);
			}
		if(e.getSource() == btnAut)
			 {
				choix = 2;
				img = new ImageIcon("img/prod_agr_irr.png").getImage().getScaledInstance(720, 550, Image.SCALE_FAST);
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
