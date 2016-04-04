package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileTest {
	public static void main(String[] args) throws FileNotFoundException {
		Object o = System.out;
		
		System.setOut(new PrintStream(new File("/Users/lany/abc.txt")));
		System.out.println("abc");
		System.setOut((PrintStream) o);
		System.out.println("bcd");
	}
}
