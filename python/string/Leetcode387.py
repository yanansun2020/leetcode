from collections import Counter
class Solution:
    def firstUniqChar(self, s: str) -> int:
        counter =Counter(s)
        for idx, ch in enumerate(s):
            if counter[ch] == 1:
                return idx
        return -1


def main():
    sol = Solution()
    s = "loveleetcode"
    result = sol.firstUniqChar(s)
    print(result)
    # print(Counter(s).most_common())
    # result = sol.frequencySort("Aabb")
    # for x,c in Counter(s).most_common():
    #     print(x)
    #     print(c)

    # result = ''.join(c*x for x,c in Counter(s).most_common())
    # s1 = 'abc'
    # s2 = '123'
    # print('s1.join(s2):', ''.join(s2))

if __name__ == "__main__":
    main()