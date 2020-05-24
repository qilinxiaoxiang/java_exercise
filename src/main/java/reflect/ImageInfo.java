package reflect;

public class ImageInfo {
    private String name;
    @ImageId
    private String id;
    private Long volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", volume=" + volume +
                '}';
    }
}
