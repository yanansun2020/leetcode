package cisco;

import org.apache.commons.lang3.StringUtils;

public class StringRemoveTest {
    public static void main(String[] args) {
        String frontendPath = "/";
        frontendPath = StringUtils.removeEnd(frontendPath, "/");
        System.out.println("test");
        String methodAPI = "GET,/invalid/source/path";
        String b = StringUtils.substringBefore(methodAPI, ",");
        //MultivaluedMap<String, String> map = new MultiVa
    }
}
