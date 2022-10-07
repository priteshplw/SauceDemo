package javaPractice;
//Write a function:
//class Solution { public int solution(int[] A); }
//that, given an array A of N integers, returns the smallest positive integer (greater than 0)
// that does not occur in A.
//        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//        Given A = [1, 2, 3], the function should return 4.
//        Given A = [−1, −3], the function should return 1.
//
//        Write an efficient algorithm for the following assumptions:
//        -N is an integer within the range [1..100,000];
//        -each element of array A is an integer within the range [−1,000,000..1,000,000].

public class FindSmallNoNotInArray {
    public static void main(String[] args) {
        int small = solution(new int[]{-1, -3, 2});
        System.out.println("small = " + small);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int small = 0;
        int i = 1;
        while (small == 0 && i <= 100000) {
            int check = 0;
            for (int tmp : A) {
                if (i == tmp) {
                    check = 0;
                    break;
                } else {
                    check = 1;
                }
            }
            if (check == 1) {
                small = i;
            }
            i++;
        }
        //  System.out.println(small);
        return small;
    }
}
//    Compilation successful.
//        Example test:[1,3,6,4,1,2]
//        WRONG ANSWER(got 0 expected 5)
//
//        Example test:[1,2,3]
//        WRONG ANSWER(got 0 expected 4)
//
//        Example test:[-1,-3]
//        WRONG ANSWER(got 0 expected 1)
