public class Main {
    public static void main(String[] args)
    {
        Point A = new Point(100, 100);
        Point B = new Point(250, 250);
        Point C = new Point(287, 365);
        Segment AB = new Segment(A, B);
        System.out.println(AB.toSvg());
        Segment[] perpendicularAB = Segment.perpendicularTo(AB, B);
        for(Segment seg : perpendicularAB)
        {
            System.out.println(seg.toSvg());
        }

        Polygon p1=new Polygon(new Point[]{A,B,C});
        System.out.println(p1.toSvg());
    }
}