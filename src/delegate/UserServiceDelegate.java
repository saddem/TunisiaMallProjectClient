package delegate;

import com.esprit.service.UserServiceRemote;

import locator.ServiceLocator;

public class UserServiceDelegate {
private static String jndiName="ejb:/ejbTest/UserService!com.esprit.service.UserServiceRemote";
	
	public static UserServiceRemote getProxy(){
		return (UserServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}

}
