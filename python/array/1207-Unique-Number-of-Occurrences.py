from collections import Counter
from typing import List
class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        counter = dict(Counter(arr))
        counter_value = counter.values()
        counter_value_dict = dict(Counter(counter_value).most_common())
        for k, v in counter_value_dict.items():
            if v > 1:
                return False
        return True


def main():
    sol = Solution()
    my_dict =dict([(0, -1)])
    my_dict[0]

    result = sol.uniqueOccurrences([1, 3, 3])
    print(result)

if __name__ == "__main__":
    main()