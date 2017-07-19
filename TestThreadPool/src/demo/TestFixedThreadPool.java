package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {

	public static void main(String[] args) {
		// ����һ�������ù̶��߳������̳߳�
		/**
		 * �����̶���С���̳߳ء�ÿ���ύһ������ʹ���һ���̣߳�ֱ���̴߳ﵽ�̳߳ص�����С���̳߳صĴ�Сһ���ﵽ���ֵ�ͻᱣ�ֲ��䣬
		 * ���ĳ���߳���Ϊִ���쳣����������ô�̳߳ػᲹ��һ�����̡߳�
		 */
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		Thread t3 = new MyThread();
		Thread t4 = new MyThread();
		Thread t5 = new MyThread();
		// ���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		// �ر��̳߳�
		pool.shutdown();
	}

}
