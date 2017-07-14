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

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return instance;
	}
}
