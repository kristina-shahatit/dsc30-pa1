public class Startup {


    public static char[] arrEvenOdd (int[] arr) {

        char[] results = new char[arr.length];
        if (arr.length == 0) {
            return results;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                results[i] = 'E';
            }
            else {
                    results[i] = 'O';
                }
            }
            return results;
        }

    public static boolean isSubstring(String mainStr, String subStr) {
            if (mainStr.length() < subStr.length()){
                return false;
            }

            if(mainStr.length() == subStr.length() && subStr != mainStr.substring(0, (subStr.length() - 1))){
                return false;
            }
            if(subStr.equals(mainStr.substring(0, subStr.length()))){
                return true;
                }
            else{
                System.out.println(mainStr);

                return(isSubstring(mainStr.substring(1), subStr));

                }
    }

    public static boolean numpadSRC(int num) {
            int[] row1 = { 0};
            int[] row2 = { 1,2,3};
            int[] row3 = { 4,5,6};
            int[] row4 = { 7,8,9};
            int[] col1 = { 0,1,4,7};
            int[] col2 = { 0,2,5,8};
            int[] col3 = { 0,3,6,9};

            return false;

    }


    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        arrEvenOdd(test);
        String str = "MARINA";
        String mstr = "M";
        System.out.println(isSubstring(mstr, str));
    }
    }
