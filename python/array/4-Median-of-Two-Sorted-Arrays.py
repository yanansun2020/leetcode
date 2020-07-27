from typing import List
import statistics
import sys
class Solution:
    #https://www.youtube.com/watch?v=LPFhl65R7ww&t=1013s
    #binary search
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        N1 = len(nums1)
        N2 = len(nums2)
        #guarantee N1 <= N2
        if N1 > N2:
            return self.findMedianSortedArrays(nums2, nums1)
        low, high = 0, N1
        partition = int ((N1 + N2 + 1)/2)
        while low <= high:
            mid_1 = int((low+high)/2)
            mid_2 = partition - mid_1
            min_value_1 = nums1[mid_1-1] if mid_1 >0 else -sys.maxsize - 1
            min_value_2 = nums2[mid_2-1] if mid_2> 0 else -sys.maxsize - 1
            max_value_1 = nums1[mid_1] if mid_1< N1 else sys.maxsize
            max_value_2 = nums2[mid_2] if mid_2<N2 else sys.maxsize
            if min_value_1 <= max_value_2 and min_value_2 <= max_value_1:
                if (N1 + N2)%2 == 0:
                    return (max(min_value_1, min_value_2)+ min(max_value_1, max_value_2))/2
                else:
                    return max(min_value_1, min_value_2)
            if min_value_1 > max_value_2:
                high = mid_1 -1
            if min_value_2 > max_value_1:
                low = mid_1 + 1

    # below is brute force
    def findMedianSortedArrays_1(self, nums1: List[int], nums2: List[int]) -> float:
        N_1 = len(nums1)
        N_2 = len(nums2)
        N = N_1 + N_2
        left = 0
        right = 0
        mid = int ((N_1 + N_2)/2)
        if N % 2 == 0:
            left = mid -1
            right = mid
        else:
            left = right = mid
        return self.merge(nums1, nums2, left, right)

    def merge(self, nums1, nums2, left, right):
        i = 0
        j = 0
        tmp_array = []
        while i < len(nums1) and j < len(nums2):
            if i + j  > right:
                break
            if nums1[i] < nums2[j]:
                tmp_array.append(nums1[i])
                i += 1
                continue
            if nums1[i] > nums2[j]:
                tmp_array.append(nums2[j])
                j += 1
                continue
            if nums1[i] == nums2[j]:
                tmp_array.append(nums2[j])
                tmp_array.append(nums2[j])
                j += 1
                i += 1

        while i+j <= right and i < len(nums1):
            tmp_array.append(nums1[i])
            i += 1
        while i+j <= right  and j < len(nums2):
            tmp_array.append(nums2[j])
            j += 1
        tmp_length = len(tmp_array)
        return (tmp_array[left] + tmp_array[right])/2

def main():
    sol = Solution()
    # result = sol.findMedianSortedArrays([1,2], [3,4])
    # print(result)
    # result = sol.findMedianSortedArrays([0,0], [0, 0])
    # print(result)
    # result = sol.findMedianSortedArrays([1,2], [3])
    # print(result)
    # result = sol.findMedianSortedArrays([3], [-2,-1])
    # print(result)
    result = sol.findMedianSortedArrays([1,3], [2])
    print(result)
if __name__ == "__main__":
    main()