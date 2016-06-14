package com.swing.frame;


import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.esprit.entity.Client;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Utilisateur;

import com.swing.modelData.ModelAdministrateur;
import com.swing.variableSession.VariableSession;

import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class FrameProfile extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField tel;
	private JTextField email;
	private JTextField login;
	private JTextArea adress;
	private JPasswordField pwd;
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
	public FrameProfile(JMenuBar jMenuBar) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 433);
		//setJMenuBar(new FrameMenu().Menu());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setJMenuBar(jMenuBar);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nom = new JTextField();
		nom.setBounds(343, 112, 143, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		JLabel lblName = new JLabel("Nom:");
		lblName.setBounds(301, 126, 46, 14);
		contentPane.add(lblName);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				/***********************/
				
			
		
				VariableSession.getCurrentUser().setNom(nom.getText());
				VariableSession.getCurrentUser().setEmail(email.getText());
				VariableSession.getCurrentUser().setLogin(login.getText());
				VariableSession.getCurrentUser().setAdresse(adress.getText());
				VariableSession.getCurrentUser().setTel(tel.getText());
				VariableSession.getCurrentUser().setPrenom(prenom.getText());				
				VariableSession.getCurrentUser().setLogin(login.getText());			
				
				
				VariableSession.getCurrentUser().setPassword(new String(pwd.getPassword()));
				
				/***********************/
				
;
				System.out.println(VariableSession.getCurrentUser().getLogin());
				
				if (VariableSession.getCurrentUser() instanceof SuperAdmin)
				CommanServiceDelegate.getProxy().update((SuperAdmin)VariableSession.getCurrentUser());
				
				
				if (VariableSession.getCurrentUser() instanceof ShopOwner)
					CommanServiceDelegate.getProxy().update((ShopOwner)VariableSession.getCurrentUser());
			
				if (VariableSession.getCurrentUser() instanceof Client)
					CommanServiceDelegate.getProxy().update((Client)VariableSession.getCurrentUser());
			
			
				
		
				
			}
		});
		Update.setBounds(231, 321, 89, 23);
		contentPane.add(Update);
		
		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setBounds(88, 126, 46, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblTl = new JLabel("Tél");
		lblTl.setBounds(301, 167, 46, 14);
		contentPane.add(lblTl);
		
		prenom = new JTextField();
		prenom.setBounds(144, 123, 134, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		tel = new JTextField();
		tel.setBounds(343, 164, 143, 20);
		contentPane.add(tel);
		tel.setColumns(10);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(88, 167, 46, 14);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(144, 164, 134, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(88, 69, 46, 14);
		contentPane.add(lblLogin);
		
		login = new JTextField();
		login.setBounds(144, 66, 134, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		JLabel lblPwd = new JLabel("Pwd");
		lblPwd.setBounds(301, 69, 46, 14);
		contentPane.add(lblPwd);
		
		pwd = new JPasswordField();
		pwd.setBounds(343, 66, 143, 20);
		contentPane.add(pwd);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(187, 228, 46, 14);
		contentPane.add(lblAdresse);
		
		adress = new JTextArea();
		adress.setBounds(258, 203, 183, 76);
		contentPane.add(adress);
		 GetDataProfile ();
	/*********************************************************/	
	}
	
	public void GetDataProfile (){

		
		Utilisateur u2= new Utilisateur();
		u2=VariableSession.getCurrentUser();
		System.out.println(u2);
		 if(u2.getNom()!=null&& !u2.getNom().isEmpty())
		 nom.setText(u2.getNom());
		 if(u2.getPrenom()!=null&& !u2.getPrenom().isEmpty())
		 prenom.setText(u2.getPrenom());
		 if(u2.getTel()!=null&& !u2.getTel().isEmpty())
		 tel.setText(u2.getTel());
		 login.setText(u2.getLogin());
		 pwd.setText(u2.getPassword());
		 if(u2.getEmail()!=null&& !u2.getEmail().isEmpty())
		 email.setText(u2.getEmail());
		 if(u2.getAdresse()!=null&& !u2.getAdresse().isEmpty())
		 adress.setText(u2.getAdresse());
		 
	}
	}
