package demo;

public class FirstSingleton {
	public static FirstSingleton instance = null;
	
	private FirstSingleton(){
		
	}
	
	 /* 静态工程方法，创建实例 */  
	public static FirstSingleton getInstance(){
		if(instance == null){
			instance = new FirstSingleton();
		}
		return instance;
	}
	
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
	public Object readResolve(){
		return instance;
	}
}
