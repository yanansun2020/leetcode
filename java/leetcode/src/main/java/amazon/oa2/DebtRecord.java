package amazon.oa2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DebtRecord {
    public List<String> maxDebt(int rows, int cols, List<Debt> records){
        Set<String> users = new HashSet<>();
        Map<String, Integer> borrowerMap = new HashMap<>();
        Map<String, Integer> lenderMap = new HashMap<>();
        for(Debt debt : records){
            borrowerMap.put(debt.borrower, borrowerMap.getOrDefault(debt.borrower, 0) + debt.amount);
            lenderMap.put(debt.lender, lenderMap.getOrDefault(debt.lender, 0) + debt.amount);
            users.add(debt.borrower);
            users.add(debt.lender);
        }
        PriorityQueue<UserBalance> queue = new PriorityQueue<>((u1, u2)->u1.balance - u2.balance);
        Integer maxNegativeBalance = Integer.MAX_VALUE;
        for(String user : users){
            Integer plus = lenderMap.get(user);
            Integer minus = borrowerMap.get(user);
            if(plus == null){
               plus = 0;
            }
            if(minus == null){
                minus = 0;
            }
            if(plus - minus < 0){
                maxNegativeBalance = Math.min(maxNegativeBalance, plus - minus);
                UserBalance userBalance = new UserBalance(user, plus -minus);
                queue.offer(userBalance);
            }
        }
        List<String> ans = new ArrayList<>();
        if(queue.isEmpty()){
            ans.add("Nobody has a negative balance");
            return ans;
        }
        while(!queue.isEmpty()){
            if(maxNegativeBalance.equals(queue.peek().balance) ){
                ans.add(queue.poll().user);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
class Debt{
    String borrower;
    String lender;
    int amount;
}

class UserBalance{
    String user;
    Integer balance;
    UserBalance(){}
    UserBalance(String user, Integer balance){
        this.user = user;
        this.balance = balance;
    }
}
