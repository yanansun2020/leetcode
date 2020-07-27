import math
from typing import List
class Solution:
    def getMinDistSum(self, positions: List[List[int]]) -> float:
        def getDistance(x, y):
            result = 0
            for i, j in positions:
                power = (x - i) ** 2 + (y-j) ** 2
                result += math.sqrt(power)
            return result
        x_sum = 0
        y_sum = 0
        for i, j in positions:
            x_sum += i
            y_sum += j
        x = x_sum/len(positions)
        y = y_sum/len(positions)
        init_distance = getDistance(x, y)

        chg = 100 #change since 0 <= positions[i][0], positions[i][1] <= 100
        while chg > 1e-6: #accuracy within 1e-5
            zoom = True
            for dx, dy in (-1, 0), (0, -1), (0, 1), (1, 0):
                xx = x + chg * dx
                yy = y + chg * dy
                dd = getDistance(xx, yy)
                if dd < init_distance:
                    init_distance = dd
                    x, y = xx, yy
                    zoom = False
                    break
            if zoom: chg /= 2
        return init_distance
def main():
    sol = Solution()
    # result = sol.getMinDistSum([[0,1],[1,0],[1,2],[2,1]])
    # print(result)
    # result = sol.getMinDistSum([[1,1],[3,3]])
    # print(result)
    # result = sol.getMinDistSum([[1,1]])
    # print(result)
    result = sol.getMinDistSum( [[1,1],[0,0],[2,0]])
    print(result)
    # result = sol.getMinDistSum( [[0,1],[3,2],[4,5],[7,6],[8,9],[11,1],[2,12]])
    # print(result)




if __name__ == "__main__":
    main()

