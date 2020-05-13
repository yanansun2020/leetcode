class Solution:
    def singleNonDuplicate(self, nums):
        left = 0
        right = len(nums) -1
        while (left <= right):
            if(left == right):
                return nums[left]
            isEven = ((right - left)/2)%2 == 0
            middle = int((left + right)/2)
            #go to left
            if isEven:
                if nums[middle] == nums[middle - 1]:
                    right = middle - 2
                else :
                    if nums[middle] == nums[middle + 1]:
                        left = middle + 2
                    else :
                        return nums[middle]


            if not isEven:
                if nums[middle] == nums[middle - 1]:
                    left = middle + 1
                else :
                    if nums[middle] == nums[middle + 1]:
                        right = middle -1
                    else:
                        return nums[middle]


def main():
    sol = Solution()
    result = sol.singleNonDuplicate([1,1,2,3,3])
    print(result)

if __name__ == "__main__":
    main()
