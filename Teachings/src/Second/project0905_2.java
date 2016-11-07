package Second;

interface Comparable {
	int compareTo(Object other);
}



class Box implements Comparable {

	private double volume; // 멤버변수
	public Box(double v) { //생성자
		volume = v;
	}
	
	@Override
	public int compareTo(Object otherObject) {
		// 강제 형 변환
		Box b = (Box) otherObject;
		
		//비교
		if (this.volume < b.volume) return -1;
		else if (this.volume > b.volume) return 1;
		else
		return 0;
	}
		
 }

class Circle implements Comparable {
	private double area;
	public Circle(double v) { //생성자
		area = v;
	}
	
	public int compareTo(Object otherObject) {
		//강제 형 변환
		Circle c = (Circle) otherObject;
		if(this.area < c.area) return -1;
		else if(this.area > c.area) return 1;
		else return 0;
	}
	
}

	
public class project0905_2 {

	public static void main(String[] args) {
//		Box b1, b2;
//		b1 = new Box(100.0);
//		b2 = new Box(50.0);
//		
//		int result = b1.compareTo(b2);
//		System.out.println(result);
//		
//		 result = b1.compareTo(b1);
//		System.out.println(result);
//		
//		 result = b2.compareTo(b1);
//		System.out.println(result);
		
		Circle b1, b2;
		b1 = new Circle(100.0);
		b2 = new Circle(50.0);
		
		int result = b1.compareTo(b2);
		System.out.println(result);
		
		 result = b1.compareTo(b1);
		System.out.println(result);
		
		 result = b2.compareTo(b1);
		System.out.println(result);
		
	}
}
