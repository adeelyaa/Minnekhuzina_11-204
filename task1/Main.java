import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        int[] data = { 121, 432, 564, 23, 1, 45, 788 };
        int size = data.length;
        RadixSort rs = new RadixSort();
        System.out.println("Array before sorting: ");
        System.out.println(Arrays.toString(data));
        rs.radixSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
