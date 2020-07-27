from typing import List
class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        list1_dict = {}
        list2_dict = {}
        result = []
        sum_index = 22001

        for index, string in enumerate(list1):
            list1_dict[string] = index
        for index, string in enumerate(list2):
            list2_dict[string] = index
        for k, v in list1_dict.items():
            v2 = list2_dict.get(k)
            if v2 is not None and sum_index >= v + v2:
                sum_index = v + v2
                result.append(k)
        return result




def main():
    sol = Solution()
    result = sol.findRestaurant(["Shogun","Tapioca Express","Burger King","KFC"],["KFC","Burger King","Tapioca Express","Shogun"])

    print(result)

if __name__ == "__main__":
    main()