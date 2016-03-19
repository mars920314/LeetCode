package ArrayMap;
//Given a collection of intervals, merge all overlapping intervals.
//Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
	//wrong, when Input:[[1,4],[0,0]]
	public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> res=new ArrayList<Interval>();
        int start=0;
        int end=0;
        if(intervals.size()<2)
            return intervals;
        for(int i=0;i<intervals.size();i++){
            start=intervals.get(i).start;
            end=intervals.get(i).end;
            while(i<intervals.size()-1 && intervals.get(i).end>=intervals.get(i+1).start){
                start=Math.min(intervals.get(i).start, intervals.get(i+1).start);
                end=Math.max(intervals.get(i).end, intervals.get(i+1).end);
                i++;
            }
            res.add(new Interval(start,end));
        }
        return res;
    }

}
