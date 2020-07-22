from typing import List
class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        ages.sort()
        count = 0
        def getTarget(left, right, target):
            while left <= right:
                mid = left + (right - left)//2
                if ages[mid] > target:
                    right = mid -1
                elif ages[mid] < target:
                    left = mid + 1
                else:
                    return mid + 1
            return left

        for i in range(len(ages)-1, 0, -1):
            target_ages = 0.5 * ages[i] + 7
            index = getTarget(0, i, target_ages)
            count += (i-index)
        return count

def main():
    sol = Solution()
    result = sol.numFriendRequests([16,16])
    print(result)
    result = sol.numFriendRequests([18, 16,18])
    print(result)
    result = sol.numFriendRequests([16,17,18])
    print(result)
    result = sol.numFriendRequests([20,30,100, 110,120])
    print(result)


if __name__ == "__main__":
    main()
