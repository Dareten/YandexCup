import java.util.ArrayList;
import java.util.Scanner;

public class AlgorithmCDivideAndConquer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n < 3){
            System.out.println("Yes");
            return;
        }
        int[] rect = new int[8];
        ArrayList<Point> points = new ArrayList<>();
        for(int i=0;i<n;++i){
            if(scan.nextInt() == 0){
                scan.nextInt();
                points.add(new Point(scan.nextInt(), scan.nextInt()));
            }else{
                for(int j=0;j<8;++j) rect[i] = scan.nextInt();
                points.add(new Point((Math.min(rect[0], Math.min(rect[2], rect[4])) +
                        Math.max(rect[0], Math.max(rect[2], rect[4]))) / 2.,
                        (Math.min(rect[1], Math.min(rect[3], rect[5])) +
                                Math.max(rect[1], Math.max(rect[3], rect[5]))) / 2.));
            }
        }
        int i = 0;
        String answer = "Yes";
        while(i < n - 2){
            if(!isOnOneLine(points.get(i), points.get(i + 1), points.get(i++ + 2))){
                answer = "No";
                break;
            }
        }
        System.out.println(answer);
    }
    public static boolean isOnOneLine(Point a, Point b, Point c){
        return (c.x - a.x) * (b.y - a.y) == (b.x - a.x) * (c.y - a.y);
    }
}
class Point {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}