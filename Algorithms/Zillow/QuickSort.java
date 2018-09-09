/**
 * Time O(nlogn)
 * Space: height of the tree. O(logn)
 * 
 */

class solution{
    public void Sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        int pivot = nums[(start + end) / 2];
        int idx = partition(nums, start, end, pivot);
        quickSort(nums, start, idx - 1);
        quickSort(nums, idx, end);
    }

    private int partition(int[] nums, int start, int end, int pivot){
        while (start <= end){
            while (nums[start] < pivot){
                start++;
            }
            while (nums[end] > pivot){
                right--;
            }
            if (start <= end){
                swap(nums, start++, end--);
            }
        }
        return start;
    }

    private void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}