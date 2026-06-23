class Solution {
    public int search(int[] nums, int target) {
        // int start = 0;
        // int end = nums.length - 1;

        return binarySearch(nums, target, 0, nums.length-1);

        // while(start<=end){
        //     int mid = (start+end)/2;
        //     if(nums[mid] < target){
        //         start = mid + 1;
        //     } else if(nums[mid] > target){
        //         end = mid - 1;
        //     } else return mid;
        // }
        // return -1;
    }

    public int binarySearch(int nums[], int target, int start, int end){
        if(end>=start){
            int mid = (start+end)/2;
            if(nums[mid] == target) return mid;

            if(nums[mid] < target){
                return binarySearch(nums, target, mid + 1, end);
            }

            return binarySearch(nums, target, start, mid - 1);
        }

        return -1;
    }
}