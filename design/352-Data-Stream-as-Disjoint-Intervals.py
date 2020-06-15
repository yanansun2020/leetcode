from bisect import *
from typing import List
class SummaryRanges:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = []


    def addNum(self, val: int) -> None:
        insort(self.arr, [val,val])


    def getIntervals(self) -> List[List[int]]:
        r = []
        for i in self.arr:
            if r and i[0] - r[-1][1] < 2:
                r[-1][1] = max(r[-1][1],i[1])
            else: r.append(i)
        self.arr = r
        return r
def main():
    randomset = SummaryRanges()
    result = randomset.addNum(1)
    result = randomset.addNum(3)
    result = randomset.addNum(2)
    result = randomset.getIntervals()

    print(result)

if __name__ == "__main__":
    main()



# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(val)
# param_2 = obj.getIntervals()