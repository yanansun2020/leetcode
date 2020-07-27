#segment tree used to range query
import sys
class Solution:
    def constructTree(self, input:List[int], segmentTree:List[int], low:int, high:int, positon:int):
        if low == high:
            segmentTree[positon] = input[low]
        mid = int ((low + high)/2)
        self.constructTree(input, segmentTree, low, mid, 2 * positon + 1)
        self.constructTree(input, segmentTree, mid, high, 2 * positon + 2)
        segmentTree[positon] = min(segmentTree[2*positon + 1], segmentTree[2 * positon + 2])

    def range_query(self, segmentTree:List[int], q_low: int, q_high:int, low, high, position):
        # total overlap
        if q_low<= low and q_high >= high:
            return segmentTree[position]
        if q_low > high or q_high < low:
            return sys.maxsize
        mid = int((low + high)/2)
        return min(self.range_query(segmentTree, q_low, q_high, low, mid, 2 * position + 1),\
            self.range_query(segmentTree, q_low, q_high, mid + 1, high, 2 * position + 2))

def main():
    sol = Solution()
     # Driver program to test the above function
    input = [-1, 3, 5, 4]
    N = len(input)
    # if N is power of 2, the segment tree length is 2 * n -1
    # if N is not power 2, find next power of 2 m which is nearest N, the segment tree length is 2 * m -1
    segmentTree = [8 * 2 -1]

if __name__ == "__main__":
    main()
