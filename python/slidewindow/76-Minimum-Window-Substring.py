from collections import defaultdict
import sys
#sliding window to record the valid string
# count to record the length
# 先扫描一遍T，把对应的字符及其出现的次数存到 HashMap 中。
# 然后开始遍历S，就把遍历到的字母对应的 HashMap 中的 value 减一，如果减1后仍大于等于0，cnt 自增1。
# 如果 cnt 等于T串长度时，开始循环，纪录一个字串并更新最小字串值。然后将子窗口的左边界向右移，
# 如果某个移除掉的字母是T串中不可缺少的字母，那么 cnt 自减1，表示此时T串并没有完全匹配。
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        frequency = defaultdict(int)
        for t_ in t:
            frequency[t_] += 1
        count = 0
        j = 0
        min_length = sys.maxsize
        result_str = ""
        for i, s_ in enumerate(s):
            frequency[s_] -= 1
            if frequency[s_] >= 0:
                count+=1
            while count == len(t):
                if i - j + 1 < min_length:
                    min_length = i - j + 1
                    result_str = s[i-min_length +1:i+1]
                frequency[s[j]] += 1
                if frequency[s[j]] > 0:
                    count -= 1
                j += 1
        return result_str

def main():
    sol = Solution()
    result = sol.minWindow("ADOBECODEBANC", "ABC")
    print(result)
    result = sol.minWindow("ADOABC", "ABC")
    print(result)
    result = sol.minWindow("ADOABCODEBANC", "ABC")
    print(result)

if __name__ == "__main__":
    main()

