class StockSpanner:
    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:
        num = 1
        element = {}
        element["price"] = price
        if not self.stack or self.stack[-1].get("price") > price:
            element["num"] = 1
            self.stack.append(element)
            return 1

        while self.stack and self.stack[-1].get("price") <= price:
            firstElement = self.stack.pop()
            num = num + firstElement.get("num")
        element["num"] = num
        self.stack.append(element)
        return num

# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)


def main():
    sol = StockSpanner()
    sol.__init__
    # result = sol.next(100)
    # print(result)
    # result = sol.next(80)
    # print(result)
    # result = sol.next(60)
    # print(result)
    # result = sol.next(70)
    # print(result)
    # result = sol.next(60)
    # print(result)
    # result = sol.next(75)
    # print(result)
    # result = sol.next(85)
    # print(result)

    result = sol.next(28)
    print(result)
    result = sol.next(14)
    print(result)
    result = sol.next(28)
    print(result)
    result = sol.next(35)
    print(result)
    result = sol.next(46)
    print(result)
    result = sol.next(53)
    print(result)
    result = sol.next(66)
    print(result)
    result = sol.next(80)
    print(result)
    result = sol.next(87)
    print(result)
    result = sol.next(88)
    print(result)

if __name__ == "__main__":
    main()