package sync;

public class ThreadTest implements Runnable{
	private static int tickets =100;
	@Override
	public void run() {
		while(true){
			synchronized(ThreadTest.class){
				if (tickets >0){
					try{
						Thread.sleep(60);
					}catch(Exception e){
						break;
					}
					System.out.println(Thread.currentThread().getName() + ':' + tickets--);
				}else{
					break;
				}
			}
		}
	}

}
