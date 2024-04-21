import java.util.Locale;

public class Ellipse implements Shape
{
    private Vec2 mid;
    private double dx, dy;

    public Ellipse(Vec2 mid, double dx, double dy)
    {
        //super(style);
        this.mid=mid;
        this.dx=dx;
        this.dy=dy;
    }

    @Override
    public String toSvg(String param)
    {
        return String.format(Locale.ENGLISH,"<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\" %s />",dx,dy,mid.x,mid.y, param);
    }
}
