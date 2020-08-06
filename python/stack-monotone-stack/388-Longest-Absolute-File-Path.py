class Solution:
    def lengthLongestPath(self, input: str) -> int:
        if not input:
            return 0
        inputs = input.split("\n")
        stack = []
        max_length = 0
        for i in range(len(inputs)):
            depth = inputs[i].count("\t")
            directory = inputs[i].replace("\t", "")
            while stack and depth <= stack[-1][1]:
                stack.pop()
            top_ele_length = 0 if not stack else stack[-1][0]
            stack.append((len(directory) + top_ele_length, depth))
            if "." in directory:
                max_length = max(max_length, stack[-1][0]+depth)
        return max_length

def main():
    sol = Solution()
    result = sol.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext")
    print(result)
    result = sol.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext")
    print(result)

if __name__ == "__main__":
    main()
