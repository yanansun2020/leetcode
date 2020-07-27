from typing import List
class Solution:
    def compress(self, chars: List[str]) -> int:
        chars.append("$$")
        i, j, k= 0, 0,0
        length = 0
        for j in range(len(chars)):
            if chars[i] == chars[j]:
                continue
            else:
                if j -i > 1:
                    chars[k] = chars[i]
                    number_str = str(j -i)
                    for index in range(len(number_str)):
                        chars[k+index+1] = number_str[index]
                    k += (1+len(number_str))
                elif j-i ==1:
                    chars[k] = chars[i]
                    k +=1
                i = j
        chars = chars[:k]
        return k

def main():
    sol = Solution()
    result = sol.compress(["a"])
    print(result)

    result = sol.compress(["y","(","V","t","l","]","&","'","T","$"])
    print(result)
    result = sol.compress(["a","a","b","b","c","c","c"])
    print(result)
    result = sol.compress(["a","b","b","b","b","b","b","b","b","b","b","b","b"])
    print(result)

if __name__ == "__main__":
    main()
