from typing import List
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if not strs:
            return []
        memo = {}
        for str in strs:
            key = ''.join(sorted(str))
            value = memo.get(key)
            if not value:
                value = []
            value.append(str)
            memo[key] = value
        result = []
        for k, v in memo.items():
            result.append(v)
        return result
def main():
    sol = Solution()
    amount = 3
    N = 2
    dp = [[0] * (amount + 1) for _ in range(N)]
    result = sol.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])
    print(result)

if __name__ == "__main__":
    main()