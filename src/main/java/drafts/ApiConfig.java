//package drafts;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.client.builder.AwsClientBuilder;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ApiConfig {
//    @Bean
//    public GroupedOpenApi publicApi(){
//        return GroupedOpenApi.builder()
//                .group("PUBLIC")
//                .pathsToMatch("/PUBLIC/**")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi privateApi(){
//        return GroupedOpenApi.builder()
//                .group("PRIVATE")
//                .pathsToMatch("/PRIVATE/**")
//                .build();
//    }
//
//    @Bean
//    public OpenAPI customeOpenAPI(){
//        return new OpenAPI()
//                .info(new Info()
//                        .title("My API")
//                        .version("v1")
//                        .description("My API description")
//                );
//
//    }
//
//    @Bean
//    public AmazonS3 amazonS3(){
//        AWSCredentials credentials = new BasicAWSCredentials(
//                "D000MDKPVAWZL2BZ6JA3",
//                "rclRXz6wjr6gSC9yaEhkuac5ZWpTpgmbEz+JyPwFXx8"
//        );
//
//        // create client
//
//        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
//                "https://fral.digitaloceanspaces.com", "fra1"
//        );
//
//        AmazonS3ClientBuilder amazonS3ClientBuilder = AmazonS3ClientBuilder
//                .standard()
//                .withCredentials(new AWSStaticCredentialsProvider(credentials));
//
//        amazonS3ClientBuilder.setEndpointConfiguration(endpointConfiguration);
//
//        AmazonS3 amazonS3 = amazonS3ClientBuilder.build();
//
//        return amazonS3;
//    }
//}
