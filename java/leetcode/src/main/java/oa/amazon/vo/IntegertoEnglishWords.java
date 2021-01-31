package oa.amazon.vo;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntegertoEnglishWords {
    public String numberToWords(int num) {
        String s = String.valueOf(num);
        List<String> sList = getList(s);
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "Thousand");
        map.put(2, "Million");
        map.put(3, "Billion");
        StringBuilder sb = new StringBuilder();
        for (int i = sList.size() - 1; i >= 0; i--) {
            String tmp = parseHundres(sList.get(i));
            sb.append(tmp).append(" ").append(map.get(i)).append(" ");
        }
        return sb.toString().trim();
    }

    private String parseHundres(String s) {
        Integer sInt = Integer.parseInt(s);
        Integer hundredth = sInt/100;
        StringBuilder sb = new StringBuilder();
        if (hundredth != 0) {
            sb.append(ones(hundredth)).append(" ").append("Hundred ");
        }

        sInt = sInt % 100;
        if (sInt < 20 && sInt >= 10) {
            sb.append(tens(sInt));
            return sb.toString();
        }
        if (sInt < 10) {
            sb.append(ones(sInt));
            return sb.toString();
        }
        Integer tenth = sInt/10;
        sInt = sInt % 10;
        sb.append(twentys(tenth)).append(" ");
        if (sInt  != 0) {
            sb.append(ones(sInt));
        }
        return sb.toString();
    }

    private String ones(Integer num) {
        switch (num){
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }

    }

    private String twentys(Integer num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Fourty";
            case 5:
                return "Fivty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninty";
            default:
                return "";
        }
    }


    private String tens(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Forteen";
            case 15:
                return "Fivteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Ninteen";
            default:
                return "";
        }
    }


    private List<String> getList(String s) {
        int endIndex = s.length();
        int startIndex = endIndex - 3;
        List<String> res = new LinkedList<>();
        while (startIndex >= 0) {
            res.add(s.substring(startIndex, endIndex));
            endIndex = startIndex;
            startIndex = endIndex - 3;
        }
        if (startIndex < 0 && endIndex > 0) {
            res.add(s.substring(0, endIndex));
        }
        return res;

    }



    @Test
    public void test() {
        Integer a = 102;
        String s = numberToWords(a);
    }
}
