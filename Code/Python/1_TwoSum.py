class Solution:
    def twoSum_bruteForce(self, nums: List[int], target: int) -> List[int]:
        ## this is O(n^2) as we have double loops
        for i in range(len(nums)):
            for j in range(i+1, len(nums)): ### simple tweak
                if(nums[i]+nums[j] == target): 
                    return [i,j]
    
    def twoSum_hashTable(self, nums: List[int], target: int) -> List[int]:
        ## in this approach we trade off space for time
        ## O(1) look up time; 
        ## overall time complexity is O(n) as we need to build hashmap (which is a dict)
        hashmap = {}
        for i in range(len(nums)):
            ## build hashmap
            hashmap[nums[i]] = i
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hashmap and hashmap[complement] != i:
                return [i, hashmap[complement]]
