package javaAPI;

import java.util.Vector;

public class ApiJava {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(-1);
		v.add(15);
		v.add(2,100);
		System.out.println("Vector Size : " + v.size());
		System.out.println("Vector capacity : " + v.capacity());
		
		for(int i=0; i<v.size(); i++) { // 배열의 사이즈를 반환한다. 
			int n = v.get(i); // 접근자를 통해서 배열의 값을 n에 저장한다. 
			System.out.println(n);
		}
		
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			int n = v.elementAt(i); 
			sum += n ;
		}
		System.out.println("Sum of Vetor : " + sum);

	}

}
