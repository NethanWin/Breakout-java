package src;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = new Point(p1.x, p1.y);
        this.p2 = new Point(p2.x, p2.y);
    }
    
    public Line(double x1, double y1, double x2, double y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }


    public double length() {
        return p1.distance(p2);
    }

    public Point start() {
        return new Point(p1.x,p1.y);
    }

    public Point middle() {
        return new Point((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0);
    }

    public Point end() {
        return new Point(p2.x,p2.y);
    }

    public static double[] getLineABC(Line l) {
        double A = l.p2.y - l.p1.y;
        double B = l.p1.x - l.p2.x;
        double C = l.p1.y * (l.p2.x - l.p1.x) - (l.p2.y - l.p1.y) * l.p1.x;
        double[] ABC = {A, B, C};
        return ABC;
    }
    
    public Point intersectionWith(Line l) {
        double[] ABC1 = getLineABC(this);
        double a1 = ABC1[0];
        double b1 = ABC1[1];
        double c1 = ABC1[2];

        double[] ABC2 = getLineABC(l);
        double a2 = ABC2[0];
        double b2 = ABC2[1];
        double c2 = ABC2[2];

        if ((a1 * b2 - a2 * b1) == 0)
            return null;
        
        double x0 = (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y0 = (c1 * a2 - c2 * a1) / (a1 * b2 - a2 * b1);
        if (isBetween(p1.x, p2.x, x0) && isBetween(p1.y, p2.y, y0) && isBetween(l.p1.x, l.p2.x, x0) && isBetween(l.p1.y, l.p2.y, y0))
            return new Point(x0, y0);
        return null;
    }

    public boolean isIntersecting(Line l) {
        return this.intersectionWith(l) != null;
    }

    public static boolean isBetween(double a, double b, double c) {
        return c >= Math.min(a, b) && c <= Math.max(a, b);
    }


    public boolean equals(Line l) {
        return p1.equals(l.start()) && p2.equals(l.start());
    }

    @Override
    public String toString() {
        return p1 + " , " + p2;
    }
}