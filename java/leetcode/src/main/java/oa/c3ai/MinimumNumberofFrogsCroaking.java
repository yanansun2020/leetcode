package oa.c3ai;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofFrogsCroaking {
    public int minNumberOfFrogs_1(String croakOfFrogs) {
        int cnt[] = new int[5];
        int frogs = 0, max_frogs = 0;
        for (int i = 0; i < croakOfFrogs.length(); ++i) {
            int ch = croakOfFrogs.charAt(i);
            int n = "croak".indexOf(ch);
            ++cnt[n];
            if (n == 0)
                max_frogs = Math.max(max_frogs, ++frogs);
            else if (--cnt[n - 1] < 0)
                return -1;
            else if (n == 4)
                --frogs;
        }
        return frogs == 0 ? max_frogs : -1;
    }


    public int minNumberOfFrogs(String croakOfFrogs) {
        if (!croakOfFrogs.startsWith("c") || !croakOfFrogs.endsWith("k") || croakOfFrogs.length()%5 != 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 0);
        map.put('o', 0);
        map.put('a', 0);
        map.put('k', 0);
        int frog = 0;
        int res = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            Character c = croakOfFrogs.charAt(i);
            map.put(c, map.get(c) + 1);
            if (c=='c') {
                frog++;
            }
            if (c =='k') {
                frog--;
            }
            res = Math.max(res, frog);
            if (!isValid(map)) {
                return -1;
            }
        }
        if (!isComplete(map)) {
            return -1;
        }
        return res;
    }

    boolean isValid(Map<Character, Integer> map){
        if (map.get('c') < map.get('r')) {
            return false;
        }
        if (map.get('r') < map.get('o')) {
            return false;
        }
        if (map.get('o') < map.get('a')) {
            return false;
        }
        if (map.get('a') < map.get('k')) {
            return false;
        }
        return true;
    }
    boolean isComplete(Map<Character, Integer> map){
        if (!map.get('c').equals(map.get('r'))) {
            return false;
        }
        if (!map.get('r').equals(map.get('o'))) {
            return false;
        }
        if (!map.get('o').equals(map.get('a'))) {
            return false;
        }
        if (!map.get('a').equals(map.get('k'))) {
            return false;
        }
        return true;
    }
    @Test
    public void test(){
        String s = "ccccccccccrrccccccrcccccccccccrcccccccccrcccccccccccrcccccrcccrrcccccccccccccrocrrcccccccccrccrocccccrccccrrcccccccrrrcrrcrccrcoccroccrccccccccorocrocccrrrrcrccrcrcrcrccrcroccccrccccroorcacrkcccrrroacccrrrraocccrrcrrccorooccrocacckcrcrrrrrrkrrccrcoacrcorcrooccacorcrccccoocroacroraoaarcoorrcrcccccocrrcoccarrorccccrcraoocrrrcoaoroccooccororrrccrcrocrrcorooocorarccoccocrrrocaccrooaaarrcrarooaarrarrororrcrcckracaccorarorocacrrarorrraoacrcokcarcoccoorcrrkaocorcrcrcrooorrcrroorkkaaarkraroraraarooccrkcrcraocooaoocraoorrrccoaraocoorrcokrararrkaakaooroorcororcaorckrrooooakcarokokcoarcccroaakkrrororacrkraooacrkaraoacaraorrorrakaokrokraccaockrookrokoororoooorroaoaokccraoraraokakrookkroakkaookkooraaocakrkokoraoarrakakkakaroaaocakkarkoocokokkrcorkkoorrkraoorkokkarkakokkkracocoaaaaakaraaooraokarrakkorokkoakokakakkcracarcaoaaoaoorcaakkraooaoakkrrroaoaoaarkkarkarkrooaookkroaaarkooakarakkooaokkoorkroaaaokoarkorraoraorcokokaakkaakrkaaokaaaroarkokokkokkkoakaaookkcakkrakooaooroaaaaooaooorkakrkkakkkkaokkooaakorkaroaorkkokaakaaaaaocrrkakrooaaroroakrakrkrakaoaaakokkaaoakrkkoakocaookkakooorkakoaaaaakkokakkorakaaaaoaarkokorkakokakckckookkraooaakokrrakkrkookkaaoakaaaokkaokkaaoakarkakaakkakorkaakkakkkakaaoaakkkaoaokkkakkkoaroookakaokaakkkkkkakoaooakcokkkrrokkkkaoakckakokkocaokaakakaaakakaakakkkkrakoaokkaakkkkkokkkkkkkkrkakkokkroaakkakaoakkoakkkkkkakakakkkaakkkkakkkrkoak";
        int asn = minNumberOfFrogs(s);
    }
}
