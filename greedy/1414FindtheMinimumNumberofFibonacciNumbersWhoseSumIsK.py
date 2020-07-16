class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        fibonacci = [1, 1]
        num = 0
        i = 2
        # builf fibonacci numbers
        while num <= k:
            num = fibonacci[i-1] + fibonacci[i-2]
            if num <= k:
                fibonacci.append(num)
            i += 1
        index = -1
        count = 0
        while k > 0:
            k -= fibonacci[index]
            count += 1
            index = self.binarySearch(fibonacci, k)
        return count

    def binarySearch(self, nums, target):
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (left + right)//2
            if nums[mid] == target:
                return mid
            if nums[mid] > target:
                right = mid -1
            if nums[mid] < target:
                left = mid + 1
        return left -1

def main():
    sol = Solution()
    result = sol.findMinFibonacciNumbers(7)
    print(result)
    result = sol.findMinFibonacciNumbers(10)
    print(result)
    result = sol.findMinFibonacciNumbers(19)
    print(result)

if __name__ == "__main__":
    main()