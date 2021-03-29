public class ArrayRelativeAlgorithm {

    /**
     *在 一个 二维 数组 中， 每一 行都 按照 从左到右 递增 的 顺序 排序， 每 一列 都 按照 从上到下 递增 的 顺序 排序。 请 完成 一个 函数，
     *  输入 这样 的 一个 二维 数组 和 一个 整数， 判断 数组 中 是否 含有 该 整数。
     *
     *
     */
    public static boolean findNumInArray(int[][] arr,int num){

        if (arr == null)  return false;

        int rowLen = arr.length;
        int columnLen = arr[0].length;
        int i = 0;
        int j = columnLen-1;

        while (j>=0 && i<rowLen){
            if (num == arr[i][j]){
                return true;
            }else if(num<arr[i][j]) {
                j--;
            }else {
                i++;
            }
        }

        return false;
    }

    /**
     *题目： 把 一个 数组 最 开始 的 若干个 元素 搬到 数组 的 末尾， 我们 称之为 数组 的 旋转。 输入 一个 递增 排序 的 数组 的 一个 旋转，
     *  输出 旋转 数组 的 最小 元素。
     *  {3,4,5,1,2}
     *
     */
    public static int findMinNum(int[] arr){
        if (arr == null || arr.length <= 0) return Integer.MIN_VALUE;
        int start = 0;
        int end = arr.length-1;
        int mid = start;
        while (arr[start]>=arr[end]){
            if (end-start == 1){
                mid = end;
                break;
            }

            mid = (end + start)/2;
            if (arr[start] == arr[end] && arr[mid] == arr[start]){
              return  findMin(arr,start,end);
            }

            if (arr[start] <= arr[mid]){
                start = mid;
            }else if (arr[end]>=arr[mid]){
                end = mid;
            }

        }
        return arr[mid];
    }

    public static int findMin(int[] arr,int start,int end){
        int min = arr[start];
        for (int i = start+1;i<end;i++){
            if (min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }


    /**
     *题目： 输入 一个 整型 数组， 数组 里 有 正数 也有 负数。 数组 中 一个 或 连续 的 多个 整数 组成 一个 子 数组。
     * 求 所有 子 数组 的 和 的 最大值。要求 时间 复杂度 为 O（ n）。
     *
     *例如 输入 的 数组 为{ 1,- 2, 3, 10,- 4, 7, 2,- 5}， 和 最 大的 子 数组 为{ 3, 10,- 4, 7, 2}， 因此 输出 为 该 子 数组 的 和 18。
     *
     */
    public static int largestSumOfSubArray(int[] arr){
        if (arr ==  null || arr.length ==0 ) return 0;
        int currSum = 0;
        int largestSum = Integer.MIN_VALUE;

        for (int i =0 ;i < arr.length;i++){
            if (currSum<=0){
                currSum = arr[i];
            }else {
                currSum += arr[i];
            }

            if (largestSum<currSum){
                largestSum = currSum;
            }
        }

        return  largestSum;
    }





}
