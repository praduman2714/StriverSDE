class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[n+m];
        int k = 0;
        int i = 0, j =0;
        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                res[k++] = nums1[i];
                i++;
            }else{
                res[k++] = nums2[j];
                j++;
            }
        }
        
        while(i < n){
            res[k++] = nums1[i++];
        }
        
        while(j < m){
            res[k++] = nums2[j++];
        }
         
        int nn = res.length;
        if(res.length % 2 == 0){
            return ((double)res[(nn/2)-1] +  (double)res[(nn/2)]) / 2;
        }
        
        return res[res.length / 2];
    }
}

Time Complexity : O(N+M)
Space Complexity : O(N+M)

The Optimal Approach


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return median(nums1, nums2, nums1.length, nums2.length);
    }
    
    public double median(int arr1[],int arr2[],int m,int n) {
    if(m>n)
        return median(arr2,arr1,n,m);//ensuring that binary search happens on minimum size array
        
    int low=0,high=m,medianPos=((m+n)+1)/2;
    while(low<=high) {
        int cut1 = (low+high)>>1;
        int cut2 = medianPos - cut1;
        
        int l1 = (cut1 == 0)? Integer.MIN_VALUE:arr1[cut1-1];
        int l2 = (cut2 == 0)? Integer.MIN_VALUE:arr2[cut2-1];
        int r1 = (cut1 == m)? Integer.MAX_VALUE:arr1[cut1];
        int r2 = (cut2 == n)? Integer.MAX_VALUE:arr2[cut2];
        
        if(l1<=r2 && l2<=r1) {
            if((m+n)%2 != 0)
                return Math.max(l1,l2);
            else 
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
        }
        else if(l1>r2) high = cut1-1;
        else low = cut1+1;
    }
    return 0.0;
}

}

Time complexity : O(log(min(n, m)))
Space complexity : O(1)