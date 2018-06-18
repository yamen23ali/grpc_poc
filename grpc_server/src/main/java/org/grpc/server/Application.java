package org.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Hello world!
 *
 */
public class Application {
	public static void main(String[] args) {
		Server server = ServerBuilder.forPort(8080).addService(new SpeechServiceImpl()).build();

		try {
			server.start();
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println(" Can't start server " + e.getMessage());
		}

	}
}
