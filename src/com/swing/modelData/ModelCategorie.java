package com.swing.modelData;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Categorie;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.Utilisateur;
import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;

public class ModelCategorie extends AbstractTableModel {



	public  final String[] entetes = { "Id", "Libelle","Description","Secteur d'activiter" };	
	ArrayList<Categorie> categories=(ArrayList<Categorie>) CommanServiceDelegate.getProxy().findAll(new Categorie());
	
	@Override
	public int getColumnCount() {
		return	entetes.length;
		
	}

	@Override
	public int getRowCount() {
	
		
		return categories.size();

		
	}
	
	@Override
	 public String getColumnName(int col) {
        return entetes[col];
    }


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		
				switch (columnIndex) {

		case 0:
			// ID
			return categories.get(rowIndex).getId();

		case 1:
			// Prenom
			return categories.get(rowIndex).getLibelle();
		case 2:
			// Prenom
			return categories.get(rowIndex).getDescription();
		case 3:
			// Prenom
			return categories.get(rowIndex).getSecteurActivite().getLibelle();
		
		
		default:
			throw new IllegalArgumentException();
		}
	}

}
