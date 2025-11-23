import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class SBATemplate {

    // =======================================================================
    // printState METHOD: Displays the current state of L, R, and MID
    // =======================================================================
    // The throws clause is necessary because of Thread.sleep()
    private static void printState(int[] numbers, int L, int R, int mid, int iteration, String action) throws InterruptedException {
        System.out.println("\n" + "=".repeat(60));
        System.out.printf("ITERATION: %d | L: %d | R: %d | MID: %d\n", iteration, L, R, mid);
        System.out.println("ACTION: " + action);

        // 1. Generate the Array String
        String arrayStr = Arrays.toString(numbers);
        System.out.println("Array: " + arrayStr);

        // 2. Generate the Pointer Line (using robust alignment logic)
        StringBuilder pointerLine = new StringBuilder();
        int currentPositionInArrayStr = 0;

        if (arrayStr.charAt(0) == '[') {
            currentPositionInArrayStr++;
        }

        for (int k = 0; k < numbers.length; k++) {
            String numStr = String.valueOf(numbers[k]);

            // Advance pointerLine to align with the start of the current number in arrayStr
            while (currentPositionInArrayStr < arrayStr.length() &&
                    (arrayStr.charAt(currentPositionInArrayStr) == ' ' || arrayStr.charAt(currentPositionInArrayStr) == ',')) {
                pointerLine.append(' ');
                currentPositionInArrayStr++;
            }

            String marker = "";
            if (k == L && k == R) {
                marker = "L/R";
            } else if (k == L) {
                marker = "L";
            } else if (k == R) {
                marker = "R";
            } else if (k == mid) {
                marker = "M";
            }

            if (!marker.isEmpty()) {
                // Determine padding for the marker
                int markerLength = marker.length();
                int numLength = numStr.length();

                int paddingLeft = Math.max(0, (numLength - markerLength) / 2);
                int paddingRight = Math.max(0, numLength - markerLength - paddingLeft);

                for(int p = 0; p < paddingLeft; p++) pointerLine.append(' ');
                pointerLine.append(marker);
                for(int p = 0; p < paddingRight; p++) pointerLine.append(' ');

            } else {
                for (int m = 0; m < numStr.length(); m++) {
                    pointerLine.append(' ');
                }
            }

            currentPositionInArrayStr += numStr.length();

            if (k < numbers.length - 1) {
                if (currentPositionInArrayStr + 2 <= arrayStr.length() &&
                        arrayStr.substring(currentPositionInArrayStr, currentPositionInArrayStr + 2).equals(", ")) {
                    pointerLine.append("  ");
                    currentPositionInArrayStr += 2;
                }
            }
        }

        System.out.println("Markers: " + pointerLine.toString());
        System.out.println("=".repeat(60));

        Thread.sleep(3000);
    }

    // =======================================================================
    // Predicate Function
    // =======================================================================
    private boolean isTrue(int[] arr, int mid, int target, boolean isFirstOccurrence) {
        if (isFirstOccurrence) {
            // Predicate for First Occurrence: Is the element at 'mid' >= target?
            return arr[mid] >= target;
        } else {
            // Predicate for Last Occurrence: Is the element at 'mid' > target?
            return arr[mid] > target;
        }
    }

    // =======================================================================
    // findBoundary (The Universal Template)
    // =======================================================================
    // Now declares InterruptedException, delegating it to the caller (Test class)
    private int findBoundary(int[] arr, int target, boolean isFirstOccurrence) throws InterruptedException {
        int L = -1;
        int R = arr.length;
        int iteration = 1;

        while (R - L > 1) {
            int mid = L + (R - L) / 2;
            String action;

            if (isTrue(arr, mid, target, isFirstOccurrence)) {
                action = String.format("arr[%d] (%d) satisfies condition. Answer at or left. R = mid (%d)", mid, arr[mid], mid);
                R = mid;
            } else {
                action = String.format("arr[%d] (%d) fails condition. Answer must be to the right. L = mid (%d)", mid, arr[mid], mid);
                L = mid;
            }

            printState(arr, L, R, mid, iteration, action);
            iteration++;
        }

        // Final result evaluation
        if (isFirstOccurrence) {
            if (R < arr.length && arr[R] == target) {
                return R;
            }
        } else { // Last Occurrence
            if (L >= 0 && arr[L] == target) {
                return L;
            }
        }

        return -1;
    }

    public int findFirst(int[] arr, int target) throws InterruptedException {
        return findBoundary(arr, target, true);
    }

    public int findLast(int[] arr, int target) throws InterruptedException {
        return findBoundary(arr, target, false);
    }
}

// =======================================================================
// BinarySearchTest Class (Main Entry Point)
// =======================================================================
public class BinarySearchTest {
    // The main method must now declare or handle InterruptedException
    public static void main(String[] args) {
        SBATemplate solver = new SBATemplate();

        try {
            int[] arr = {3, 3, 7, 9, 10, 10, 10, 12, 15};
            int target = 10;

            System.out.println("\n" + "#".repeat(70));
            System.out.println("### START TEST SUITE: SBA Binary Search Visualization ###");
            System.out.println("#".repeat(70));

            System.out.println("\n--- Finding First Occurrence of " + target + " ---");
            int firstIndex = solver.findFirst(arr, target);
            System.out.println("\n*** Final Result: First Occurrence Index: " + firstIndex + " (Expected: 4) ***");

            System.out.println("\n--- Finding Last Occurrence of " + target + " ---");
            int lastIndex = solver.findLast(arr, target);
            System.out.println("\n*** Final Result: Last Occurrence Index: " + lastIndex + " (Expected: 6) ***");

            System.out.println("\n--- Element Not Present (Target: 11) ---");
            int nonExistent = 11;
            int notFound = solver.findFirst(arr, nonExistent);
            System.out.println("\n*** Final Result: Occurrence of " + nonExistent + ": " + notFound + " (Expected: -1) ***");

            System.out.println("\n" + "#".repeat(70));
            System.out.println("### END TEST SUITE ###");
            System.out.println("#".repeat(70));

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Execution was interrupted: " + e.getMessage());
        }
    }
}