package javaPractice;
//Description
//        We have given Aniket a bet. He has to climb any set of staircase with a combination of one, or two steps each climb. If he failed to do this, he will have to buy pizza for everyone. Can you help Aniket figure out how many different ways he can climb to the top if the total number of stairs is n.
//        Input format:
//        • A single integer n denoting the total number of stairs.
//        Output format:
//        • Print a single integer denoting the number of ways he can climb n steps
//        Constraints
//        • 0 <= n <= 1000
//        • The solution should have O(n) time.
//        Examples
//        • Input: 3
//        Output:  3
//        Explanation:
//        There are three ways to climb to the top.
//        1. He can climb one step at a time.
//        2. He can first climb one step and cover the remaining stairs with two steps.
//        3. He could also do the reverse, and climb two steps at once, and cover the remaining steps in one step.
//        Thus, there are three ways to reach the top.
class Solution{
    int total=1;
    int soul(int n){
        if(n>0)
        total=n*soul(n-1);
        return total;
    }
}
public class stairCase {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.soul(3));
    }

}
