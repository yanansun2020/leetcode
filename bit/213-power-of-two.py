class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0:
            return False
        if n == 1:
            return True
        n_mode = n % 2
        if n_mode !=0:
            return False
        return self.isPowerOfTwo(n>>1)



def main():
    sol = Solution()
    result = sol.isPowerOfTwo(0)
    print(result)

if __name__ == "__main__":
    main()