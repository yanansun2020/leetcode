class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1
        uglyNumbers_2 = []
        uglyNumbers_3 = []
        uglyNumbers_5 = []
        uglyNumbers_ordered = [1]
        for i in range(1, n):
            tmp_number = uglyNumbers_ordered[i-1]
            uglyNumbers_2.append(tmp_number * 2)
            uglyNumbers_3.append(tmp_number * 3)
            uglyNumbers_5.append(tmp_number * 5)
            min_number = self.find_min_and_pop(uglyNumbers_2, uglyNumbers_3, uglyNumbers_5)
            uglyNumbers_ordered.append(min_number)
        return uglyNumbers_ordered[n-1]
    def find_min_and_pop(self, uglyNumbers_2, uglyNumbers_3, uglyNumbers_5):
        min_number = min(uglyNumbers_2[0], uglyNumbers_3[0], uglyNumbers_5[0])
        if min_number == uglyNumbers_2[0]:
            uglyNumbers_2.pop(0)
        if min_number == uglyNumbers_3[0]:
            uglyNumbers_3.pop(0)
        if min_number == uglyNumbers_5[0]:
            uglyNumbers_5.pop(0)
        return min_number
def main():
    sol = Solution()
    result = sol.nthUglyNumber(10)
    print(result)

if __name__ == "__main__":
    main()
