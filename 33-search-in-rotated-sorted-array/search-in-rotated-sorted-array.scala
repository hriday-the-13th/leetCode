object Solution {
    def search(nums: Array[Int], target: Int): Int = {
        def binSearch(start: Int, end: Int): Int = {
        if (start > end) return -1

        val mid = (start + end) / 2

        if(nums(mid) == target) return mid

        if(nums(start) <= nums(mid)){
            if(nums(start) <= target && target <= nums(mid)){
                binSearch(start, mid - 1)
            } else {
                binSearch(mid + 1, end)
            }
        } else {
            if(nums(mid) <= target && target <= nums(end)){
                binSearch(mid + 1, end)
            } else {
                binSearch(start, mid - 1)
            }
        }
        }
        binSearch(0, nums.length - 1)
    }

    
}