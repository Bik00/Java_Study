package Second;

 // �߻� Ŭ���� ����
abstract class RemoteControlClass {
	// �߻� �޼ҵ� ����
	public abstract void turnon();
	public abstract void turnoff();


}

//�������̽� 
interface RemoteControl {
	// �߻� �޼ҵ� ����
	public void turnon();
	public void turnoff();
	
}



class Tel implements RemoteControl {

	@Override
	public void turnon() {
		// TODO Auto-generated method stub
		System.out.println("�ڷ����� �ѱ�");
	}

	@Override
	public void turnoff() {
		// TODO Auto-generated method stub
		System.out.println("�ڷ����� ����");
	}
	
	public void print() {
		System.out.println("�ڷ����� ���");
	}
	
}


class Ref implements RemoteControl {

	@Override
	public void turnon() {
		// TODO Auto-generated method stub
		System.out.println("����� �ѱ�");
	}

	@Override
	public void turnoff() {
		// TODO Auto-generated method stub
		System.out.println("����� ����");
	}
	
}



public class project0905 {

	public static void main(String[] args) {
		
		RemoteControl rObject;
		rObject = new Tel();
		rObject.turnon();
//		rObject.print(); // ���ǰ� ����� �ȵǾ� �־ ���� ����~
		
		rObject = new Ref();
		rObject.turnon();
		
		
//		Tel tObject = new Tel();
//		Ref rObject = new Ref();
//		
//		tObject.turnon();
//		rObject.turnon();
//		
//		tObject.turnoff();
//		rObject.turnoff();
	}

}
