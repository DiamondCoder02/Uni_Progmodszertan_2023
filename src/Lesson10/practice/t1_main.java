package Lesson10.practice;

public class t1_main {
	public static void main(String[] args) {
		int v[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		t1_Decide fobj = new t1_Decide() {
			@Override
			public boolean ifCondition(int x) {
				return x % 2 == 0;
			}
		};
		// nrT(v, fobj);
		System.out.println("Even numbers:  " + nrT(v, fobj));

		t1_Decide fobj2 = x -> x % 2 == 0;
		// (a, b) -> a + b;
		// () -> 
		/*
		(a, b) -> {
			int c;
			c = a + b;
			return c;
		};
		*/
		System.out.println("Even numbers : " + nrT(v, fobj2));
	}

	static int nrT(int v[], t1_Decide fobj){
		int ln = v.length;
		int db = 0;
		for (int i = 0; i < ln; i++) {
			if (fobj.ifCondition(v[i])) {
				db++;
			}
		}
		return db;
	}
}
