package com.swing.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.esprit.entity.Categorie;
import com.esprit.entity.Evenement;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.SousCategorie;
import com.swing.modelData.ModelEvenement;

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
import com.toedter.calendar.JDateChooser;

public class FrameEvenement extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTable table;
	private ModelEvenement modele;
	private JTextArea description;
	private JList list;
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
	
	public FrameEvenement(JMenuBar jMenuBar) {
		
		setTitle("Evenement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 444);
		setJMenuBar(jMenuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 154, 40, 14);
		contentPane.add(lblId);
		
		id = new JTextField();
		id.setBounds(39, 151, 40, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton Add = new JButton("Add");
		JDateChooser date_debut = new JDateChooser();
		date_debut.setBounds(168, 154, 115, 26);
		contentPane.add(date_debut);
		
		JDateChooser date_fin = new JDateChooser();
		date_fin.setBounds(342, 154, 115, 26);
		contentPane.add(date_fin);
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/***********************/
			
				Evenement u=new Evenement();
				if(!id.getText().isEmpty()&&id.getText().equals(""))
				u.setId(Integer.parseInt(id.getText()));
		
	
				u.setDescription(description.getText());
				u.setDateDebut(date_debut.getDate());
				u.setDateFin(date_fin.getDate());
		
				
				/***********************/
			
				
				CommanServiceDelegate.getProxy().create(u);

				clearTextFieldsS();
				table.setModel(new ModelEvenement());
				
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
				

				
				CommanServiceDelegate.getProxy().delete(new Evenement(),"id",u.getId()+"");
				clearTextFieldsS();
				
				table.clearSelection();
				table.setModel(new ModelEvenement());
				
				
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		Remove.setBounds(304, 236, 89, 23);
		contentPane.add(Remove);
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				/***********************/
				Evenement u=new Evenement();
				u.setId(Integer.parseInt(id.getText()));
		
	
				u.setDescription(description.getText());
				u.setDateDebut(date_debut.getDate());
				u.setDateFin(date_fin.getDate());
				
								/***********************/
				

				
				CommanServiceDelegate.getProxy().update(u);
				
				
				clearTextFieldsS();
				table.setModel(new ModelEvenement());
				
		
				
			}
		});
		Update.setBounds(390, 236, 89, 23);
		contentPane.add(Update);
		
		modele= new ModelEvenement() ;
		table = new JTable(modele);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 11, 622, 104);
		contentPane.add(scrollPane);
		
		JLabel lblPrnom = new JLabel("Date Debut");
		lblPrnom.setBounds(93, 154, 89, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblAdresse = new JLabel("Description");
		lblAdresse.setBounds(458, 154, 89, 14);
		contentPane.add(lblAdresse);
		
		description = new JTextArea();
		description.setBounds(544, 153, 139, 77);
		contentPane.add(description);
		
		JLabel lblDateFin = new JLabel("Date Fin");
		lblDateFin.setBounds(289, 154, 89, 14);
		contentPane.add(lblDateFin);
		

	/*****************************************************/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = table.getSelectedRow();
				 id.setText( table.getValueAt(row, 0).toString());
				 date_debut.setDate((Date) table.getValueAt(row, 2));
				 date_fin.setDate((Date) table.getValueAt(row, 2));
				 description.setText(table.getValueAt(row, 3).toString());
			} 
		});
		
	}
	
	public void clearTextFieldsS (){

		

		 id.setText("");
		 description.setText("");
		 
	}
	}
