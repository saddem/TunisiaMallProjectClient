package test;

import java.util.ArrayList;

import org.jboss.remotingjmx.Util;

import com.esprit.entity.ShopOwner;
import com.esprit.entity.Utilisateur;

import delegate.CommanServiceDelegate;

public class CreateSomeUsers {

	public static void main(String[] args) {

		
		ArrayList<ShopOwner> users=CommanServiceDelegate.getProxy().findAll(new ShopOwner());
		
		System.out.println(users.size());
		
	/*	User user=(User) CommanService.getProxy().findById(new User(),"id", "1");
		System.out.println(user.getName());
		
		CommanService.getProxy().delete(new User(),"id", "1");
		
		 users=CommanService.getProxy().findAll(new User());
			
			System.out.println(users.size());
			*/
		/*	Utilisateur user=(Utilisateur) CommanServiceDelegate.getProxy().findById(new Utilisateur(),"id", "2");
			user.setNom("tesst333");
			CommanServiceDelegate.getProxy().update(user);
		*/	
			
			System.out.println(" 2 :"+ CommanServiceDelegate.getProxy().findReqList(new ShopOwner()," c.enabled='1'").size());
		
	}

}
