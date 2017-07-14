package demo;

public class FourthSingleton {

	private FourthSingleton() {

	}

	/**
	 * ʵ������ǣ�����ģʽʹ���ڲ�����ά��������ʵ�֣�JVM�ڲ��Ļ����ܹ���֤��һ���౻���ص�ʱ�������ļ��ع������̻߳���ġ�
	 * ���������ǵ�һ�ε���getInstance��ʱ��
	 * ��JVM�ܹ������Ǳ�֤instanceֻ������һ�Σ����һᱣ֤�Ѹ�ֵ��instance���ڴ��ʼ�����
	 * ���������ǾͲ��õ�����������⡣ͬʱ�÷���Ҳֻ���ڵ�һ�ε��õ�ʱ��ʹ�û�����ƣ������ͽ���˵��������⡣
	 * 
	 * @author Administrator
	 * 
	 */
	private static class SingletonFactory {
		private static FourthSingleton instance = new FourthSingleton();
	}

	public static FourthSingleton getInstance() {
		return SingletonFactory.instance;
	}

	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */
	public Object readResolve() {
		return getInstance();
	}
}