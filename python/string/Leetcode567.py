class Solution:
    def checkInclusion_solution2(self, s1: str, s2: str) -> bool:
        s1_length = len(s1)
        s2_length = len(s2)
        if s1_length > s2_length:
            return False
        feq_s1 = [0] * 26
        feq_s2 = [0] * 26
        for index in range(s1_length):
            s_s1 = s1[index]
            s_s2 = s2[index]
            pos = ord(s_s1)-ord('a')
            pos_1 = ord(s_s2) - ord('a')
            feq_s1[pos] = 1 + feq_s1[pos]
            feq_s2[pos_1] = 1 + feq_s2[pos_1]
        if feq_s1 == feq_s2:
             return True
        for index in range(s1_length,s2_length):
            s_s2 = s2[index]
            pos = ord(s_s2) - ord('a')
            feq_s2[pos] = 1 + feq_s2[pos]
            s_s2_tmp = s2[index - s1_length]
            pos_1 = ord(s_s2_tmp) - ord('a')
            feq_s2[pos_1] = feq_s2[pos_1] -1
            if feq_s1 == feq_s2:
                return True
        return False


    def checkInclusion(self, s1: str, s2: str) -> bool:
        dict_s1 = self.getFrequency(s1)
        keys_s1 = dict_s1.keys()
        len_s1 = len(s1)
        range_s2 = len(s2)- len_s1 + 1
        for index in range(range_s2):
            tmp_str = s2[index : index+len_s1]
            dict_tmp = self.getFrequency(tmp_str)
            keys_tmp = dict_tmp.keys()
            if self.equalFrequency(dict_s1, dict_tmp):
                return True
        return False

    def getFrequency(self, string):
        mydict = {}
        for i in string:
            frequency = mydict.get(i)
            if not frequency:
                frequency = 0
            frequency = frequency + 1
            mydict[i] = frequency
        return mydict

    def equalFrequency(self, dict_s1, dict_tmp):
        for key in dict_s1:
            value_s1 = dict_s1[key]
            value_tmp = dict_tmp.get(key)
            if not value_tmp or value_s1 != value_tmp:
                return False
        return True

def main():
    sol = Solution()

    result = sol.checkInclusion("ab", "a")
    result = sol.checkInclusion_solution2("ab", "a")
    print(result)

if __name__ == "__main__":
    main()