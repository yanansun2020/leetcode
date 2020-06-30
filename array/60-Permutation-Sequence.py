import math
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        possibilities = []
        for i in range(n-1, -1, -1):
            possibilities.append(math.factorial(i))
        # possibilities[-1] = 0
        array = []
        for i in range(1, n +1):
            array.append(i)
        self.result = ''
        def getResult(possibilities, array, k):
            if len(possibilities) == 1:
                self.result += str(array[0])
                return
            mod = k % possibilities[0]
            m = int(k/possibilities[0])

            if mod > 0:
                self.result+= str(array[m])
                array.pop(m)
            elif mod == 0:
                self.result+= str(array[m-1])
                array.pop(m-1)
            k = mod
            possibilities.pop(0)
            getResult(possibilities, array, k)
        getResult(possibilities, array, k)
        return self.result

def main():
    sol = Solution()
    # result = sol.getPermutation(1, 1)
    # print(result)
    # result = sol.getPermutation(3, 3)
    # print(result)
    # result = sol.getPermutation(4, 9)
    # print(result)
    result = sol.getPermutation(3, 2)
    print(result)
    result = sol.getPermutation(1, 1)
    print(result)
if __name__ == "__main__":
    main()