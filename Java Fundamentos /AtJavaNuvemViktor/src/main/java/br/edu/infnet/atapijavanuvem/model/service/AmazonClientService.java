package br.edu.infnet.atapijavanuvem.model.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
@Api(tags = "Amazon S3")
@Service
public class AmazonClientService {

    private AmazonS3 amazonS3;
    @Value("${aws.key}")
    private String key;

    @Value("${aws.secret}")
    private String secret;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.bucketName}")
    private String bucketName;

    @PostConstruct
    private void initializeAmazon(){
        amazonS3 = AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(key,secret)))
                .build();
    }

    @ApiOperation(value = "Salva um arquivo no Amazon S3")
    public void save(byte[] bytes, String fileName) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, new ByteArrayInputStream(bytes), new ObjectMetadata());
        amazonS3.putObject(putObjectRequest);
    }

    @ApiOperation(value = "Obtém a URL de um arquivo no Amazon S3")
    public String getFileUrl(String fileName) {
        return amazonS3.getUrl(bucketName, fileName).toString();
    }

    @ApiOperation(value = "Obtém um objeto do Amazon S3")
    public S3Object getObject(String objectKey) {
        return amazonS3.getObject(bucketName, objectKey);
    }

    @ApiOperation(value = "Deleta um objeto do Amazon S3")
    public void delete(String objectKey) {
        amazonS3.deleteObject(bucketName, objectKey);
    }
}