from typing import List
class Solution:
    # merge from right to left
    # not have to compare equals
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i,j, k = m-1, n-1, m+n-1
        while j >=0:
            if i>=0 and nums1[i] > nums2[j]:
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
            k -= 1
        return nums1

def main():
    sol = Solution()
    # result = sol.addBinary("11", "1")
    # print(result)
    result = sol.merge([2,0], 1,[1], 1 )
    print(result)
    result = sol.merge([1,2,3,0,0,0], 3,[2, 5,6], 3 )
    print(result)

if __name__ == "__main__":
    main()
