package leetcode;

import java.util.TreeSet;
//Treeset
public class ExamRoom {
    private int N;
    private TreeSet<Integer> seats = new TreeSet<>();
    private TreeSet<Interval> intervals = new TreeSet<Interval>();

    public ExamRoom(int N) {
        this.N = N;
        seats.add(-1);
        seats.add(N);
        intervals.add(new Interval(-1, N));
    }

    public int seat() {
        Interval first = intervals.pollFirst();
        if (first.start == -1){
            seats.add(0);
            intervals.add(new Interval(0, first.end));
            return 0;
        }
        if (first.end == N){
            seats.add(N-1);
            intervals.add(new Interval(first.start, N-1));
            return N-1;
        }
        int middle = (first.start + first.end)/2;
        seats.add(middle);
        intervals.add(new Interval(first.start, middle));
        intervals.add(new Interval(middle, first.end));
        return middle;
    }

    public void leave(int p) {
        Integer left = seats.lower(p);
        Integer right = seats.higher(p);
        Interval new_interval = new Interval(left, right);
        Interval interval_1 = new Interval(left, p);
        Interval interval_2 = new Interval(p, right);
        seats.remove(p);
        intervals.remove(interval_1);
        intervals.remove(interval_2);
        intervals.add(new_interval);
    }

    class Interval implements Comparable<Interval>{
        public Interval(){}
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int start;
        public int end;

        @Override
        public int compareTo(Interval interval) {
            int distance_1 = getDistance(interval);
            int distance_2 = getDistance(this);
            if (distance_1 == distance_2) {
                return this.start - interval.start;
            }
            return distance_1 - distance_2;
        }
        public int getDistance(Interval interval){
            if(interval.start < 0){
                return interval.end - 0;
            }
            if(interval.end == N){
                return N-1 - interval.start;
            }
            int middle = (interval.start + interval.end) / 2;
            return Math.min(middle-interval.start, interval.end-middle);
        }
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(8);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(7);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());

    }

}

