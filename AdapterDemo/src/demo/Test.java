package demo;

public class Test {

	public static void main(String[] args) {
		Targetable target = new Adapter();
		target.method1();
		target.method2();
		
		Source source = new Source();
		Targetable targetable = new Wrapper(source);
		targetable.method1();
		targetable.method2();
		
		Sourceable source1 = new SouceSub1();
		Sourceable source2 = new SouceSub2();
		
		source1.method1();
		source1.method2();
		source2.method1();
		source2.method2();
	}

}
