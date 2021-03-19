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


    /**
     * 冒泡排序算法
     * 空间复杂度O(1),平均时间复杂度O（n^2）,最好情况下是O(n),稳定的排序
     */
    public static int[] bubbleSort(int[] arr){
        if (arr == null) return null;

        int temp;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] =  arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return  arr;
    }

    /**
     * 改进的冒泡排序
     */
    public static int[] improvedBubbleSort(int[] arr){
        if (arr == null) return  null;
        int temp;
        boolean isSwapped = false;

        for (int i=0; i < arr.length-1;i++){
            isSwapped = false;
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] =  arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }

            if (!isSwapped){
                break;
            }
        }

        return arr;
    }

    /**
     * 直接选择排序算法
     * 空间复杂度O(1),平均时间复杂度O（n^2）,不稳定的排序
     */
    public static int[] selectSort(int[] arr){
        if (arr == null) return null;

        int temp,index;
        for (int i=0;i<arr.length-1;i++){
            index = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[index]){
                    index = j;
                }
            }

            temp = arr[i];
            arr[i] =  arr[index];
            arr[index] = temp;
        }
        return  arr;
    }

    /**
     * 希尔排序
     * 空间复杂度O(1),时间复杂度O（n^3/2）,不稳定的排序
     */
    public static int[] shellSort(int[] arr){
        if (arr == null) return null;

        int temp;

        for (int gap = (arr.length-1)/2;gap >= 1;gap /=2){
            for (int i = gap ;i<arr.length;i++){
                for (int j= i-gap;j>=0;j--){
                    if (arr[j]>arr[j+gap]){
                        temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        return  arr;
    }

    /**
     * 快速排序
     * 空间复杂度最好O(log2n),最坏O(n),时间复杂度最坏O（n^2），最好O(log2n),不稳定的排序
     */
    public static void  quickSort(int[] arr,int low,int high){
        if (arr == null) return;

        int p;
        if (low<high){
            p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }

    public static int partition(int[] arr,int low,int high){
        int temp = arr[low];

        while (low<high){
            while (low<high && temp < arr[high]){
                high--;
            }
            arr[low] = arr[high];

            while (low<high && temp > arr[low]){
                low++;
            }
            arr[high]  = arr[low];
        }

        arr[low] = temp;

        return  low;
    }

    /**
     * 堆排序
     * 空间复杂度O(1),时间复杂度O（nlog2n）,不稳定的排序
     */
    public static  void  heapSort(int[] arr){
        if (arr == null) return;

        //先创建堆，从第一个非叶子节点开始
        for (int i=(arr.length-1)/2;i>=0;i--){
            adjustHeap(arr,arr.length,i);
        }

        //堆排序
        for (int i=arr.length-1;i>0;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            adjustHeap(arr,i,0);
        }
    }

    public static void adjustHeap(int[] arr,int lenOfArr, int currentIndex){
         int largest = currentIndex;
         int l = 2*currentIndex+1;
         int r = 2*currentIndex+2;

         if (l<lenOfArr && arr[l]>arr[largest]){
            largest = l;
         }

         if (r<lenOfArr && arr[r]>arr[largest]){
             largest = r;
         }

         if (largest != currentIndex){
             int temp = arr[currentIndex];
             arr[currentIndex] = arr[largest];
             arr[largest] = temp;
             adjustHeap(arr,lenOfArr,largest);
         }
    }


    /**
     * 归并排序
     * 空间复杂度O(n),时间复杂度O（nlog2n）,稳定的排序
     *
     */
    public static void  mergeSort(int[] arr,int low, int high){
        if (arr == null) return;
        int mid = (high+low)/2;
        if (low<high){
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,high,mid);
        }
    }

    public static void merge(int[] arr ,int low, int high,int mid){
        int[] temp = new int[high-low+1];
        int i = low;
        int j= mid+1;
        int k = 0;

        while (i <= mid && j <= high){
            if (arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        while (i<=mid){
            temp[k++] = arr[i++];
        }

        while (j<=high){
            temp[k++] = arr[j++];
        }

        for (int q = 0;q<temp.length;q++){
            arr[q+low] = temp[q];
        }

    }
}
