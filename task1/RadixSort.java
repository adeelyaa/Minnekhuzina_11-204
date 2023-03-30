import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.util.stream.Collectors;
class RadixSort {
    public static int cnt;

    //Function to implement counting sort
    public static void countingSort2(int a[], int n, int place) {
        int[] output = new int[n + 1];
        int[] count = new int[10];

        // Calculate count of elements
        for (int i = 0; i < n; i++) {
            count[(a[i] / place) % 10]++;
            cnt++;
        }

        // Calculate cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            cnt++;
        }

        // Place the elements in sorted order
        for (int i = n - 1; i >= 0; i--) {
            output[count[(a[i] / place) % 10] - 1] = a[i];
            count[(a[i] / place) % 10]--;
            cnt++;
        }

        for (int i = 0; i < n; i++) {
            a[i] = output[i];
            cnt++;
        }
    }

    // Function to get the largest element from an array
    public static int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            cnt++;
        }
        return max;
    }

    // Main function to implement radix sort
    public static void radixSort(int array[], int size) {
        // Get maximum element
        int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort2(array, size, place);
            cnt++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Double> map = new HashMap<>();
        Map<Integer, Integer> mapCnt = new HashMap<>();
        Scanner file = new Scanner(new File("File.txt"));
        String[] testData = file.nextLine().split(" ");
        int[] testArr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            testArr[i] = Integer.parseInt(testData[i]);
        }
        radixSort(testArr, testData.length);

        while (file.hasNextLine()) {
            String[] data = file.nextLine().split(" ");
            int[] arr = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }
            cnt = 0;
            long startTime = System.nanoTime();
            radixSort(arr, data.length);
            long endTime = System.nanoTime();
            map.put(arr.length, (double) (endTime - startTime));
            mapCnt.put(arr.length, cnt);
        }

        List<Map.Entry<Integer, Double>> list = new LinkedList<>(map.entrySet());

        List<Map.Entry<Integer, Double>> sortedList = list.stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }

        List<Map.Entry<Integer, Integer>> list1 = new LinkedList<>(mapCnt.entrySet());
        List<Map.Entry<Integer, Integer>> sortedList1 = list1.stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        for (int i = 0; i < sortedList1.size(); i++) {
            System.out.println(sortedList1.get(i));
        }
    }
}
