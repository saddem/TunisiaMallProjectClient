package com.swing.variableSession;

import com.esprit.entity.Utilisateur;

public class VariableSession {
	
	 private static VariableSession variableSession = new VariableSession( );
	
	 private static Utilisateur CurrentUser=new Utilisateur();
	private VariableSession(){
		
		
	}
	
	public static VariableSession getInstance( ) {
	      return variableSession;
	   }

	public static Utilisateur getCurrentUser() {
		return CurrentUser;
	}

	public static void setCurrentUser(Utilisateur currentUser) {
		CurrentUser = currentUser;
	}
	
	
	
	

}
