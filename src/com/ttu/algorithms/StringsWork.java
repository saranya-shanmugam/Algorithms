import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsWork {

    public static void main (String args[]) {
        StringsTest strTest = new StringsTest();
        strTest.jewelsAndStones();
        strTest.anagram();
        strTest.uniqueEmail();
    }

    // https://leetcode.com/problems/unique-email-addresses/
    private int uniqueEmail() {
        String[] emailss = {"fg.r.u.uzj+o.pw@kziczvh.com","r.cyo.g+d.h+b.ja@tgsg.z.com","fg.r.u.uzj+o.f.d@kziczvh.com","r.cyo.g+ng.r.iq@tgsg.z.com","fg.r.u.uzj+lp.k@kziczvh.com","r.cyo.g+n.h.e+n.g@tgsg.z.com","fg.r.u.uzj+k+p.j@kziczvh.com","fg.r.u.uzj+w.y+b@kziczvh.com","r.cyo.g+x+d.c+f.t@tgsg.z.com","r.cyo.g+x+t.y.l.i@tgsg.z.com","r.cyo.g+brxxi@tgsg.z.com","r.cyo.g+z+dr.k.u@tgsg.z.com","r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com","fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com","fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"};
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Pattern pattern = Pattern.compile("([^+]*)(.*)(@.*)");
        Set<String> emailSet = new HashSet<>();
        Arrays.stream(emailss).forEach(email -> {
            Matcher m = pattern.matcher(email);
            if(m.find()) {
                StringBuilder sb = new StringBuilder((m.group(1)).replaceAll("\\.", ""));
                sb.append(m.group(3));
                emailSet.add(sb.toString());
            }
        });
        System.out.println(emailSet);
        System.out.println(emailSet.size());
        return emailSet.size();
    }

    // https://leetcode.com/problems/find-anagram-mappings/
    private void anagram() {
        Integer[] A = {1,2,3,4,5};
        Integer[] B = {5,4,3,2,1};
        int[] P = new int[A.length];
        Map<Integer, Integer> mapB = new HashMap<>();

        for(int i=0; i<B.length; i++) {
            mapB.put(B[i],i);
        }
        for(int i=0; i<A.length; i++) {
            P[i] = mapB.get(A[i]);
        }
        System.out.println(Arrays.toString(P));
    }

    // https://leetcode.com/problems/jewels-and-stones/
    private void jewelsAndStones() {
        String J = "aA";
        String S = "aAAbbbb";

        S = S.replaceAll("[^" + J + "]", "");
        int count = S.length();
        System.out.println("count " + count + S);

    }
}
