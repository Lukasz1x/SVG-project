import java.util.Locale;

public class GradientFillShapeDecorator extends ShapeDecorator
{
    private int index;

    public GradientFillShapeDecorator(Shape shape, int index)
    {
        super(shape);
        this.index=index;
    }

    public static class Builder
    {

        private String gradient;

        public Builder()
        {
            this.gradient="\t<linearGradient id=\"g%d\" >\n";
        }

        public Builder addStop(double stop_offset, String stop_color)
        {
            this.gradient+=String.format(Locale.ENGLISH,"\t\t<stop offset=\"%f\" style=\"stop-color:%s\" />\n", stop_offset, stop_color);
            return this;
        }

        public GradientFillShapeDecorator build(Shape shape)
        {
            this.gradient+= "\t</linearGradient>";
            int i = SvgScene.getInstance().addFilter(this.gradient);
            return new GradientFillShapeDecorator(shape, i);
        }
    }

    @Override
    public String toSvg(String param)
    {
        String p=param + String.format("fill=\"url(#g%d)\" ", index);
        return super.toSvg(p);
    }
}
