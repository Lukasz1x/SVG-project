public abstract class Shape
{
    protected Style style;

    public Shape(Style style)
    {
        this.style=style;
    }

    abstract String toSvg();
}
