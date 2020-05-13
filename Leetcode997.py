class Solution:
    def findJudge1(self, N, trust):
        trusts = [0] * (N+1)
        for (a, b) in trust:
            trusts[a] -= 1
            trusts[b] += 1

        for i in range(1, len(trusts)):
            if trusts[i] == N-1:
                return i
        return -1
    def findJudge(self, N, trust):
        allPeople = []
        for i in range(N):
            allPeople.append(i+1)
        myDict = {}
        for tru in trust:
            #remove ele and provide dict
            v = myDict.get(tru[0])
            if(v is not None):
                v.append(tru[1])
            else :
                lists = []
                lists.append(tru[1])
                myDict[tru[0]] = lists
            if(tru[0] in allPeople):
                allPeople.remove(tru[0])

        sol = Solution()
        for possibleJudge in allPeople:
            if  sol.trustByEveryOne(possibleJudge, myDict, N) :
                return possibleJudge
        return -1
    def trustByEveryOne(self, judge, myDict, N):
        for i in range(N) :
            if(i+1 != judge):
                possibleJudges = myDict.get(i+1)
                if(possibleJudges is None):
                    return False
                if(judge not in possibleJudges):
                    return False
        return True;
def main():
    sol = Solution()
    result = sol.findJudge1(11, [[1,8],[1,3],[2,8],[2,3],[4,8],[4,3],[5,8],[5,3],[6,8],[6,3],[7,8],[7,3],[9,8],[9,3],[11,8],[11,3]])
    print(result)

if __name__ == "__main__":
    main()
