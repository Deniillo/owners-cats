package itmo.deniill.service.specification;

import java.util.ArrayList;
import java.util.List;

public class CastToType {
    public static Object castToRequiredType(Class type, String value) {
        if (Enum.class.isAssignableFrom(type)) {
            return Enum.valueOf(type, value);
        }else if(Integer.class.isAssignableFrom(type)) {
            return Integer.valueOf(value);
        }
        return value;
    }

    public static Object castToRequiredType(Class type, List<String> values) {
        List<Object> objects = new ArrayList<>();
        for (String value : values) {
            objects.add(castToRequiredType(type, value));
        }
        return objects;
    }
}
