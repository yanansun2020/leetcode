from typing import List
import operator
class Solution:
    def isMonotonic(self, A: List[int]) -> bool:
        store = 0
        def cmp(a, b):
            return (a > b) - (a < b)
        for i in range(len(A)-1):
            c = cmp(A[i], A[i+1])
            if c:
                if c != store != 0:
                    return False
                store = c
        return True


    # two pass
    def isMonotonic_two_pass(self, A: List[int]) -> bool:
        def increase():
            for i in range(1, len(A)):
                if A[i] >= A[i-1]:
                    continue
                else:
                    return False
            return True

        def decreae():
            for i in range(1, len(A)):
                if A[i] <= A[i-1]:
                    continue
                else:
                    return False
            return True
        return increase() or decreae()

def main():
    sol = Solution()
    result = sol.isMonotonic([1,2,2,3])
    print(result)
    result = sol.isMonotonic([6,5,4,4])
    print(result)
    result = sol.isMonotonic([1,3,2])
    print(result)
    result = sol.isMonotonic([1,2,4,5])
    print(result)
    result = sol.isMonotonic([1,1,1])
    print(result)

if __name__ == "__main__":
    main()
