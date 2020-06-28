from collections import defaultdict
class Solution:
    def longestDupSubstring(self, S: str) -> str:
        if not S:
            return ''
        h = 1
        d = 26
        q = 1<< 32
        left = 0
        right = len(S)
        result = ''
        while left <= right:
            middle = left + (right-left)//2
            # if middle == 9:
            #     print(middle)
            find_result, find_pattern = self.helper(S, middle, h, d, q)
            if find_result == True:
                result = find_pattern
                left = middle + 1
            if find_result == False:
                right = middle -1
        return result

    #判断从某个pattern的起始位置， 到pattern_length下 是否有相同的字符串
    def helper(self, S, L, h, d, q):
        #slide window to get String
        memo = defaultdict(list)
        for i in range(L-1):
            h = (h*d)%q
        hashcode_s = 0
        for index in range(0, len(S) - L + 1):
            if index == 0:
                hashcode_s = self.hashCode(S[index:index+L], L, d, q)
            else:
                hashcode_s = (d*(hashcode_s-ord(S[index-1])*h) + ord(S[index+L-1]))%q
                # if L== 11 or L ==9 or L ==10 or word == "dccdbcebdda":
                #     print(11111)
                #     print(hashcode_s)
                #     print(word)
                # if hashcode_s == "577004641":
                #     print(memo[hashcode_s])
                # 说明之前计算除来过这个hsahcode_s
                for previous_index in memo[hashcode_s]:
                    if  S[previous_index:previous_index+L] == S[index:index+L]:
                        return True, S[index:index+L]
            memo[hashcode_s].append(index)
        return False, ''
    def hashCode(self, pattern, L, d, q):
        p = 0
        for i in range(L):
            p = (d*p + ord(pattern[i]))%q
        return p

def main():
    sol = Solution()
    result = sol.longestDupSubstring("banana")
    print(result)

if __name__ == "__main__":
    main()
