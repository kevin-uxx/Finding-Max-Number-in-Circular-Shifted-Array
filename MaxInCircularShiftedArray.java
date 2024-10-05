import java.util.Random;

public class MaxInCircularShiftedArray {

    public static int findMax(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            
            if (arr[mid] > arr[right]) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }

        return arr[left]; 
    }

    public static void main(String[] args) {
        int[] sizes = {500000, 750000, 1000000, 2000000, 4000000};
        Random random = new Random();

        for (int n : sizes) {
            
            int[] sortedArray = new int[n];
            for (int i = 0; i < n; i++) {
                sortedArray[i] = i + 1; 
            }

            
            int shift = 4;
            int[] circularArray = new int[n];
            for (int i = 0; i < n; i++) {
                circularArray[i] = sortedArray[(i + shift) % n];
            }

            
            long startTime = System.nanoTime();
            int max = findMax(circularArray);
            long endTime = System.nanoTime();

            long duration = endTime - startTime; 
            System.out.println("Max in circular shifted array of size " + n + ": " + max);
            System.out.println("Time taken for n = " + n + ": " + duration + " ns");
        }
    }
}
