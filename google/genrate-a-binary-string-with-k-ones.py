# Q2. genrate a binary string which have  k 1, and the length is n.
#  For example, if n = 4 and k = 2, the answer is:
from typing import List
class Solution:
    def Generate(self, n:int, k:int)->List[str]:
        #generate a 0, 1 list with k 1s and n-k 0s
        tmp_list = []
        for i in range(0, k):
            tmp_list.append(str(1))
        for i in range(k, n):
            tmp_list.append(str(0))
        result = []

        def getStr(array_list, result_str):
            if not array_list:
                if result_str not in result:
                    result.append(result_str)
                return
            for i in range(0, len(array_list)):
                result_str = result_str + array_list[i]
                tmp_array = list(array_list)
                tmp_array.pop(i)
                getStr(tmp_array, result_str)
                result_str = result_str[:-1]
        getStr(tmp_list, '')
        return result

def main():
    sol = Solution()
    result = sol.Generate(4, 2)
    print(result)
    # result = sol.Generate(4)
    # print(result)
    # result = sol.Generate(7)
    # print(result)

if __name__ == "__main__":
    main()
