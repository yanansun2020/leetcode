class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        tmp = []
        for num in nums:


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