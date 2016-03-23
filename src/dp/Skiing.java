package dp;
import java.util.Scanner;  
  
  
public class Skiing {  
  
    static int[][] result;  
    static int max = 0;  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        int m = sc.nextInt();  
        int n = sc.nextInt();  
        double[][] a = new double[m][n];  
        result = new int[m][n];  
        for(int i=0;i<m;i++){  
            for(int j=0;j<n;j++){  
                a[i][j] = sc.nextDouble();  
                result[i][j]=0;  
            }  
        }  
        for(int i=0;i<m;i++){  
            for(int j=0;j<n;j++){  
                result[i][j] = Calculate(a,m,n,i,j);  
                if(result[i][j]>max){  
                    max = result[i][j];  
                }  
            }  
        }  
        System.out.println(max);  
    }  
    private static int Calculate(double[][] a,int m,int n, int i, int j) {  
        if(result[i][j]>0){  
            return result[i][j];  
        }  
        int te=0,x;  
        if(j-1>=0&&a[i][j]>a[i][j-1]){  
            x=Calculate(a,m,n,i,j-1);  
            if(x>te){  
                te =x;  
            }  
        }  
        if(j+1<n&&a[i][j]>a[i][j+1]){  
            x=Calculate(a,m,n,i,j+1);  
            if(x>te){  
                te=x;  
            }  
        }  
        if(i-1>=0&&a[i][j]>a[i-1][j]){  
            x=Calculate(a,m,n,i-1,j);  
            if(x>te){  
                te=x;  
            }  
        }  
        if(i+1<n&&a[i][j]>a[i+1][j]){  
            x=Calculate(a,m,n,i+1,j);  
            if(x>te){  
                te=x;  
            }  
        }         
        return te+1;  
    }  
  
}  