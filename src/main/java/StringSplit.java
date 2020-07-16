import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class StringSplit {
    public static void main(String[] args) {
        String asd = "-asdfg-ar-few----rd-";
        strsplit(asd, "-");
    }

    private static void strsplit(String asd, String s) {
        List<Character> stringList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        stringList = asd.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        StringBuffer stringBuffer = new StringBuffer();
        for (Character c : stringList) {
            if (c.toString().equalsIgnoreCase(s)) {
                if (stringBuffer.toString().trim().length() > 0)
                    strings.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else
                stringBuffer.append(c);
        }
        if (stringBuffer.toString().trim().length() > 0)
            strings.add(stringBuffer.toString());
        System.out.println(strings);
    }


}