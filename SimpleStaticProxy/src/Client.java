
public class Client {

	public static void main(String[] args) {
//		UserManager userManager = new UserManagerImplProxy(new UserManagerImpl());
//		userManager.addUser("001","ÓÚÁÁ");
		ProxyHandler proxyHandler = new ProxyHandler();
		UserManager userManager = (UserManager)proxyHandler.newProxyInstance(new UserManagerImpl());
		
		String name = userManager.findUser("0001");
		System.out.println("client.main-->>" + name);

	}
}
