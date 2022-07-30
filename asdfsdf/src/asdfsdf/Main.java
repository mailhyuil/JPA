package asdfsdf;

public class Main {
	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis();
		for (long i = 0; i < 933322; i++) {
			System.out.println(i);
		}
		long afterTime = System.currentTimeMillis();		
		System.out.println("걸린시간 : " + (afterTime - beforeTime)+"ms");
	}
}
