package string;

import org.junit.Test;

public class IntegertoEnglishWords {
    int baseBillion = (int)1e9;
    int baseMillion = (int)1e6;
    int baseThousand = (int)1e3;
    int baseHundres = 100;
    int baseTen = 10;
    public String numberToWords(int num) {
        if(num ==0){
            return "Zero";
        }
        int billion = num /baseBillion ;
        int million = (num - billion * baseBillion) /baseMillion ;
        int thousand = (num - billion * baseBillion - million * baseMillion) / baseThousand;
        int rest = num - billion * baseBillion - million * baseMillion - thousand * baseThousand;
        String result = "";
        if (billion != 0)
            result = three(billion) + " Billion";
        if (million != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(million) + " Million";
        }
        if (thousand != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(rest);
        }
        return result;
    }
    public String one(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    public String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    public String two(int num) {
        if (num == 0)
            return "";
        else if (num < baseTen)
            return one(num);
        else if (num < 20)
            return twoLessThan20(num);
        else {
            int tenner = num / baseTen;
            int rest = num - tenner * baseTen;
            if (rest != 0)
                return ten(tenner) + " " + one(rest);
            else
                return ten(tenner);
        }
    }

    public String three(int num) {
        int hundred = num / baseHundres;
        int rest = num - hundred * baseHundres;
        String res = "";
        if (hundred*rest != 0)
            res = one(hundred) + " Hundred " + two(rest);
        else if ((hundred == 0) && (rest != 0))
            res = two(rest);
        else if ((hundred != 0) && (rest == 0))
            res = one(hundred) + " Hundred";
        return res;
    }
    @Test
    public void test(){
        int num = 1234;
        String ans = numberToWords(num);
    }

}
