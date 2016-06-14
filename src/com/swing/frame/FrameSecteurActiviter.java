package com.swing.frame;


import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.esprit.entity.SecteurActivite;

//import com.swing.luncher.FrameMenu;

import com.swing.modelData.ModelSecteurActiviter;

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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

public class FrameSecteurActiviter extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTable table;
	private ModelSecteurActiviter modele;
	private JTextField libelle;
	private JTextArea description;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
//	
	public FrameSecteurActiviter(JMenuBar jMenuBar) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 335);
		setJMenuBar(jMenuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(57, 157, 46, 14);
		contentPane.add(lblId);
		
		id = new JTextField();
		id.setBounds(80, 154, 40, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton Add = new JButton("Add");
		
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/***********************/
			
				SecteurActivite u=new SecteurActivite();
				if(!id.getText().isEmpty()&&id.getText().equals(""))
				u.setId(Integer.parseInt(id.getText()));
		
	
				u.setDescription(description.getText());
		
				u.setLibelle(libelle.getText());				
				
				/***********************/
				
				CommanServiceDelegate.getProxy().create(u);

				clearTextFieldsS();
				table.setModel(new ModelSecteurActiviter());
				
			//	UserServiceDelagate.getProxy().deleteUser(user);
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		
		
		
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Add.setBounds(160, 240, 89, 23);
		contentPane.add(Add);
		
		JButton Remove = new JButton("Remove");
		Remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SecteurActivite u=new SecteurActivite();
				u.setId(Integer.parseInt(id.getText()));
				

				
				CommanServiceDelegate.getProxy().delete(new SecteurActivite(),"id",u.getId()+"");
				clearTextFieldsS();
				
				table.clearSelection();
				table.setModel(new ModelSecteurActiviter());
				
				
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		Remove.setBounds(248, 240, 89, 23);
		contentPane.add(Remove);
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				/***********************/
				SecteurActivite u=new SecteurActivite();
				u.setId(Integer.parseInt(id.getText()));
		
	
				u.setDescription(description.getText());
		
				u.setLibelle(libelle.getText());				
				
				
								/***********************/
				
				
				
				CommanServiceDelegate.getProxy().update(u);
				
				
				clearTextFieldsS();
				table.setModel(new ModelSecteurActiviter());
				
		
				
			}
		});
		Update.setBounds(334, 240, 89, 23);
		contentPane.add(Update);
		
		modele= new ModelSecteurActiviter() ;
		table = new JTable(modele);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 11, 622, 104);
		contentPane.add(scrollPane);
		
		JLabel lblPrnom = new JLabel("Libelle");
		lblPrnom.setBounds(156, 157, 46, 14);
		contentPane.add(lblPrnom);
		
		libelle = new JTextField();
		libelle.setBounds(232, 153, 86, 20);
		contentPane.add(libelle);
		libelle.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Description");
		lblAdresse.setBounds(328, 157, 65, 14);
		contentPane.add(lblAdresse);
		
		description = new JTextArea();
		description.setBounds(411, 151, 139, 77);
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
		
	
	}
	
	public void clearTextFieldsS (){

		

		 id.setText("");
	
		 libelle.setText("");
		 description.setText("");
		 
	}
	


	}
