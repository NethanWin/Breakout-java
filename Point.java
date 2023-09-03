public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    public boolean equals(Point p) {
        return p.x == x && p.y == y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}
