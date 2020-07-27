class Solution:
    def convert(self, s: str, numRows: int) -> str:
        sb_list = [''] * numRows
        downward = True
        cur_row =0
        for ch in s:
            sb_list[cur_row] += ch
            if cur_row == numRows -1:
                downward = False
                cur_row -= 1
                if cur_row < 0:
                    cur_row = 0
                continue
            if cur_row == 0:
                downward = True
                cur_row += 1
                continue
            if downward:
                cur_row += 1
            else:
                cur_row -= 1
                if cur_row <0 :
                    cur_row = 0
        result = ""
        for str in sb_list:
            result += str
        return result

def main():
    sol = Solution()
    result = sol.convert("ABC", 1)
    print(result)

if __name__ == "__main__":
    main()