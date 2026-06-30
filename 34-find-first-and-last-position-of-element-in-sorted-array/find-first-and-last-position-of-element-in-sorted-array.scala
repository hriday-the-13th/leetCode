object Solution {
    def searchRange(nums: Array[Int], target: Int): Array[Int] = {
        
        def lowerBound(start: Int, end: Int, first: Int): Int = {
            if(start>end) return first
            val mid = (start + end) / 2
            if(nums(mid) == target) {
                lowerBound(start, mid -1, mid)
            } else if(nums(mid) < target){
                lowerBound(mid + 1, end, first)
            } else {
                lowerBound(start, mid - 1, first)
            }
        }

        def upperBound(start: Int, end: Int, last: Int): Int = {
            if(start>end) return last
            val mid = (start + end) / 2
            if(nums(mid) == target) {
                upperBound(mid + 1, end, mid)
            } else if(nums(mid) < target){
                upperBound(mid + 1, end, last)
            } else {
                upperBound(start, mid - 1, last)
            }
        }

        val lb = lowerBound(0, nums.length-1, -1)
        if(lb == nums.length && nums(lb) != target) Array(-1, -1)
        else Array(lb, upperBound(0, nums.length-1, -1))
    }
}