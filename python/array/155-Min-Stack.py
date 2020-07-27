class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        min_value = x
        if self.stack:
            top_ele = self.stack[-1]
            min_value = min(min_value, top_ele[1])
        self.stack.append((x, min_value))


    def pop(self) -> None:
        if self.stack:
            self.stack.pop(-1)


    def top(self) -> int:
        if not self.stack:
            return None
        return self.stack[-1][0]


    def getMin(self) -> int:
        if not self.stack:
            return None
        return self.stack[-1][1]



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()