# grpc_poc
A POC for grpc-client and grpc-server.

Client will stream audio frames (bytes) to the server using grpc stub.

The server will receive the frames from the client and call google cloud speech (using also grpc) 
and send the results back to the client.

Note: service_accounts json file should be provided to the server in order to be able to talk with google.


