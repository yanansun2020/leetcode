class Solution {
    public int getWinner(int[] arr, int k) {
        Map<Integer, Integer> memo= new HashMap<Integer, Integer>()
        max_v = max(arr)
        while arr[0] != max_v:
            first = arr[0]
            second = arr[1]
            max_value = max(first, second)
            min_value = min(first, second)
            memo[max_value] += 1
            if memo[max_value] == k:
                return max_value
            arr = arr[2:]
            arr.insert(0, max_value)
            arr.append(min_value)
        return max_v
    }
}