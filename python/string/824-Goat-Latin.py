class Solution:
    def toGoatLatin(self, S: str) -> str:
        S += " "
        i, j = 0, 0
        vowel = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
        ans = ""
        tmp_s = 'a'
        while i < len(S):
            if S[i] == " ":
                word = S[j:i]
                if word[0] in vowel:
                    word += "ma"
                else:
                    word = word[1:] + word[0:1] + "ma"
                word += (tmp_s + " ")
                ans += word
                tmp_s += 'a'
                j = i + 1
            i += 1
        return ans[:-1]
                     
def main():
    sol = Solution()
    result = sol.toGoatLatin("I speak Goat Latin")
    print(result)

if __name__ == "__main__":
    main()