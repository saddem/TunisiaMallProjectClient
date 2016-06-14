package delegate;

import com.esprit.comman.CommanServiceRemote;

import locator.ServiceLocator;

public class CommandeServiceeDelegate {
	private static String jndiName="/ejbTest/CommanService!com.esprit.comman.CommanServiceRemote";
	//								ejb:/ejbTest/UserService!com.esprit.service.UserServiceRemote

	public static CommanServiceRemote getProxy(){
		return (CommanServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
}