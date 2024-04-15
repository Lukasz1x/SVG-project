public class Main {
    public static void main(String[] args)
    {
        Point A = new Point(210, 100);
        Point B = new Point(240, 175);
        Point C = new Point(350, 300);
        Point D = new Point(460, 175);
        Point E = new Point(490, 100);
        Point F = new Point(445, 70);
        Point G = new Point(380, 100);
        Point H = new Point(360, 125);
        Point I = new Point(350, 140);
        Point J = new Point(340, 125);
        Point K = new Point(320, 100);
        Point L = new Point(255, 70);


        Style style = new Style("red", "black", 5);


        Segment AB = new Segment(A, B);
        System.out.println(AB.toSvg());
        Segment[] perpendicularAB = Segment.perpendicularTo(AB, B);
        for(Segment seg : perpendicularAB)
        {
            System.out.println(seg.toSvg());
        }

        Ellipse e =new Ellipse(new Point(250, 550),200,50, style);

        Polygon p1=new Polygon(new Point[]{A,B,C,D,E,F,G,H,I,J,K,L}, style);
        SvgScene scene=new SvgScene();
        scene.add(p1);
        scene.add(e);
        //scene.add(Polygon.square(AB, style));
        scene.save("scene.html");


    }
}