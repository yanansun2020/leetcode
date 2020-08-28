package oa.amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SupplierMaxProfit {
    long highestProfit(int numSuppliers, List<Long> inventory, long order)
    {
        // WRITE YOUR CODE HERE
        long highestProfit = 0L;
        if(inventory == null || inventory.size() == 0){
            return highestProfit;
        }
        Collections.sort(inventory, (i1, i2)->i2.compareTo(i1));
        int supplierCount = 0;
        for(int i =0; i< inventory.size() && order > 0; i++){
            long cur = inventory.get(i);
            long next = (i == inventory.size() -1) ? 0 : inventory.get(i+1);
            supplierCount++;
            while(order > 0 && cur > next){
                highestProfit += (Math.min(order, supplierCount) * cur);
                cur--;
                order -= supplierCount;
            }
        }
        return highestProfit;
    }



    long highestProfit_2(int numSuppliers, List<Long> inventory, long order){
        long resProfit = 0;
        Collections.sort(inventory, (i1, i2)->i2.compareTo(i1));
        int supplierCount = 0;
        for(int i =0; i< inventory.size() && order > 0; i++){
            long cur = inventory.get(i);
            long next = i == inventory.size()-1? 0 : inventory.get(i+1);
            supplierCount++;
            while(order >0 && cur > next){
                resProfit += (Math.min(supplierCount, order) * cur);
                cur--;
                order -= supplierCount;
            }
        }
        return resProfit;

    }
    long highestProfit_1(int numSuppliers, List<Long> inventory, long order){
        Map<Long, Long> treeMap = new TreeMap<Long, Long>((o1, o2)->o2.compareTo(o1));
        for(int i=0; i<inventory.size(); i++){
            treeMap.put(inventory.get(i), treeMap.getOrDefault(inventory.get(i), 0L) + 1L);
        }
        long tmp = order;
        long maxProfit = 0L;
        for(Map.Entry<Long, Long> entry:treeMap.entrySet()){
            Long itemInStock = entry.getKey();
            Long itemSupplierCount = entry.getValue();
            if(tmp > 0){
                maxProfit += (itemInStock * Math.min(tmp, itemSupplierCount));
                tmp -= itemSupplierCount;
                treeMap.put(itemInStock-1, treeMap.getOrDefault(itemInStock-1, 0L) + itemSupplierCount);
            }else{
                break;
            }
        }
        return maxProfit;
    }
    @Test
    public void test(){
        List<Long> inventory = new ArrayList<Long>(){
            {
                add(2L);
                add(5L);
//                add(5L);
            }
        };
        long a = highestProfit(2, inventory, 4L);
        long b = highestProfit(3, inventory, 3L);
        long c = highestProfit(3, inventory, 100L);
    }
}
class StockSupplier{
    int stock;
    int supplierCount;
    StockSupplier(){}
    StockSupplier(int stock, int supplierCount){
        this.stock = stock;
        this.supplierCount = supplierCount;
    }
}
