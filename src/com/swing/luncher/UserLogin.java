package com.swing.luncher;

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
import com.esprit.entity.Boutique;
import com.esprit.entity.Client;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.swing.luncher.FrameWelcome;
import com.swing.variableSession.VariableSession;

import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;

class UserLogin extends JFrame {
	private JTabbedPane tabbedPane;
	private JPanel panelConnexion;
	private JPanel panelInscription;
	private JPanel panelInscriptionClient;

	JButton loginB, cancel;
	JTextField uname;
	JPasswordField pass;
	JLabel u, p;

	private JTextField nom;
	private JTextField nomClient;
	private JTextField prenom;
	private JTextField prenomClient;
	private JTextField tel;
	private JTextField telClient;
	private JTextField email;
	private JTextField emailClient;
	private JTextField login;
	private JTextField loginClient;
	private JTextArea adress;
	private JTextArea adressClient;
	private JPasswordField pwd;
	private JPasswordField pwdClient;
	private JList listSecteurActivite;

	private JScrollPane scrollPane;
	private DefaultListModel modelListSecteurActivite;
	private DefaultListModel modelListBoutique;
	private JScrollPane scrollPane_1;
	private JList listBoutique;

	public UserLogin() {
		// NOTE: to reduce the amount of code in this example, it uses
		// panels with a NULL layout. This is NOT suitable for
		// production code since it may not display correctly for
		// a look-and-feel.

		setTitle("Bienvenu au tunisia mall version test 1.0");
		setSize(800, 500);
		setBackground(Color.gray);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Connexion", panelConnexion);
		tabbedPane.addTab("Demande d'inscription Shop Owner", panelInscription);
		tabbedPane.addTab("Demande d'inscription Client", panelInscriptionClient);
		
		JLabel lblPwd_1 = new JLabel("Pwd:");
		lblPwd_1.setBounds(301, 69, 46, 14);
		panelInscriptionClient.add(lblPwd_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 203, 128, 130);
		panelInscription.add(scrollPane);
		modelListSecteurActivite = new DefaultListModel();

		ArrayList<SecteurActivite> secteurActivites = CommanServiceDelegate.getProxy().findAll(new SecteurActivite());
		for (int i = 0; i < secteurActivites.size(); i++) {
			modelListSecteurActivite.addElement(secteurActivites.get(i).getLibelle());

		}
		listSecteurActivite = new JList(modelListSecteurActivite);
		scrollPane.setViewportView(listSecteurActivite);
		listSecteurActivite.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSecteurActivite.setSelectedIndex(0);

		System.out.println(secteurActivites.size());

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(558, 203, 143, 147);
		panelInscription.add(scrollPane_1);

		listBoutique = new JList(modelListBoutique);
		scrollPane_1.setViewportView(listBoutique);
		topPanel.add(tabbedPane, BorderLayout.CENTER);
	}

	public void createPage1() {
		panelConnexion = new JPanel();
		panelConnexion.setLayout(null);

		u = new JLabel("Username");
		p = new JLabel("Password");

		uname = new JTextField(20);
		pass = new JPasswordField(20);

		loginB = new JButton("Login");
		cancel = new JButton("Cancel");

		u.setBounds(22, 35, 150, 20);
		panelConnexion.add(u);

		uname.setBounds(186, 35, 150, 20);
		panelConnexion.add(uname);

		p.setBounds(362, 35, 150, 20);
		panelConnexion.add(p);

		pass = new JPasswordField();
		pass.setBounds(511, 35, 150, 20);
		panelConnexion.add(pass);

		loginB.setBounds(10, 100, 308, 20);
		panelConnexion.add(loginB);
		cancel.setBounds(328, 100, 300, 20);
		panelConnexion.add(cancel);

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

				ShopOwner u2 = new ShopOwner();
				u2.setLogin(un);
				u2.setPassword(pa);

				SuperAdmin superAdmin = (SuperAdmin) UserServiceDelegate.getProxy().auth(u);
				Client client = (Client) UserServiceDelegate.getProxy().auth(u1);
				ShopOwner shopOwner = (ShopOwner) UserServiceDelegate.getProxy().auth(u2);

				if (superAdmin != null) {
					VariableSession.getInstance().setCurrentUser(superAdmin);
					dispose();
					new FrameWelcome();

				} else if (client != null) {
					VariableSession.getInstance().setCurrentUser(client);
					dispose();
					new FrameWelcomeClient();
				} else if (shopOwner != null) {
					VariableSession.getInstance().setCurrentUser(shopOwner);
					dispose();
					new FrameWelcomeShopOwner();

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

	public void createPage2() {
		panelInscription = new JPanel();
		panelInscription.setLayout(null);

		nom = new JTextField();
		nom.setBounds(343, 112, 143, 20);
		panelInscription.add(nom);

		JLabel lblName = new JLabel("Nom:");
		lblName.setBounds(301, 126, 46, 14);
		panelInscription.add(lblName);

		JButton demande = new JButton("Envoyer Votre Demande");
		demande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		demande.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				/***********************/
				ShopOwner u = new ShopOwner();

				u.setNom(nom.getText());
				u.setEmail(email.getText());
				u.setLogin(login.getText());
				u.setAdresse(adress.getText());
				u.setTel(tel.getText());
				u.setPrenom(prenom.getText());

				u.setPassword(new String(pwd.getPassword()));

			
				u.setApprouver("en attente");
				u.setDemande(true);
				
				SuperAdmin u2 = new SuperAdmin();
				/***********************/
				u2.setLogin(login.getText());
				u2.setPassword(new String(pwd.getPassword()));

				/***********************/
				
				Client u3 = new Client();

				u3.setLogin(login.getText());
				u3.setPassword(new String(pwd.getPassword()));

				/***********************/
				
			
				u.setDemande(true);

				SuperAdmin superAdmin = (SuperAdmin) UserServiceDelegate.getProxy().auth(u2);
				Client client = (Client) UserServiceDelegate.getProxy().auth(u);
				ShopOwner shopOwner = (ShopOwner) UserServiceDelegate.getProxy().auth(u);
				
				if((client!=null)||(shopOwner!=null)||(superAdmin!=null)){
					
					JOptionPane optionPane = new JOptionPane("Login Invalide", JOptionPane.NO_OPTION);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					
				}else{
					
				
				//	MailDelegate.getProxy().msg(u.getEmail(), "Demande Shop Owner", "MR : "+u.getNom()+" "+u.getPrenom()+" veut loué Numéro:" + u.getBoutique().getNum());
				u.setSecteurActiviter((SecteurActivite) CommanServiceDelegate.getProxy().findById(new SecteurActivite(),
						"libelle", "'" + listSecteurActivite.getSelectedValue().toString() + "'"));

				u.setBoutique((Boutique) CommanServiceDelegate.getProxy().findById(new Boutique(), "num",
						"'" + listBoutique.getSelectedValue().toString() + "'"));

				System.out.println("U login" + login.getText() + u.getLogin());

				UserServiceDelegate.getProxy().create(u);

				clearTextFieldsS();

				JOptionPane optionPane = new JOptionPane("Votre Demande à était Bient envoyer", JOptionPane.YES_OPTION);
				JDialog dialog = optionPane.createDialog("OK!");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				
				}

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

		/*********************************************************/
		// il faut charger les boutique vides seulement
		modelListBoutique = new DefaultListModel();

		ArrayList<Boutique> boutiques = CommanServiceDelegate.getProxy().findAll(new Boutique());
		for (int i = 0; i < boutiques.size(); i++) {
			modelListBoutique.addElement(boutiques.get(i).getNum());

		}
		listBoutique = new JList(modelListBoutique);
	}

	public void createPage3() {
		panelInscriptionClient = new JPanel();
		panelInscriptionClient.setLayout(null);

		nomClient = new JTextField();
		nomClient.setBounds(343, 112, 143, 20);
		panelInscriptionClient.add(nomClient);

		JLabel lblName = new JLabel("Nom:");
		lblName.setBounds(301, 126, 46, 14);
		panelInscriptionClient.add(lblName);

		JButton demande = new JButton("Enregistre");
		demande.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				/***********************/
				Client u = new Client();

				u.setNom(nom.getText());
				u.setEmail(email.getText());
				u.setLogin(login.getText());
				u.setAdresse(adress.getText());
				u.setTel(tel.getText());
				u.setPrenom(prenom.getText());
				u.setLogin(login.getText());

				u.setPassword(new String(pwd.getPassword()));
				u.setEnabled(true);

				UserServiceDelegate.getProxy().create(u);

				clearTextFieldsS();

				JOptionPane optionPane = new JOptionPane("Votre Demande à était Bient envoyer", JOptionPane.YES_OPTION);
				JDialog dialog = optionPane.createDialog("Warning!");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);

			}
		});
		demande.setBounds(231, 321, 89, 23);
		panelInscriptionClient.add(demande);

		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setBounds(88, 126, 46, 14);
		panelInscriptionClient.add(lblPrnom);

		JLabel lblTl = new JLabel("Tél");
		lblTl.setBounds(301, 167, 46, 14);
		panelInscriptionClient.add(lblTl);

		prenomClient = new JTextField();
		prenomClient.setBounds(144, 123, 134, 20);
		panelInscriptionClient.add(prenomClient);

		telClient = new JTextField();
		telClient.setBounds(343, 164, 143, 20);
		panelInscriptionClient.add(telClient);

		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(88, 167, 46, 14);
		panelInscriptionClient.add(lblEmail);

		emailClient = new JTextField();
		emailClient.setBounds(144, 164, 134, 20);
		panelInscriptionClient.add(emailClient);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(88, 69, 46, 14);
		panelInscriptionClient.add(lblLogin);

		loginClient = new JTextField();
		loginClient.setBounds(144, 66, 134, 20);

		panelInscriptionClient.add(loginClient);

		JLabel lblPwd = new JLabel("Pwd");
		lblPwd.setBounds(301, 69, 46, 14);
		panelInscription.add(lblPwd);

		pwdClient = new JPasswordField();
		pwdClient.setBounds(343, 66, 143, 20);
		panelInscriptionClient.add(pwdClient);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(187, 228, 46, 14);
		panelInscriptionClient.add(lblAdresse);

		adressClient = new JTextArea();
		adressClient.setBounds(258, 203, 183, 76);
		panelInscriptionClient.add(adressClient);

		modelListSecteurActivite = new DefaultListModel();

	}

	public void clearTextFieldsS() {

		nomClient.setText("");
		prenomClient.setText("");
		telClient.setText("");
		loginClient.setText("");
		pwdClient.setText("");
		emailClient.setText("");
		adressClient.setText("");

	}

	// Main method to get things started
	public static void main(String args[]) {
		// Create an instance of the test application
		UserLogin mainFrame = new UserLogin();
		mainFrame.setVisible(true);
	}
}