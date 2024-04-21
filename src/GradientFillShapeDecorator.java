import java.util.Locale;

public class GradientFillShapeDecorator extends ShapeDecorator
{
    private static int index;
    private int i;
    public GradientFillShapeDecorator(Shape shape)
    {
        super(shape);
        i=index;
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

        public void build()
        {
            this.gradient+= "\t</linearGradient>";
            index = SvgScene.getInstance().addFilter(this.gradient);
        }
    }

    @Override
    public String toSvg(String param)
    {
        String p=param + String.format("fill=\"url(#g%d)\" ", i);
        return super.toSvg(p);
    }
}
