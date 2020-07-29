class Solution:
    def maximumSwap(self, num: int) -> int:
        num_str = str(num)
        N = len(num_str)
        max_num_after = [None for i in range(N)]
        max_num_after[N-1] = N-1
        for i in range(N-2, -1, -1):
            if num_str[i] >num_str[max_num_after[i+1]]:
                max_num_after[i] = i
            else:
                max_num_after[i] = max_num_after[i+1]
        result_str = ""
        for i in range(N):
            if num_str[i] != num_str[max_num_after[i]]:
                result_str = self.swap(i, max_num_after[i], num_str)
                break
        return int(result_str) if result_str else num

    def swap(self, i, j, num_str):
        return num_str[0:i] + num_str[j:j+1] +num_str[i+1:j] +  num_str[i:i+1] + num_str[j+1:]

def main():
    sol = Solution()
    result = sol.maximumSwap(2376)
    print(result)
    result = sol.maximumSwap(9973)
    print(result)


if __name__ == "__main__":
    main()
