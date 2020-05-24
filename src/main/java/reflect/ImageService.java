package reflect;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    //    @ImageExport
    public ImageInfo getImageInfo(int seed) {
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setName("abc" + seed);
        imageInfo.setId("abc" + seed);
        imageInfo.setVolume(1L + seed);
        return imageInfo;
    }

    @ImageExport
    public Result getImageSet() {
        ImageSet imageSet = new ImageSet();
        imageSet.setCoverImage("cover");
        imageSet.setName("abc");
        List<ImageInfo> list = new ArrayList<>();
        list.add(getImageInfo(1));
        list.add(getImageInfo(2));
        imageSet.setImageInfos(list);
        return Result.success(imageSet);
    }

}
