import java.util.Locale;

public class Segment
{
    private Point start, end;

    public Segment(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double getLength()
    {
        return Math.hypot(end.x - start.x, end.y - start.y);
    }

    public String toSvg()
    {
        return String.format(Locale.ENGLISH,"<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:red;stroke-width:2\" />", start.x, start.y, end.x, end.y);
    }

    public static Segment[] perpendicularTo(Segment segment, Point point)
    {
        double vecX, vecY;
        vecX=segment.end.x-segment.start.x;
        vecY=segment.end.y-segment.start.y;
        Segment[] result = new Segment[2];
        result[0] = new Segment(point, new Point(point.x+vecY,point.y-vecX));
        result[1] = new Segment(point, new Point(point.x-vecY,point.y+vecX));
        return result;
    }
}
