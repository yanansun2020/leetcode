# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        self.result = 0

        def count(node):
            if not node:
                return []
            if not node.left and not node.right:
                distance_array = []
                distance_array.append(0)
                return distance_array
            left_distance = count(node.left)
            right_distance = count(node.right)
            for i in range(len(left_distance)):
                left_distance[i] += 1
            for i in range(len(right_distance)):
                right_distance[i] += 1
            for i in range(len(left_distance)):
                for j in range(len(right_distance)):
                    if left_distance[i] + right_distance[j] <= distance:
                        self.result += 1
            array = []
            array.extend(list(left_distance))
            array.extend(list(right_distance))
            return array
        count(root)
        return self.result


def main():
    sol = Solution()
    root = TreeNode(1, TreeNode(2, None, TreeNode(4)), TreeNode(3))
    result = sol.countPairs(root, 3)
    print(result)
    # result = sol.intervalIntersection([[3,3],[5,-1],[-2,4]], 2)
    # print(result)


if __name__ == "__main__":
    main()