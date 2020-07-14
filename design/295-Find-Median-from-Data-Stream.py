from heapq import heappop, heappush, heapify
class MedianFinder:
    # two heaps, max_heap and min_heap, values in max_heap are less than that in min_heap
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.max_heap = []
        self.min_heap = []

    def addNum(self, num: int) -> None:
        if not self.min_heap:
            heappush(self.min_heap, num)
            return
        if not self.max_heap:
            if num > self.min_heap[0]:
                heappush(self.min_heap, num)
                heappush(self.max_heap, MaxHeapObj(heappop(self.min_heap)))
            else:
                heappush(self.max_heap,MaxHeapObj(num))
            return
        if num >= self.min_heap[0]:
            heappush(self.min_heap, num)
        if num < self.min_heap[0]:
            heappush(self.max_heap, MaxHeapObj(num))
        self.rebalance()


    def findMedian(self) -> float:
        len_max_heap = len(self.max_heap)
        len_min_heap = len(self.min_heap)
        if len_max_heap == len_min_heap:
            return (self.max_heap[0].val + self.min_heap[0]) /2
        if len_max_heap > len_min_heap:
            return self.max_heap[0].val
        return self.min_heap[0]

    def rebalance(self):
        min_length = len(self.min_heap)
        max_length = len(self.max_heap)
        if min_length -max_length > 1:
            heappush(self.max_heap, MaxHeapObj(heappop(self.min_heap)))
        if max_length -min_length > 1:
            heappush(self.min_heap, heappop(self.max_heap).val)

class MaxHeapObj(object):
    def __init__(self, val): self.val = val
    def __lt__(self, other): return self.val > other.val
    def __eq__(self, other): return self.val == other.val
    def __str__(self): return str(self.val)

def main():
    randomset = MedianFinder()
    result = randomset.addNum(12)
    result = randomset.findMedian()
    print(result)
    result = randomset.addNum(10)
    result = randomset.findMedian()
    print(result)
    result = randomset.addNum(13)
    result = randomset.findMedian()
    print(result)
    result = randomset.addNum(11)
    result = randomset.findMedian()
    print(result)
    # randomset = MedianFinder()
    # result = randomset.addNum(6)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(10)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(2)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(6)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(5)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(0)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(6)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(3)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(1)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(0)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(0)
    # result = randomset.findMedian()
    # print(result)

    # randomset = MedianFinder()
    # result = randomset.addNum(2)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(3)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(4)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(5)
    # result = randomset.findMedian()
    # print(result)


    # randomset = MedianFinder()
    # randomset.addNum(-1)
    # result = randomset.findMedian()
    # print(result)
    # randomset.addNum(-2)
    # result = randomset.findMedian()
    # print(result)
    # randomset.addNum(-3)
    # result = randomset.findMedian()
    # print(result)
    # randomset.addNum(-4)
    # result = randomset.findMedian()
    # print(result)
    # randomset.addNum(-5)
    # result = randomset.findMedian()
    # print(result)


    # randomset = MedianFinder()
    # result = randomset.addNum(2)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(1)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(5)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(3)
    # result = randomset.findMedian()
    # print(result)
    # result = randomset.addNum(4)
    # result = randomset.findMedian()
    # print(result)



if __name__ == "__main__":
    main()
# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()