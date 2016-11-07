package project1104;

class Counter {
	int value=0;
	public synchronized void increment() {
		value = value+1;
	}
	public void print() {
		System.out.println(value);
	}
}
class MyThread extends Thread {
	Counter sharedCounter;
	//������
	public MyThread(Counter input) {
		sharedCounter = input;
	}
	@Override
	public void run() {
		// 10000�� ������Ų��.
		for(int i=0;i<10000;i++) {
			sharedCounter.increment();
		//	if(i%40 ==0) {
				sharedCounter.print();
		//	}
			
			//delay
			try {
				sleep(2);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class WDB {

	public static void main(String[] args) {
		Counter myCounter = new Counter();
		MyThread a1 = new MyThread(myCounter);
		MyThread a2 = new MyThread(myCounter);
		a1.start();
		a2.start();

	}

}
