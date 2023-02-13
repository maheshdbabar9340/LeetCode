class Solution:
    def countOdds(self, low: int, high: int) -> int:
        return ceil(high/2)-ceil((low-1)/2)
