package org.grpc.client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.grpc.speech.SpeechRequest;
import org.grpc.speech.SpeechResponse;
import org.grpc.speech.SpeechServiceGrpc;

import com.google.protobuf.ByteString;

import io.grpc.stub.StreamObserver;

public class SpeechClient {

	SpeechServiceGrpc.SpeechServiceStub asyncStub;

	public SpeechClient(SpeechServiceGrpc.SpeechServiceStub asyncStub) {
		this.asyncStub = asyncStub;
	}

	public void convertToText(byte[][] data) throws InterruptedException {

		final CountDownLatch finishLatch = new CountDownLatch(1);

		StreamObserver<SpeechResponse> responseObserver = new SpeechResponseObserver();

		StreamObserver<SpeechRequest> requestObserver = asyncStub.recognize(responseObserver);

		try {
			for (int i = 0; i < data.length; i++) {
				SpeechRequest request = SpeechRequest.newBuilder().setMessage(ByteString.copyFrom(data[i])).build();

				requestObserver.onNext(request);

				// Sleep for a bit before sending the next one. ( important to work :/ )
				Thread.sleep(50);
			}
		} catch (Exception e) {
			System.out.println(" Exception " + e.getMessage());
			requestObserver.onError(e);
		}
		requestObserver.onCompleted();

		// Since Receiving happens asynchronously we have to keep waiting for incoming
		// responses
		if (!finishLatch.await(1, TimeUnit.MINUTES)) {
			System.out.println(" Recognition didn't finish after 1 min");
		}
	}
}
