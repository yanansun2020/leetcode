from typing import List
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        s1_length = len(s)
        s2_length = len(p)
        result = []
        if s1_length < s2_length:
            return result
        feq_s1 = [0] * 26
        feq_s2 = [0] * 26

        for index in range(s2_length):
            s_s1 = s[index]
            s_s2 = p[index]
            pos = ord(s_s1)-ord('a')
            pos_1 = ord(s_s2) - ord('a')
            feq_s1[pos] = 1 + feq_s1[pos]
            feq_s2[pos_1] = 1 + feq_s2[pos_1]

        if feq_s1 == feq_s2:
           result.append(0)

        for index in range(s2_length, s1_length):
            s_s1 =s[index]
            pos = ord(s_s1) - ord('a')
            feq_s1[pos] = 1 + feq_s1[pos]
            s_s1_tmp = s[index - s2_length]
            pos_1 = ord(s_s1_tmp) - ord('a')
            feq_s1[pos_1] = feq_s1[pos_1] -1
            if feq_s1 == feq_s2:
                result.append(index - s2_length + 1)
        return result




def main():
    sol = Solution()
    # result = sol.findAnagrams("cbaebabacd", "abc")
    # print(result)
    result = sol.findAnagrams("abab", "ab")
    print(result)

if __name__ == "__main__":
    main()