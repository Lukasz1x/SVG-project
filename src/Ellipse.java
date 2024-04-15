import java.util.Locale;

public class Ellipse extends Shape
{
    private Point mid;
    private double dx, dy;

    public Ellipse(Point mid, double dx, double dy, Style style)
    {
        super(style);
        this.mid=mid;
        this.dx=dx;
        this.dy=dy;
    }

    @Override
    public String toSvg()
    {
        return String.format(Locale.ENGLISH,"<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\"  %s />",dx,dy,mid.x,mid.y,style.toSvg());
    }
}
