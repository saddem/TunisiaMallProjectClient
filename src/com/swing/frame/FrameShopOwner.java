package com.swing.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.esprit.entity.Boutique;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.Utilisateur;

import com.swing.modelData.ModelAdministrateur;
import com.swing.modelData.ModelShopOwner;

import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class FrameShopOwner extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField nom;
	private JTable table;
	private ModelShopOwner modele;
	private JTextField prenom;
	private JTextField tel;
	private JTextField email;
	private JTextField login;
	private JTextArea adress;
	private JPasswordField pwd;
	private DefaultListModel modelListBoutique;
	private JList listBoutique;
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
	public FrameShopOwner(JMenuBar jMenuBar) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 433);
		//setJMenuBar(new FrameMenu().Menu());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setJMenuBar(jMenuBar);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(57, 157, 46, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(80, 154, 40, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(423, 154, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		JLabel lblName = new JLabel("Nom:");
		lblName.setBounds(350, 157, 46, 14);
		contentPane.add(lblName);
		
		JButton Add = new JButton("Add");
		
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/***********************/
				ShopOwner u=new ShopOwner();
				u.setId(Integer.parseInt(textField.getText()));
		
				u.setNom(nom.getText());
				u.setEmail(email.getText());
				u.setLogin(login.getText());
				u.setAdresse(adress.getText());
				u.setTel(tel.getText());
				u.setPrenom(prenom.getText());				
				u.setLogin(login.getText());			
				
				u.setPassword(new String(pwd.getPassword()));
				
				/***********************/
				
				UserServiceDelegate.getProxy().create(u);

				clearTextFieldsS();
				table.setModel(new ModelShopOwner());
				
			//	UserServiceDelagate.getProxy().deleteUser(user);
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		
		
		
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Add.setBounds(57, 321, 89, 23);
		contentPane.add(Add);
		
		JButton Remove = new JButton("Remove");
		Remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Utilisateur u=new Utilisateur();
				u.setId(Integer.parseInt(textField.getText()));
				
				u.setNom(nom.getText());
				
				UserServiceDelegate.getProxy().delete(new ShopOwner(),"id",u.getId()+"");
				clearTextFieldsS();
				
				table.clearSelection();
				table.setModel(new ModelShopOwner());
				
				
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		Remove.setBounds(145, 321, 89, 23);
		contentPane.add(Remove);
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				/***********************/
				ShopOwner u=new ShopOwner();
				u.setId(Integer.parseInt(textField.getText()));
		
				u.setNom(nom.getText());
				u.setEmail(email.getText());
				u.setLogin(login.getText());
				u.setAdresse(adress.getText());
				u.setTel(tel.getText());
				u.setPrenom(prenom.getText());				
				u.setLogin(login.getText());			
				
				
				u.setPassword(new String(pwd.getPassword()));
				
				/***********************/
				
				
				Utilisateur u2= new Utilisateur();
				u2=(Utilisateur) UserServiceDelegate.getProxy().findById(new ShopOwner(), "id",textField.getText() );
			
				u.setEnabled(u2.isEnabled());
				UserServiceDelegate.getProxy().update(u);
				
				
				clearTextFieldsS();
				table.setModel(new ModelShopOwner());
				
		
				
			}
		});
		Update.setBounds(231, 321, 89, 23);
		contentPane.add(Update);
		
		modele= new ModelShopOwner() ;
		table = new JTable(modele);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 11, 622, 104);
		contentPane.add(scrollPane);
		
		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setBounds(156, 157, 46, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblTl = new JLabel("Tél");
		lblTl.setBounds(209, 239, 46, 14);
		contentPane.add(lblTl);
		
		prenom = new JTextField();
		prenom.setBounds(232, 153, 86, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		tel = new JTextField();
		tel.setBounds(246, 236, 86, 20);
		contentPane.add(tel);
		tel.setColumns(10);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(57, 239, 46, 14);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(105, 236, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(80, 126, 46, 14);
		contentPane.add(lblLogin);
		
		login = new JTextField();
		login.setBounds(145, 126, 134, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		JButton btnEnableDisableAccount = new JButton("Enable/disable");
		btnEnableDisableAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//1111
				textField.getText();
				ShopOwner u= new ShopOwner();
				u=(ShopOwner) UserServiceDelegate.getProxy().findById(new ShopOwner(), "id",textField.getText() );
				if (u.isEnabled()){
					u.setEnabled(false);
				}else{
					u.setEnabled(true);
				}
				UserServiceDelegate.getProxy().update((ShopOwner)u);
				
				
				clearTextFieldsS();
				table.setModel(new ModelShopOwner());
			}
		});
		btnEnableDisableAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEnableDisableAccount.setBounds(324, 321, 110, 23);
		contentPane.add(btnEnableDisableAccount);
		
		JLabel lblPwd = new JLabel("Pwd");
		lblPwd.setBounds(288, 129, 46, 14);
		contentPane.add(lblPwd);
		
		pwd = new JPasswordField();
		pwd.setBounds(313, 126, 118, 20);
		contentPane.add(pwd);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(337, 239, 46, 14);
		contentPane.add(lblAdresse);
		
		adress = new JTextArea();
		adress.setBounds(393, 214, 139, 77);
		contentPane.add(adress);
		
		JButton buttonAprouver = new JButton("Approuver et enabled");
		buttonAprouver.setBounds(443, 321, 110, 23);
		contentPane.add(buttonAprouver);
		
		
		buttonAprouver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//1111
				textField.getText();
				ShopOwner u= new ShopOwner();
				u=(ShopOwner) UserServiceDelegate.getProxy().findById(new ShopOwner(), "id",textField.getText() );
			
				Boutique u2= new Boutique();
				u2=(Boutique) CommanServiceDelegate.getProxy().findById(new Boutique(), "num",table.getValueAt(table.getSelectedRow(), 11).toString() );
				u2.setEtat("loué");
				CommanServiceDelegate.getProxy().update(u2);
				
				u.setEnabled(true);
					u.setApprouver("OK");
				UserServiceDelegate.getProxy().update((ShopOwner)u);
				
				
				clearTextFieldsS();
				table.setModel(new ModelShopOwner());
				table.clearSelection();
			}
		});
	/*****************************************************/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int row = table.getSelectedRow();

				 textField.setText( table.getValueAt(row, 0).toString());
				 nom.setText(table.getValueAt(row, 1).toString());
				 prenom.setText(table.getValueAt(row, 2).toString());
				 tel.setText(table.getValueAt(row, 3).toString());
				 login.setText(table.getValueAt(row, 4).toString());
				 pwd.setText(table.getValueAt(row, 5).toString());
				 email.setText(table.getValueAt(row, 6).toString());
				 adress.setText(table.getValueAt(row, 7).toString());
			} 
		});
	/*********************************************************/	
		
		/*********************************************************/	
		//il faut charger les boutique  vides seulement
	/*	 modelListBoutique =  new DefaultListModel();
			
		ArrayList<Boutique> boutiques=CommanServiceDelegate.getProxy().findAll(new Boutique());
		for (int i = 0; i < boutiques.size(); i++) {
			modelListBoutique.addElement(boutiques.get(i).getNum());
				
		}
		listBoutique= new JList(modelListBoutique);
		
		contentPane.add(listBoutique);*/
		
	}
	
	public void clearTextFieldsS (){

		

		 textField.setText("");
		 nom.setText("");
		 prenom.setText("");
		 tel.setText("");
		 login.setText("");
		 pwd.setText("");
		 email.setText("");
		 adress.setText("");
		 
	}
	}
