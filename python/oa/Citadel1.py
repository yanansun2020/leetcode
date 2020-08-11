class Solution:
    def droppedRequests(self, requestTime):
        # Write your code here
        max_value = max(requestTime)
        count = 0
        memo_list = [0 for i in range(max_value + 1)]
        for i in range(len(requestTime)):
            memo_list[requestTime[i]] += 1
        memo_accum = [0 for i in range(max_value + 1)]
        for i in range(1, len(memo_list)):
            memo_accum[i] += memo_accum[i-1] + memo_list[i]
        for i in range(len(memo_list)):
            if memo_list[i] == 0:
                continue
            count_60 = 0
            count_10 =0
            count_1 = 0
            if i-60<0 and memo_accum[i] > 60:
                count_60 = (memo_accum[i] -60)
            if i-60>=0 and memo_accum[i] - memo_accum[i-60] > 60:
                count_60 = (memo_accum[i] - memo_accum[i-60] -60)
            if i-10<0 and memo_accum[i] > 20:
                count_10 = (memo_accum[i] -20)
            if i-10>=0 and memo_accum[i] - memo_accum[i-10] > 20:
                count_10 = (memo_accum[i]-memo_accum[i-10] -20)
            if memo_list[i] > 3:
                count_1 = (memo_list[i] -3)
            count += max(count_60, count_10, count_1)
        return count
def main():
    sol = Solution()

    result = sol.droppedRequests([1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11])
    print(result)

if __name__ == "__main__":
    main()