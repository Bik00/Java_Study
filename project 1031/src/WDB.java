
//1. Thread Ŭ������ ��ӹ޾� ����ڰ� ������ Ŭ������ �����ϴ� ���

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
