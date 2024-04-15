import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SvgScene
{
    private List<Shape> shapes=new ArrayList<Shape>();

    public void add(Shape p)
    {
        shapes.add(p);
    }

//    private Point getBounds()
//    {
//        double x=0.0;
//        double y=0.0;
//        for(Polygon poly : polygons)
//        {
//            for(Point p : poly.points)
//            {
//                x=Math.max(x, p.x);
//                y=Math.max(y, p.y);
//            }
//        }
//        return new Point(x*1.25, y*1.25);
//    }

    public void save(String filename)
    {
        try{
            FileWriter fw=new FileWriter(filename);
            Point bounds = new Point(1000,1000);//getBounds();
            fw.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>");
            fw.write(String.format(Locale.ENGLISH, "<svg height=\"%f\" width=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">\n",bounds.y, bounds.x));
            for(Shape shape : shapes)
            {
                fw.write(shape.toSvg() + "\n");
            }
            fw.write("</svg>\n" +
                    "</body>\n" +
                    "</html>");
            fw.close();
        }catch (IOException e)
        {
            System.err.println("can't write to file: "+filename);
        }
    }

}
