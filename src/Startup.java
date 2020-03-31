public class Startup {


        public static char[] arrEvenOdd ( int[] arr){
            char[] results = new char[arr.length];
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
            
    }


    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        arrEvenOdd(test);
    }
    }
