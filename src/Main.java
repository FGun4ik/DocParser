import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


// Евстифеев Егор РПО2
public class Main {
    public static void main(String[] args) {
        String htmlParse = parsingSite("data/code.html");
        Document document = Jsoup.parse(htmlParse);
        Elements elements = document.select("a.link");

        elements.forEach(element -> {
            if (String.valueOf(element).contains("https://www.hse.ru/ma/")){
                System.out.println(element.text());
            }
        });
    }

    public static String parsingSite(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));
            allLines.forEach(line -> builder.append(line).append("\n"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return builder.toString();
    }
}