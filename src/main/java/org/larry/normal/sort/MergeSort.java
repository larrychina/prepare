package org.larry.normal.sort;

/**
 * 归并排序
 * 基本思想：分治算法，把一个大集合分成两个小集合，然后合并
 * 时间复杂度：T(n) = T(n1) + T(n2) + k   O(nlogn)
 * 空间复杂度：因为在合并过程中需要开辟一块和集合大小的内存空间，故O(n)
 */
public class MergeSort {


    public int[] sort(int arr[]){
        if(arr == null || arr.length == 0){
            return arr;
        }

        int sart = 0 , end = arr.length -1;
        sortC(arr,sart,end);
        return arr ;
    }

    public void sortC(int arr[],int low,int high){
        if(low < high){
            int divide = (low + high ) / 2 ;

            sortC(arr,low,divide) ;

            sortC(arr,divide+1,high) ;

            megere(arr,low,divide,high);
        }
    }

    public void megere(int [] arr,int low , int mindle ,int high){

        int tmp[] = new int[arr.length] ;
        int i = low , j = mindle + 1 ;
        int index = 0 ;
        while (i <= mindle && j <= high){
            if(arr[i] < arr[j]){
                tmp[index++] = arr[i++] ;
            } else{
                tmp[index++] = arr[j++] ;
            }
        }
        while (i <= mindle){
            tmp[index++] = arr[i++] ;
        }
        while ( j <= high){
            tmp[index++] = arr[j++] ;
        }
        index = 0 ;
        while (low <= high){
            arr[low++] = tmp[index++] ;
        }
    }

    public void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println("");
    }
    public static void main(String[] args) {

        int arr[] = new int[]{1,5,9,4,6,7,2};
        int arr1[] = new int[]{7,6,5,4,3,2,1};
        MergeSort bs = new MergeSort() ;
        bs.megere(arr,0,(arr.length)/2,arr.length-1);
        bs.print(arr);
        //bs.print(bs.sort(arr));
        //bs.print(bs.sort(arr1));
    }
}
