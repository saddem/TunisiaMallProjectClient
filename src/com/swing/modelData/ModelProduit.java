package com.swing.modelData;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.esprit.entity.Produit;
import delegate.CommanServiceDelegate;


public class ModelProduit extends AbstractTableModel {

	public  final String[] entetes = {"Id", "Libelle", "Description", "Prix HT", "Tva %", "Quantite", "Sous Categorie"};	
	ArrayList<Produit> produits=(ArrayList<Produit>) CommanServiceDelegate.getProxy().findAll(new Produit());
	
	@Override
	public int getColumnCount() {
		return	entetes.length;
	}

	@Override
	public int getRowCount() {
		return produits.size();
	}
	
	@Override
	 public String getColumnName(int col) {
        return entetes[col];
    }


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
	switch (columnIndex) {

		case 0:
			return produits.get(rowIndex).getId();

		case 1:
			return produits.get(rowIndex).getLibelle();
		
		case 2:
			return produits.get(rowIndex).getDescription();	
		
		case 3:
			return produits.get(rowIndex).getPrixHt();
	
		case 4:
			return produits.get(rowIndex).getTva();
			
		case 5:
			return produits.get(rowIndex).getQuantite();
			
		case 6:
			return produits.get(rowIndex).getSouscategories();
			
		default:
			throw new IllegalArgumentException();
		}
	}

}
