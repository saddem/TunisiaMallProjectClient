package com.swing.modelData;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.Utilisateur;
import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;

public class ModelSecteurActiviter extends AbstractTableModel {



	public  final String[] entetes = { "Id", "Libelle","Description" };	
	ArrayList<SecteurActivite> secteurActivites=(ArrayList<SecteurActivite>) CommanServiceDelegate.getProxy().findAll(new SecteurActivite());
	
	@Override
	public int getColumnCount() {
		return	entetes.length;
		
	}

	@Override
	public int getRowCount() {
	
		
		return secteurActivites.size();

		
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
			return secteurActivites.get(rowIndex).getId();

		case 1:
			// Prenom
			return secteurActivites.get(rowIndex).getLibelle();
		case 2:
			// Prenom
			return secteurActivites.get(rowIndex).getDescription();
		
		
		default:
			throw new IllegalArgumentException();
		}
	}

}
