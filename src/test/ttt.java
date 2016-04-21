package test;

class ttt {

	public static void main(String[] args) {
		int ans = 0;
		for(int i=100; i<=999; i++){
			int j1 = i/100;
			int j2 = i%100/10;
			int j3 = i%10;
			if((j1 == j2) ||(j2 == j3)||(j1 == j3)){
				if((j1+j2 > j3) && (j1 + j3 > j2) &&(j2 + j3 > j1)){
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
