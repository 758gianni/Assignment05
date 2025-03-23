package assignment05;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Nikita Neveditsin
 */
public class A5Tests {

    private static final double TP = 0.375;
    private static final double TPP = 0.5;

    public static void main(String[] args) {
        double sum = 0;

        DynamicArray<Integer> ia = new DynamicArray<Integer>();
        //testing isEmpty()
        if (ia.isEmpty()) {
            System.out.println("Test 1 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 1 FAILED: ia.isEmpty() must return true, "
                    + "returned: " + ia.isEmpty());
        }

        //add 4 elements
        ia.add(5);
        ia.add(51);
        ia.add(52);
        ia.add(53);

        //testing size() I
        if (ia.size() == 4) {
            System.out.println("Test 2 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 2 FAILED: ia.size() must return 4, "
                    + "returned: " + ia.size());
        }

        //testing toJavaArray I
        if (Arrays.equals(ia.toJavaArray(),
                new Integer[]{5, 51, 52, 53})) {
            System.out.println("Test 3 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 3 FAILED: ia.toJavaArray() must return "
                    + "[5, 51, 52, 53], "
                    + "returned: " + Arrays.toString(ia.toJavaArray()));
        }

        //testsing getUnderlyingArrayCopy() I
        if (Arrays.equals(ia.getUnderlyingArrayCopy(),
                new Integer[]{5, 51, 52, 53, null, null, null, null})) {
            System.out.println("Test 4 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 4 FAILED: ia.getUnderlyingArrayCopy() must return "
                    + "[5, 51, 52, 53, null, null, null, null], "
                    + "returned: " + Arrays.toString(ia.getUnderlyingArrayCopy()));
        }

        ia.add(54);
        ia.add(0);
        ia.add(0);
        ia.add(57);

        //testing size() II
        if (ia.size() == 8) {
            System.out.println("Test 5 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 5 FAILED: ia.size() must return 8, "
                    + "returned: " + ia.size());
        }

        //testsing getUnderlyingArrayCopy() II
        if (Arrays.equals(ia.getUnderlyingArrayCopy(),
                new Integer[]{5, 51, 52, 53, 54, 0, 0, 57})
                && Arrays.equals(ia.getUnderlyingArrayCopy(), ia.toJavaArray())) {
            System.out.println("Test 6 PASSED");
            sum += TP;

        } else {
            System.out.println("Test 6 FAILED: ia.getUnderlyingArrayCopy() must "
                    + "return [5, 51, 52, 53, 54, 0, 0, 57] and be equal to "
                    + "ia.toJavaArray, "
                    + "returned: " + Arrays.toString(ia.getUnderlyingArrayCopy()));
        }

        //testsing toString()
        if (ia.toString().equals(Arrays.toString(ia.toJavaArray()))) {
            System.out.println("Test 7 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 7 FAILED: toString must return the string "
                    + "representation of"
                    + "ia.toJavaArray(): [5, 51, 52, 53, 54, 0, 0, 57]. Got: "
                    + ia);
        }

        //testing add with resizing
        ia.add(58);
        ia.add(0);

        if (Arrays.equals(ia.toJavaArray(),
                new Integer[]{5, 51, 52, 53, 54, 0, 0, 57, 58, 0})) {
            System.out.println("Test 8 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 8 FAILED: toJavaArray must return  "
                    + "[5, 51, 52, 53, 54, 0, 0, 57, 58, 0]. Returned: "
                    + Arrays.toString(ia.toJavaArray()));
        }

        if (Arrays.equals(ia.getUnderlyingArrayCopy(),
                new Integer[]{5, 51, 52, 53, 54, 0, 0, 57, 58, 0, null, null, null, null, null, null})) {
            System.out.println("Test 9 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 9 FAILED: toJavaArray must return  "
                    + "[5, 51, 52, 53, 54, 0, 0, 57, 58, 0, null, null, null, null, null, null]. "
                    + "Returned: "
                    + Arrays.toString(ia.getUnderlyingArrayCopy()));
        }

        for (int i = 1; i <= 8; i++) {
            ia.add(i * i);
        }

        if (Arrays.equals(ia.toJavaArray(),
                new Integer[]{5, 51, 52, 53, 54, 0, 0, 57, 58, 0, 1, 4, 9,
                    16, 25, 36, 49, 64})) {
            System.out.println("Test 10 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 10 FAILED: toJavaArray must return  "
                    + "[5, 51, 52, 53, 54, 0, 0, 57, 58, 0, 1, 4, 9,"
                    + " 16, 25, 36, 49, 64]. Returned: "
                    + Arrays.toString(ia.toJavaArray()));
        }

        if (Arrays.equals(ia.getUnderlyingArrayCopy(),
                new Integer[]{5, 51, 52, 53, 54, 0, 0, 57, 58, 0, 1, 4, 9, 16, 25,
                    36, 49, 64, null, null, null, null, null, null, null, null, null, null, null, null, null, null})) {
            System.out.println("Test 11 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 11 FAILED: toJavaArray must return  \n"
                    + "[5, 51, 52, 53, 54, 0, 0, 57, 58, 0, 1, 4, 9, 16, 25, 36,"
                    + " 49, 64, null, null, null, null, null, null, null, null, null, null, null, null, null, null]. "
                    + "Returned: \n"
                    + Arrays.toString(ia.getUnderlyingArrayCopy()));
        }

        if (ia.getLast() == 64) {
            System.out.println("Test 12 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 12 FAILED: getLast must return 64\n"
                    + ""
                    + "Returned: \n"
                    + ia.getLast());
        }

        //testing the set method (1pt)        
        ia.set(5, 500);
        ia.set(6, 600);
        ia.set(9, 900);
        if (Arrays.equals(ia.getUnderlyingArrayCopy(),
                new Integer[]{5, 51, 52, 53, 54, 500, 600, 57, 58, 900, 1, 4, 9, 16,
                    25, 36, 49, 64, null, null, null, null, null, null, null, null, null, null, null, null, null, null})) {
            System.out.println("Test 13 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 13 FAILED: getUnderlyingArrayCopy must return  \n"
                    + "[5, 51, 52, 53, 54, 500, 600, 57, 58, 900, 1, 4, 9, "
                    + "16, 25, 36, 49, 64, null, null, null, null, null, null, null, null, null, null, null, null, null, null]. "
                    + "Returned: \n"
                    + Arrays.toString(ia.getUnderlyingArrayCopy()));
        }

        try {
            ia.set(18, -1);
            System.out.println("Test 14 FAILED: IndexOutOfBoundsException expected");
        } catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("Test 14 PASSED");
            sum += TP;
        }

        //tests for getRandom()
        Object[] arr = ia.toJavaArray();
        arr = Stream.of(arr).toArray(Integer[]::new);
        int[] indices = new int[65535];
        int ii = 0;
        for (ii = 0; ii < 65535; ii++) {
            Integer el = ia.getRandom();
            int idx = -1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == el) {
                    idx = j;
                    break;
                }
            }
            indices[ii] = idx;
            if (idx < 0) {
                System.out.println("Test 15 FAILED: ia.getRandom() returned"
                        + " an element that is not in array: " + el);
                break;
            }
        }
        if (ii == 65535) {
            System.out.println("Test 15 PASSED");
            sum += TP;
        }

        int iii = 0;
        Arrays.sort(indices);
        for (iii = 0; iii < ia.size(); iii++) {
            if (Arrays.binarySearch(indices, iii) < 0) {
                System.out.println("Test 16 FAILED: ia.getRandom() never returned "
                        + "an element at index: " + iii + "\nTry to re-run the tests "
                        + "but probably there is an error in your getRandom method");
                break;
            }
        }

        if (iii == ia.size()) {
            System.out.println("Test 16 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 16 FAILED: check your getRandom() method");
        }

        //tests for copy
        ia.toJavaArray()[0] = -1000;
        if (ia.toJavaArray()[0].equals(5)) {
            System.out.println("Test 17 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 17 FAILED: are you returning a COPY of an array"
                    + " in the toJavaArray() method?");
        }

        ia.getUnderlyingArrayCopy()[0] = -1000;
        if (ia.getUnderlyingArrayCopy()[0].equals(5)) {
            System.out.println("Test 18 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 18 FAILED: are you returning a COPY of an array"
                    + " in the getUnderlyingArrayCopy() method?");
        }

        //tests for get
        if (ia.get(0) == 5 && ia.get(1) == 51 && ia.get(ia.size() - 1) == 64) {
            System.out.println("Test 19 PASSED");
            sum += TP;
        } else {
            System.out.println("Test 19 FAILED: check your get() method");
        }

        try {
            ia.get(18);
            System.out.println("Test 20 FAILED: IndexOutOfBoundsException expected");
        } catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("Test 20 PASSED");
            sum += TP;
        }

        ia = new DynamicArray<Integer>();
        ia.add(5);
        ia.add(51);
        ia.add(52);
        ia.add(53);
        ia.add(54);
        ia.add(55);
        ia.add(56);
        ia.add(57);
        ia.add(58);

        //delete last
        for (int val = 58, i = ia.size() - 1; i > 0; i--, val--) {
            if (ia.delete(i) != val || ia.size() != i) {
                System.out.println("Test 21 FAILED: deleting the last element");
                break;
            }
        }

        if (ia.size() == 1 && Arrays.equals(ia.toJavaArray(), new Integer[]{5})
                && ia.get(ia.size() - 1) == 5) {
            System.out.println("Test 21 PASSED");
            sum += TPP;
        }

        ia.add(51);
        ia.add(52);
        ia.add(53);
        ia.add(54);
        ia.add(55);
        ia.add(56);
        ia.add(57);
        ia.add(58);

        //delete first
        for (int val = 51, i = 0; i < 8; i++, val++) {
            int delVal = ia.delete(1);
            if (delVal != val) {
                System.out.println("Test 22 FAILED: deleting the first element. "
                        + "Expectd: " + val + " Got: " + delVal);
                break;
            }
        }

        if (ia.size() == 1 && Arrays.equals(ia.toJavaArray(), new Integer[]{5})
                && ia.get(ia.size() - 1) == 5) {
            System.out.println("Test 22 PASSED");
            sum += TPP;
        }

        //delete at index 1
        ia.delete(0);
        if (ia.size() == 0 && Arrays.equals(ia.toJavaArray(), new Integer[]{})) {
            System.out.println("Test 23 PASSED");
            sum += TPP;
        } else {
            System.out.println("Test 23 FAILED: deleting the last element");
        }

        ia.add(5);
        ia.add(51);
        ia.add(52);
        ia.add(53);
        ia.add(54);
        ia.add(55);
        ia.add(56);
        ia.add(57);
        ia.add(58);

        //delete random elements
        boolean passed = false;
        if (ia.delete(3) == 53 && Arrays.equals(ia.toJavaArray(),
                new Integer[]{5, 51, 52, 54, 55, 56, 57, 58})) {
            if (ia.delete(0) == 5 && Arrays.equals(ia.toJavaArray(),
                    new Integer[]{51, 52, 54, 55, 56, 57, 58})) {
                if (ia.delete(ia.size() - 1) == 58 && Arrays.equals(ia.toJavaArray(),
                        new Integer[]{51, 52, 54, 55, 56, 57})) {
                    if (ia.delete(1) == 52 && Arrays.equals(ia.toJavaArray(),
                            new Integer[]{51, 54, 55, 56, 57})) {
                        System.out.println("Test 24 PASSED");
                        sum += TPP;
                        passed = true;
                    }
                }
            }
        }

        if (!passed) {
            System.out.println("Test 24 FAILED: random deletions");
        }

        ia.delete(0);
        ia.delete(1);
        ia.delete(0);
        ia.delete(ia.size() - 1);
        ia.delete(ia.size() - 1);

        try {
            ia.delete(0);
            System.out.println("Test 25 FAILED: IndexOutOfBoundsException expected");
        } catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("Test 25 PASSED");
            sum += TPP;
        }

        System.out.println("SUM: " + sum);

    }

}
