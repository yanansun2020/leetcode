from collections import Counter
class Solution:
    def reorganizeString(self, S: str) -> str:
        memo = dict(Counter(S).most_common())
        keys = list(memo.keys())
        key = keys[0]
        most_count = memo[key]
        array = ["" for i in range(most_count)]
        i = 0
        for string, count in memo.items():
            j = 0
            while j < count:
                array[i%most_count] += string
                j += 1
                i += 1
        result = ""
        for string in array:
            if result and result[-1] == string[0]:
                return ""
            result += string
        return result

def main():
    sol = Solution()
    result = sol.reorganizeString("vvvlo")
    print(result)
    result = sol.reorganizeString("aab")
    print(result)
    result = sol.reorganizeString("aaab")
    print(result)
if __name__ == "__main__":
    main()