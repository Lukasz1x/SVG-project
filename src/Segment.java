import java.util.Locale;

public class Segment
{
    private Vec2 start, end;

    public Segment(Vec2 start, Vec2 end)
    {
        this.start = start;
        this.end = end;
    }

    public Vec2 getStart() {
        return start;
    }

    public Vec2 getEnd() {
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

    public static Segment[] perpendicularTo(Segment segment, Vec2 point)
    {
        double vecX, vecY;
        vecX=segment.end.x-segment.start.x;
        vecY=segment.end.y-segment.start.y;
        Segment[] result = new Segment[2];
        result[0] = new Segment(point, new Vec2(point.x+vecY,point.y-vecX));
        result[1] = new Segment(point, new Vec2(point.x-vecY,point.y+vecX));
        return result;
    }
}
