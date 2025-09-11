class MyHashMap:

    def __init__(self):
        self.size = 10**6 + 1
        self.EMPTY = -1
        self.data = [self.EMPTY] * self.size

    def put(self, key: int, value: int) -> None:
        self.data[key] = value

    def get(self, key: int) -> int:
        return self.data[key]

    def remove(self, key: int) -> None:
        self.data[key] = self.EMPTY


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)