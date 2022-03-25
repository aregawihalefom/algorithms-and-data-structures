package patterns.mergeInterval;


/*
 * Definition of Interval:
 * public classes Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

import utilites.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 *  Intervals : Sort and then work
 *
 *   Determine if there is overlap , he can't
 *
 *
 */

public class MeetingRooms {


    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {


        Collections.sort(intervals, ((o1, o2) -> Integer.compare(o1.getStart(), o2.getStart())));

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            Interval prev = intervals.get(i-1);
            if(current.getStart() <= prev.getEnd())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        MeetingRooms meetingRooms = new MeetingRooms();

        //[(0,30),(5,10),(15,20)]
        Interval interval1 = new Interval(0, 30);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(15, 20);

        List<Interval> meetings = new ArrayList<>();
        meetings.add(interval1);meetings.add(interval2);meetings.add(interval3);
        System.out.println(meetingRooms.canAttendMeetings(meetings));
    }

}
