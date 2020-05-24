package reflect;

import org.springframework.util.StringUtils;

public class ImageUtil {
    public static String getUrl(String imageId) {
        if (StringUtils.isEmpty(imageId)) {
            return null;
        }
        return "http://wsbo.com/" + imageId;
    }
}
