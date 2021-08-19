package com.algorithms.interview.heap;

import java.util.*;

public class MinMeetingRooms {
    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        final int N = intervals == null ? 0 : intervals.size();

        // 把所有的会议时间段都按start来排序
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // 这里要按照会议室的结束时间来排序
        Queue<Integer> meetingRooms = new PriorityQueue<>((v1, v2) -> v1 - v2);

        for (Interval meeting : intervals) {
            if (!meetingRooms.isEmpty() && meetingRooms.peek() <= meeting.start) {
                // 我们需要把这个会议室的结束时间修改一下
                // 当然，优先级队列里面是不好直接修改元素值的
                // 那我们只能采用先出队，再把当前会议结束时间入队的方式
                meetingRooms.poll();
                meetingRooms.add(meeting.end);
            } else {
                // 如果找不到会议室，那么新开一间
                // 标记其结束时间
                meetingRooms.add(meeting.end);
            }
        }
        return meetingRooms.size();
    }

}
