package ArrayMap;
//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res=new ArrayList<Interval>();
        for(int i=0;i<intervals.size();i++){
            if(newInterval.start>intervals.get(i).end)
                res.add(intervals.get(i));
            else
                newInterval.start=Math.min(newInterval.start,intervals.get(i).start);
            if(newInterval.end<intervals.get(i).start)
                res.add(intervals.get(i));
            else
                newInterval.end=Math.max(newInterval.end, intervals.get(i).end);
        }
        for(int i=0;i<res.size();i++)
            if(newInterval.start<res.get(i).start){
                res.add(i, newInterval);
                break;
            }
        if(res.size()==0 || newInterval.start>res.get(res.size()-1).end)
            res.add(newInterval);
        return res;
    }

}
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}