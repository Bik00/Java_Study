
//1. Runable �������̽��� ��ӹ޴� Ŭ������ ����

class MyThread2 implements Runnable {
	String name;
	
	//������
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
		// 2. Runnable ���� ���̽��� ��ӹ޾� Ŭ������ �����ϰ��� �� ���
		//2.1  ��ӹ��� Ŭ���� MyThread ��ü�� �����Ѵ�.
		// 2.2 Thread ��ü�� ������ MyThread ��ü�� �Ű������� �����.
		// 2.3 Thread ��ü�� start �޼ҵ带 �����Ѵ�.
		
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
