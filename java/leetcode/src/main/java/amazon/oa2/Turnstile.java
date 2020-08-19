package amazon.oa2;

import org.junit.Test;

import java.util.PriorityQueue;

public class Turnstile {
    int[] getTime(int numCustomers, int[] arrTime, int[] directions){
        if(numCustomers<=0 || arrTime== null || arrTime.length == 0||directions==null ||directions.length == 0){
            return null;
        }
        PriorityQueue<Customer> in = new PriorityQueue<>((c1, c2)->c1.arrTim-c2.arrTim);
        PriorityQueue<Customer> out = new PriorityQueue<>((c1, c2)->c1.arrTim-c2.arrTim);
        for(int i =0; i<numCustomers; i++){
            if(directions[i] == 0){
                in.offer(new Customer(i, arrTime[i]));
            }else if(directions[i] == 1){
                out.offer(new Customer(i, arrTime[i]));
            }
        }
        LastTimeDirection last = new LastTimeDirection(-10, 1);
        int[] ans = new int[numCustomers];
        while(!in.isEmpty() && !out.isEmpty()){
            Customer inCus = in.peek();
            Customer outCus = out.peek();
            boolean used = Math.min(inCus.arrTim, outCus.arrTim) -last.lastTime <= 1;
            if(!used){
                if(inCus.arrTim < outCus.arrTim){
                    moveEle(in, out, last, ans, 0);
                }else{
                    moveEle(in, out, last, ans, 1);
                }
            }else{
                boolean canIn = inCus.arrTim -last.lastTime <= 1;
                boolean canOut = outCus.arrTim - last.lastTime <= 1;
                if(canIn && canOut){
                    if(last.lastDir == 0){
                        moveEle(in, out, last, ans, 0);
                    }else{
                        moveEle(in, out, last, ans, 1);
                    }
                }else if(canIn){
                    moveEle(in, out, last, ans, 0);
                }else{
                    moveEle(in, out, last, ans, 1);
                }
            }
        }
        while(!in.isEmpty()){
            moveEle(in, out, last, ans, 0);
        }
        while(!out.isEmpty()){
            moveEle(in, out, last, ans, 1);
        }
        return ans;
    }
    private void moveEle(PriorityQueue<Customer> in, PriorityQueue<Customer> out, LastTimeDirection last, int[] ans, int dir){
        PriorityQueue<Customer> queue = (dir == 1)? out : in;
        Customer customer = queue.poll();
        int time = Math.max(last.lastTime + 1, customer.arrTim);
        last.lastTime = time;
        last.lastDir = dir;
        ans[customer.customer] = time;

    }
    @Test
    public void test(){
        int[] time1 = {0,0,1,5};
        int[] directio1 = {0,1,1,0};
        int[] ans = getTime(4, time1, directio1);
        int[] time2 = {0,1,1,3,3};
        int[] directions2 = {0,1,0,0,1};
        int[] ans1 = getTime(5, time2, directions2);
    }
}

class Customer{
    int customer;
    int arrTim;
    int direction;
    Customer(){}
    Customer(int customer, int arrTims){
        this.customer = customer;
        this.arrTim = arrTims;
    }
}

class LastTimeDirection{
    int lastTime;
    int lastDir;
    LastTimeDirection(){}
    LastTimeDirection(int lastTime, int lastDir){
        this.lastTime = lastTime;
        this.lastDir = lastDir;
    }
}
