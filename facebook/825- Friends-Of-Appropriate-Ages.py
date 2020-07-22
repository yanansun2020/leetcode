from typing import List
import bisect
from collections import Counter
class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        memo = dict(Counter(ages))
        sorted_ages = list(memo.keys())
        sorted_ages.sort(reverse = True)
        count = 0
        for i, age in enumerate(sorted_ages):
            low_age = int(age * 0.5) + 7
            j = i
            while j <len(sorted_ages) and sorted_ages[j] > low_age:
                if j == i:
                    count += (memo[age] *  (memo[age] -1)) if memo[age] > 1 else 0
                else:
                    count += memo[age] * memo[sorted_ages[j]]
                j += 1

        return count

    # using bisect() to find index to insert new element, right most possible index by default
    # using bisect_left() to find index to insert new element
    # using bisect_right() to find index to insert new element
    def numFriendRequests_bisect(self, ages: List[int]) -> int:
        ages.sort()
        n = len(ages)
        total = 0
        for age in ages:
            low_age = int(age * 0.5) + 7
            high_age = age
            if low_age >= high_age:
                continue
            lo = bisect.bisect(ages, low_age)
            if lo >= n:
                continue
            hi = bisect.bisect(ages, high_age) - 1
            total += hi - lo
        return total

def main():
    sol = Solution()
    result = sol.numFriendRequests([16,16])
    print(result)
    result = sol.numFriendRequests([16, 16, 17,17,17, 17, 18,18])
    result = sol.numFriendRequests_bisect([16, 16, 17,17,17, 17, 18,18])
    # idx = bisect.bisect([16, 17,17,17, 18,18], 17)
    print(result)
    result = sol.numFriendRequests([16,17,18])
    idx = bisect.bisect([16, 17,18], 17)
    print(result)
    result = sol.numFriendRequests([20,30,100, 110,120])
    print(result)


if __name__ == "__main__":
    main()
