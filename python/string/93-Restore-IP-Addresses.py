from typing import List
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        ans = []
        def getIP(start, ip_array, k):
            if k == 0:
                if start == len(s):
                    ans.append(ip_array[1:])
                return
            for i in range(1, 4):
                if start + i <= len(s):
                    ip_component = s[start:start+i]
                    if ip_component[0] == '0' and len(ip_component) > 1:
                        continue
                    if int(ip_component)> 255:
                        continue
                    # ip_array.append(ip_component)
                    getIP(start + i, ip_array+"."+ip_component, k-1)
                    # ip_array.pop(-1)
        getIP(0, "", 4)
        return ans
def main():
    sol = Solution()
    result = sol.restoreIpAddresses("010010")
    print(result)
    result = sol.restoreIpAddresses("1234")
    print(result)
    result = sol.restoreIpAddresses("25525511135")
    print(result)

if __name__ == "__main__":
    main()