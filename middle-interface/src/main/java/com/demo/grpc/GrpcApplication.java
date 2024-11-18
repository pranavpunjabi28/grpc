package com.demo.grpc;

import com.example.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcApplication {
	public final static ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8083).usePlaintext().build();

	public static void main(String[] args) {
		SpringApplication.run(GrpcApplication.class, args);
	}

}
