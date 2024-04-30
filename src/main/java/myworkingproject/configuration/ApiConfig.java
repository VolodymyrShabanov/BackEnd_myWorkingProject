package myworkingproject.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("PUBLIC")
                .pathsToMatch("/PUBLIC/**")
                .build();
    }

    @Bean
    public GroupedOpenApi privateApi(){
        return GroupedOpenApi.builder()
                .group("PRIVATE")
                .pathsToMatch("/PRIVATE/**")
                .build();
    }

    @Bean
    public OpenAPI customeOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("My API")
                        .version("v1")
                        .description("My API description")
                );

    }
}
