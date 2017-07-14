package demo;

public class ThirdSingleton {

	public static ThirdSingleton instance = null;

	private ThirdSingleton() {

	}

	public static ThirdSingleton getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new ThirdSingleton();
				}
			}
		}
		return instance;
	}

	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */
	public Object readResolve() {
		return instance;
	}
}
