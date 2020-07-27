from typing import List
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return
        result = [0 for i in range(n)]
        stack = []
        previous_time = 0
        for log in logs:
            thread_time = log.split(':')
            thread = int(thread_time[0])
            type_ = thread_time[1]
            time = int(thread_time[2])
            if not stack:
                stack.append((thread, time))
            else:
                if type_ == 'start':
                    result[stack[-1][0]] += (time-previous_time)
                    previous_time = time
                    stack.append((thread, time))
                if type_ == 'end':
                    result[stack[-1][0]] += (time -previous_time + 1)
                    stack.pop(-1)
                    previous_time = time + 1
        return result

def main():
    sol = Solution()
    result = sol.exclusiveTime(2, ["0:start:0","1:start:2","0:start:5","0:end:6", "1:end:7"])
    print(result)

    result = sol.exclusiveTime(2, ["0:start:0","1:start:2","1:end:5","0:end:6"])
    print(result)

    result = sol.exclusiveTime(2, ["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"])
    print(result)
if __name__ == "__main__":
    main()
