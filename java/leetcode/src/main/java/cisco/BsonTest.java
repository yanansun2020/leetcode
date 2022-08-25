package cisco;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.Test;


public class BsonTest {
    @Test
    public void test() {
        String a = "62eef3fa0b692e5774290060";
        ObjectId objId = new ObjectId(a);
        System.out.println(objId);
        StringBuilder sb = new StringBuilder();
    }
}
