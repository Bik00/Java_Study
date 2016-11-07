package Third;

abstract class MyComparable {
	public abstract int compareTo(Object other);
}

class Shape {
	protected int x,y;
}

abstract class Animal {
	public abstract void speak();
}

class Dog extends Animal {

	@Override
	public void speak() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {

	@Override
	public void speak() {
		System.out.println("야옹");
	}
	
	public void scratch() {
		System.out.println("앞발로 핧퀴다");
	}
}


public class WDB {

	public static void main(String[] args) {
		Dog a = new Dog();
		Cat b = new Cat();
		
//		a.speak();
//		b.speak();
//		Animal c;
//		c = a;
//		c.speak();
//		
//		c = b;
//		c.speak();
		// 객체 배열
		Animal list[] = new Animal[5];
		int vars[] = new int[5];
		
		list[0] = a;
		list[1] = b;
		list[2] = a;
		list[3] = b;
		list[4] = a;
		
		for (int i = 0; i<5;i++) {
			list[i].speak();
		}
		b = (Cat)list[3]; // 강제 형변환
		b.scratch(); // 객체가 캣인것을 확신하면 강제적으로 형을 바꿀 수 있다.
		
		((Cat)list[1]).scratch();
		
	//	((Cat)list[0]).scratch(); 이 경우에는 원래 객체가 Dog 객체이기때문에 오류가 발생하게 된다. 그래서 확신하지 않으면 형변환 하지 말자
		
		
		Animal a1;
		a1 = new Cat();
		
		if(a1 instanceof Cat) {
			System.out.println("Cat 객체 입니다.");
		}
		else {
			System.out.println("Cat 객체가 아닙니다.");			
		}
		
		if(a1 instanceof Animal) {
			System.out.println("Animal 객체 입니다.");
		}
		else {
			System.out.println("Animal 객체가 아닙니다.");			
		}
		
		if(a1 instanceof Dog) {
			System.out.println("Dog 객체 입니다.");
		}
		else {
			System.out.println("Dog 객체가 아닙니다.");			
		}
		
	}
}