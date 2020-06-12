import random
class RandomizedSet:
    memo = {}
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.memo = {}


    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if self.memo.get(val) is None:
            self.memo[val] = 1
            return True
        return False


    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if self.memo.get(val) is not None:
            del self.memo[val]
            return True
        return False


    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        if self.memo:
            return random.choice(list(self.memo.keys()))
        else:
            return -1



def main():
    randomset = RandomizedSet()
    result = randomset.insert(1)
    result = randomset.insert(2)
    result = randomset.getRandom()
    result = randomset.remove(1)
    print(result)

if __name__ == "__main__":
    main()

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()