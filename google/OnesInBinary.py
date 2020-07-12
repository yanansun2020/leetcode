# Q1, Give a  number, count how many 1s in its binary representation. For example,
# if input is 5, it will output 2 as 5 has binary representation 101.
class Solution:
    def numberOfOnes(self, num:int)->int:
        count = 0
        while num >0:
            mod_result = num % 2
            if mod_result == 1:
                count += 1
            num = num >> 1
        return count
def main():
    sol = Solution()
    result = sol.numberOfOnes(5)
    print(result)
    result = sol.numberOfOnes(4)
    print(result)
    result = sol.numberOfOnes(7)
    print(result)

if __name__ == "__main__":
    main()
