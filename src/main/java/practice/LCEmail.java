package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Every email consists of a local name and a domain name, separated by the @ sign.

        For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

        Besides lowercase letters, these emails may contain '.'s or '+'s.

        If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

        If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

        Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?



        Example 1:

        Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
        Output: 2
        Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails


        Note:

        1 <= emails[i].length <= 100
        1 <= emails.length <= 100
        Each emails[i] contains exactly one '@' character.
        All local and domain names are non-empty.
        Local names do not start with a '+' character      */
public class LCEmail {

    List<Character> excludeCharsRightSideSymbol = List.of('+');
    List<Character> ignoreChars = List.of('.');
    List<Character> exactlyOneCharacter = List.of('@');
    int maxInputEmailLength = 100;
    int maxEmailsLength = 100;
    int minLocalNameLength = 1;
    Set<String> emailList = new HashSet<>(100);

    static Set<String> getEmailList(List<String> emails) {
        Set<String> list = new HashSet<>();
        emails.forEach(a -> {
            String[] splitemailid = a.split("@");
            if (splitemailid.length != 2 || splitemailid[0].length() < 1 || splitemailid[0].length() > 100) {
                //do nothing for now
            } else {
                String trimmedLocalName = splitemailid[0].replace(".", "");
                String localName = trimmedLocalName.split("\\+")[0];
                if (localName.length() >= 1) {
                    String emailid = localName + "@" + splitemailid[1];
                    list.add(emailid);
                }
            }
        });

        return list;
    }

    static int numUniqueEmails(String[] emails) {
        Set<String> list = new HashSet<>();
        List<String> emailss = Arrays.asList(emails);
        emailss.forEach(a -> {
            String[] splitemailid = a.split("@");
            if (splitemailid.length != 2 || splitemailid[0].length() <= 1 || splitemailid[0].length() > 100) {
                //do nothing for now
            } else {
                String trimmedLocalName = splitemailid[0].replace(".", "");
                String localName = trimmedLocalName.split("\\+")[0];
                if (localName.length() > 1) {
                    String emailid = localName + "@" + splitemailid[1];
                    list.add(emailid);
                }
            }
        });

        return list.size();
    }

    static String validateEmail(String email) {

        StringBuffer sb = new StringBuffer();
        boolean isPlusVisited = false;

        for (int i = 0; i < email.length(); i++) {
                boolean isValid = true;

                if (email.charAt(i) == '+') {
                    isValid = false;
                    isPlusVisited = true;
                }

                if(email.charAt(i)=='@'){
                    sb.append(email.substring(i));
                    break;
                }
                if (isValid && !isPlusVisited) {
                    sb.append(email.charAt(i));
                }
            }

            return sb.toString();

    }


    public static void main(String[] email) {
        List<String> emails = List.of("aa+s+d.d@leetcode.com", "b@leetcode.com", "c@leetcode.com");
        System.out.println(LCEmail.getEmailList(emails));
        Set<String> emailsss=new HashSet<>();
        for(String badEmail :emails){
            emailsss.add(LCEmail.validateEmail(badEmail));
        }
        System.out.println(emailsss);
    }


}
