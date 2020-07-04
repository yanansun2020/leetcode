class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        tmp = []
        for num in nums:

        def addToTmp(num):
            N = len(tmp)
            if N == 0:
                tmp.append(num)
                return
            l, r = 0, N -1
            while l <= r:
                if nums[]



def main():
    sol = Solution()
    # result = sol.search([2,5,6,0,0,1,2], 1)
    # print(result)
    result = sol.search([1, 3,1,1,1], 3)
    print(result)
    # result = sol.search([1,3,1,1,1], 3)
    # print(result)
if __name__ == "__main__":
    main()