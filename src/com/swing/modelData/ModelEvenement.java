package com.swing.modelData;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Categorie;
import com.esprit.entity.Evenement;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.SousCategorie;
import com.esprit.entity.Utilisateur;
import com.swing.variableSession.VariableSession;

import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;

public class ModelEvenement extends AbstractTableModel {



	public  final String[] entetes = { "Id", "Date Début","Date Fin","Description"};	
	ArrayList<Evenement> evenements=CommanServiceDelegate.getProxy().findAll(new Evenement());
	
	
	@Override
	public int getColumnCount() {
		return	entetes.length;
		
	}

	@Override
	public int getRowCount() {
	
		
		return evenements.size();

		
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
			return evenements.get(rowIndex).getId();

		case 1:
			// Prenom
			return evenements.get(rowIndex).getDateDebut();
		case 2:
			// Prenom
			return evenements.get(rowIndex).getDateFin();
		case 3:
			return evenements.get(rowIndex).getDescription();
		
		
		
		default:
			throw new IllegalArgumentException();
		}
	}

}
