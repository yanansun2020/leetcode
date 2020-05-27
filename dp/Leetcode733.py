class Solution:
    def floodFill(self, image, sr, sc, newColor):
        originalColor = image[sr][sc]
        length = len(image[0])
        rowLegth = len(image)
        queue = []
        queue1 = []
        ele = [sr, sc]
        queue.append(ele)
        queue1.append(ele)
        #get four point
        sol = Solution()
        while len(queue) > 0:
            element = queue.pop()
            image[element[0]][element[1]] = newColor
            sol.addAdjacentEle(image, element[0], element[1], originalColor, queue, length, rowLegth, queue1)
        return image

    def addAdjacentEle(self, image, sr, sc, originalColor, queue, length, rowLegth, queue1):
        if(sr - 1 >= 0 and image[sr -1][sc] == originalColor):
            ele = [sr-1, sc]
            if(ele not in queue1):
                queue.append(ele)
                queue1.append(ele)
        if(sc -1 >= 0  and image[sr][sc-1] == originalColor):
            ele = [sr, sc - 1]
            if(ele not in queue1):
                queue.append(ele)
                queue1.append(ele)
        if(sr + 1 < rowLegth and image[sr + 1][sc] == originalColor):
            ele = [sr+1, sc]
            if(ele not in queue1):
                queue.append(ele)
                queue1.append(ele)
        if(sc + 1 < length and image[sr][sc + 1] == originalColor):
            ele = [sr, sc + 1]
            if(ele not in queue1):
                queue.append(ele)
                queue1.append(ele)


def main():
    sol = Solution()
    result = sol.floodFill([[0,0,0],[0,1,1]], 1, 1, 1)
    print(result)

if __name__ == "__main__":
    main()
