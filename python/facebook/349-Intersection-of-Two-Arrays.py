from typing import List
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        i, j = 0, 0
        result = []
        while i < len(nums1) and j <  len(nums2):
            if nums1[i] == nums2[j]:
                if nums1[i] not in result:
                    result.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] < nums2[j]:
                i += 1
            else:
                j += 1
        return result

def main():
    sol = Solution()
    result = sol.intersection([1,2,2,1], [2, 2])
    print(result)
    result = sol.intersection([4,9,5], [9,4,9,8,4])
    print(result)
if __name__ == "__main__":
    main()