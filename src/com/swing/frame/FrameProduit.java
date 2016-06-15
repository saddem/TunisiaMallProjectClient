package com.swing.frame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.esprit.entity.Categorie;
import com.esprit.entity.Produit;
import com.esprit.entity.SousCategorie;
import com.swing.modelData.ModelProduit;
import delegate.CommanServiceDelegate;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import javax.swing.JList;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class FrameProduit extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ModelProduit modelproduit;
	private JTextField prht;
	private JTextField libelle;
	private JTextField txtid;
	private JList listSousCategorie ;
	private JList listCategorie;
	private JList listeboutique ;
	private JTextField txtTva;
	private JTextField txtqte;
	private JTextField textDescription;

	public FrameProduit(JMenuBar jMenuBar) {
		setTitle("Produit");
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
				
				Produit p=new Produit();

				p.setQuantite(Integer.parseInt(txtqte.getText()));
				p.setPrixHt(Integer.parseInt(prht.getText()));// To float
				p.setTva(Integer.parseInt(txtTva.getText()));// To float
				p.setDescription(textDescription.getText());
				p.setId(Integer.parseInt(txtid.getText()));
				//p.setSouscategories(listSousCategorie.getSelectedValue().toString());
				//p.setBoutique(listeboutique.getSelectedValue().toString());
				
				CommanServiceDelegate.getProxy().create(p);
				clearTextFieldsS();
				table.setModel(new ModelProduit());
			}
		});
		
		
		
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Add.setBounds(215, 335, 89, 23);
		contentPane.add(Add);
		
		JButton Remove = new JButton("Remove");
		Remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CommanServiceDelegate.getProxy().delete(new Produit(),"id",txtid.getText()+"");
				clearTextFieldsS();
				table.clearSelection();
				table.setModel(new ModelProduit());
			}
		});
		Remove.setBounds(314, 335, 89, 23);
		contentPane.add(Remove);
		
		
		
		JButton Update = new JButton("Update");
		Update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
                Produit p=new Produit();
				//p.setNum(Integer.parseInt(libelle.getText()));
				//p.setTel(prht.getText());
		
				Produit p2=new Produit();
				p2=(Produit) CommanServiceDelegate.getProxy().findById(new Produit(), "id",txtid.getText() );
				//p.setEtat( listSousCategorie.getSelectedValue().toString());
				p.setId(p2.getId());
				CommanServiceDelegate.getProxy().update(p);
	
				clearTextFieldsS();
				table.setModel(new ModelProduit());
				
			}
		});
		Update.setBounds(413, 335, 89, 23);
		contentPane.add(Update);
		
		modelproduit= new ModelProduit() ;
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Libelle", "Description", "Prix HT", "Tva %", "Quantite", "Sous Categorie", "Boutique"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setEnabled(false);
		table.setBackground(SystemColor.text);
		table.setBorder(null);
	
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 655, 106);
		contentPane.add(scrollPane);
		
		JLabel lblTl = new JLabel("Prix HT");
		lblTl.setBounds(387, 163, 46, 14);
		contentPane.add(lblTl);
		
		prht = new JTextField();
		prht.setBounds(369, 188, 64, 20);
		contentPane.add(prht);
		prht.setColumns(10);
		
		JLabel lbltva = new JLabel("Libelle");
		lbltva.setBounds(270, 163, 89, 14);
		contentPane.add(lbltva);
		
		libelle = new JTextField();
		libelle.setBounds(254, 188, 105, 20);
		contentPane.add(libelle);
		libelle.setColumns(10);
		
		txtid = new JTextField();
		txtid.setEnabled(false);
		txtid.setBounds(142, 188, 46, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(142, 163, 27, 14);
		contentPane.add(lblId);
		
		DefaultListModel modelListsous =  new DefaultListModel();
		ArrayList<SousCategorie> souscategorie=CommanServiceDelegate.getProxy().findAll(new SousCategorie());
		for (int i = 0; i < souscategorie.size(); i++) {
			modelListsous.addElement(souscategorie.get(i).getLibelle());
		}
		
		listSousCategorie = new JList(modelListsous);
		listSousCategorie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSousCategorie.setSelectedIndex(0);
		listSousCategorie.setBounds(10, 295, 122, 69);
		contentPane.add(listSousCategorie);
		
		
		JLabel lblsouscat = new JLabel("Sous Categorie");
		lblsouscat.setBounds(10, 270, 122, 14);
		contentPane.add(lblsouscat);
		
		txtTva = new JTextField();
		txtTva.setColumns(10);
		txtTva.setBounds(443, 188, 46, 20);
		contentPane.add(txtTva);
		
		JLabel lblTva = new JLabel("Tva %");
		lblTva.setBounds(443, 163, 57, 14);
		contentPane.add(lblTva);
		
		txtqte = new JTextField();
		txtqte.setColumns(10);
		txtqte.setBounds(503, 188, 57, 20);
		contentPane.add(txtqte);
		
		JLabel Qte = new JLabel("Quantite");
		Qte.setBounds(514, 163, 46, 14);
		contentPane.add(Qte);
		

		DefaultListModel modelListcateg =  new DefaultListModel();
		ArrayList<Categorie> categorie=CommanServiceDelegate.getProxy().findAll(new Categorie());
		for (int i = 0; i < categorie.size(); i++) {
			modelListcateg.addElement(categorie.get(i).getLibelle());
		}
		
		listCategorie = new JList(modelListcateg);
		listCategorie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCategorie.setSelectedIndex(0);
		listCategorie.setBounds(10, 190, 122, 69);
		contentPane.add(listCategorie);
		
		
		
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(10, 163, 122, 14);
		contentPane.add(lblCategorie);
		
		JLabel description = new JLabel("Description de Produit");
		description.setBounds(142, 241, 145, 14);
		contentPane.add(description);
		
		textDescription = new JTextField();
		textDescription.setColumns(10);
		textDescription.setBounds(314, 239, 246, 45);
		contentPane.add(textDescription);
	/*****************************************************/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int row = table.getSelectedRow();
				 txtid.setText( table.getValueAt(row, 0).toString());
				 prht.setText(table.getValueAt(row, 1).toString());
				 libelle.setText(table.getValueAt(row, 2).toString());
			
			} 
		});
	/*********************************************************/	
	}
	
	public void clearTextFieldsS (){

	   	 listSousCategorie.setSelectedIndex(0);
	   	 listeboutique.setSelectedIndex(0);
		 txtid.setText("");		
		 prht.setText("");
		 libelle.setText("");
		 textDescription.setText("");
	}
	}
