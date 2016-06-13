package com.swing.modelData;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import com.esprit.entity.Commande;
import delegate.CommanServiceDelegate;

public class ModelCommande extends AbstractTableModel {



	public  final String[] entetes = { "Id", "Date Demande","Date Traitement","Date Livraison","Etat","Client"};	
	ArrayList<Commande> commandes=(ArrayList<Commande>) CommanServiceDelegate.getProxy().findAll(new Commande());
	
	@Override
	public int getColumnCount() {
		return	entetes.length;
		
	}

	@Override
	public int getRowCount() {
	
		
		return commandes.size();

		
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
			return commandes.get(rowIndex).getId();

		case 1:
			// Prenom
			return commandes.get(rowIndex).getDateDemande();
		case 2:
			// Prenom
			return commandes.get(rowIndex).getDateTraitement();
		case 3:
			// Prenom
			return commandes.get(rowIndex).getDateLivraison();	
		case 4:
			// Prenom
			return commandes.get(rowIndex).getEtat();
		case 5:
			// Prenom
			return commandes.get(rowIndex).getClient();		
		
		
		default:
			throw new IllegalArgumentException();
		}
	}

}
