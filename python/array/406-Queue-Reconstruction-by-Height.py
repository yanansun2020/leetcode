from typing import List
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        result = []
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        for h, k in people:
            result.insert(k, [h, k])
        return result
def main():
    sol = Solution()
    result = sol.reconstructQueue([[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]])
    print(result)
if __name__ == "__main__":
    main()