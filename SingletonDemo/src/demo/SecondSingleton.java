package demo;

public class SecondSingleton {

	public static SecondSingleton instance = null;
	
	private SecondSingleton(){
		
	}
	
	public static synchronized SecondSingleton getInstance(){
		if(instance == null){
			instance = new SecondSingleton();
		}
		return instance;
	}
	
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
	public Object readResolve(){
		return instance;
	}
}
