package demo;

public class FirstSingleton {
	public static FirstSingleton instance = null;
	
	private FirstSingleton(){
		
	}
	
	 /* ��̬���̷���������ʵ�� */  
	public static FirstSingleton getInstance(){
		if(instance == null){
			instance = new FirstSingleton();
		}
		return instance;
	}
	
	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */  
	public Object readResolve(){
		return instance;
	}
}
