package com.swing.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.esprit.entity.Categorie;
import com.esprit.entity.Commande;
import com.esprit.entity.Produit;
import com.esprit.entity.Prouduit_Commande;
import com.esprit.entity.SecteurActivite;

//import com.swing.luncher.FrameMenu;

import com.swing.modelData.ModelCategorie;
import com.swing.modelData.ModelCommander;

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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

public class FrameComander extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTable table;
	private ModelCommander modele;
	private JTextField quantiter;
	
	private JList list;
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
	
	public FrameComander(JMenuBar jMenuBar) {
		setTitle("Commander");
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
		id.setEnabled(false);
		id.setBounds(209, 154, 40, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton Add = new JButton("Commander");
		
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/***********************/
			   Prouduit_Commande u=new Prouduit_Commande();
				
				
				if(!id.getText().isEmpty()&&id.getText().equals(""))
				u.setQuantite(quantiter.getText());
				
				/***********************/
				u.setProduitId((long) CommanServiceDelegate.getProxy().findById(new Produit(),"id","'"+list.getSelectedValue().toString()+"'"));

				
				CommanServiceDelegate.getProxy().create(u);

				clearTextFieldsS();
				table.setModel(new ModelCommander());
				
			//	UserServiceDelagate.getProxy().deleteUser(user);
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		
		
		
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Add.setBounds(190, 236, 115, 23);
		contentPane.add(Add);
		
		JButton Remove = new JButton("Remove");
		Remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Prouduit_Commande u=new Prouduit_Commande();
				
				CommanServiceDelegate.getProxy().delete(new Prouduit_Commande(),"id",u.getCommandeId()+"");
				clearTextFieldsS();
				
				table.clearSelection();
				table.setModel(new ModelCommander());
				
				
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		Remove.setBounds(304, 236, 89, 23);
		contentPane.add(Remove);
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				/***********************/
				Prouduit_Commande u = new Prouduit_Commande();
				
				
				
								/***********************/
				
				u.setProduitId(  (long) CommanServiceDelegate.getProxy().findById(new Produit(),"id","'"+list.getSelectedValue().toString()+"'"));

				
				CommanServiceDelegate.getProxy().update(u);
				
				
				clearTextFieldsS();
				table.setModel(new ModelCommander());
				
		
				
			}
		});
		Update.setBounds(390, 236, 89, 23);
		contentPane.add(Update);
		
		modele= new ModelCommander() ;
		table = new JTable(modele);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 11, 622, 104);
		contentPane.add(scrollPane);
		
		JLabel lblPrnom = new JLabel("quantiter");
		lblPrnom.setBounds(262, 157, 46, 14);
		contentPane.add(lblPrnom);
		
		quantiter = new JTextField();
		quantiter.setBounds(318, 154, 86, 20);
		contentPane.add(quantiter);
		quantiter.setColumns(10);
		
		
	/*****************************************************/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int row = table.getSelectedRow();

				 id.setText( table.getValueAt(row, 0).toString());
				 
				 //libelle.setText(table.getValueAt(row, 1).toString());

				 //description.setText(table.getValueAt(row, 2).toString());
			} 
		});
	/*********************************************************/	
		
	DefaultListModel modelList =  new DefaultListModel();
		ArrayList<Prouduit_Commande>commandes=CommanServiceDelegate.getProxy().findAll(new Prouduit_Commande());
		for (int i = 0; i < commandes.size(); i++) {
			modelList.addElement(commandes.get(i).getCommandeId());
				
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
	
		// libelle.setText("");
		 
		// description.setText("");
		 
	}
	}
