package sync;

public class MainTest {
	public static void main(String[] args) throws Exception{
		ThreadTest t = new ThreadTest();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		t2.start();
	}
}
