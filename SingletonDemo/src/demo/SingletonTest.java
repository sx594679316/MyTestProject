package demo;

import java.util.Vector;

public class SingletonTest {
	
	private static SingletonTest instance = null;
	
	private Vector properties = null;
	
	public Vector getPorperties(){
		return properties;
	}
	
	private SingletonTest(){
		
	}
	
	private static synchronized void syncInit(){
		if(instance == null){
			instance = new SingletonTest();
		}
	}
	
	public static SingletonTest getInstance(){
		if(instance == null){
			syncInit();
		}
		return instance;
	}
	
	public void updatroperties(){
		SingletonTest shadow = new SingletonTest();
		properties = shadow.getPorperties();
	}
}
