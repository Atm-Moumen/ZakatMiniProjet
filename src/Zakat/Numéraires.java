package Zakat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Numéraires implements MouseListener
{
	JFrame fen;
	Container cont;
	JButton btn_ret, btnNum, btnCalc, btnRest;
	Font policeBtn, police, policeText;
	JLabel label, l_Sai, l_res, image;
	JTextField t_sai, t_res;
	JPanel panel;
	Image img;
	
	public double ZakatNuméraire(double a)
	{
		final double quorum = 705.5;
		double quote_part = 0;
		if(a >= quorum)
			quote_part = (a * 2.5) / 100;
		return quote_part;
	}
	private boolean isNumeric(JTextField t_sai) 
	{
		try{ double a = Double.valueOf(t_sai.getText()); }
		catch (NumberFormatException e){return false;}
		return true;
	}
	
	public Numéraires() 
	{
		// TODO Auto-generated constructor stub
		fen = new JFrame();

		
		cont = fen.getContentPane();
		cont.setBackground(Color.white);
		cont.setLayout(null);
		
		label = new JLabel("Numéraires");
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
		
		btnNum = new JButton("Monnaie");
		btnNum.setBounds(15, 110, 150, 100);
		btnNum.setBackground(new Color(200, 200, 200));
		btnNum.setBorder(BorderFactory.createEmptyBorder());
		btnNum.setFocusable(false);
		btnNum.setFont(policeBtn);
		btnNum.addMouseListener(this);
		panel.add(btnNum);
		
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
		btnCalc.setBackground(new Color(210, 210, 210));
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
							t_res.setText(String.valueOf( ZakatNuméraire(Double.valueOf(t_sai.getText()))));	
						}
					}

				

				
			}
		});

		image.add(btnCalc);
		
		btnRest = new JButton("Effacer");
		btnRest.setBounds(510, 310, 100, 50);
		btnRest.setBackground(new Color(210, 210, 210));
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
		
		fen.setTitle("Numéraires");
		fen.setSize(720, 550);
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setLayout(null);
		fen.setResizable(false);
		fen.setUndecorated(true);
		fen.setVisible(true);
		}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		t_sai.setEnabled(true);
		t_res.setText("");
		t_sai.setText("");
		img = new ImageIcon("img/numeraire1.png").getImage().getScaledInstance(720, 550, Image.SCALE_FAST);
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
