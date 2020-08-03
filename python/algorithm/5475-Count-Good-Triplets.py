from typing import List
class Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        N = len(arr)
        result = []
        for i in range(N-2):
            for j in range(i+1, N-1):
                for k in range(j+1, N):
                    if abs(arr[i] - arr[j]) <= a and\
                        abs(arr[j] - arr[k]) <= b and \
                            abs(arr[i]-arr[k]) <= c:
                            result.append((arr[i], arr[j], arr[k]))
        return result

def main():
    sol = Solution()
    result = sol.countGoodTriplets([3,0,1,1,9,7], 7,2,3)
    print(result)
if __name__ == "__main__":
    main()


