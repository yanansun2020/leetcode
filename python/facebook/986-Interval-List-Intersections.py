from typing import List
class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        i, j = 0, 0
        merged_list = []
        while i < len(A) and j < len(B):
            list_a = A[i]
            list_b = B[j]
            merged = self.getInterval(list_a, list_b)
            if merged:
                merged_list.append(merged)
            if list_a[-1] < list_b[-1]:
                i += 1
            elif list_a[-1] > list_b[-1]:
                j += 1
            else:
                i += 1
                j += 1
        return merged_list

    def getInterval(self, a:List[int], b:List[int])->List[int]:
        left = max(a[0], b[0])
        right = min(a[1], b[1])
        if left <= right:
            return [left, right]

def main():
    sol = Solution()
    result = sol.intervalIntersection([[0,2],[5,10],[13,23],[24,25]], [[1,5],[8,12],[15,24],[25,26]])
    print(result)
    # result = sol.intervalIntersection([[3,3],[5,-1],[-2,4]], 2)
    # print(result)


if __name__ == "__main__":
    main()
