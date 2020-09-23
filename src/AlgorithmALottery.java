import java.util.Scanner;
import java.util.stream.IntStream;

public class AlgorithmALottery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] luckyOnes = new int[10];
        for(int i=0;i<10;++i) luckyOnes[i] = scan.nextInt();
        int n = scan.nextInt(), c;
        for(int i=0;i<n;++i){
            c = 0;
            for(int j=0;j<6;++j){
                int checked = scan.nextInt();
                if(IntStream.of(luckyOnes).anyMatch(x -> x == checked)){
                    if(++c == 3){
                        System.out.println("Lucky");
                        scan.nextLine();
                        break;
                    }
                }
                if(j == 5) System.out.println("Unlucky");
            }
        }
    }
}
