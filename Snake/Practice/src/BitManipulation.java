public class BitManipulation {
    public static void main(String[] args) {
        int n=78;
        System.out.println("3rd bit in the given number is"+ans(n)+"Setting 5th bit"+set(78)+"Reset 4th bit"+reset(78));
        int[] arr={2,2,3,2,4,4,4,5,6,6,5,5,6};
        System.out.println("only number appeared once is"+thrice(arr));
    }
    public static int ans(int n){
        return (n&(1<<(3-1)))>>2;
    }
    public static int set(int n){
       return n=(n|(1<<4));

    }
    public static int reset(int n){
        return n=n&(~(1<<3));
    }
    public static int thrice(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += (nums[j] >> i) & 1;
            }
            if (cnt % 3 == 1) ans = ans | (1 << i); // sets the ith bit
        }
        return ans;

    }
}
