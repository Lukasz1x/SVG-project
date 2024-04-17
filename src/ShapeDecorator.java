public class ShapeDecorator implements Shape
{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape shape)
    {
        decoratedShape=shape;
    }

    @Override
    public String toSvg(String param)
    {
        return decoratedShape.toSvg(param);
    }
}
