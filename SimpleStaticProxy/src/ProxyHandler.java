import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

	private Object targetObject;

	/**
	 * Ŀ��ĳ�ʼ������������Ŀ�����ɴ�����
	 * 
	 * @param targetObject
	 * @return
	 */
	public Object newProxyInstance(Object targetObject) {
		this.targetObject = targetObject;
		// ��һ��������Ŀ���װ����
		// �ڶ���������Ŀ��ӿڣ�Ϊÿ���ӿ����ɴ���
		// ����������������ʵ����InvocationHandler�Ķ��󣬵���һ���ô����������ͻ����InvocationHandler��invoke����
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
				targetObject.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// ��¼��־�Ȳ������ӡ�������
		System.out.println("start-->>" + method.getName());
		for (int i = 0; i < args.length; i++) {
			// ��ӡ����Ŀ�귽���Ĳ���
			System.out.println(args[i]);
		}
		Object ret = null;
		try {
			// ����Ŀ�귽��
			ret = method.invoke(targetObject, args);
			// ִ�гɹ�����ӡ�ɹ���Ϣ
			System.out.println("success-->>" + method.getName());
		} catch (Exception e) {
			e.printStackTrace();
			// ʧ��ʱ����ӡʧ����Ϣ
			System.out.println("error-->>" + method.getName());
			throw e;
		}

		return ret;

	}

}