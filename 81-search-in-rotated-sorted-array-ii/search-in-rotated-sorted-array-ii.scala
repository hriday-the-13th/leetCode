object Solution {
    def search(nums: Array[Int], target: Int): Boolean = {
        
        def binSearch(start: Int, end: Int): Boolean = {
            if(start>end) return false
            val mid = (start + end) / 2
            if(nums(mid) == target) return true
            
            if(nums(start) == nums(mid) && nums(mid) == nums(end)){
                return binSearch(start+1, end-1)
            }

            if(nums(start) <= nums(mid)){
                if(target>=nums(start) && target<=nums(mid)){
                    binSearch(start, mid-1)
                } else {
                    binSearch(mid+1, end)
                }
            } else {
                if(target>=nums(mid) && target<= nums(end)){
                    binSearch(mid+1, end)
                } else {
                    binSearch(start, mid-1)
                }
            }
        }
        binSearch(0, nums.length-1)
    }
}