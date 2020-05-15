from typing import List
class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        myDict = {}
        toList1 = []
        keys = []
        for edge in edges:
            fromI = edge[0]
            toI = edge[1]
            toList = myDict.get(fromI)
            if not toList:
                 toList = []
            toList.append(toI)
            myDict[fromI] = toList
            toList1.append(toI)
            keys.append(fromI)
        head = edges[0][0]
        nodes = list(set(keys).difference(set(toList1)))
        nodes.remove(head)
        if nodes:
            for node in nodes:
                lst = myDict.get(node)
                for i in lst:
                    tmpList = myDict.get(i)
                    if not tmpList:
                        tmpList = []
                    tmpList.append(node)
                    myDict[i] = tmpList
                myDict[node] = None


        children = myDict.get(head)
        time = self.findPath(head, children, myDict, hasApple)
        if time == 2 and hasApple[head]:
            return 1
        if time == 0 and (not hasApple[head]):
            return 0
        elif time > 2:
            return time -2

    def findPath(self, head, children, myDict, hasApple):
        if not children:
            if hasApple[head]:
                return 2
            else :
                return 0
        if children:
            path = 0
            for child in children:
                if child:
                    childPath =  self.findPath(child, myDict.get(child), myDict, hasApple)
                    path = childPath + path
            if path > 0:
                return 2 + path
            elif hasApple[head]:
                return 2
            else:
                return 0



def main():
    sol = Solution()
    # result = sol.minTime(4, [[0,1],[1,2],[0,3]], [True,True,True,True])
    # print(result)
    result = sol.minTime(7, [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], [False,False,True,False,True,True,False])
    print(result)
    result = sol.minTime(7, [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], [False,False,True,False,False,True,False])
    print(result)
    result = sol.minTime(7, [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], [False,False,False,False,False,False,False])
    print(result)
    result = sol.minTime(4, [[0,2],[0,3],[1,2]], [False,True,False,False])
    print(result)

if __name__ == "__main__":
    main()