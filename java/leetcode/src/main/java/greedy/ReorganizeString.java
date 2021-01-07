package greedy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Same as RearrangeStringkDistanceApart, but with distance 2
 */
public class ReorganizeString {
    public String reOrg(String S){
        Map<Character, Integer> countMap = getFrequency(S);
        PriorityQueue<Character> queue = new PriorityQueue<Character>((o1, o2)->countMap.get(o2) - countMap.get(o1));
        queue.addAll(countMap.keySet());
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            Character cur = queue.poll();
            Character next = queue.poll();
            sb.append(cur).append(next);
            Integer freCur = countMap.get(cur);
            freCur--;
            Integer freNext = countMap.get(next);
            freNext--;
            if (freCur > 0) {
                queue.offer(cur);
            }
            if (freNext > 0) {
                queue.offer(next);
            }
        }
        if (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return "";
            } else {
                sb.append(queue.poll());
            }
        }
        return sb.toString();
    }
    private Map<Character, Integer> getFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;  i < s.length(); i++) {
            map.put(s.charAt(i), 1 + map.getOrDefault(s.charAt(i), 0));
        }
        return map;
    }
    public String reorganizeString(String S) {
        if (S == null || S.length() <= 1){
            return S;
        }
        S = frequencySort(S);
        char[] chars = S.toCharArray();
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            if (sameWithPrev(prev, cur)) {
                int index = findNextNotSame(cur, i, chars);
                if (index == -1) {
                    System.out.println("index is " + i);
                    return "";
                }
                swap(i, index, chars);
            }
            prev = chars[i];
        }
        return String.valueOf(chars);
    }

    private void swap(int i, int index, char[] chars) {
        char tmp = chars[index];
        chars[index] = chars[i];
        chars[i] = tmp;
    }

    private boolean sameWithPrev(char prev, char cur){
        return prev == cur;
    }
    private int findNextNotSame(char ch, int start,  char[] chars){
        for (int i = start + 1; i < chars.length; i++) {
            if (chars[i] != ch) {
                return i;
            }
        }
        return -1;
    }

    public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(frequency.entrySet());
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 0) {
            Map.Entry<Character, Integer> entry = maxHeap.remove();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String ans = reorganizeString("tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao");
    }
}
