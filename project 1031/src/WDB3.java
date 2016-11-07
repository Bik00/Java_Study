
//1. Runable 인터페이스를 상속받는 클래스를 생성

class MyThread2 implements Runnable {
	String name;
	
	//생성자
	public MyThread2(String input) {
		name = input;
	}
	@Override
	public void run() {
		for (int i=0;i<10000;i++) { 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name+":"+i+" ");
		}
	}
	
}


public class WDB3 {

	public static void main(String[] args) {
		// 2. Runnable 인터 페이스를 상속받아 클래스를 생성하고자 할 경우
		//2.1  상속받은 클래스 MyThread 객체를 생성한다.
		// 2.2 Thread 객체를 생성할 MyThread 객체를 매개변수로 만든다.
		// 2.3 Thread 객체의 start 메소드를 생성한다.
		
		//2.1
		MyThread2 a = new MyThread2("a");
		//2.2
		Thread thread = new Thread(a);
		//2.3
		thread.start();
		
		
		//2.1
		MyThread2 b = new MyThread2("b");
		//2.2
		Thread thread2 = new Thread(b);
		//2.3
		thread2.start();

	}

}
