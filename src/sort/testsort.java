package sort;

import java.util.*;
 
public class testsort {
 
   private static int[] a;
   private static int n;
   private static int left;
   private static int right;
   private static int largest;
 
 
   public static void buildheap(int []a) {
      n = a.length-1;
      for(int i=n/2; i>=0; i--){
         maxheap(a,i);
      }
   }
 
   public static void maxheap(int[] a, int i) { 
      left = 2*i;
      right = 2*i+1;
 
      if(left <= n && a[left] > a[i]){
         largest=left;
      } else {
         largest=i;
      }
 
      if(right <= n && a[right] > a[largest]) {
         largest=right;
      }
      
      if(largest!=i) {
         exchange(i, largest);
         maxheap(a, largest);
      }
   }
 
   public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t; 
   }
 
   public static void sort(int[] myarray) {
      a = myarray;
      buildheap(a);
      System.out.println(Arrays.toString(a));
      for(int i=n; i>0; i--) {
         exchange(0, i);
         n=n-1;
         maxheap(a, 0);
      }
   }
 
   public static void main(String[] args) {
      int []numbers={5,6,0,9,4,5,1,7,2,8,11,3};
      System.out.println(Arrays.toString(numbers));
      sort(numbers);
      System.out.println(Arrays.toString(numbers));
   }
}