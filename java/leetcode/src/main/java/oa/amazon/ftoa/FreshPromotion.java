package oa.amazon.ftoa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * KMP time: O(m + n) m: length of pattern n:length of the other string
 */
public class FreshPromotion {
    private int freshPromotion_naive(String[][] codeList, String[] shoppingCart){
        int cartIdx = 0, codeIdx = 0;
        while (cartIdx < shoppingCart.length && codeIdx < codeList.length) {
            String cur = shoppingCart[cartIdx];
//            If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
            if((codeList[codeIdx][0].equals("anything") || codeList[codeIdx][0].equals(cur)) && hasOrder(shoppingCart, cartIdx, codeList[codeIdx])){
                cartIdx += codeList[codeIdx++].length;
            }else{
                cartIdx++;
            }
        }
//        If the all the codeList is present then return 1, else 0.
        return codeIdx == codeList.length ? 1 : 0;
    }

    private static boolean hasOrder(String[] shoppingCart, int idx, String[] order) {
//        Loop through the codeList to check if the fruits are in order.
        for (String s : order) {
            if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))){
                idx++;
            }else{
                return false;
            }
        }
        return true;
    }


    private int freshPromotion(String[][] codeList, String[] shoppingCart){
        List<String> codeListStr = getcodeListStr(codeList);
        return substringSearch(shoppingCart, codeListStr);
    }

    /**
     * i always goes forward, j: the pointer for the pattern string, will go backward
     * @param customerList
     * @param p
     * @return
     */
    public int substringSearch(String[] customerList, List<String> p){
        int[] suffixTable = getKMPTable(p);
        int j = 0;
        int i = 0;
        while (i < customerList.length && j < p.size()){
            if(customerList[i].equals(p.get(j)) || "anything".equals(p.get(j))){
                j++;
                i++;
                continue;
            }
            if (j == 0){
                i++;
            }else {
                j = suffixTable[j-1];
            }
        }
        if (j == p.size()) {
            return 1;
        }
        return 0;
    }
    private List<String> getcodeListStr(String[][] codeListArray){
        List<String> codeList = new ArrayList<>();
        for (int i = 0; i < codeListArray.length; i++) {
            for (int j = 0; j < codeListArray[i].length; j++) {
                codeList.add(codeListArray[i][j]);
            }
        }
        return codeList;
    }

    int[] getKMPTable(List<String> codeList) {
        int[] table = new int[codeList.size()];
        int j = 0;
        for(int i = 1; i < codeList.size(); i++){
            while (j > 0 && !codeList.get(i).equals(codeList.get(j))){
                j = table[j - 1];
            }
            if(codeList.get(i).equals(codeList.get(j)) || codeList.get(i).equals("anything")){
                table[i] = j + 1;
                j++;
            }
        }
        return table;
    }

    @Test
    public void test(){
        String[][] codeList = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] cart = {"orange", "apple", "orange", "apple","apple", "banana", "orange", "banana", "orange"};
        int ans1 = freshPromotion(codeList, cart);
        cart = new String[]{"banana", "orange", "banana", "apple", "apple"};
        cart = new String[]{"apple", "banana", "apple", "banana", "orange", "banana"};
        int ans = freshPromotion(codeList, cart);
        codeList = new String[][]{{"apple", "apple"}, {"apple", "apple", "banana"}};
        cart = new String[]{"apple", "apple", "apple", "banana"};
        ans = freshPromotion(codeList, cart);

    }
}
