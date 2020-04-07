public class Startup {
   private static int EVEN_CHECK = 2;
   private static int PRUNE_HELPER = 10;
   private static int HALF = 2;

    public static char[] arrEvenOdd(int[] arr) {
        char[] results = new char[arr.length];
        if (arr.length == 0) {
            return results;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % EVEN_CHECK == 0) {
                results[i] = 'E';
            } else {
                results[i] = 'O';
            }
        }
        return results;
    }

    public static boolean isSubstring(String mainStr, String subStr) {
        if (mainStr.length() < subStr.length()) {
            return false;
        }

        if (mainStr.length() == subStr.length() && subStr != mainStr.substring(0, (subStr.length() - 1))) {
            return false;
        }
        if (subStr.equals(mainStr.substring(0, subStr.length()))) {
            return true;
        } else {
            System.out.println(mainStr);

            return (isSubstring(mainStr.substring(1), subStr));

        }
    }

    public static int[][] prune(int[][] sets, int num) {
//        Returns the sets that contain num
        int[][] newSets = new int[sets.length][];
        int index = 0;
        for (int[] set : sets) {
            if (set == null) {
                continue;
            }
            for (int n : set) {
                if (n == num) {
                    newSets[index] = set;
                    index++;
                    break;
                }
            }
        }
        // Return the new elements
        int[][] slice = new int[index][];
        for (int i = 0; i < slice.length; i++) {
            slice[i] = newSets[i];
        }
        return slice;

    }

    public static boolean numpadSRC(int num) {
        int[] row1 = {0};
        int[] row2 = {1, 2, 3};
        int[] row3 = {4, 5, 6};
        int[] row4 = {7, 8, 9};
        int[] col1 = {0, 1, 4, 7};
        int[] col2 = {0, 2, 5, 8};
        int[] col3 = {0, 3, 6, 9};
        int[][] sets = {row1, row2, row3, row4, col1, col2, col3};
        while (num != 0) {
            sets = prune(sets, num % PRUNE_HELPER);
            num = (num / PRUNE_HELPER);
        }
        return sets.length > 0;

//            String sNum = Integer.toString(num);
//            int rowNum;
//            int lastNum = num%10;
//
//            if (lastNum == 1 || lastNum == 2 || lastNum == 3) {
//                rowNum = 2;
//                if(lastNum%10 ==1 || lastNum == 2 || lastNum ==3) {
//
//                }
//            }

    }

    public static int max(int[] arr) {
        int max = 0;
        for (int i : arr) {

            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int[] createSet(int[] arr) {
        boolean[] sortHelper = new boolean[max(arr) + 1];
        int unique = 0;
        for (int i : arr) {
            if (!sortHelper[i]) {
                unique++;
                sortHelper[i] = true;
            }

        }

        int[] set = new int[unique];
        int index = 0;
        for (int i = 0; i <= max(arr); i++) {
            if (sortHelper[i]) {
                set[index] = i;
                index++;
            }
        }
        return set;
    }

    public static boolean subsetHelper(int[] set1, int[] set2, int i, int f) {
        if (i > set1.length) {
            return true;
        } else if (f == set2.length && set1[i] != set2[f]) {
            return false;
        } else if (set1[i] == set2[f]) {
            return subsetHelper(set1, set2, i + 1, f + 1);
        } else {
            return subsetHelper(set1, set2, i, f + 1);
        }
    }

    public static boolean subsetChecker(int[] set1, int[] set2) {
        return subsetHelper(set1, set2, 0, 0);
    }

    public static int recursiveBinarySearch(int[] arr, int left, int right, int target) {
        int check = left + (right - left) / HALF;
        if (right - left == 1 && arr[check] != target) {
            return -1;
        } else if (arr[check] == target) {
            return check;
        } else if (target > arr[check]) {
            return recursiveBinarySearch(arr, check, right, target);
        } else {
            return recursiveBinarySearch(arr, left, check, target);
        }
    }
    public static char encryptHelper(char c) {
        String afterCap = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String originalCap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String originalLow = "abcdefghijklmnopqrstuvwxyz";
        String afterLow = "zyxwvutsrqponmlkjihgfedcba";
        if (afterCap.indexOf(c) == -1 && afterLow.indexOf(c) != -1) {
            return afterLow.charAt(originalLow.indexOf(c));
        }
        if (afterLow.indexOf(c) == -1 && afterCap.indexOf(c) != -1) {
            return afterCap.charAt(originalCap.indexOf(c));
        }
        else {
            return c;
        }

    }


    public static String encryptString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += encryptHelper(s.charAt(i));
        }
        return result;
    }
    public static String repeat(String s, int width) {
        String str = "";
        if (width == 0) {
            return "";
        }
        for (int i = 0; i < width; i++) {
            str += s;


        }
        return str;
    }
    public static String drawPattern(int width) {
        String result = "";
        String star = "*";
        if (width % EVEN_CHECK == 0) {
            for (int i = 1; i <= width / HALF; i++) {

                result += repeat(star, i) + repeat(" ", width / HALF - i) + repeat(" ", width / HALF - i) + repeat(star, i) + "\n";
            }
            for (int i = width; i >= width / HALF; i--) {

                result += repeat(star, i) + repeat(" ", width / HALF - i) + repeat(" ", width / HALF - i) + repeat(star, i) + "\n";
            }

        }
        if (width % EVEN_CHECK != 0) {
            width++;
            for (int i = 1; i <= width / HALF; i++) {

                result += repeat(star, i) + repeat(" ", width / HALF - i) + repeat(" ", width / HALF - i) + repeat(star, i) + "\n";
            }
            for (int i = width / HALF - 1; i >= 0; i--) {

                result += repeat(star, i) + repeat(" ", width / HALF - i) + repeat(" ", width / HALF - i) + repeat(star, i) + "\n";
            }

        }
        return result;

    }






    public static void printArr(int[] arr) {
        System.out.print("{");
        for (int i = 0; i <  arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(" , ");
            }
        }
        System.out.println("}");
    }
    public static void main(String[] args) {
//        Even Odd
        int[] test = {1, 2, 3, 4, 5};
        arrEvenOdd(test);
//        Substring
        String str = "MARINA";
        String mstr = "M";
        System.out.println(isSubstring(mstr, str));
        System.out.println(55768 % 10);
//        numPad
        int[] s1 = new int[]{0};
        int[] s2 = new int[]{1, 2, 3};
        int[] s3 = new int[]{4, 5, 6};
        int[] s4 = new int[]{7, 8, 9};
        int[] s5 = new int[]{0, 1, 4, 7};
        int[] s6 = new int[]{0, 2, 5, 8};
        int[] s7 = new int[]{0, 3, 6, 9};
        int[][] sets = new int[][]{s1, s2, s3, s4, s5, s6, s7};
        int[] testCases = new int[]{1047, 2058, 999633, 258, 987, 123, 443, 332, 0, 9, 9087};
        for (int t: testCases) {
            System.out.println(t);
            System.out.println(numpadSRC(t));
        }
        int[] t0 = new int[]{7, 7, 47, 6, 12, 1, 36, 3, 22, 48};
        int[] t1 = new int[]{40, 5, 31, 15, 4, 44, 46, 5, 27, 40};
        int[] t2 = new int[]{48, 21, 40, 27, 13, 38, 4, 36, 20, 17};
        int[] t3 = new int[]{40, 5, 44, 35, 34, 9, 11, 42, 32, 23};
        int[] t4 = new int[]{26, 26, 7, 24, 39, 7, 32, 28, 13, 25};
        int[] t5 = new int[]{2, 5, 4, 3, 7, 3, 9, 12, 4, 5, 9, 6, 2, 7, 4, 3, 6, 6};

        int[][] testCases2 = new int[][]{t0, t1, t2, t3, t4, t5};
        for (int[] t : testCases2) {
            System.out.println("Test");
            printArr(t);
            printArr(createSet(t));
        }
        int[] sub0 = new int[]{};
        int[] sub1 = new int[]{1, 2, 3};
        int[] sub2 = new int[]{1, 2, 3, 4};
        int[] sub3 = new int[]{-2, 6, 7, 8};
        int[] sub4 = new int[]{-10, -2, 1, 2, 3, 6, 7, 8, 9};
        assert subsetChecker(sub0, sub1) && subsetChecker(sub0, sub4);
        assert subsetChecker(sub1, sub2);
        assert !subsetChecker(sub1, sub3);
        assert !subsetChecker(sub4, sub2);
        assert !subsetChecker(sub3, sub1);
        assert subsetChecker(t5, t5);
        assert subsetChecker(sub3, sub4);

        int recursionT = 0;
        int recursionT2 = 5;
        int[] testerRec = new int[] {-5, 1, 2, 3, 8, 9, 10, 12};
        System.out.println(recursiveBinarySearch(testerRec, recursionT, recursionT2, 4));
        System.out.println(encryptString("abcdefg, hijklmn, OPQRST, UVWXYZ!"));
        System.out.print(drawPattern(11));

    }
    }
