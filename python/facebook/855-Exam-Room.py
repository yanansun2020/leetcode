class ExamRoom:
    # ---Java
    def __init__(self, N: int):
        self.seats.append((-1, N))

    def seat(self) -> int:
        interval = self.seats[0]
        if interval[0] == -1:
            return 0

        self.seats.pop(0)

    def leave(self, p: int) -> None:



# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(N)
# param_1 = obj.seat()
# obj.leave(p)