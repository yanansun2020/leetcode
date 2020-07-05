from typing import List
class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        if not left:
            min_value = min(right)
            return n - min_value
        if not right:
            max_value = max(left)
            return max_value
        if max(left) < min(right):
            return max(max(left), n-min(right))
        l = min(right)
        r = max(left)
        l_step = -1
        r_step = -1
        while l <= r :
            l = l + 1
            r = r -1
            l_step += 1
            r_step += 1
        l_step += (l-1)
        r_step += (n -(r+1))
        if l -r == 2:
            return max(l_step, r_step)
        else:
            return max(l_step, r_step) + 1
def main():
    sol = Solution()
    result = sol.getLastMoment(4, [4,3], [0,1])
    print(result)
    result = sol.getLastMoment(7, [], [0,1,2,3,4,5,6,7])
    print(result)
    result = sol.getLastMoment(7,  [0,1,2,3,4,5,6,7], [])
    print(result)
    result = sol.getLastMoment(9,  [5], [4])
    print(result)
    result = sol.getLastMoment(6,  [6], [0])
    print(result)
    result = sol.getLastMoment(12,  [7,1], [12, 11])
    print(result)




if __name__ == "__main__":
    main()


