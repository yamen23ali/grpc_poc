package org.grpc.client;

import org.grpc.speech.SpeechResponse;

import io.grpc.stub.StreamObserver;

public class SpeechResponseObserver implements StreamObserver<SpeechResponse> {

	@Override
	public void onNext(SpeechResponse response) {
		// TODO Auto-generated method stub
		//System.out.println(" =============================== ");
		System.out.println(response.getMessage().toStringUtf8());
		//System.out.println(" =============================== ");
	}

	@Override
	public void onError(Throwable e) {
		System.out.println(" Problem while receiving " + e.getMessage());
	}

	@Override
	public void onCompleted() {
		System.out.println(" Receiving completeed");
	}
}
