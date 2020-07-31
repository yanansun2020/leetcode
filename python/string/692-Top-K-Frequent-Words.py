class Node:
    def __init__(self, val, frequency):
        self.val = val
        self.frequency = frequency
        def __lt__(self, other):
            return self.frequency > other.val
from heapq import heapify, heappush, heappop
from collections import defaultdict
from typing import List
from collections import Counter
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        count = Counter(words)
        heap = [(-freq, word) for word, freq in count.items()]
        heapify(heap)
        return [heappop(heap)[1] for _ in range(k)]


def main():
    sol = Solution()
    # result = sol.topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 2)
    # print(result)
    result = sol.topKFrequent( ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], 4)
    print(result)

if __name__ == "__main__":
    main()