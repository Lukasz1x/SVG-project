import java.util.Locale;

public class SolidFillShapeDecorator extends ShapeDecorator
{
    private String color;

    public SolidFillShapeDecorator(Shape shape, String color)
    {
        super(shape);
        this.color=color;
    }

    @Override
    public String toSvg(String param)
    {
        String p = String.format(Locale.ENGLISH,"fill=\"%s\" %s ",color, param);
        return super.toSvg(p);
    }
}
