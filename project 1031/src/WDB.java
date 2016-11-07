
//1. Thread 클래스를 상속받아 사용자가 쓰레드 클래스를 생성하는 방법

class MyThread extends Thread {
	String name;
	
	public MyThread(String input) {
		name = input;
	}
	
	
	@Override
	public void run() {
		for(int i = 0; i<10000;i++) {
			System.out.println(name+":"+i+" ");
		}
	}
}

public class WDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread a = new MyThread("a");
		a.start();
		MyThread b = new MyThread("b");
		b.start();
	}

}
