# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        left, right = 1, n
        while left <= right:
            mid = (left+right)//2
            if self.isBadVersion(mid) == False:
                if mid + 1 <= n and self.isBadVersion(mid + 1) == True:
                    return mid + 1
                left = mid + 1
                if left > n:
                    return n

            else:
                if mid-1 >= 1 and self.isBadVersion(mid-1) == False:
                    return mid
                right = mid -1
                if right ==0:
                    return 1

