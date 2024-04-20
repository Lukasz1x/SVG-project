public class Main {
    public static void main(String[] args)
    {
        Vec2 A = new Vec2(210, 100);
        Vec2 B = new Vec2(240, 175);
        Vec2 C = new Vec2(350, 300);
        Vec2 D = new Vec2(460, 175);
        Vec2 E = new Vec2(490, 100);
        Vec2 F = new Vec2(445, 70);
        Vec2 G = new Vec2(380, 100);
        Vec2 H = new Vec2(360, 125);
        Vec2 I = new Vec2(350, 140);
        Vec2 J = new Vec2(340, 125);
        Vec2 K = new Vec2(320, 100);
        Vec2 L = new Vec2(255, 70);


        Style style = new Style("red", "black", 5);


        Segment AB = new Segment(A, B);
        System.out.println(AB.toSvg());
        Segment[] perpendicularAB = Segment.perpendicularTo(AB, B);
        for(Segment seg : perpendicularAB)
        {
            System.out.println(seg.toSvg());
        }

        Ellipse e =new Ellipse(new Vec2(250, 550),200,50);

        Polygon p1=new Polygon(new Vec2[]{A,B,C,D,E,F,G,H,I,J,K,L});
        Shape heart=new SolidFillShapeDecorator(p1, "pink");
        heart = new StrokeShapeDecorator(heart, "red", 3);
        TransformationDecorator.Builder builder = new TransformationDecorator.Builder();
        builder.translate(new Vec2(10, 10))
                .rotate(15,new Vec2(100,100))
                .scale(new Vec2(1.25,1.25));
        heart= builder.build(heart);
        heart= new DropShadowDecorator(heart);
        SvgScene scene=SvgScene.getInstance();
        scene.add(heart);
        scene.add(e);
        //scene.add(Polygon.square(AB, style));
        scene.save("scene.html");


    }
}