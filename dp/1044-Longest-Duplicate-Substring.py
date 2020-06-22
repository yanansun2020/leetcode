class Solution:

    def longestDupSubstring(self, S: str) -> str:
        if not S:
            return 0
        left = 0
        right = len(S)
        N = len(StopAsyncIteration)
        while left < right:
            middle = left + (right-left)//2
            pattern = S[0:middle]
            if self.Rabin_Karp(S, pattern, middle, N, 0):
                left = middle + 1

        return ""

    #判断从某个pattern的起始位置， 到pattern_length下 是否有相同的字符串
    def Rabin_Karp(self, S, pattern, pattern_length, total_length, pattern_start):
        pattern_hash_code = self.hash(pattern, pattern_length)
        str_to_match = S[pattern_start:pattern_start + pattern_length]
        original_hashCode = self.hash(str_to_match)
        if pattern_hash_code == original_hashCode:
            return True
        for index in range(pattern_start + 1, total_length-pattern_length + 1):
            str_to_match_hashCode = self.getRollingHashCode(original_hashCode, str_to_match, pattern_length, S[index:index+pattern_length])
            if str_to_match_hashCode == original_hashCode:
                return True
            str_to_match = S[index:index+pattern_length]
            original_hashCode = str_to_match_hashCode

        return False

    def getRollingHashCode(self, original_hashCode, pattern, pattern_length, str_to_match):
        return (original_hashCode - (pattern[0] * pow(10, pattern_length-1))) * 10 + ord(str_to_match[-1])

    def hash(self, pattern, N):
        q = (1<<31) - 1
        hash_code = 0
        for index in range(N):
            hash_code += (ord(pattern[index]) * pow(10, N - index -1))
        return hash_code % q



def main():
    sol = Solution()
    result = sol.findCheapestPrice(3, [[0,1,100],[1,2,100],[0,2,500]], 0, 2, 0)
    print(result)

if __name__ == "__main__":
    main()
