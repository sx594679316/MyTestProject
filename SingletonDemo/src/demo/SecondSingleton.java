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
	
	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */  
	public Object readResolve(){
		return instance;
	}
}
