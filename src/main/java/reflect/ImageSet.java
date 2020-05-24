package reflect;

import java.util.List;

public class ImageSet {

    private String name;
    @ImageId
    private String coverImage;
    private List<ImageInfo> imageInfos;

    private List<String> imageNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public List<ImageInfo> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(List<ImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
    }

    @Override
    public String toString() {
        return "ImageSet{" +
                "name='" + name + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", imageInfos=" + imageInfos +
                '}';
    }
}
