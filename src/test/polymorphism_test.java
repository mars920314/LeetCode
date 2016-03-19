package test;
//比如，一个父类有多个子类，父类若赋给不同子类的对象，则父类调用方法时，不同子类对象，调用不同方法
public class polymorphism_test {
	//定义应用
	public static void main(String[] args){
		people peoples;
		Chinese chinese = new Chinese();  //创建中国人
		American american = new American();  //创建美国人
		Japanese japanese = new Japanese();  //创建日本人
		peoples = chinese;
		peoples.speak();
		peoples = american;
		peoples.speak();
		peoples = japanese;
		peoples.speak();
	}
//最后运行该程序的结果为：
//中国人说中国话;美国人说英语;日本人说日本话
}

//定义人
class people{
	  public void speak(){
	      System.out.println("人们说话");
	  }
}

//定义中国人
class Chinese extends people{
	  public void speak(){
	      System.out.println("中国人说中国话");
	  }
}

//定义美国人
class American extends people{
	  public void speak(){
	      System.out.println("美国人说英语");
	  }
}

//定义日本人
class Japanese extends people{
	  public void speak(){
	      System.out.println("日本人说日本话");
	  }
}


