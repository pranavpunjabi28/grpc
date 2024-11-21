import io.grpc.Server;
import io.grpc.ServerBuilder;
import serviceimpl.UserServiceImpl;

import java.io.IOException;

public class GrpcServer {

//    Logger log= LoggerFactory.getLogger(GrpcServer.class);

    public static void main(String[] args){
        Server server = ServerBuilder
                .forPort(8083)
                .addService(new UserServiceImpl())
                .build();

        try {
            //Bind and start the server. After this call returns, clients may begin connecting to the listening socket(s).
            server.start();
        } catch (IOException e) {
            //if unable to bind
            System.out.println("IOException While Starting a Server due to if unable to bind");
           throw new RuntimeException(e);
        }catch(IllegalStateException e){
            System.out.println("IllegalStateException in start() due to server is already started or shut down");
            throw new RuntimeException(e);
        }
        try {
            //Waits for the server to become terminated.
            //Calling this method before start() or shutdown() is permitted and does not change its behavior.
            server.awaitTermination();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException bcz server already Occupied");
           throw new RuntimeException(e);
        }
    }
}
