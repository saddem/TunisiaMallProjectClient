package com.swing.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.esprit.entity.Categorie;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.SousCategorie;

//import com.swing.luncher.FrameMenu;

import com.swing.modelData.ModelSousCategorie;
import com.swing.variableSession.VariableSession;

import delegate.CommanServiceDelegate;
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
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

public class FrameSousCategorie extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTable table;
	private ModelSousCategorie modele;
	private JTextField libelle;
	private JTextArea description;
	private JList list;
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
	
	public FrameSousCategorie(JMenuBar jMenuBar) {
		setTitle("Sous Categorie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 335);
		setJMenuBar(jMenuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(159, 157, 40, 14);
		contentPane.add(lblId);
		
		id = new JTextField();
		id.setBounds(209, 154, 40, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton Add = new JButton("Add");
		
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/***********************/
			
				SousCategorie u=new SousCategorie();
				if(!id.getText().isEmpty()&&id.getText().equals(""))
				u.setId(Integer.parseInt(id.getText()));
		
	
				u.setDescription(description.getText());
		
				u.setLibelle(libelle.getText());	
				u.setShopOwner((ShopOwner)VariableSession.getCurrentUser());
				
				/***********************/
				System.out.println(list.getSelectedValue().toString());
				u.setCategorie((Categorie) CommanServiceDelegate.getProxy().findById(new Categorie(), "libelle", "'"+list.getSelectedValue().toString()+"'"));

				
				CommanServiceDelegate.getProxy().create(u);

				clearTextFieldsS();
				table.setModel(new ModelSousCategorie());
				
			//	UserServiceDelagate.getProxy().deleteUser(user);
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		
		
		
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Add.setBounds(216, 236, 89, 23);
		contentPane.add(Add);
		
		JButton Remove = new JButton("Remove");
		Remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Categorie u=new Categorie();
				u.setId(Integer.parseInt(id.getText()));
				

				
				CommanServiceDelegate.getProxy().delete(new SousCategorie(),"id",u.getId()+"");
				clearTextFieldsS();
				
				table.clearSelection();
				table.setModel(new ModelSousCategorie());
				
				
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		Remove.setBounds(304, 236, 89, 23);
		contentPane.add(Remove);
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				/***********************/
				SousCategorie u=new SousCategorie();
				u.setId(Integer.parseInt(id.getText()));
		
	
				u.setDescription(description.getText());
		
				u.setLibelle(libelle.getText());				
				
				
								/***********************/
				
				u.setCategorie((Categorie) CommanServiceDelegate.getProxy().findById(new Categorie(), "libelle", "'"+list.getSelectedValue().toString()+"'"));

				
				CommanServiceDelegate.getProxy().update(u);
				
				
				clearTextFieldsS();
				table.setModel(new ModelSousCategorie());
				
		
				
			}
		});
		Update.setBounds(390, 236, 89, 23);
		contentPane.add(Update);
		
		modele= new ModelSousCategorie() ;
		table = new JTable(modele);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 11, 622, 104);
		contentPane.add(scrollPane);
		
		JLabel lblPrnom = new JLabel("Libelle");
		lblPrnom.setBounds(262, 157, 46, 14);
		contentPane.add(lblPrnom);
		
		libelle = new JTextField();
		libelle.setBounds(318, 154, 86, 20);
		contentPane.add(libelle);
		libelle.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Description");
		lblAdresse.setBounds(414, 157, 65, 14);
		contentPane.add(lblAdresse);
		
		description = new JTextArea();
		description.setBounds(503, 151, 139, 77);
		contentPane.add(description);
	/*****************************************************/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int row = table.getSelectedRow();

				 id.setText( table.getValueAt(row, 0).toString());

				 libelle.setText(table.getValueAt(row, 1).toString());

				 description.setText(table.getValueAt(row, 2).toString());
			} 
		});
	/*********************************************************/	
		
	DefaultListModel modelList =  new DefaultListModel();
		
		ArrayList<Categorie> categorie=CommanServiceDelegate.getProxy().findAll(new Categorie());
		for (int i = 0; i < categorie.size(); i++) {
			modelList.addElement(categorie.get(i).getLibelle());
				
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 126, 133, 148);
		contentPane.add(scrollPane_1);
		
			list = new JList(modelList);
			scrollPane_1.setViewportView(list);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setSelectedIndex(0);
		
	}
	
	public void clearTextFieldsS (){

		

		 id.setText("");
	
		 libelle.setText("");
		 description.setText("");
		 
	}
	}
