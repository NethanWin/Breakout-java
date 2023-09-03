public class Assignment2 {
    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        
        System.out.println(p1.distance(p2));
        System.out.println(p2.distance(p1));
    }
}
