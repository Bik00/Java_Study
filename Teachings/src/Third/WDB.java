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
		System.out.println("�۸�");
	}
}

class Cat extends Animal {

	@Override
	public void speak() {
		System.out.println("�߿�");
	}
	
	public void scratch() {
		System.out.println("�չ߷� �C����");
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
		// ��ü �迭
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
		b = (Cat)list[3]; // ���� ����ȯ
		b.scratch(); // ��ü�� Ĺ�ΰ��� Ȯ���ϸ� ���������� ���� �ٲ� �� �ִ�.
		
		((Cat)list[1]).scratch();
		
	//	((Cat)list[0]).scratch(); �� ��쿡�� ���� ��ü�� Dog ��ü�̱⶧���� ������ �߻��ϰ� �ȴ�. �׷��� Ȯ������ ������ ����ȯ ���� ����
		
		
		Animal a1;
		a1 = new Cat();
		
		if(a1 instanceof Cat) {
			System.out.println("Cat ��ü �Դϴ�.");
		}
		else {
			System.out.println("Cat ��ü�� �ƴմϴ�.");			
		}
		
		if(a1 instanceof Animal) {
			System.out.println("Animal ��ü �Դϴ�.");
		}
		else {
			System.out.println("Animal ��ü�� �ƴմϴ�.");			
		}
		
		if(a1 instanceof Dog) {
			System.out.println("Dog ��ü �Դϴ�.");
		}
		else {
			System.out.println("Dog ��ü�� �ƴմϴ�.");			
		}
		
	}
}