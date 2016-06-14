package com.swing.luncher;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.swing.frame.FrameAdministrateur;
import com.swing.frame.FrameBoutique;
import com.swing.frame.FrameCategorie;
import com.swing.frame.FrameEvenement;
import com.swing.frame.FrameProfile;
import com.swing.frame.FrameSecteurActiviter;
import com.swing.frame.FrameShopOwner;
import com.swing.frame.FrameSousCategorie;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class FrameWelcomeShopOwner extends JFrame {

	private JPanel contentPane;

	
	 FrameProfile frameProfile;
	 FrameCategorie frameCategorie;
	 FrameSousCategorie frameSousCategorie;
	 
	 
	 void disableFrame(){
		 setVisible(false); 
		 
		
		 
		 if (frameProfile!=null){
			 frameProfile.setVisible(false);
		 }
		 
		
		 if (frameCategorie!=null){
			 frameCategorie.setVisible(false);
		 }
		 if (frameSousCategorie!=null){
			 frameSousCategorie.setVisible(false);
		 }
		
		 
	 }
	 FrameWelcomeShopOwner frameWelcome;
		public  JMenuBar Menu(){
			
		
		 
			 JMenuBar menubar = new JMenuBar();
			 JMenu gestion = new JMenu("Gestion ");
			 menubar.add(gestion);
			
			
			 gestion.setMnemonic(KeyEvent.VK_F);
			 
			 JMenuItem userItem3 = new JMenuItem("profile");
			 JMenuItem userItem7 = new JMenuItem("Sous Categorie");
			 
			

			

			 userItem3.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameProfile=new FrameProfile(Menu());
					 frameProfile.setVisible(true);
				 }});

			

			 userItem7.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameSousCategorie=new FrameSousCategorie(Menu());
					 frameSousCategorie.setVisible(true);
				 }});
			
			 
			 userItem3.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameProfile=new FrameProfile(Menu());
					 frameProfile.setVisible(true);
				 }});
		
			 //gestion.add(userItem);
			 //gestion.add(userItem2);
			 gestion.add(userItem3);
		
			 //gestion.add(userItem5);
		
			 gestion.add(userItem7);
			 //gestion.add(userItem8);
			 menubar.add(gestion);
			 
			 
			
			 return (menubar);
			
		}
		
	public FrameWelcomeShopOwner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(Menu());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEspaceAdministrateur = new JLabel("Espace ShopOwner");
		lblEspaceAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspaceAdministrateur.setForeground(Color.ORANGE);
		lblEspaceAdministrateur.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblEspaceAdministrateur.setBounds(6, 6, 438, 244);
		contentPane.add(lblEspaceAdministrateur);
		
		setTitle("Welcome");
		setVisible(true);
	}
	}
