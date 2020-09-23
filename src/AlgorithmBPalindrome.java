import java.util.Scanner;

public class AlgorithmBPalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim(), shortest = "zzz", two;
        int inputLength = input.length() - 1;
        for(int i=0;i<inputLength;++i){
            two = input.substring(i, i + 2);
            if(isPalindrome(two) && (shortest.compareTo(two) > 0 || shortest.length() != 2)){
                shortest = two;
            }else if(i < inputLength - 1 && shortest.length() != 2 && isPalindrome(input.substring(i, i + 3)) && shortest.compareTo(input.substring(i, i + 3)) > 0){
                shortest = input.substring(i, i + 3);
            }
        }
        if(shortest.equals("zzz")) System.out.println("-1");
        else System.out.println(shortest);
    }
    public static boolean isPalindrome(String str){
        return str.charAt(0) == str.charAt(str.length() - 1);
    }
}
