from typing import List
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        results = []
        if n <=0:
            return results
        def getCombinations(start, end, k, result):
            if k == 1:
                for i in range(start, end + 1):
                    result_1 = result + [i]
                    results.append(result_1)
                return
            for i in range(start, end + 1):
                tmp_result = list(result)
                tmp_result.append(i)
                getCombinations(i + 1, end, k-1, tmp_result)
        getCombinations(1, n, k, [])
        return results

def main():
    sol = Solution()
    # result = sol.combine(4, 2)
    # print(result)
    result = sol.combine(1,2)
    print(result)
    result = sol.combine(3,2)
    print(result)

if __name__ == "__main__":
    main()