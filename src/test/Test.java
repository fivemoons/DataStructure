package test;

public class Test{
	public void changeString(String sVar){
		sVar = "changeString";
	}
	public void changeObj(Test objVar){
		objVar.setMStr("changeString");
	}
	private String mStr = "";
	public String getMStr(){
		return mStr;
	}
	public void setMStr(String str){
		mStr = str;
	}
	public static void main(String[] args){
		Test t = new Test();
		t.setMStr("main");
		String s4Test = "main";
		t.changeString(s4Test);
		System.out.println(s4Test);
		t.changeObj(t);
		System.out.println(t.getMStr());
	}
}