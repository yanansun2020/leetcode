from collections import Counter
from typing import List
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        task_dict = dict(Counter(tasks).most_common())
        max_= task_dict.get(list(task_dict.keys())[0])
        max_count = 0
        for k, v in task_dict.items():
            if v != max_:
                break
            max_count += 1
        return max((max_ - 1) * (n + 1) + max_count, len(tasks))
def main():
    sol = Solution()
    result = sol.leastInterval(["A","A","A","B","B","B"], 2)
    print(result)
    result = sol.leastInterval(["A","A","A","B","B","B"], 0)
    print(result)
    result = sol.leastInterval(["A","A","A","A","A","A","B","C","D","E","F","G"], 2)
    print(result)
    result = sol.leastInterval(["A","A","B","B","C","D","E","F","G","H","I","J"], 2)
    print(result)

if __name__ == "__main__":
    main()
