package org.grpc.server;

import org.grpc.speech.SpeechRequest;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import io.grpc.stub.StreamObserver;

class SpeechRequestObserver implements StreamObserver<SpeechRequest> {

	ApiStreamObserver<StreamingRecognizeRequest> googleRequestObserver;

	public SpeechRequestObserver(ApiStreamObserver<StreamingRecognizeRequest> googleRequestObserver) {
		this.googleRequestObserver = googleRequestObserver;
	}

	@Override
	public void onNext(SpeechRequest speechRequest) {
		System.out.println("Received ====");
		googleRequestObserver
				.onNext(StreamingRecognizeRequest.newBuilder().setAudioContent(speechRequest.getMessage()).build());
	}

	@Override
	public void onError(Throwable e) {
		System.out.println(" error : " + e.getMessage());
	}

	@Override
	public void onCompleted() {
		System.out.println("Done  receiving");
		googleRequestObserver.onCompleted();
	}
}