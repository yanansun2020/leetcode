class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        product = 1
        count_zero = 0
        for num in nums:
            if num == 0:
                count_zero += 1
            else:
                product *= num
        output = []
        for num in nums:
            if count_zero == 0:
                output.append(product//num)
            elif count_zero == 1:
                if num != 0:
                    output.append(0)
                else:
                    output.append(product)
            elif count_zero > 1:
                output.append(0)
        return output