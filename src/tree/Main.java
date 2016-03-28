package tree;
import java.io.*;
import java.util.*;
public class Main{
  private int n; //器官
  private float k1;
  private float k2;
  private float k;
  private float weight;
  private String stopGrowing="1";
  
  public Main(){}
  public Main(int n, float k1, float k2, float k, float weight){
    this.n = n;
    this.k1 = k1;
    this.k2 = k2;
    this.k = k;
    this.weight = weight;
  }
  
  private String grow(){
    int day = 1;
    while(weight <= k){
      if((k1+k2) <= 1){
    	  stopGrowing = "inf";
      break;
      }
    
    weight *= (k1 + k2);
    stopGrowing = day + "";
    day++;
    }
    return stopGrowing;
  }
  public static void main(String[] args){
  	List<String> out = new ArrayList<String>();
    String s;
    int T = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try{
    	s = br.readLine();
      	T = Integer.valueOf(s);
    }catch(IOException e){
      e.printStackTrace();
    }
    
    for(int i=1; i<=T; i++){
      String[] baseInfoList;
      String[] organWeightList;
      float firstDayWeight = 0;
      try{
        s = br.readLine();
        baseInfoList = s.split(" ");
        s = br.readLine();
        organWeightList = s.split(" ");
                            
        for(int j=0; j<organWeightList.length; j++){
        	firstDayWeight += Float.valueOf(organWeightList[i]);
        }
                                  
        Main cat = new Main(Integer.valueOf(baseInfoList[0]), 
                            Float.valueOf(baseInfoList[1]), 
                            Float.valueOf(baseInfoList[2]),
                            Float.valueOf(baseInfoList[3]),
                            firstDayWeight);
        
        out.add(cat.grow());
        }catch(IOException e){
          e.printStackTrace();
      }
    }
    
    for(int i=1; i<=T; i++){
      System.out.println("Case #" + i + ":" + out.get(i-1));
    }                     
  }
}