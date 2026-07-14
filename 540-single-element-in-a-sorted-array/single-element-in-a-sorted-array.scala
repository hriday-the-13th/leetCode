object Solution {
    def singleNonDuplicate(nums: Array[Int]): Int = {

        if(nums.length == 1){
            return nums(0)
        }
        
        if(nums(0) != nums(1)){
            return nums(0)
        }

        if(nums(nums.length-1) != nums(nums.length-2)){
            return nums(nums.length - 1)
        }

        def binary(start: Int, end: Int): Int = {
            if(start>end) return -1

            val mid = (start + end) / 2

            if(nums(mid) != nums(mid - 1) && nums(mid) != nums(mid + 1)){
                return nums(mid)
            }

            if((mid%2 == 1 && nums(mid-1) == nums(mid)) || (mid%2 == 0 && nums(mid) == nums(mid + 1))){
                binary(mid + 1, end)
            } else {
                binary(start, mid - 1)
            }
        }
        binary(1, nums.length-1)
    }
}