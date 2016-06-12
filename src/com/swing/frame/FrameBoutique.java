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

public class FrameBoutique extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ModelBoutique modele;
	private JTextField tel;
	private JTextField localisation;
	private JTextField textField;
	private JList list ;
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
	public FrameBoutique(JMenuBar jMenuBar) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 433);
		//setJMenuBar(new FrameMenu().Menu());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setJMenuBar(jMenuBar);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Add = new JButton("Add");
		
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/***********************/
				Boutique u=new Boutique();
				u.setEtat( list.getSelectedValue().toString());
				u.setNum(Integer.parseInt(localisation.getText()));
				u.setTel(tel.getText());
						
				/***********************/
				
				CommanServiceDelegate.getProxy().create(u);

				clearTextFieldsS();
				table.setModel(new ModelBoutique());

			}
		});
		
		
		
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Add.setBounds(203, 284, 89, 23);
		contentPane.add(Add);
		
		JButton Remove = new JButton("Remove");
		Remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				CommanServiceDelegate.getProxy().delete(new Boutique(),"id",textField.getText()+"");
				clearTextFieldsS();
				
				table.clearSelection();
				table.setModel(new ModelBoutique());
				
				
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		Remove.setBounds(291, 284, 89, 23);
		contentPane.add(Remove);
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
Boutique u=new Boutique();
				
				u.setNum(Integer.parseInt(localisation.getText()));
				u.setTel(tel.getText());
				
				/***********************/
				
				
				Boutique u2=new Boutique();
				u2=(Boutique) CommanServiceDelegate.getProxy().findById(new Boutique(), "id",textField.getText() );
				u.setEtat( list.getSelectedValue().toString());
				u.setId(u2.getId());
				CommanServiceDelegate.getProxy().update(u);
				
				
				clearTextFieldsS();
				table.setModel(new ModelBoutique());
				
		
				
			}
		});
		Update.setBounds(377, 284, 89, 23);
		contentPane.add(Update);
		
		modele= new ModelBoutique() ;
		table = new JTable(modele);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 11, 622, 104);
		contentPane.add(scrollPane);
		
		JLabel lblTl = new JLabel("Tél");
		lblTl.setBounds(500, 196, 46, 14);
		contentPane.add(lblTl);
		
		tel = new JTextField();
		tel.setBounds(556, 193, 86, 20);
		contentPane.add(tel);
		tel.setColumns(10);
		
		JLabel lbl = new JLabel("Localisation");
		lbl.setBounds(286, 196, 89, 14);
		contentPane.add(lbl);
		
		localisation = new JTextField();
		localisation.setBounds(385, 193, 105, 20);
		contentPane.add(localisation);
		localisation.setColumns(10);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(190, 193, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(147, 196, 27, 14);
		contentPane.add(lblId);
		
		DefaultListModel modelList =  new DefaultListModel();
	
		modelList.addElement("Vide");
		modelList.addElement("en négociation");
		modelList.addElement("Loué");
		list = new JList(modelList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setBounds(10, 180, 122, 95);
		contentPane.add(list);
	/*****************************************************/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int row = table.getSelectedRow();

				 textField.setText( table.getValueAt(row, 0).toString());
				
				 tel.setText(table.getValueAt(row, 1).toString());
		
				 localisation.setText(table.getValueAt(row, 2).toString());
			
			} 
		});
	/*********************************************************/	
	}
	
	public void clearTextFieldsS (){

	   	 list.setSelectedIndex(0);
		 textField.setText("");		
		 tel.setText("");
		 localisation.setText("");

		 
	}
	}
