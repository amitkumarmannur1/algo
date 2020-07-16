import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class testingDelimiter {

    public static void main(String[] asd) {
        String s = "amit Kumar Mannur";
        String delimeters = " .~`!#$%^&*+=-[]\\\';,/{}|\":<>?";
        String REGEX = ":";
        String INPUT = "boo:and:foo";

        s.contains(delimeters);
        Pattern pattern = Pattern.compile(REGEX);

        "a.b".codePoints()
                .mapToObj(cp -> new String(Character.toChars(cp)))
                .toArray(String[]::new);

        String[] result = pattern.split(INPUT, 2);
        for (String data : result) {
            System.out.println(data);
        }

        System.out.println(getName("amit kumar"));
        Pattern.compile("\\| .~`!#$%^&*+=-\\[];,\\{}")
                .splitAsStream("010|020 202.323 23.42&aer")
                .collect(Collectors.toList());

        substringFirstOf("amit kumar Mannur", "\" .~`!#$%^&*+=-[]\\\\\\';,/{}|\\\":<>?".chars().mapToObj(e->(char)e).collect(Collectors.toList()));

    }

    public static String getName(String fullName){
        return fullName.split(Pattern.quote(" .~`!#$%^&*+=-[]\\\';,/{}|\":<>?)\\E"))[0];
    }

    public static String getSurname(String fullName){
        return fullName.split(" (?!.* )")[1];
    }

    public static String substringFirstOf(String original, List<Character> characters) {
        return characters.stream()
                .map(i -> original.indexOf(i))
                .filter(min -> min > 0)
                .reduce(Integer::min)
                .map(position -> original.substring(0, position))
                .orElse(original);
    }



}
