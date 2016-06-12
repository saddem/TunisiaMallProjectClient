package com.swing.modelData;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import com.esprit.entity.SuperAdmin;
import com.esprit.entity.Utilisateur;
import delegate.CommanServiceDelegate;
import delegate.UserServiceDelegate;

public class ModelAdministrateur extends AbstractTableModel {



	public  final String[] entetes = { "Id", "Nom","Prenom","Tel","Login","Pssword","Email","Adresse","Enabled" };	
	ArrayList<Utilisateur> users=(ArrayList<Utilisateur>) UserServiceDelegate.getProxy().findAll(new SuperAdmin());
	
	@Override
	public int getColumnCount() {
		return	entetes.length;
		
	}

	@Override
	public int getRowCount() {
	
		
		return users.size();

		
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
			return users.get(rowIndex).getId();

		case 1:
			// Prenom
			return users.get(rowIndex).getNom();
		case 2:
			// Prenom
			return users.get(rowIndex).getPrenom();
		case 3:
			// Prenom
			return users.get(rowIndex).getTel();
		case 4:
			// Prenom
			return users.get(rowIndex).getLogin();	

		case 5:
			// Prenom
			return users.get(rowIndex).getPassword();	

		case 6:
			// Prenom
			return users.get(rowIndex).getEmail();	
			
		case 7:
			// Prenom
			return users.get(rowIndex).getAdresse();	
			
			
			case 8:
				// Prenom
				return users.get(rowIndex).isEnabled();
		
		default:
			throw new IllegalArgumentException();
		}
	}

}
