
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class TowerOfHanoi_Tests {
    public ArrayList<String> allowedImports = new ArrayList<>();

    @Before
    public void setup()
    {
        allowedImports.add("java.util.ArrayList");
        allowedImports.add("java.util.Scanner");
        System.setOut(testingOutputStream);
    }

    @Test(timeout = 250)
    public void checkImports() throws Exception{
        String className = "TowerOfHanoi";
        String fileName = "src/"+generateClassName(className).replaceAll("\\.","/")+".java";
        boolean allowedOnly = true;
        ArrayList<String> invalidImport = new ArrayList<>();
        try
        {

            File file = new File(fileName);
            Scanner fromFile = new Scanner(file);
            while(fromFile.hasNextLine())
            {
                String line = fromFile.nextLine().trim();
                if(line.contains("import"))
                {
                    boolean good = false;
                    for(String allowed: allowedImports)
                    {
                        if(line.matches("\\s*import\\s+"+allowed+"\\s*;\s*(//\\.*)?"))
                            good=true;
                    }
                    if(!good)
                    {
                        allowedOnly=false;
                        invalidImport.add(line);
                    }
                }

            }
        }
        catch(Exception e)
        {
            Assert.assertTrue("Missing File: "+className+".java",false);
            allowedOnly = false;
        }

        Assert.assertTrue("Invalid imports: "+invalidImport,allowedOnly);
    }

    public String generateClassName(String name)
    {
        if(getClass().toString().contains("."))
        {
            return getClass().toString().substring(6,getClass().toString().lastIndexOf(".")+1)+name;
        }
        return name;
    }

    public TestingOutputStream testingOutputStream = new TestingOutputStream();


    public String unifyLineSeperators(String line)
    {
        return line.replaceAll("\\n|\\r\\n", System.getProperty("line.separator")).trim();
    }

    @Test(timeout = 250)
    public void test1() throws Exception{
        String input =  "7\n" +
                "1\n" +
                "2\n" +
                "0\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "5\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n";

        String expected =   "Enter the number of disks you would like to play with (3-6):\n" +
                "That value is out of range, please try again.\n" +
                "Enter the number of disks you would like to play with (3-6):\n" +
                "That value is out of range, please try again.\n" +
                "Enter the number of disks you would like to play with (3-6):\n" +
                "That value is out of range, please try again.\n" +
                "Enter the number of disks you would like to play with (3-6):\n" +
                "That value is out of range, please try again.\n" +
                "Enter the number of disks you would like to play with (3-6):\n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "   XXX      -       -    \n" +
                "  XXXXX     -       -    \n" +
                " XXXXXXX    -       -    \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "  XXXXX     -       -    \n" +
                " XXXXXXX    -      XXX   \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                " XXXXXXX  XXXXX    XXX   \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -      XXX      -    \n" +
                " XXXXXXX  XXXXX     -    \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -      XXX      -    \n" +
                "    -     XXXXX  XXXXXXX \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "   XXX    XXXXX  XXXXXXX \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -     XXXXX  \n" +
                "   XXX      -    XXXXXXX \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -      XXX   \n" +
                "    -       -     XXXXX  \n" +
                "    -       -    XXXXXXX \n" +
                "-------------------------\n" +
                "\n" +
                "Congratulations you solved 3 disks in 7 moves. A perfect solutions is 7 moves.";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Class<?> classRef = Class.forName(generateClassName("TowerOfHanoi"));
        Object classObject = classRef.getConstructor().newInstance();

        Method main = classRef.getMethod("main",String[].class);
        try
        {
            main.invoke(classObject,(Object)null);
        }
        catch ( InvocationTargetException e )
        {
            throw (Exception) e.getCause();
        }

        expected = unifyLineSeperators(expected);

        TestingOutputStream o = (TestingOutputStream)System.out;
        Assert.assertEquals(unifyLineSeperators(expected), unifyLineSeperators(o.toString()));
    }

    @Test(timeout = 250)
    public void test2() throws Exception{
        String input =  "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n";

        String expected =   "Enter the number of disks you would like to play with (3-6):\n" +
                "That value is out of range, please try again.\n" +
                "Enter the number of disks you would like to play with (3-6):\n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "   XXX      -       -    \n" +
                "  XXXXX     -       -    \n" +
                " XXXXXXX    -       -    \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "  XXXXX     -       -    \n" +
                " XXXXXXX   XXX      -    \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "  XXXXX     -       -    \n" +
                " XXXXXXX    -      XXX   \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                " XXXXXXX  XXXXX    XXX   \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -      XXX      -    \n" +
                " XXXXXXX  XXXXX     -    \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -      XXX      -    \n" +
                "    -     XXXXX  XXXXXXX \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "   XXX    XXXXX  XXXXXXX \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -     XXXXX  \n" +
                "   XXX      -    XXXXXXX \n" +
                "-------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "    -       -       -    \n" +
                "    -       -       -    \n" +
                "    -       -      XXX   \n" +
                "    -       -     XXXXX  \n" +
                "    -       -    XXXXXXX \n" +
                "-------------------------\n" +
                "\n" +
                "Congratulations you solved 3 disks in 8 moves. A perfect solutions is 7 moves.";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Class<?> classRef = Class.forName(generateClassName("TowerOfHanoi"));
        Object classObject = classRef.getConstructor().newInstance();

        Method main = classRef.getMethod("main",String[].class);
        try
        {
            main.invoke(classObject,(Object)null);
        }
        catch ( InvocationTargetException e )
        {
            throw (Exception) e.getCause();
        }

        expected = unifyLineSeperators(expected);

        TestingOutputStream o = (TestingOutputStream)System.out;
        Assert.assertEquals(unifyLineSeperators(expected), unifyLineSeperators(o.toString()));
    }

    @Test(timeout = 250)
    public void test3() throws Exception{
        String input =  "7\n" +
                "4\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "3\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n";

        String expected =   "Enter the number of disks you would like to play with (3-6):\n" +
                "That value is out of range, please try again.\n" +
                "Enter the number of disks you would like to play with (3-6):\n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -         -     \n" +
                "   XXXXX       -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX     -         -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "   XXXXX       -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX     -        XXX    \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX   XXXXX      XXX    \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "   XXXXX       -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX     -        XXX    \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -         -     \n" +
                "   XXXXX       -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX     -         -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "   XXXXX       -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX    XXX        -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX    XXX      XXXXX   \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "  XXXXXXX      -        XXX    \n" +
                " XXXXXXXXX     -       XXXXX   \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -        XXX    \n" +
                " XXXXXXXXX  XXXXXXX    XXXXX   \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -         -     \n" +
                " XXXXXXXXX  XXXXXXX    XXXXX   \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX      XXXXX       -     \n" +
                " XXXXXXXXX  XXXXXXX      -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -        XXX        -     \n" +
                "     -       XXXXX       -     \n" +
                " XXXXXXXXX  XXXXXXX      -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -        XXX        -     \n" +
                "     -       XXXXX       -     \n" +
                "     -      XXXXXXX  XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -       XXXXX      XXX    \n" +
                "     -      XXXXXXX  XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -        XXX    \n" +
                "   XXXXX    XXXXXXX  XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -         -     \n" +
                "   XXXXX    XXXXXXX  XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -      XXXXXXX  \n" +
                "   XXXXX       -     XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -      XXXXXXX  \n" +
                "   XXXXX      XXX    XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -       XXXXX   \n" +
                "     -         -      XXXXXXX  \n" +
                "     -        XXX    XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -        XXX    \n" +
                "     -         -       XXXXX   \n" +
                "     -         -      XXXXXXX  \n" +
                "     -         -     XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Congratulations you solved 4 disks in 19 moves. A perfect solutions is 15 moves.";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Class<?> classRef = Class.forName(generateClassName("TowerOfHanoi"));
        Object classObject = classRef.getConstructor().newInstance();

        Method main = classRef.getMethod("main",String[].class);
        try
        {
            main.invoke(classObject,(Object)null);
        }
        catch ( InvocationTargetException e )
        {
            throw (Exception) e.getCause();
        }

        expected = unifyLineSeperators(expected);

        TestingOutputStream o = (TestingOutputStream)System.out;
        Assert.assertEquals(unifyLineSeperators(expected), unifyLineSeperators(o.toString()));
    }

    @Test(timeout = 250)
    public void test4() throws Exception{
        String input =  "4\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n";

        String expected =   "Enter the number of disks you would like to play with (3-6):\n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -         -     \n" +
                "   XXXXX       -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX     -         -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "   XXXXX       -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX    XXX        -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "  XXXXXXX      -         -     \n" +
                " XXXXXXXXX    XXX      XXXXX   \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "  XXXXXXX      -        XXX    \n" +
                " XXXXXXXXX     -       XXXXX   \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -        XXX    \n" +
                " XXXXXXXXX  XXXXXXX    XXXXX   \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -         -     \n" +
                " XXXXXXXXX  XXXXXXX    XXXXX   \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX      XXXXX       -     \n" +
                " XXXXXXXXX  XXXXXXX      -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -        XXX        -     \n" +
                "     -       XXXXX       -     \n" +
                " XXXXXXXXX  XXXXXXX      -     \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -        XXX        -     \n" +
                "     -       XXXXX       -     \n" +
                "     -      XXXXXXX  XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -       XXXXX      XXX    \n" +
                "     -      XXXXXXX  XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -        XXX    \n" +
                "   XXXXX    XXXXXXX  XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -         -     \n" +
                "   XXXXX    XXXXXXX  XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "    XXX        -      XXXXXXX  \n" +
                "   XXXXX       -     XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -      XXXXXXX  \n" +
                "   XXXXX      XXX    XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -       XXXXX   \n" +
                "     -         -      XXXXXXX  \n" +
                "     -        XXX    XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "     -         -         -     \n" +
                "     -         -         -     \n" +
                "     -         -        XXX    \n" +
                "     -         -       XXXXX   \n" +
                "     -         -      XXXXXXX  \n" +
                "     -         -     XXXXXXXXX \n" +
                "-------------------------------\n" +
                "\n" +
                "Congratulations you solved 4 disks in 15 moves. A perfect solutions is 15 moves.";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Class<?> classRef = Class.forName(generateClassName("TowerOfHanoi"));
        Object classObject = classRef.getConstructor().newInstance();

        Method main = classRef.getMethod("main",String[].class);
        try
        {
            main.invoke(classObject,(Object)null);
        }
        catch ( InvocationTargetException e )
        {
            throw (Exception) e.getCause();
        }

        expected = unifyLineSeperators(expected);

        TestingOutputStream o = (TestingOutputStream)System.out;
        Assert.assertEquals(unifyLineSeperators(expected), unifyLineSeperators(o.toString()));
    }

    @Test(timeout = 250)
    public void test6() throws Exception{
        String input =  "55\n" +
                "5\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n";

        String expected =   "Enter the number of disks you would like to play with (3-6):\n" +
                "That value is out of range, please try again.\n" +
                "Enter the number of disks you would like to play with (3-6):\n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "     XXX          -           -      \n" +
                "    XXXXX         -           -      \n" +
                "   XXXXXXX        -           -      \n" +
                "  XXXXXXXXX       -           -      \n" +
                " XXXXXXXXXXX      -           -      \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "    XXXXX         -           -      \n" +
                "   XXXXXXX        -           -      \n" +
                "  XXXXXXXXX       -           -      \n" +
                " XXXXXXXXXXX     XXX          -      \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "    XXXXX         -           -      \n" +
                "   XXXXXXX        -           -      \n" +
                "  XXXXXXXXX       -           -      \n" +
                " XXXXXXXXXXX      -          XXX     \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "   XXXXXXX        -           -      \n" +
                "  XXXXXXXXX       -           -      \n" +
                " XXXXXXXXXXX    XXXXX        XXX     \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "   XXXXXXX        -           -      \n" +
                "  XXXXXXXXX      XXX          -      \n" +
                " XXXXXXXXXXX    XXXXX         -      \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "  XXXXXXXXX      XXX          -      \n" +
                " XXXXXXXXXXX    XXXXX      XXXXXXX   \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "     XXX          -           -      \n" +
                "  XXXXXXXXX       -           -      \n" +
                " XXXXXXXXXXX    XXXXX      XXXXXXX   \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "     XXX          -           -      \n" +
                "  XXXXXXXXX       -         XXXXX    \n" +
                " XXXXXXXXXXX      -        XXXXXXX   \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -          XXX     \n" +
                "  XXXXXXXXX       -         XXXXX    \n" +
                " XXXXXXXXXXX      -        XXXXXXX   \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -          XXX     \n" +
                "      -           -         XXXXX    \n" +
                " XXXXXXXXXXX  XXXXXXXXX    XXXXXXX   \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -          XXX        XXXXX    \n" +
                " XXXXXXXXXXX  XXXXXXXXX    XXXXXXX   \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "    XXXXX        XXX          -      \n" +
                " XXXXXXXXXXX  XXXXXXXXX    XXXXXXX   \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "     XXX          -           -      \n" +
                "    XXXXX         -           -      \n" +
                " XXXXXXXXXXX  XXXXXXXXX    XXXXXXX   \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "     XXX          -           -      \n" +
                "    XXXXX      XXXXXXX        -      \n" +
                " XXXXXXXXXXX  XXXXXXXXX       -      \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "    XXXXX      XXXXXXX        -      \n" +
                " XXXXXXXXXXX  XXXXXXXXX      XXX     \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -         XXXXX         -      \n" +
                "      -        XXXXXXX        -      \n" +
                " XXXXXXXXXXX  XXXXXXXXX      XXX     \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -         XXXXX         -      \n" +
                "     XXX       XXXXXXX        -      \n" +
                " XXXXXXXXXXX  XXXXXXXXX       -      \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -          XXX          -      \n" +
                "      -         XXXXX         -      \n" +
                "      -        XXXXXXX        -      \n" +
                " XXXXXXXXXXX  XXXXXXXXX       -      \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -          XXX          -      \n" +
                "      -         XXXXX         -      \n" +
                "      -        XXXXXXX        -      \n" +
                "      -       XXXXXXXXX  XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -         XXXXX         -      \n" +
                "      -        XXXXXXX        -      \n" +
                "     XXX      XXXXXXXXX  XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -        XXXXXXX      XXXXX    \n" +
                "     XXX      XXXXXXXXX  XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -          XXX     \n" +
                "      -        XXXXXXX      XXXXX    \n" +
                "      -       XXXXXXXXX  XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -          XXX     \n" +
                "      -           -         XXXXX    \n" +
                "   XXXXXXX    XXXXXXXXX  XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -          XXX        XXXXX    \n" +
                "   XXXXXXX    XXXXXXXXX  XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "    XXXXX        XXX          -      \n" +
                "   XXXXXXX    XXXXXXXXX  XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "     XXX          -           -      \n" +
                "    XXXXX         -           -      \n" +
                "   XXXXXXX    XXXXXXXXX  XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "     XXX          -           -      \n" +
                "    XXXXX         -       XXXXXXXXX  \n" +
                "   XXXXXXX        -      XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -          XXX     \n" +
                "    XXXXX         -       XXXXXXXXX  \n" +
                "   XXXXXXX        -      XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -          XXX     \n" +
                "      -           -       XXXXXXXXX  \n" +
                "   XXXXXXX      XXXXX    XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -          XXX      XXXXXXXXX  \n" +
                "   XXXXXXX      XXXXX    XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -        XXXXXXX   \n" +
                "      -          XXX      XXXXXXXXX  \n" +
                "      -         XXXXX    XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -        XXXXXXX   \n" +
                "      -           -       XXXXXXXXX  \n" +
                "     XXX        XXXXX    XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -         XXXXX    \n" +
                "      -           -        XXXXXXX   \n" +
                "      -           -       XXXXXXXXX  \n" +
                "     XXX          -      XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "      -           -           -      \n" +
                "      -           -           -      \n" +
                "      -           -          XXX     \n" +
                "      -           -         XXXXX    \n" +
                "      -           -        XXXXXXX   \n" +
                "      -           -       XXXXXXXXX  \n" +
                "      -           -      XXXXXXXXXXX \n" +
                "-------------------------------------\n" +
                "\n" +
                "Congratulations you solved 5 disks in 33 moves. A perfect solutions is 31 moves.";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Class<?> classRef = Class.forName(generateClassName("TowerOfHanoi"));
        Object classObject = classRef.getConstructor().newInstance();

        Method main = classRef.getMethod("main",String[].class);
        try
        {
            main.invoke(classObject,(Object)null);
        }
        catch ( InvocationTargetException e )
        {
            throw (Exception) e.getCause();
        }

        expected = unifyLineSeperators(expected);

        TestingOutputStream o = (TestingOutputStream)System.out;
        Assert.assertEquals(unifyLineSeperators(expected), unifyLineSeperators(o.toString()));
    }

    @Test(timeout = 250)
    public void test7() throws Exception{
        String input =  "6\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n";

        String expected =   "Enter the number of disks you would like to play with (3-6):\n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX       -             -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX       -            XXX      \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX     XXXXX          XXX      \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX       XXX            -       \n" +
                " XXXXXXXXXXXXX     XXXXX           -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX     XXXXX          XXX      \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX       -            XXX      \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX       -             -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX      XXX            -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX      XXX          XXXXX     \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -            XXX      \n" +
                " XXXXXXXXXXXXX       -           XXXXX     \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -            XXX      \n" +
                " XXXXXXXXXXXXX    XXXXXXX        XXXXX     \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX    XXXXXXX        XXXXX     \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "   XXXXXXXXX         -             -       \n" +
                "  XXXXXXXXXXX      XXXXX           -       \n" +
                " XXXXXXXXXXXXX    XXXXXXX          -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "   XXXXXXXXX        XXX            -       \n" +
                "  XXXXXXXXXXX      XXXXX           -       \n" +
                " XXXXXXXXXXXXX    XXXXXXX          -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "  XXXXXXXXXXX      XXXXX           -       \n" +
                " XXXXXXXXXXXXX    XXXXXXX      XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "  XXXXXXXXXXX      XXXXX          XXX      \n" +
                " XXXXXXXXXXXXX    XXXXXXX      XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX           -             -       \n" +
                "  XXXXXXXXXXX        -            XXX      \n" +
                " XXXXXXXXXXXXX    XXXXXXX      XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "     XXXXX           -             -       \n" +
                "  XXXXXXXXXXX        -             -       \n" +
                " XXXXXXXXXXXXX    XXXXXXX      XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "     XXXXX           -             -       \n" +
                "  XXXXXXXXXXX        -          XXXXXXX    \n" +
                " XXXXXXXXXXXXX       -         XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX           -             -       \n" +
                "  XXXXXXXXXXX        -          XXXXXXX    \n" +
                " XXXXXXXXXXXXX      XXX        XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -           XXXXX     \n" +
                "  XXXXXXXXXXX        -          XXXXXXX    \n" +
                " XXXXXXXXXXXXX      XXX        XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -           XXXXX     \n" +
                "  XXXXXXXXXXX        -          XXXXXXX    \n" +
                " XXXXXXXXXXXXX       -         XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -           XXXXX     \n" +
                "       -             -          XXXXXXX    \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -           XXXXX     \n" +
                "      XXX            -          XXXXXXX    \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX          XXXXX        XXXXXXX    \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "       -           XXXXX        XXXXXXX    \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "    XXXXXXX        XXXXX           -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "    XXXXXXX        XXXXX           -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "    XXXXXXX        XXXXX          XXX      \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -            XXX      \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX    XXXXXXXXX   \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX      XXXXXXXXX         -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX        -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX          XXX            -       \n" +
                "    XXXXXXX      XXXXXXXXX         -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX        -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "    XXXXXXX      XXXXXXXXX         -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX      XXXXX     \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "    XXXXXXX      XXXXXXXXX        XXX      \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX      XXXXX     \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -          XXXXXXX          -       \n" +
                "       -         XXXXXXXXX        XXX      \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX      XXXXX     \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -          XXXXXXX          -       \n" +
                "      XXX        XXXXXXXXX         -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX      XXXXX     \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -           XXXXX           -       \n" +
                "       -          XXXXXXX          -       \n" +
                "      XXX        XXXXXXXXX         -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX        -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "       -           XXXXX           -       \n" +
                "       -          XXXXXXX          -       \n" +
                "       -         XXXXXXXXX         -       \n" +
                " XXXXXXXXXXXXX  XXXXXXXXXXX        -       \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "       -           XXXXX           -       \n" +
                "       -          XXXXXXX          -       \n" +
                "       -         XXXXXXXXX         -       \n" +
                "       -        XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "\tInvalid Move.\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -           XXXXX           -       \n" +
                "       -          XXXXXXX          -       \n" +
                "       -         XXXXXXXXX        XXX      \n" +
                "       -        XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -          XXXXXXX          -       \n" +
                "       -         XXXXXXXXX        XXX      \n" +
                "     XXXXX      XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -          XXXXXXX          -       \n" +
                "      XXX        XXXXXXXXX         -       \n" +
                "     XXXXX      XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX        XXXXXXXXX      XXXXXXX    \n" +
                "     XXXXX      XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "       -         XXXXXXXXX      XXXXXXX    \n" +
                "     XXXXX      XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX          XXXXX     \n" +
                "       -         XXXXXXXXX      XXXXXXX    \n" +
                "       -        XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -           XXXXX     \n" +
                "       -         XXXXXXXXX      XXXXXXX    \n" +
                "       -        XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -           XXXXX     \n" +
                "       -             -          XXXXXXX    \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -           XXXXX     \n" +
                "       -            XXX         XXXXXXX    \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -           XXXXX     \n" +
                "      XXX            -          XXXXXXX    \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX          XXXXX        XXXXXXX    \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "       -           XXXXX        XXXXXXX    \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "    XXXXXXX        XXXXX           -       \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "    XXXXXXX        XXXXX          XXX      \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -            XXX      \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -             -       \n" +
                "   XXXXXXXXX    XXXXXXXXXXX  XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX            -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -        XXXXXXXXXXX  \n" +
                "   XXXXXXXXX         -       XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "     XXXXX           -             -       \n" +
                "    XXXXXXX          -        XXXXXXXXXXX  \n" +
                "   XXXXXXXXX        XXX      XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -           XXXXX     \n" +
                "    XXXXXXX          -        XXXXXXXXXXX  \n" +
                "   XXXXXXXXX        XXX      XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -           XXXXX     \n" +
                "    XXXXXXX          -        XXXXXXXXXXX  \n" +
                "   XXXXXXXXX         -       XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -           XXXXX     \n" +
                "       -             -        XXXXXXXXXXX  \n" +
                "   XXXXXXXXX      XXXXXXX    XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -           XXXXX     \n" +
                "      XXX            -        XXXXXXXXXXX  \n" +
                "   XXXXXXXXX      XXXXXXX    XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "      XXX          XXXXX      XXXXXXXXXXX  \n" +
                "   XXXXXXXXX      XXXXXXX    XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX            -       \n" +
                "       -           XXXXX      XXXXXXXXXXX  \n" +
                "   XXXXXXXXX      XXXXXXX    XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -            XXX        XXXXXXXXX   \n" +
                "       -           XXXXX      XXXXXXXXXXX  \n" +
                "       -          XXXXXXX    XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -         XXXXXXXXX   \n" +
                "       -           XXXXX      XXXXXXXXXXX  \n" +
                "       -          XXXXXXX    XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -         XXXXXXXXX   \n" +
                "       -             -        XXXXXXXXXXX  \n" +
                "     XXXXX        XXXXXXX    XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -         XXXXXXXXX   \n" +
                "      XXX            -        XXXXXXXXXXX  \n" +
                "     XXXXX        XXXXXXX    XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -          XXXXXXX    \n" +
                "       -             -         XXXXXXXXX   \n" +
                "      XXX            -        XXXXXXXXXXX  \n" +
                "     XXXXX           -       XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -          XXXXXXX    \n" +
                "       -             -         XXXXXXXXX   \n" +
                "       -             -        XXXXXXXXXXX  \n" +
                "     XXXXX          XXX      XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -           XXXXX     \n" +
                "       -             -          XXXXXXX    \n" +
                "       -             -         XXXXXXXXX   \n" +
                "       -             -        XXXXXXXXXXX  \n" +
                "       -            XXX      XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Enter your from pole (1-3):\n" +

                "Enter your to pole (1-3):\n" +

                "       -             -             -       \n" +
                "       -             -             -       \n" +
                "       -             -            XXX      \n" +
                "       -             -           XXXXX     \n" +
                "       -             -          XXXXXXX    \n" +
                "       -             -         XXXXXXXXX   \n" +
                "       -             -        XXXXXXXXXXX  \n" +
                "       -             -       XXXXXXXXXXXXX \n" +
                "-------------------------------------------\n" +
                "\n" +
                "Congratulations you solved 6 disks in 71 moves. A perfect solutions is 63 moves.";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Class<?> classRef = Class.forName(generateClassName("TowerOfHanoi"));
        Object classObject = classRef.getConstructor().newInstance();

        Method main = classRef.getMethod("main",String[].class);
        try
        {
            main.invoke(classObject,(Object)null);
        }
        catch ( InvocationTargetException e )
        {
            throw (Exception) e.getCause();
        }

        expected = unifyLineSeperators(expected);

        TestingOutputStream o = (TestingOutputStream)System.out;
        Assert.assertEquals(unifyLineSeperators(expected), unifyLineSeperators(o.toString()));
    }
}
