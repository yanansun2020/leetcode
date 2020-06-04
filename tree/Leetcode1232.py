class Solution:
    def checkStraightLine(self, coordinates):
        if len(coordinates) < 2:
            return False
        list0 = coordinates[0]
        list1 = coordinates[1]

        x0 = list0[0]
        x1 = list1[0]
        if(x0 == x1):
            for coordinate in coordinates:
                if(coordinate[0] != x0):
                    return False
            return True
        else:
            sol = Solution()
            slope = sol.getSlope(list0, list1)
            b = sol.getb(list0, slope)

            for coordinate in coordinates:
                if(slope * coordinate[0] + b != coordinate[1]):
                    return False
            return True;

    def getSlope(self, list0, list1):
        x0 = list0[0]
        y0 = list0[1]
        x1 = list1[0]
        y1 = list1[1]
        return (y1 -y0)/(x1 - x0)

    def getb(self, list0, slope):
        b = list0[1] - slope * list0[0]
        return b

def main():
    sol = Solution()
    result = sol.checkStraightLine([[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]])
    result1 = sol.checkStraightLine([[-7,-3],[-7,-1],[-2,-2],[0,-8],[2,-2],[5,-6],[5,-5],[1,7]])
    print(result1)

if __name__ == "__main__":
    main()
