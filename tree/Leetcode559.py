from Node import Node
class Solution:
    def maxDepth(self, root) -> int:
        if root is None:
            return
        else:
            MaxChildreanDepth = 0
            children = root.children
            sol = Solution()
            if children:
                for child in children:
                    MaxChildreanDepthi = 1 + sol.maxDepth(child)
                    if MaxChildreanDepthi > MaxChildreanDepth:
                        MaxChildreanDepth = MaxChildreanDepthi
                return MaxChildreanDepth
            else :
                return 1

def main():
    node1 = Node(5, None)
    #node2 = Node(6, [Node(7, None)])
    node2 = Node(6, None)
    node = Node(1, [Node(3, [node1, node2]),Node(2, None),Node(4, None)])
    # node = Node(1, [Node(2, None), Node(3, None)])
    sol = Solution()
    result = sol.maxDepth(node)
    print(result)

if __name__ == "__main__":
    main()
