package devidedConquer;
import java.util.ArrayList;
public class ClosestPairs {
	public static void main(String[] args){
		ArrayList<Point> points=new ArrayList<Point>();
		//require points are sorted by point.x
		points.add(new Point(2,3));
		points.add(new Point(3, 4));
		points.add(new Point(5, 1));
		points.add(new Point(12, 10));
		points.add(new Point(12, 30));
		points.add(new Point(40, 50));
	    double n = points.size();
	    ClosestPairs closestpair=new ClosestPairs();
	    System.out.println("The smallest distance is "+ closest(points, n));
	}
	public static double closest(ArrayList<Point> points,double n){
		if(n==1)
			return Integer.MAX_VALUE;
		if(n==2)
			return distance(points.get(0),points.get(1));
		int i;
		ArrayList<Point> leftsubpoints=new ArrayList<Point>();
		for(i=0;i<n/2;i++)
			leftsubpoints.add(points.get(i));
		double leftdis=closest(leftsubpoints, leftsubpoints.size());
		ArrayList<Point> rightsubpoints=new ArrayList<Point>();
		for(i=(int) (n/2+1);i<n;i++)
			rightsubpoints.add(points.get(i));
		double rightdis=closest(rightsubpoints, rightsubpoints.size());
		double mindis=merge(leftsubpoints, rightsubpoints, Math.min(leftdis, rightdis));
		return mindis;
	}
	public static double distance(Point a, Point b){
		return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}
	public static double merge(ArrayList<Point> leftsubpoints,ArrayList<Point> rightsubpoints, double min){
		for(int i=0; i<leftsubpoints.size();i++){
			for(int j=0;j<rightsubpoints.size();j++){
				if(rightsubpoints.get(j).x-leftsubpoints.get(i).x<min)
					if(distance(rightsubpoints.get(j),leftsubpoints.get(i))<min)
						min=distance(rightsubpoints.get(j),leftsubpoints.get(i));
					else ;
				else
					break;
			}
		}
		return min;
	}

}
class Point{
	int x,y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}