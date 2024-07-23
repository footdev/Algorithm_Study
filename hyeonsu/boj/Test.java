package hyeonsu.boj;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String str = "b";
        StringBuilder sb = new StringBuilder();
        sb.append("aaaa");

        for (int i = 0; i < 20; i++) {
            str += "b";
        }

        sb.append(str);
        sb.insert(0, str);

        System.out.println(sb.toString());

        Set<String> s = new HashSet<>();

        s.add("aa");
        s.contains("aa");
    }
}
