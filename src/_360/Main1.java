package _360;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int b = in.nextInt();
			if (n == 1)
				System.out.println(1);
			else if (n % 2 == 0) {
				int x = n / 2;
				if (x == b)
					System.out.println(b + 1);
				else if (x > b)
					System.out.println(b + 1);
				else
					System.out.println(b - 1);
			} else {
				int x = (n + 1) / 2;
				if (x == b)
					System.out.println(b - 1);
				else if (x > b)
					System.out.println(b + 1);
				else
					System.out.println(b - 1);
			}
		}
	}
}
