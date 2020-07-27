from typing import List
import collections
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        conn_out = collections.defaultdict(list)
        conn_in = collections.defaultdict(list)
        for prerequisite in prerequisites:
            conn_out[prerequisite[1]].append(prerequisite[0])
            conn_in[prerequisite[0]].append(prerequisite[1])

        if not conn_out and not conn_in:
            return True
        # get node with out-degree only
        list_only_out = self.getOneNodeWithOnlyOut(conn_out, conn_in)
        if not list_only_out:
            return False

        result = False
        for node in list_only_out:
            node = list_only_out[0]
            vistied = []
            marked = []
            result = self.dfs(node, conn_out, vistied, marked)
            if not result:
                return False
        return result

    def dfs(self, conn, conn_out, vistied, marked):
        if conn in vistied and conn not in marked:
            return False
        vistied.append(conn)
        conn_list = conn_out.get(conn)
        if conn_list:
            for conn_1 in conn_list:
                result = self.dfs(conn_1, conn_out, vistied, marked)
                if not result:
                    return False
        marked.append(conn)
        return True

    def getOneNodeWithOnlyOut(self, conn_out, conn_in):
        return list(set(conn_out.keys()).difference(set(conn_in.keys())))


def main():
    sol = Solution()
    # result = sol.canFinish(2, [[1,0], [2, 0], [3, 1], [3, 2]])
    # print(result)
    result = sol.canFinish(8, [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5]])
    print(result)

if __name__ == "__main__":
    main()
