package reflect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/image")
//    @ImageExport
    public Result getImageSet() {
        return imageService.getImageSet();
    }
}
