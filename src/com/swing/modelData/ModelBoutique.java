package com.swing.modelData;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.esprit.entity.Boutique;
import delegate.CommanServiceDelegate;

public class ModelBoutique extends AbstractTableModel {



	public  final String[] entetes = { "Id","Localisation","Telephone","Nom Boutique","Etat" };	
	ArrayList<Boutique> boutiques=(ArrayList<Boutique>) CommanServiceDelegate.getProxy().findAll(new Boutique());
	
	@Override
	public int getColumnCount() {
		return	entetes.length;
		
	}

	@Override
	public int getRowCount() {
		return boutiques.size();
	}
	
	@Override
	 public String getColumnName(int col) {
        return entetes[col];
    }


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
				switch (columnIndex) {	
		case 0:
			return boutiques.get(rowIndex).getId();
			
		case 1:
			return boutiques.get(rowIndex).getNum();
			
		case 2:
			return boutiques.get(rowIndex).getTel();
			
		case 3:
			return boutiques.get(rowIndex).getLibelle();
	
		case 4:
			return boutiques.get(rowIndex).getEtat();
			
		default:
			throw new IllegalArgumentException();
		}
	}

}
