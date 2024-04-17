public class Polygon implements Shape
{
    public Vec2[] points;

    public Polygon(Vec2[] points)
    {
        //super(new Style("none","black",1 ));
        this.points = points;
    }

//    public Polygon(Point[] points, Style style)
//    {
//        super(style);
//        this.points = points;
//    }

    public Polygon(Polygon polygon)
    {
        //super(new Style(polygon.style.fillColor, polygon.style.strokeColor, polygon.style.strokeWidth));
        points = new Vec2[polygon.points.length];
        for(int i = 0; i < polygon.points.length; i++)
        {
            this.points[i] = new Vec2(polygon.points[i].x, polygon.points[i].y);
        }
    }

    //<polygon points="100,10 150,190 50,190" style="fill:lime;stroke:purple;stroke-width:3" />
    @Override
    public String toSvg(String param)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon points=\"");
        for(Vec2 p : points)
        {
            sb
                    .append(p.x)
                    .append(",")
                    .append(p.y)
                    .append(" ");
        }
        sb.append("\" ");
        //sb.append(style.toSvg());
        sb.append(param);
        sb.append(" />");
        return sb.toString();
    }

    public static Polygon square(Segment AB)
    {
        Vec2 mid = new Vec2((AB.getStart().x+AB.getEnd().x)/2,(AB.getStart().y+AB.getEnd().y)/2);
        Segment[] perpendicular =Segment.perpendicularTo(new Segment(AB.getStart(),mid), mid);
        Vec2[] points = new Vec2[4];
        points[0]=AB.getStart();
        points[1]=perpendicular[0].getEnd();
        points[2]=AB.getEnd();
        points[3]=perpendicular[1].getEnd();
        return new Polygon(points);
    }

}
