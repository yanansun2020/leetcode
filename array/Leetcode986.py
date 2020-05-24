from typing import List
class Solution:
    index = 0
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        result = []
        self.index = 0
        lenth_B = len(B)
        for element in A:
            self.getResult(element, B, result, lenth_B)
        return result

    def getResult(self, element, tmpList, result, lenth_B):
        start_a = element[0]
        end_a = element[1]
        for idx in range(self.index, lenth_B):
            start_result = -1
            end_result = -1
            start_b = tmpList[idx][0]
            end_b = tmpList[idx][1]
            if start_a >= start_b and start_a<= end_b:
                start_result = start_a
            if start_b >= start_a and start_b <= end_a:
                start_result = start_b
            if end_a >= start_b and end_a <= end_b:
                end_result = end_a
            if end_b >= start_a and end_b <= end_a:
                end_result = end_b
            if start_result != -1 and end_result != -1:
                tmp_list = []
                tmp_list.append(start_result)
                tmp_list.append(end_result)
                result.append(tmp_list)
            if end_a < start_b:
                break
            if start_a >= end_b:
                self.index = idx +1



def main():
    sol = Solution()
    result = sol.intervalIntersection([[0,2],[5,10],[13,23],[24,25]], [[1,5],[8,12],[15,24],[25,26]])
    print(result)

if __name__ == "__main__":
    main()