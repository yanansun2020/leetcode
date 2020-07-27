from collections import Counter
from typing import List
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        counter = Counter(arr).most_common()
        for index in range(len(counter)-1,-1,-1):
            key = counter[index][0]
            value = counter[index][1]
            k -= value
            if k == 0:
                index -= 1
                break
            if k < 0:
                break
        return index + 1

def main():
    sol = Solution()
    result = sol.findLeastNumOfUniqueInts([4,3,1,1,3,3,2], 1)
    print(result)

if __name__ == "__main__":
    main()