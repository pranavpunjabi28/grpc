package serviceimpl;

import com.example.grpc.UserRequest;
import com.example.grpc.UserResponse;
import com.example.grpc.UserServiceGrpc;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> response){
        String id=request.getUserId();

        if (id.isEmpty()) {
            throw Status.INVALID_ARGUMENT
                    .withDescription("User ID cannot be null or empty")
                    .asRuntimeException();
        }

        String name="pranav";
        String email="hello@123.com";
        UserResponse user=UserResponse.newBuilder().setAge(21).setEmail(email).setName(name).build();
        try {
            response.onNext(user);
            response.onCompleted();
        }catch (StatusRuntimeException e) {
            //If a gRPC server or client stream encounters a critical error, such as network issues, invalid data, or unauthorized access,
            //when a stream encounters a critical error, the exception thrown is typically a StatusRuntimeException (a subclass of RuntimeException) on the client side
            System.out.println("while Processing a request Receive a terminating error from the stream.");
            response.onError(e);//onError() will throw and notify the client
        }catch(Exception e){
            System.out.println("unexpected error occurred");
            response.onError(e);
        }
    }
}
