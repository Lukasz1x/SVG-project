import java.util.Locale;

public class Style
{
    public final String fillColor, strokeColor;
    public final double strokeWidth;

    public Style(String fillColor, String strokeColor, double strokeWidth)
    {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    //style="fill:lime;stroke:purple;stroke-width:3"
    public String toSvg()
    {
        return String.format(Locale.ENGLISH,"style=\"fill:%s;stroke:%s;stroke-width:%f\"", fillColor, strokeColor, strokeWidth);
    }
}
