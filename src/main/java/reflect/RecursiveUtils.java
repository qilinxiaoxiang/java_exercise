package reflect;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class RecursiveUtils {

    public static void processImageId(Object result) {
        // 如果自己就是简单类型或其数组直接拦掉
        if (BeanUtils.isSimpleProperty(result.getClass())) {
            return;
        }
        Field[] declaredFields = result.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            Class<?> type = field.getType();
            // 简单类型或其数组中, 除了String都拦掉
            if (BeanUtils.isSimpleProperty(type) && type != String.class) {
                return;
            }
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(result);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value == null) {
                continue;
            }
            if (field.isAnnotationPresent(ImageId.class) && type == String.class) {
                // 如果是String, 并且被ImageId注解修饰, 则进行处理
                try {
                    field.set(result, ImageUtil.getUrl((String) value));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Collection.class.isAssignableFrom(type)) {
                // 如果是Collection, 则遍历递归
                ((Collection<?>) value).forEach(RecursiveUtils::processImageId);
            } else if (Map.class.isAssignableFrom(type)) {
                // 如果是map, 则遍历递归
                ((Map<?, ?>) value).forEach((k, v) -> {
                    RecursiveUtils.processImageId(k);
                    RecursiveUtils.processImageId(v);
                });
            } else if (type.isArray()) {
                // 如果是对象数组, 则遍历递归
                Arrays.stream(((Object[]) value)).forEach(RecursiveUtils::processImageId);
            } else {
                // 普通对象则直接, 递归
                processImageId(value);
            }
        }
    }

    public static void main(String[] args) {
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setName("abc");
        imageInfo.setId("abc");
        imageInfo.setVolume(1L);
        System.out.println(imageInfo.toString());
        processImageId(imageInfo);
        System.out.println(imageInfo.toString());
    }
}
