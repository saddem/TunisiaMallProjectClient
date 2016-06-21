package com.swing.frame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.esprit.entity.Boutique;
import com.swing.modelData.ModelBoutique;

import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.Component;

public class FrameBoutique extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ModelBoutique modele;
	private JTextField tel;
	private JTextField localisation;
	private JList list ;
	private JTextField libelleboutique;
	private JTextField textField;

	public FrameBoutique(JMenuBar jMenuBar) {
		setTitle("Boutique");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setJMenuBar(jMenuBar);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton Add = new JButton("Add");
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Boutique u=new Boutique();
				u.setEtat(list.getSelectedValue().toString());
				u.setLibelle(libelleboutique.getText());
				u.setNum(Integer.parseInt(localisation.getText()));
				u.setTel(tel.getText());
				CommanServiceDelegate.getProxy().create(u);
				clearTextFieldsS();
				table.setModel(new ModelBoutique());

			}
		});
		
		
		
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Add.setBounds(142, 289, 89, 23);
		contentPane.add(Add);
		
		JButton Remove = new JButton("Remove");
		Remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				CommanServiceDelegate.getProxy().delete(new Boutique(),"id",textField.getText()+"");
				clearTextFieldsS();
				table.clearSelection();
				table.setModel(new ModelBoutique());
			}
		});
		Remove.setBounds(230, 289, 89, 23);
		contentPane.add(Remove);
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
                Boutique u=new Boutique();
				
				u.setNum(Integer.parseInt(localisation.getText()));
				u.setTel(tel.getText());
				u.setLibelle(libelleboutique.getText());

				Boutique u2=new Boutique();
				u2=(Boutique) CommanServiceDelegate.getProxy().findById(new Boutique(), "id",textField.getText() );
				u.setEtat( list.getSelectedValue().toString());
				u.setId(u2.getId());
				CommanServiceDelegate.getProxy().update(u);				
				clearTextFieldsS();
				table.setModel(new ModelBoutique());

			}
		});
		Update.setBounds(316, 289, 89, 23);
		contentPane.add(Update);
		
		modele= new ModelBoutique() ;
		table = new JTable(modele);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 11, 622, 104);
		contentPane.add(scrollPane);
		
		JLabel lblTl = new JLabel("Telephone");
		lblTl.setBounds(424, 227, 63, 14);
		contentPane.add(lblTl);
		
		tel = new JTextField();
		tel.setBounds(497, 224, 86, 20);
		contentPane.add(tel);
		tel.setColumns(10);
		
		JLabel lbl = new JLabel("Localisation");
		lbl.setBounds(142, 181, 89, 14);
		contentPane.add(lbl);
		
		localisation = new JTextField();
		localisation.setBounds(252, 178, 40, 20);
		contentPane.add(localisation);
		localisation.setColumns(10);
		
		DefaultListModel modelList =  new DefaultListModel();
	
		modelList.addElement("Vide");
		modelList.addElement("en negociation");
		modelList.addElement("Louer");
		list = new JList(modelList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setBounds(10, 180, 122, 64);
		contentPane.add(list);
		
		libelleboutique = new JTextField();
		libelleboutique.setBounds(250, 224, 148, 20);
		contentPane.add(libelleboutique);
		libelleboutique.setColumns(10);
		
		JLabel lblNomBoutique = new JLabel("Nom Boutique");
		lblNomBoutique.setBounds(142, 229, 89, 14);
		contentPane.add(lblNomBoutique);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(20, 139, 40, 20);
		contentPane.add(textField);
	/*****************************************************/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int row = table.getSelectedRow();
				 textField.setText( table.getValueAt(row, 0).toString());
				 localisation.setText(table.getValueAt(row, 1).toString());
				 tel.setText(table.getValueAt(row, 2).toString());
				 libelleboutique.setText( table.getValueAt(row, 3).toString());
			} 
		});
	/*********************************************************/	
	}
	
	public void clearTextFieldsS (){

	   	 list.setSelectedIndex(0);
		 libelleboutique.setText("");		
		 tel.setText("");
		 localisation.setText("");

		 
	}
	}
