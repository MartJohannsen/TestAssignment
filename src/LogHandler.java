import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Martin on 11-10-2018.
 */
public class LogHandler
{
    private static LogHandler instance = new LogHandler();

    public static LogHandler getInstance()
    {
        return instance;
    }

    public void logMessage(String message, String type)
    {
        File logFile = new File("C://Users//Martin//IdeaProjects//UnitTestProject//logs//" +
                "errorlogFile.txt");

        if (logFile.exists())
        {
            String text = readFile(logFile);

            try
            {
                PrintStream printStream = new PrintStream(logFile);

                printStream.append(text);
                printStream.append(createLogMessage(message, type) + "\n");

                System.out.println(readFile(logFile));
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }

    }

    public String createLogMessage(String message, String type)
    {
        Date date= new Date();

        long time = date.getTime();

        Timestamp ts = new Timestamp(time);
        return ts + " => " + type + " => " + message;
    }

    public String readFile(File file)
    {
        String text = "";

        try
        {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
                text += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return text;
    }
}
