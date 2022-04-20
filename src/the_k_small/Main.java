package the_k_small;

import java.util.Scanner;

public class Main{
    static int QuickSelect(int[] a, int s, int t, int k) {
        int i = s, j = t;
        int tmp;
        if(s < t)
        {
            tmp = a[s];
            while(i != j)
            {
                while(j > i && a[j] >= tmp)
                    j--;
                a[i] = a[j];
                while(i < j && a[i] <= tmp)
                    i++;
                a[j] = a[i];
            }
            a[i] = tmp;
            if(k-1 == i){
                return a[i];
            }
            else if(k-1 < i)
                return QuickSelect(a, s, i-1, k);
            else
                return QuickSelect(a, i+1, t, k);
        }
        else if(s == t && s == k-1){
            return a[k-1];
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] nums;
        int k,k_small;
        nums=sc.nextLine().split(" ");
        int[] num =new int[nums.length];
        k=sc.nextInt();
        for(int i=0;i<num.length;i++){
            num[i]=Integer.parseInt(nums[i]);
        }
        k_small=QuickSelect(num,0,nums.length-1,k);
        System.out.println(k_small);


    }
}

