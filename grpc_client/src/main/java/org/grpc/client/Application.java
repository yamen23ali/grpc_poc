package org.grpc.client;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.grpc.speech.SpeechServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Hello world!
 *
 */
public class Application {
	public static byte[][] chunkArray(byte[] array, int chunkSize) {
		int numOfChunks = (int) Math.ceil((double) array.length / chunkSize);
		byte[][] output = new byte[numOfChunks][];

		for (int i = 0; i < numOfChunks; ++i) {
			int start = i * chunkSize;
			int length = Math.min(array.length - start, chunkSize);

			byte[] temp = new byte[length];
			System.arraycopy(array, start, temp, 0, length);
			output[i] = temp;
		}

		return output;
	}

	public static void main(String[] args) {

		try {
			Path path = Paths.get("test.pcm");
			byte[][] data = Application.chunkArray(Files.readAllBytes(path), 1024);

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

			SpeechServiceGrpc.SpeechServiceStub asyncStub = SpeechServiceGrpc.newStub(channel);
			SpeechClient client = new SpeechClient(asyncStub);
			client.convertToText(data);
			channel.shutdown();
		} catch (Exception e) {
			System.out.println(" can't use grpc " + e.getMessage());
		}
	}
}
