//package myworkingproject.files;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.UUID;
//
//
//@RestController
//@RequiredArgsConstructor
//public class FilesController {
//
//    private final AmazonS3 amazonS3;
//
//    @PostMapping("/api/files")
//    public StandardResponseDto upload(@RequestParam("file") MultipartFile file) throws IOException {
////        System.out.println(file.getOriginalFilename());
////        System.out.println(file.getSize());
////        System.out.println(file.getContentType());
//
//
//        String dirPath = "C:\\Users\\Anetta\\Desktop\\fileFromApi";
//        String originalFileName = file.getOriginalFilename();
//        String extension;
//
//
//        if (originalFileName != null) {
//            extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
//
//        } else {
//            throw new IllegalArgumentException("null original file name");
//
//        }
//
//        String uuid = UUID.randomUUID().toString();
//        String newFileName = uuid + "." + extension;
//
//        InputStream inputStream = file.getInputStream();
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentType(file.getContentType());
//
//        PutObjectRequest request = new PutObjectRequest(
//                "cohor35project",
//                newFileName,
//                inputStream,
//                metadata
//
//        ).withCannedAcl(CannedAccessControlList.PublicRead);
//
//        amazonS3.putObject(request);
//
//        return StandardResponseDto.builder()
//                .message(newFileName)
//                .build();
//
////        try {
////            InputStream inputStream = file.getInputStream();
////            Files.copy(inputStream, Path.of(dirPath, newFileName));
////
////        } catch (Exception e) {
////            throw new IllegalStateException(e);
////        }
//
//        //upload in DigitalOcean
//
////        AWSCredentials credentials = new BasicAWSCredentials(
////                "D000MDKPVAWZL2BZ6JA3",
////                "rclRXz6wjr6gSC9yaEhkuac5ZWpTpgmbEz+JyPwFXx8"
////        );
////
////        // create client
////
////        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
////                "https://fral.digitaloceanspaces.com", "fra1"
////        );
////
////        AmazonS3ClientBuilder amazonS3ClientBuilder = AmazonS3ClientBuilder
////                .standard()
////                .withCredentials(new AWSStaticCredentialsProvider(credentials));
////
////        AmazonS3 amazonS3 = amazonS3ClientBuilder.build();
//
//
//    }
//
//}
