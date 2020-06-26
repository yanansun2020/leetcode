from typing import List
class Solution:
    # divide and conquer
    # bottom up
    def mergeSort(self, nums: List[int]) -> List[int]:
        N = len(nums)
        if N == 1:
            return nums
        left_array = self.mergeSort(nums[0:N//2])
        right_array = self.mergeSort(nums[N//2:])
        return self.merge(left_array, right_array)

    def merge(self, nums1, nums2):
        i = 0
        j = 0
        result_array = []
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
               result_array.append(nums1[i])
               i +=1
            elif nums1[i] > nums2[j]:
                result_array.append(nums2[j])
                j +=1
            elif nums1[i] == nums2[j]:
                result_array.append(nums1[i])
                result_array.append(nums1[i])
                i += 1
                j += 1
        while i < len(nums1):
            result_array.append(nums1[i])
            i += 1
        while j < len(nums2):
            result_array.append(nums2[j])
            j += 1
        return result_array
def main():
    sol = Solution()
    result = sol.mergeSort([5, 7, 3, 1, 6])
    print(result)
if __name__ == "__main__":
    main()
