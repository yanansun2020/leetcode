from collections import Counter
class Solution:
    def minSteps(self, s: str, t: str) -> int:
        counter_s = dict(Counter(s))
        counter_t = dict(Counter(t))
        result = 0
        for k_s, v_s in counter_s.items():
            v_t = counter_t.get(k_s)
            if v_t:
                v_s -= v_t
                if v_s < 0:
                    v_s = 0
            result += v_s
        return result


