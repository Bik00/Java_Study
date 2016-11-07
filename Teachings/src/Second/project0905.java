package Second;

 // 추상 클래스 정의
abstract class RemoteControlClass {
	// 추상 메소드 정의
	public abstract void turnon();
	public abstract void turnoff();


}

//인터페이스 
interface RemoteControl {
	// 추상 메소드 정의
	public void turnon();
	public void turnoff();
	
}



class Tel implements RemoteControl {

	@Override
	public void turnon() {
		// TODO Auto-generated method stub
		System.out.println("텔레비전 켜기");
	}

	@Override
	public void turnoff() {
		// TODO Auto-generated method stub
		System.out.println("텔레비전 끄기");
	}
	
	public void print() {
		System.out.println("텔레비전 출력");
	}
	
}


class Ref implements RemoteControl {

	@Override
	public void turnon() {
		// TODO Auto-generated method stub
		System.out.println("냉장고 켜기");
	}

	@Override
	public void turnoff() {
		// TODO Auto-generated method stub
		System.out.println("냉장고 끄기");
	}
	
}



public class project0905 {

	public static void main(String[] args) {
		
		RemoteControl rObject;
		rObject = new Tel();
		rObject.turnon();
//		rObject.print(); // 정의가 제대로 안되어 있어서 오류 난다~
		
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
