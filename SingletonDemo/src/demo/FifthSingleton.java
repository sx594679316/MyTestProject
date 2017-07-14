package demo;

public class FifthSingleton {

	private static FifthSingleton instance = null;
	
	private FifthSingleton(){
		
	}
	
	private static synchronized void syncInit(){
		if(instance == null){
			instance = new FifthSingleton();
		}
	}
	
	public static FifthSingleton getInstance(){
		if(instance == null){
			syncInit();
		}
		return instance;
	}
}
