package demo;

public class MyThread extends Thread {

	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName() + "����ִ�С�����");
	}
}
