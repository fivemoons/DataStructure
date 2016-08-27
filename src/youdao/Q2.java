package youdao;

import java.io.*;
import java.util.*;

public class Q2 {
	public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        int[] pai = new int[500];
        int[] a = new int[300];
        int[] b = new int[300];
        for(int kk=0; kk<T; kk++){
            int n = cin.nextInt();
            int k = cin.nextInt();
            for(int i=0; i<2*n; i++){
            	pai[i] = cin.nextInt();
            }
            for(int i=0; i<k; i++){
            	for(int j=0; j<n; j++){
            		a[j] = pai[j];
            		b[j] = pai[j+n];
            	}
            	for(int j=0; j<n; j++){
        			pai[j*2] = a[j];
        			pai[j*2+1] = b[j];
        		}
            	
            }
            for(int i=0; i<2*n-1; i++){
            	System.out.print(pai[i]);
            	System.out.print(' ');
            }
            System.out.println(pai[2*n-1]);
        }
    }
}
