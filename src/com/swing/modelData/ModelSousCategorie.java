package com.swing.modelData;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Categorie;
import com.esprit.entity.SecteurActivite;
import com.esprit.entity.ShopOwner;
import com.esprit.entity.SousCategorie;
import com.esprit.entity.Utilisateur;
import com.swing.variableSession.VariableSession;

import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;

public class ModelSousCategorie extends AbstractTableModel {



	public  final String[] entetes = { "Id", "Libelle","Description","Categorie"};	
	ArrayList<SousCategorie> sousCategories=CommanServiceDelegate.getProxy().findReqList(new SousCategorie(), " c.shopOwner.id="+VariableSession.getCurrentUser().getId());
	
	
	@Override
	public int getColumnCount() {
		return	entetes.length;
		
	}

	@Override
	public int getRowCount() {
	
		
		return sousCategories.size();

		
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
			return sousCategories.get(rowIndex).getId();

		case 1:
			// Prenom
			return sousCategories.get(rowIndex).getLibelle();
		case 2:
			// Prenom
			return sousCategories.get(rowIndex).getDescription();
		case 3:
			// Prenom
			try {
				return sousCategories.get(rowIndex).getCategorie().getLibelle();

			} catch (Exception e) {
				return "";
			}
		
		
		
		default:
			throw new IllegalArgumentException();
		}
	}

}
