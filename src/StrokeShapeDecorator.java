import java.util.Locale;

public class StrokeShapeDecorator extends ShapeDecorator
{
    private String color;
    private double width;

    public StrokeShapeDecorator(Shape shape, String color, double width)
    {
        super(shape);
        this.color=color;
        this.width=width;
    }

    @Override
    public String toSvg(String param)
    {
        String p = String.format(Locale.ENGLISH, "stroke=\"%s\" stroke-width=\"%f\" ", color, width);
        return super.toSvg(p);
    }
}
