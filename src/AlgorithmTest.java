import java.util.Arrays;

public class AlgorithmTest {
    public static void main(String[] args) {
        int arr[] = { 38,65,97,76,13,27,49 };
        SortAlgorithm.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


}
