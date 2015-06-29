package main;

public class Task5 {

	public static double getPower(double base, double exp) {
		if (base == 0 && exp == 0) {
			throw new ArithmeticException("Both base and exp cannot be 0.");
		}
		if (base == 0) {
			return 0;
		}
		if (exp == 0) {
			return 1;
		}
		
		if (exp < 0) {
			return (1 / base) * getPower(1 / base, -exp - 1);
		} else {		
			return base * getPower(base, exp - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getPower(2, 5));
		System.out.println(getPower(-2, 4));
		System.out.println(getPower(-2, -2));
	}

}
