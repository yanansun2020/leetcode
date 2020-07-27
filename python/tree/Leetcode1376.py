from typing import List

class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        myDict = {}
        for index in range(n):
            if manager[index] != -1:
                subordinations = myDict.get(manager[index])
                if not subordinations:
                    subordinations = []
                subordinations.append(index)
                myDict[manager[index]] = subordinations
        sol = Solution()
        return sol.getDepth(headID, myDict, informTime)

    def getDepth(self, headID, myDict, informTime):
        subordinations = myDict.get(headID)
        if subordinations:
            maxTime = 0
            sol = Solution()
            for subordination in subordinations:
                timeOfI = informTime[headID] + sol.getDepth(subordination, myDict, informTime)
                if timeOfI > maxTime:
                    maxTime = timeOfI
            return maxTime
        else:
            return informTime[headID]

def main():
    sol = Solution()
    result = sol.numOfMinutes(7, 6, [1,2,3,4,5,6,-1], [0,6,5,4,3,2,1])
    print(result)

if __name__ == "__main__":
    main()