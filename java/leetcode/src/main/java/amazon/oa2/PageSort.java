package amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PageSort {
    List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, PairInt> items,
                                     int sortParameter, int sortOrder,//0-asc 1-desc  0-name 1-relevance 2-price
                                     int itemPerPage, int pageNumber){
        if(numOfItems < 1 || items == null || items.size() == 0){
            return new ArrayList<>();
        }
        List<PageItem> pageItems = new ArrayList<>();
        for(Map.Entry<String, PairInt> item : items.entrySet()){
            pageItems.add(new PageItem(item.getKey(), item.getValue().first, item.getValue().second));
        }
        Collections.sort(pageItems, (item1, item2)->{
            if(sortParameter == 0){
                return sortOrder == 0 ? item1.itemName.compareTo(item2.itemName) : item2.itemName.compareTo(item1.itemName);
            }else if(sortParameter == 1){
                return sortOrder == 0? item1.relevance-item2.relevance : item2.relevance-item1.relevance;
            }
            return sortOrder == 0?item1.price-item2.price : item2.price-item1.price;
        });
        int size =  pageItems.size();
        int start = pageNumber*itemPerPage;
        List<PageItem> ansPageItem = pageItems.subList(start, Math.min((pageNumber+1)*itemPerPage,size));
        return ansPageItem.stream().map(PageItem::getItemName).collect(Collectors.toList());
    }

    @Test
    public void test(){
        HashMap<String, PairInt> items = new HashMap<>();
        items.put("item1", new PairInt(10, 15));
        items.put("item2", new PairInt(3,4));
        items.put("item3", new PairInt(17, 8));

        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        List<String> b = a.subList(1, 2);
        List<String> ans = fetchItemsToDisplay(3,items, 1, 0, 2, 1);

    }
}
class PageItem{
    String itemName;
    int relevance;
    int price;
    PageItem(String itemName, int relevance, int price){
        this.itemName = itemName;
        this.relevance = relevance;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }
}
