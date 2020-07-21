from typing import List
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        intervals.sort()
        merge_result = []
        i = 0
        left_array = intervals[0]
        while i < len(intervals):
            merged = self.mer(left_array, intervals[i])
            if merged:
                left_array = merged
            else:
                merge_result.append(list(left_array))
                left_array = intervals[i]
            i += 1
        merge_result.append(left_array)
        return merge_result

    def mer(self, A, B) -> bool:
        left_a = A[0]
        left_b = B[0]
        right_a = A[1]
        right_b = B[1]
        if right_a >=left_b:
            return [min(left_a, left_a), max(right_a, right_b)]
        return []

def main():
    sol = Solution()
    result = sol.merge([[1,3],[8,10],[15,18],[2,6]])
    print(result)

if __name__ == "__main__":
    main()
