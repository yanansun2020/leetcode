import operator
from collections import Counter
class Solution:
    def frequencySort(self, s: str) -> str:
        myDict = {}
        result = ""
        for string in s:
            num = myDict.get(string)
            if not num:
                num = 0
            num = num + 1
            myDict[string] = num
        sorted_dict = dict(sorted(myDict.items(), key=operator.itemgetter(1), reverse=True))
        for k,v in sorted_dict.items():
             for i in range(v):
                result = result + k
        return result

    def frequencySort1(self, s: str) -> str:
         return ''.join(c*x for x,c in Counter(s).most_common())


def main():
    sol = Solution()
    s = "Aabb"
    print(Counter(s).most_common())
    result = sol.frequencySort("Aabb")
    for x,c in Counter(s).most_common():
        print(x)
        print(c)

    result = ''.join(c*x for x,c in Counter(s).most_common())
    s1 = 'abc'
    s2 = '123'
    print('s1.join(s2):', ''.join(s2))

if __name__ == "__main__":
    main()