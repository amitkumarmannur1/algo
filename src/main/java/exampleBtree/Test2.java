package exampleBtree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
    public static final String DELIMITER = "/";

    public static final String RESOURCES_FILE = "resoucetest.txt";

    public static void main(String arg[]) throws IOException, URISyntaxException {
        List<List<String>> lists = new ArrayList<>();
        List<String> data = getData();

        Optional.ofNullable(data).orElseGet(Collections::emptyList).forEach(line -> {
            List<String> toConcat = null;
            String[] splitString = line.split(DELIMITER);
            List<String> filteredList = data.stream()
                    .filter(e -> !e.equalsIgnoreCase(line)).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
            List<String> foundElements = null;
            List<String> splits = new ArrayList<>(Arrays.asList(splitString));
            if (verify(lists, splits))
                toConcat = ispresent(splitString[1], filteredList, foundElements);
            if (toConcat == null || toConcat.isEmpty()) {
                if (verify(lists, splits))
                    lists.add(splits);
            } else {
                splits.addAll(toConcat);
                lists.add(splits);
            }
        });
        lists.forEach(e -> System.out.println(Arrays.toString(e.toArray())));
    }

    private static boolean verify(List<List<String>> lists, List<String> splits) {
        for (List<String> lis : lists) {
            if (lis.containsAll(splits))
                return false;
        }
        return true;
    }

    /**
     * Method to verify if the element is eligible to conact with its parent.
     *
     * @param s
     * @param filteredList
     * @param foundElements
     * @return
     */
    private static List<String> ispresent(String s, List<String> filteredList, List<String> foundElements) {
        if(foundElements==null){
            foundElements = new ArrayList<>();
        }
        for (String line : filteredList) {
            String[] splitString = line.split(DELIMITER);
            if (s.equalsIgnoreCase(splitString[0])){
                foundElements.add(splitString[1]);
                filteredList.remove(line);
                ispresent(splitString[1], filteredList, foundElements);
            }
        }
        return foundElements;
    }

    /**
     * Method to read the resources file and add each line in list
     *
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public static List<String> getData() throws IOException, URISyntaxException {
        Path path = Paths.get(Testclass.class.getClassLoader().getResource(RESOURCES_FILE).toURI());
        List<String> data = new CopyOnWriteArrayList<>();
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> data.add(line));
        lines.close();
        return data;
    }
}
