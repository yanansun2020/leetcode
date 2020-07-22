from typing import List
import bisect
class Solution:
    # using bisect() to find index to insert new element, right most possible index by default
    # using bisect_left() to find index to insert new element
    # using bisect_right() to find index to insert new element
    def numFriendRequests(self, ages: List[int]) -> int:
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
    # result = sol.numFriendRequests([16,16])
    # print(result)
    result = sol.numFriendRequests([16, 16, 17,17,17, 18,18])
    # idx = bisect.bisect([16, 17,17,17, 18,18], 17)
    print(result)
    result = sol.numFriendRequests([16,17,18])
    idx = bisect.bisect([16, 17,18], 17)
    print(result)
    result = sol.numFriendRequests([20,30,100, 110,120])
    print(result)


if __name__ == "__main__":
    main()
