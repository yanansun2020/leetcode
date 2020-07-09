from typing import List
import copy
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrack(elements, one_res):
            # if not elements:
            #     res.append(one_res)
            #     return
            # for i in range(len(elements)):
            #     ele = elements[i]
            #     tmp_out = copy.deepcopy(one_res)
            #     tmp_out.append(ele)
            #     tmp_elements = copy.deepcopy(elements)
            #     del tmp_elements[i]
            #     backtrack(tmp_elements, tmp_out)
            if len(one_res) == len(elements):
                res.append(one_res)
                return
            for item in elements:
                if item not in one_res:
                    tmp_res = copy.deepcopy(one_res)
                    tmp_res.append(item)
                    backtrack(elements, tmp_res)
        backtrack(nums, [])
        return res
def main():
    sol = Solution()
    result = sol.permute([1,2,3])
    print(result)
    result = sol.permute([1,2])
    print(result)

if __name__ == "__main__":
    main()