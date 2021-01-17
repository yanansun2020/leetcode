package oa.amazon.ftoa;

import org.junit.Test;

import java.util.PriorityQueue;

public class Turnstile {
    int processTime = -1;
    int preDirection = -1;// 0: enter, 1: exit
    public int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
        PriorityQueue<PersonTime> exit = new PriorityQueue<>((a, b)->a.arrTime == b.arrTime? a.personId - b.personId : a.arrTime - b.arrTime);
        PriorityQueue<PersonTime> enter = new PriorityQueue<>((a, b)->a.arrTime == b.arrTime? a.personId - b.personId : a.arrTime - b.arrTime);
        for (int i = 0; i < arrTime.length; i++) {
            if (direction[i] == 1) {
                exit.offer(new PersonTime(i, arrTime[i]));
            } else {
                enter.offer(new PersonTime(i, arrTime[i]));
            }
        }
        int[] ans = new int[numCustomers];
        processTime = -1;
        preDirection = -1;
        while (!exit.isEmpty() && !enter.isEmpty()) {
            PersonTime exitPerson = exit.peek();
            PersonTime enterPerson = enter.peek();
            //if both queue are line up
            if (exitPerson.arrTime <= processTime  && enterPerson.arrTime <= processTime) {
                if(preDirection == -1 || preDirection == 1){
                    exitPerson(exit, ans);
                    continue;
                }
                if (preDirection == 0) {
                    enterPerson(enter, ans);
                    continue;
                }
            }
            //If someone is waiting in the exit queue
            if (exitPerson.arrTime <= processTime) {
                exitPerson(exit, ans);
                continue;
            }
            //If someone is waiting in the enter queue
            if (enterPerson.arrTime <= processTime) {
                enterPerson(enter, ans);
                continue;
            }
            int minTime = Math.min(exitPerson.arrTime, enterPerson.arrTime);
            if (minTime > processTime ) {
                processTime = minTime;
                preDirection = -1;
            }
        }
        while (!exit.isEmpty()) {
            exitPerson(exit, ans);
        }
        while (!enter.isEmpty()) {
            enterPerson(enter, ans);
        }
        return ans;
    }

    private void enterPerson(PriorityQueue<PersonTime> enter, int[] ans){
        PersonTime enterPerson = enter.poll();
        ans[enterPerson.personId] = Math.max(processTime, enterPerson.arrTime);
        processTime++;
        preDirection = 0;
    }
    private void exitPerson(PriorityQueue<PersonTime> exit, int[] ans){
        PersonTime enterPerson = exit.poll();
        ans[enterPerson.personId] = Math.max(processTime, enterPerson.arrTime);
        processTime++;
        preDirection = 1;
    }


    @Test
    public void test(){
        int[] arrTime = new int[]{0,0,1,1,2,2,2,3,3,3,4,5,6,6,7,8,8,9,10,10,11,11,12,12,13,13,13,13,14,14,14,15,15,15,18,18,18,18,19,21,22,22,23,24,25,27,27,28,28,28,28,29,30,30,30,31,32,32,32,33,33,33,34,34,35,35,36,36,37,37,38,38,38,39,39,39,39,39,40,40,40,40,40,42,42,43,44,45,45,45,46,46,48,48,49,49,50,50,50,50};
        int[] directi = new int[]{0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,0,0,1,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,1,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,0,0,0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,1,0,0};
        int[] ans = getTimes(100, arrTime, directi);
        arrTime = new int[]{1,2,2,4,4};
        directi = new int[]{0, 1, 0, 0, 1};
        ans = getTimes(5, arrTime, directi);
    }
}

class PersonTime{
    int personId;
    int arrTime;
    PersonTime(){}
    PersonTime(int personId, int arrTime){
        this.personId = personId;
        this.arrTime = arrTime;
    }
}
