public class PalindromeChecker{
    public boolean check(String input){
        int i = 0;
        int j = input.length() - 1;
        while(i <= j){
            System.out.println(pc.check("racecar"));
            System.out.println(pc.check("blue"));
            if(input.charAt(i) != input.charAt(j)){
                break;
            }else{
                i++;
                j--;
            }
        }
        return false;
    }

    public static void main(String args[]){
        PalindromeChecker pali = new PalindromeChecker();
        System.out.println(pali.check("racecar"));
        System.out.println(pali.check("blue"));
    }
}