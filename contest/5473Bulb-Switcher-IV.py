class Solution:
    def minFlips(self, target: str) -> int:
        self.result = 0
        flip = "0"
        for i in range(len(target)):
            if target[i] == flip:
                continue
            self.result += 1
            flip = "1" if flip == "0" else "0"
        return self.result

    def minFlips_TLE(self, target: str) -> int:
        self.result = 0
        def findMin(original, tag):
            if not tag:
                return
            i = 0
            while i < len(tag):
                if original != tag[i]:
                    self.result += 1
                    break
                i += 1
            original = "0" if original == "1" else "1"
            findMin(original, tag[i:])
        findMin("0", target)
        return self.result

def main():
    sol = Solution()
    result = sol.minFlips("10111")
    print(result)
    result = sol.minFlips("101")
    print(result)
    result = sol.minFlips("00000")
    print(result)
    result = sol.minFlips("001011101")
    print(result)
    # result = sol.intervalIntersection([[3,3],[5,-1],[-2,4]], 2)
    # print(result)


if __name__ == "__main__":
    main()
