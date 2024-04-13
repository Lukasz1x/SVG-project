public class Polygon
{
    public Point[] points;

    public Polygon(Point[] points)
    {
        this.points = points;
    }

    public Polygon(Polygon polygon)
    {
        points = new Point[polygon.points.length];
        for(int i = 0; i < polygon.points.length; i++)
        {
            this.points[i] = new Point(polygon.points[i].x, polygon.points[i].y);
        }
    }

    //<polygon points="100,10 150,190 50,190" style="fill:lime;stroke:purple;stroke-width:3" />
    public String toSvg()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon points=\"");
        for(Point p : points)
        {
            sb
                    .append(p.x)
                    .append(",")
                    .append(p.y)
                    .append(" ");
        }
        sb.append("\"");
        sb.append(" />");
        return sb.toString();
    }

}
