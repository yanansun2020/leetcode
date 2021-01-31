package oa.wepay.oa;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Currencyrecognization {
    Set<Character> set = new HashSet<>();
    public boolean isCurrency(String s) {
        set.add('$');
        set.add('¥');
        set.add('€');
        if (s == null || s.length() == 0 || s.length() == 1) {
            return false;
        }
        Character c0 = s.charAt(0);
        if (!isValidSymbol(c0, s)) {
            return false;
        }
        if (s.startsWith("(")) {
            s = s.substring(1, s.length() - 1);
        }
        int digitStartIndex = getDigitStartIndex(s);
        return isValidNum(s.substring(digitStartIndex));
    }

    private boolean isValidNum(String s) {
        if(s.startsWith("0")) {
            if (numOfDot(s) != 1) {
                return false;
            }
            return validDecimal(s);
        }
        if (s.contains(",") && s.contains(".")) {
            if (numOfDot(s) != 1) {
                return false;
            }
            return validSeparator(s.substring(0, s.indexOf('.')));
        }
        if (s.contains(",") && validSeparator(s)) {
            return true;
        }
        return allnumber(s);
    }

    private boolean allnumber(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validSeparator(String s) {
        if (s.length() <= 4) {
            return false;
        }
        int lastIndex = s.length();
        int i = s.length() - 4;
        for (; i >= 0; i -= 4) {
            if (s.charAt(i) == ','  && validThree(s.substring(i + 1, lastIndex))) {
                lastIndex = i;
            } else {
                return false;
            }
        }
        String sub = s.substring(0, lastIndex);
        return validThree(sub);
    }

    private boolean validThree(String substring) {
        for (int i = 0; i < substring.length(); i++) {
            if (!Character.isDigit(substring.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validDecimal (String s) {
        int dotIndex = s.indexOf('.');
        return s.substring(dotIndex + 1).length() == 2;
    }

    private int numOfDot(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                count++;
            }
        }
        return count;
    }

    private boolean isValidSymbol(Character c, String s) {
        Character second = s.charAt(1);
        if (set.contains(c)) {
            return Character.isDigit(second);
        }
        if (c == '(' || c == '-') {
            boolean res = set.contains(second) && s.length() > 2 && Character.isDigit(s.charAt(2));
            if (c == '(') {
                return res && s.charAt(s.length() - 1) ==')';
            }
            return res;
        }
        return false;
    }
    private int getDigitStartIndex(String s) {
        int i = 0;
        for (; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!Character.isDigit(c)) {
                continue;
            }
            break;
        }
        return i;
    }

    @Test
    public void test() {
        String[] s = new String[]{"$450", "-€23", "(¥2400)", "$4,500.00", "€0.25"};
        String[] p = new String[] {"($)","cat", "^24", "$45,0", "(€350", "(-$3.50)", "¥120.00", "$-50", " €43.56", "$65.", "€82.1", "48.50", "¥1200,000"};
        for (String ss : s) {
            boolean isCa = isCurrency(ss);
            System.out.println(isCa);

        }
        for (String pp : p) {
            boolean isCa = isCurrency(pp);
            System.out.println(isCa);
        }
        boolean isCa = isCurrency("(¥2400)");
    }
}
