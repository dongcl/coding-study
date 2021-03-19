public class SortAlgorithm {


    /**
     * 直接插入排序算法
     * 空间复杂度O(1),平均时间复杂度O（n^2）,最好情况下是O(n),稳定的排序
     */
    public static int[] insertSort(int[] arr){
        if (arr == null) return null;

        int temp,j;
        for (int i=1;i<arr.length;i++){
            temp = arr[i];
            j = i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;
        }

        return  arr;
    }
}
