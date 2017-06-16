import java.util.StringTokenizer;

/**
 * Created by gaowenfeng on 2017/4/22.
 */
public class Applet {
    public static void main(String[] args) {
        String s = "ac+b/cde";
        StringTokenizer parser = new StringTokenizer(s,"+-*/ ",true);
        while (parser.hasMoreTokens()){
            System.out.println(parser.nextToken());
        }
    }
}
