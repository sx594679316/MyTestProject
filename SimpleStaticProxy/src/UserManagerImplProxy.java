public class UserManagerImplProxy implements UserManager {

	private UserManager userManager;

	public UserManagerImplProxy(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public void addUser(String userId, String userName) {
		System.out.println("start-->>addUser() userId-->>" + userId);
		userManager.addUser(userId, userName);
	}

	@Override
	public void delUser(String userId) {
		System.out.println("start-->>addUser() userId-->>" + userId);
		userManager.delUser(userId);
	}

	@Override
	public void modifyUser(String userId, String userName) {
		System.out.println("start-->>modifyUser() userId-->>" + userId);
		userManager.modifyUser(userId, userName);
	}

	@Override
	public String findUser(String userId) {
		System.out.println("start-->>findUser() userId-->>" + userId);
		userManager.findUser(userId);
		return null;
	}

}
