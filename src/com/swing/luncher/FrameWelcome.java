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

import com.esprit.entity.ShopOwner;

import com.swing.frame.FrameAdministrateur;
import com.swing.frame.FrameBoutique;
import com.swing.frame.FrameCategorie;

import com.swing.frame.FrameEvenement;
import com.swing.frame.FrameProduit;

import com.swing.frame.FrameCommande;

import com.swing.frame.FrameProfile;
import com.swing.frame.FrameSecteurActiviter;
import com.swing.frame.FrameShopOwner;
import com.swing.frame.FrameSousCategorie;
import com.swing.frame.FrameSwingEmailSender;
import com.swing.variableSession.VariableSession;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class FrameWelcome extends JFrame {

	private JPanel contentPane;

	 FrameSecteurActiviter frameSecteurActiviter;
	 FrameAdministrateur frameAdministrateur;
	 FrameProfile frameProfile;
	 FrameBoutique frameBoutique;
	 FrameShopOwner frameShopOwner;
	 FrameCategorie frameCategorie;
	 FrameSousCategorie frameSousCategorie;
	 FrameEvenement frameEvenement;
	 FrameProduit frameProduit;
	 FrameCommande frameCommande;
	 FrameSwingEmailSender frameSwingEmailSender;
	 
	 void disableFrame(){
		 setVisible(false); 
		 if (frameSwingEmailSender!=null){
			 frameSwingEmailSender.setVisible(false);
		 }
		  
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
		 if (frameCommande!=null){
			 frameCommande.setVisible(false);
		 }
		 
		 if (frameProduit!=null){
			 frameProduit.setVisible(false);
		 }
	 }
	 FrameWelcome frameWelcome;
		public  JMenuBar Menu(){

			 JMenuBar menubar = new JMenuBar();
			 JMenu gestion = new JMenu("Utilisateur et profile");
			 JMenu gestion2 = new JMenu("Centre");
			 JMenu gestion3 = new JMenu("Client");
			 JMenu gestion4 = new JMenu("Utility");
			 
			 gestion.setMnemonic(KeyEvent.VK_F);
			 
			 JMenuItem userItem = new JMenuItem("user");
			 JMenuItem userItem3 = new JMenuItem("profile");
			 JMenuItem userItem5 = new JMenuItem("Shop Owner");
			 
			 JMenuItem userItem0= new JMenuItem("mail");
			 
			 JMenuItem userItem2 = new JMenuItem("Secteur d'activiter");
			 JMenuItem userItem4 = new JMenuItem("Boutique");
			 JMenuItem userItem6 = new JMenuItem("Categorie");
			 
			 
			 JMenuItem userItem7 = new JMenuItem("Sous Categorie");
			 
			 JMenuItem userItem8 = new JMenuItem("Evenement");
			 JMenuItem userItem9 = new JMenuItem("Produit");
			 JMenuItem userItem10 = new JMenuItem("Commandes");

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
			 
			
			 userItem9.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameProduit=new FrameProduit(Menu());
					 frameProduit.setVisible(true);
				 }});
			 
	
			 userItem10.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameCommande=new FrameCommande(Menu());
					 frameCommande.setVisible(true);
				 }});
			 userItem0.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event) {
					 disableFrame();
					 frameSwingEmailSender=new FrameSwingEmailSender(Menu());
					 frameSwingEmailSender.setVisible(true);
				 }});
			 
		
			 gestion.add(userItem);
		
			 gestion.add(userItem3);
		
			 gestion.add(userItem5);
		
			
			if (VariableSession.getCurrentUser()  instanceof ShopOwner) {
				 gestion.add(userItem7);
			}
			 
			 gestion3.add(userItem8);
			 gestion3.add(userItem9);
			 gestion3.add(userItem10);
			 
			 gestion2.add(userItem2);
			 gestion2.add(userItem4);
			 gestion2.add(userItem6);
			 

			 gestion4.add(userItem0); 
			 
			 menubar.add(gestion);
			 menubar.add(gestion2);
			 menubar.add(gestion3);
			 
			 menubar.add(gestion4);
			  JMenuItem exit = new JMenuItem("Logout");
			  exit.addMouseListener(new MouseAdapter() {
			  	@Override
			  	public void mouseClicked(MouseEvent arg0) {
			  		dispose();
			  		UserLogin f=new UserLogin();
			  		f.setVisible(true);
			  	}
			  	
			  });
			 // exit.addActionListener((ActionListener) new UserLogin());
			  menubar.add(exit);
			
			 return (menubar);
			
		}
		
	public FrameWelcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 444);
		setJMenuBar(Menu());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Welcome");
		setVisible(true);
	}
	
	
	
	
	}
