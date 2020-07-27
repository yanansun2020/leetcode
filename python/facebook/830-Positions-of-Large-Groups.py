from typing import List
class Solution:
    # Approach1-two pointers
    # Approach2- stack
    def largeGroupPositions(self, S: str) -> List[List[int]]:
        if not S:
            return []
        i, j = 0, 0
        S += "$"
        N = len(S)
        result = []
        while i < N:
            if S[i] == S[j]:
                i += 1
            else:
                if i-j >= 3:
                    result.append([j, i-1])
                j = i
        return result
def main():
    sol = Solution()
    result = sol.largeGroupPositions("aaa")
    print(result)
    result = sol.largeGroupPositions("abbxxxxzzy")
    print(result)
    result = sol.largeGroupPositions("abc")
    print(result)
    result = sol.largeGroupPositions("abcdddeeeeaabbbcd")
    print(result)


if __name__ == "__main__":
    main()
