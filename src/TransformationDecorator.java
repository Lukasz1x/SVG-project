import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator
{
    public static class Builder
    {
        private String transform;

        public Builder()
        {
            this.transform="";
        }

        public Builder translate(Vec2 translateVector)
        {
            this.transform+=String.format(Locale.ENGLISH,"translate(%f %f)", translateVector.x,translateVector.y);
            return this;
        }

        public Builder rotate(double rotateAngle, Vec2 rotateCenter)
        {
            this.transform+=String.format(Locale.ENGLISH, "rotate(%f %f %f)",rotateAngle, rotateCenter.x, rotateCenter.y);
            return this;
        }

        public Builder scale(Vec2 scaleVector)
        {
            this.transform+=String.format(Locale.ENGLISH, "scale(%f %f)", scaleVector.x, scaleVector.y);
            return this;
        }

        public TransformationDecorator build(Shape shape)
        {
            return new TransformationDecorator(shape, transform);
        }

    }

    private String transform;
    public TransformationDecorator(Shape shape, String transform)
    {
        super(shape);
        this.transform=transform;
    }

    @Override
    public String toSvg(String param)
    {
        String p = String.format(Locale.ENGLISH, "transform=\"%s\" %s", this.transform, param);
        return super.toSvg(p);
    }

}
