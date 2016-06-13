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


public class FrameWelcomeClient extends JFrame {

	private JPanel contentPane;

	

	 FrameSecteurActiviter frameSecteurActiviter;
	 FrameAdministrateur frameAdministrateur;
	 FrameProfile frameProfile;
	 FrameBoutique frameBoutique;
	 FrameShopOwner frameShopOwner;
	 FrameCategorie frameCategorie;
	 FrameSousCategorie frameSousCategorie;
	 FrameEvenement frameEvenement;
	 
	 void disableFrame(){
		 setVisible(false); 
		 
		 if (frameAdministrateur!=null){
			 frameAdministrateur.setVisible(false);
		 }
		 
		 if (frameSecteurActiviter!=null){
			 frameSecteurActiviter.setVisible(false);
		 }
		 
		 if (frameProfile!=null){
			 frameProfile.setVisible(false);
		 }
		 
		 if (frameBoutique!=null){
			 frameBoutique.setVisible(false);
		 }
		 if (frameShopOwner!=null){
			 frameShopOwner.setVisible(false);
		 }
		 if (frameCategorie!=null){
			 frameCategorie.setVisible(false);
		 }
		 if (frameSousCategorie!=null){
			 frameSousCategorie.setVisible(false);
		 }
		 if (frameEvenement!=null){
			 frameEvenement.setVisible(false);
		 }
		 
	 }
	 FrameWelcomeClient frameWelcome;
		public  JMenuBar Menu(){
			
		
		 
			 JMenuBar menubar = new JMenuBar();
			 JMenu gestion = new JMenu("Gestion ");
			 menubar.add(gestion);
			
			
			 gestion.setMnemonic(KeyEvent.VK_F);
			 JMenuItem userItem = new JMenuItem("user");
			 JMenuItem userItem2 = new JMenuItem("Secteur d'activiter");
			 JMenuItem userItem3 = new JMenuItem("profile");
			 JMenuItem userItem4 = new JMenuItem("Boutique");
			 JMenuItem userItem5 = new JMenuItem("Shop Owner");
			 JMenuItem userItem6 = new JMenuItem("Categorie");
			 JMenuItem userItem7 = new JMenuItem("Sous Categorie");
			 JMenuItem userItem8 = new JMenuItem("Evenement");
			 userItem.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameAdministrateur=new FrameAdministrateur(Menu()); 
					 frameAdministrateur.setVisible(true);
				 }});

			 userItem2.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameSecteurActiviter=new FrameSecteurActiviter(Menu());
					 frameSecteurActiviter.setVisible(true);
				 }});

			 userItem3.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameProfile=new FrameProfile(Menu());
					 frameProfile.setVisible(true);
				 }});

			 userItem4.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameBoutique=new FrameBoutique(Menu());
					 frameBoutique.setVisible(true);
				 }});


			 userItem5.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameShopOwner=new FrameShopOwner(Menu());
					 frameShopOwner.setVisible(true);
				 }});
			 
			 userItem6.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameCategorie=new FrameCategorie(Menu());
					 frameCategorie.setVisible(true);
				 }});
			 userItem7.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameSousCategorie=new FrameSousCategorie(Menu());
					 frameSousCategorie.setVisible(true);
				 }});
			 userItem8.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameEvenement=new FrameEvenement(Menu());
					 frameEvenement.setVisible(true);
				 }});
		

			 gestion.add(userItem3);

			 menubar.add(gestion);
			 
			 
			
			 return (menubar);
			
		}
		
	public FrameWelcomeClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(Menu());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEspaceAdministrateur = new JLabel("Espace Client");
		lblEspaceAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspaceAdministrateur.setForeground(Color.ORANGE);
		lblEspaceAdministrateur.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblEspaceAdministrateur.setBounds(6, 6, 438, 244);
		contentPane.add(lblEspaceAdministrateur);
		
		setTitle("Welcome");
		setVisible(true);
	}
	}
