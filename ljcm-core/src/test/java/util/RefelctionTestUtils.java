package util;

import java.lang.reflect.Field;
import java.util.Hashtable;

public class RefelctionTestUtils {
    public static Object getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName); //NoSuchFieldException
        field.setAccessible(true);
        return field.get(obj);
    }
}
