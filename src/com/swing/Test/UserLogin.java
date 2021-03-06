package com.swing.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Utilisateur;
import com.esprit.entity.Client;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.swing.luncher.FrameWelcome;
import com.swing.variableSession.VariableSession;

import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;

class UserLogin
		extends 	JFrame
{
	private		JTabbedPane tabbedPane;
	private		JPanel		panelConnexion;
	private		JPanel		panelInscription;

	JButton loginB, cancel;
	JTextField uname;
	JPasswordField pass;
	JLabel u, p;
	
	private JTextField nom;
	private JTextField prenom;
	private JTextField tel;
	private JTextField email;
	private JTextField login;
	private JTextArea adress;
	private JPasswordField pwd;
	private JList list ;

	public UserLogin()
	{
		// NOTE: to reduce the amount of code in this example, it uses
		// panels with a NULL layout.  This is NOT suitable for
		// production code since it may not display correctly for
		// a look-and-feel.
		
		setTitle( "Tabbed Pane Application" );
		setSize( 800, 500 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();
	

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Connexion", panelConnexion );
		tabbedPane.addTab( "Demande d'inscription", panelInscription );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
	}

	public void createPage1()
	{
		panelConnexion = new JPanel();
		panelConnexion.setLayout( null );

		u = new JLabel("Username");
		p = new JLabel("Password");

		uname = new JTextField(20);
		pass = new JPasswordField(20);

		loginB = new JButton("Login");
		cancel = new JButton("Cancel");
		

		u.setBounds( 22, 35, 150, 20 );
		panelConnexion.add( u );

		
		uname.setBounds( 186, 35, 150, 20 );
		panelConnexion.add( uname );

		
		p.setBounds( 362, 35, 150, 20 );
		panelConnexion.add(p);

		pass = new JPasswordField();
		pass.setBounds( 511, 35, 150, 20 );
		panelConnexion.add( pass );
		
		
		loginB.setBounds( 10,100, 308, 20 );
		panelConnexion.add( loginB );
		cancel.setBounds( 328,100, 300, 20 );
		panelConnexion.add( cancel );
		
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String un = uname.getText();
				String pa = new String(pass.getPassword());
				SuperAdmin u = new SuperAdmin();
				u.setLogin(un);
				u.setPassword(pa);
				Client u1 = new Client();
				u1.setLogin(un);
				u1.setPassword(pa);
				SuperAdmin admin = (SuperAdmin) UserServiceDelegate.getProxy().auth(u);
				Client client=(Client) UserServiceDelegate.getProxy().auth(u1);
				if ( admin!= null){
					VariableSession.getInstance().setCurrentUser(admin);
					dispose();
					 new FrameWelcome();
					 
				} else if ( client != null) {
					VariableSession.getInstance().setCurrentUser(client);
					dispose();
					 new FrameWelcome();
				} else {

					JOptionPane optionPane = new JOptionPane("Mdp inccorect ou nom utilisateur inccorect",
							JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
			}
		});

		KeyAdapter k = new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER)
					loginB.doClick();
			}
		};

		pass.addKeyListener(k);
		uname.addKeyListener(k);

		
	}

	public void createPage2()
	{
		panelInscription = new JPanel();
		panelInscription.setLayout( null );
		

		nom = new JTextField();
		nom.setBounds(343, 112, 143, 20);		
		panelInscription.add(nom);
		
		JLabel lblName = new JLabel("Nom:");
		lblName.setBounds(301, 126, 46, 14);
		panelInscription.add(lblName);
		
		
		
		JButton demande = new JButton("Envoyer Votre Demande");
		demande.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				/***********************/
				ShopOwner u=new ShopOwner();
				
				
				u.setNom(nom.getText());
				u.setEmail(email.getText());
				u.setLogin(login.getText());
				u.setAdresse(adress.getText());
				u.setTel(tel.getText());
				u.setPrenom(prenom.getText());				
				u.setLogin(login.getText());			
				
				
				u.setPassword(new String(pwd.getPassword()));
				
				/***********************/
				u.setApprouver("en attente");
				u.setDemande(true);
					System.out.println(list.getSelectedValue().toString());
					u.setSecteurActiviter((SecteurActivite) CommanServiceDelegate.getProxy().findById(new SecteurActivite(), "libelle", "'"+list.getSelectedValue().toString()+"'"));
				UserServiceDelegate.getProxy().create(u);
				
				
				clearTextFieldsS();
				
				
				JOptionPane optionPane = new JOptionPane("Votre Demande à était Bient envoyer",
						JOptionPane.YES_OPTION);
				JDialog dialog = optionPane.createDialog("Warning!");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
		
				
			}
		});
		demande.setBounds(231, 321, 89, 23);
		panelInscription.add(demande);
		
		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setBounds(88, 126, 46, 14);
		panelInscription.add(lblPrnom);
		
		JLabel lblTl = new JLabel("Tél");
		lblTl.setBounds(301, 167, 46, 14);
		panelInscription.add(lblTl);
		
		prenom = new JTextField();
		prenom.setBounds(144, 123, 134, 20);
		panelInscription.add(prenom);
		
		
		tel = new JTextField();
		tel.setBounds(343, 164, 143, 20);
		panelInscription.add(tel);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(88, 167, 46, 14);
		panelInscription.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(144, 164, 134, 20);
		panelInscription.add(email);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(88, 69, 46, 14);
		panelInscription.add(lblLogin);
		
			login = new JTextField();
		login.setBounds(144, 66, 134, 20);
		
		panelInscription.add(login);
		
		JLabel lblPwd = new JLabel("Pwd");
		lblPwd.setBounds(301, 69, 46, 14);
		panelInscription.add(lblPwd);
		
		pwd = new JPasswordField();
		pwd.setBounds(343, 66, 143, 20);
		panelInscription.add(pwd);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(187, 228, 46, 14);
		panelInscription.add(lblAdresse);
		
		adress = new JTextArea();
		adress.setBounds(258, 203, 183, 76);
		panelInscription.add(adress);
		
		
		DefaultListModel modelList =  new DefaultListModel();
		
		ArrayList<SecteurActivite> secteurActivites=CommanServiceDelegate.getProxy().findAll(new SecteurActivite());
		for (int i = 0; i < secteurActivites.size(); i++) {
			modelList.addElement(secteurActivites.get(i).getLibelle());
				
		}
	
		list = new JList(modelList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setBounds(10, 180, 122, 95);
		panelInscription.add(list);
		/*********************************************************/	

	}

	public void clearTextFieldsS (){

		

		
		 nom.setText("");
		 prenom.setText("");
		 tel.setText("");
		 login.setText("");
		 pwd.setText("");
		 email.setText("");
		 adress.setText("");
		 
	}
	
    // Main method to get things started
	public static void main( String args[] )
	{
		// Create an instance of the test application
		UserLogin mainFrame	= new UserLogin();
		mainFrame.setVisible( true );
	}
}