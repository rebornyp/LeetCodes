## Merge Interval
***

- 区间合并，主要是里面使用到了Comprator接口和内部类，大开眼界。
- 以及里面动态合并区间的集合思想也非常重要

***

```java
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString() {
    	return "(" + start + "~" + end + ")";
    }
}

***

public ArrayList<Interval> merge(ArrayList<Interval> intervals) {  
    ArrayList<Interval> res = new ArrayList<Interval>();  
    if(intervals==null || intervals.size()==0)  
        return intervals;  
    Comparator<Interval> comp = new Comparator<Interval>()  
    {  
        @Override  
        public int compare(Interval i1, Interval i2)  
        {  
            if(i1.start==i2.start)  
                return i1.end-i2.end;  
            return i1.start-i2.start;  
        }  
    };  
    Collections.sort(intervals,comp);  
      
    res.add(intervals.get(0));  
    for(int i=1;i<intervals.size();i++)  
    {  
        if(res.get(res.size()-1).end>=intervals.get(i).start)  
        {  
            res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);  
        }  
        else  
        {  
            res.add(intervals.get(i));  
        }  
    }  
    return res;  
}
```
