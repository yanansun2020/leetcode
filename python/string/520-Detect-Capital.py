class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        Num_cap, n = 0, len(word)
        for letter in word:
            Num_cap += letter.isupper()
        if Num_cap == 0 or Num_cap == n or Num_cap == 1 and word[0].isupper():
            return True
        return False

    def detectCapitalUse_1(self, word: str) -> bool:
        lowercase = False
        uppercase_number = 0
        for ch in word:
            if 'a'<= ch<='z':
                lowercase = True
                if uppercase_number > 1:
                    return False
            if "A"<= ch<="Z":
                uppercase_number += 1
                if lowercase:
                    return False
        return True