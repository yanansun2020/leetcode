from collections import defaultdict
from typing import List
class Solution:
    def prisonAfterNDays(self, cells: List[int], N: int) -> List[int]:
        memo = defaultdict()
        memo_1 = defaultdict()
        data = list(cells)
        flag = False
        start_repeat = 0
        range_ = 0
        for i in range(N+1):
            if i == 0:
                memo[0] = cells
                memo_1[str(cells)] = i
                continue
            tmp = [0 for i in range(8)]
            for j in range(1, 7):
                tmp[j] = 1 if data[j-1] == data[j + 1] else 0
            if memo_1.get(str(tmp)):
                flag = True
                start_repeat = memo_1.get(str(tmp))
                range_ = i - start_repeat
                break
            else:
                tmp_1 = list(tmp)
                memo[i] = tmp_1
                memo_1[str(tmp_1)] = i
                data = tmp_1
        if flag:
            j = (N - start_repeat) % range_
            return memo[j + start_repeat]
        return memo[N]
def main():
    sol = Solution()
    result = sol.prisonAfterNDays([0,1,0,1,1,0,0,1], 7)
    print(result)
    result = sol.prisonAfterNDays([1,0,0,1,0,0,1,0], 1000000000)
    print(result)
    result = sol.prisonAfterNDays([0,0,1,1,1,1,0,0], 8)
    print(result)
if __name__ == "__main__":
    main()
