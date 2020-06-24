class Solution:
    def toLowerCase(self, str: str) -> str:
        if not str:
            return ""
        result = ''
        for ch in str:
            order_ch = ord(ch)
            if 65 <= order_ch <= 90:
                result += chr(order_ch + 32)
            else:
                result += ch
        return result

def main():
    sol = Solution()
    result = sol.toLowerCase("LOVE YOU")
    print(result)

if __name__ == "__main__":
    main()