package com.swing.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.esprit.entity.Commande;
import com.swing.modelData.ModelCommande;
import delegate.CommanServiceDelegate;
import javax.swing.JFormattedTextField;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class FrameCommande extends JFrame {
	
	private JPanel contentPane;
	private JTextField id;
	private DateFormat dd;
	private DateFormat dt;
	private DateFormat dl;
	private JTextField etat;
	private JTable table;
	private ModelCommande modele;
	

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @param jMenuBar 
	 */
	
	public FrameCommande(JMenuBar jMenuBar) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 335);
		setJMenuBar(jMenuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 157, 46, 14);
		contentPane.add(lblId);
		
		id = new JTextField();
		id.setBounds(33, 154, 40, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lbldd = new JLabel("Date Demande");
		lbldd.setBounds(90, 157, 71, 14);
		contentPane.add(lbldd);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(171, 157, 87, 20);
		contentPane.add(dateChooser);
		

		
		
		JLabel lbldt = new JLabel("Date Traitement");
		lbldt.setBounds(216, 197, 78, 14);
		contentPane.add(lbldt);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(439, 157, 87, 20);
		contentPane.add(dateChooser_1);
		
		
		
		JLabel lbldl = new JLabel("Date Livraison");
		lbldl.setBounds(358, 157, 71, 14);
		contentPane.add(lbldl);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(311, 197, 87, 20);
		contentPane.add(dateChooser_2);
		

		

		JLabel lblEtat = new JLabel("Etat");
		lblEtat.setBounds(564, 157, 65, 14);
		contentPane.add(lblEtat);
		
		etat = new JTextField();
		etat.setBounds(597, 154, 40, 20);
		contentPane.add(etat);
		
		
		
		JButton Add = new JButton("Add");
		
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/***********************/
			
				Commande c=new Commande();
				
				if(!id.getText().isEmpty()&&id.getText().equals(""))
				c.setId(Integer.parseInt(id.getText()));
				c.setDateDemande(dateChooser.getDate());
				c.setDateTraitement(dateChooser_1.getDate());
				c.setDateLivraison(dateChooser_2.getDate());
				c.setEtat(etat.getText());
		
	
						
				
				/***********************/
				
				CommanServiceDelegate.getProxy().create(c);

				clearTextFieldsS();
				table.setModel(new ModelCommande());
				
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
				Commande c=new Commande();
				c.setId(Integer.parseInt(id.getText()));
				
				CommanServiceDelegate.getProxy().delete(new Commande(),"id",c.getId()+"");
				clearTextFieldsS();
				
				table.clearSelection();
				table.setModel(new ModelCommande());
				
				
			//	UserServiceDelagate.getProxy().updateUser(user);
			}
		});
		Remove.setBounds(248, 240, 89, 23);
		contentPane.add(Remove);
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				/***********************/
				Commande c=new Commande();
				c.setId(Integer.parseInt(id.getText()));
				c.setDateDemande(dateChooser.getDate());
				c.setDateTraitement(dateChooser_1.getDate());
				c.setDateLivraison(dateChooser_2.getDate());
				c.setEtat(etat.getText());
	
				
				
								/***********************/
				
				
				
				CommanServiceDelegate.getProxy().update(c);
				
				
				clearTextFieldsS();
				table.setModel(new ModelCommande());
				
		
				
			}
		});
		Update.setBounds(334, 240, 89, 23);
		contentPane.add(Update);
		
		modele= new ModelCommande() ;
		table = new JTable(modele);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 11, 622, 104);
		contentPane.add(scrollPane);
		
		
		
		
		
		
		
	/*****************************************************/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int row = table.getSelectedRow();

				 id.setText( table.getValueAt(row, 0).toString());
				 dateChooser.setDate((Date) table.getValueAt(row, 1));
				 dateChooser_1.setDate((Date) table.getValueAt(row, 2));
				 dateChooser_2.setDate((Date) table.getValueAt(row, 3));
				 etat.setText(table.getValueAt(row, 4).toString());
			} 
		});
	/*********************************************************/	
		
	
	}
	
	public void clearTextFieldsS (){

		

		 id.setText("");
	
		 
		 etat.setText("");
		 
	}
	}
