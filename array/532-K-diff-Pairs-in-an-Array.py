from typing import List
class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        # 已经访问过的节点
        has_visited = {}
        pair_num = 0
        N = len(nums)
        for i in range(N):
            cur_value = nums[i]
            if cur_value in has_visited:
                if k == 0:
                    pair_num += 1
                continue
            else:
                if cur_value-k in has_visited:
                    pair_num += 1
                if cur_value + k in has_visited:
                    pair_num += 1
                has_visited[nums[i]] = 1
        return pair_num




def main():
    sol = Solution()
    result = sol.findPairs([1,2,3,4,5], -1)
    print(result)

if __name__ == "__main__":
    main()