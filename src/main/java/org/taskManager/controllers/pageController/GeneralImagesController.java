//package org.taskManager.controllers.pageController;
//
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.taskManager.services.TaskImageService;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//
//@RestController
//public class GeneralImagesController {
//    private final TaskImageService taskImageService;
//    private static final String IMAGE_DIRECTORY = "C:\\Users\\1\\OneDrive\\Рабочий стол\\ideaProjects\\taskManager\\src\\main\\resources\\TaskImages";
//
//    public GeneralImagesController(TaskImageService taskImageService) {
//        this.taskImageService = taskImageService;
//    }
//
////    @PostMapping("/addImage")
////    public void getTaskInfo(@RequestParam("file") MultipartFile image) {
////        try{
////            byte[] imageBytes = image.getBytes();
////            Path imagePath = Paths.get(IMAGE_DIRECTORY + image.getOriginalFilename());
////
////            if(Files.exists(imagePath)){
////                System.out.println("File already exist");
////            }else {
////                Files.write(imagePath, imageBytes);
////            }
////
////        } catch (IOException e){};
////    }
//}
