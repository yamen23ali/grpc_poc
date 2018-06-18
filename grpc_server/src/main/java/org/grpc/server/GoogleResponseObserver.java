package org.grpc.server;

import java.nio.charset.Charset;

import org.grpc.speech.SpeechResponse;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import com.google.protobuf.ByteString;

import io.grpc.stub.StreamObserver;

class GoogleResponseObserver<T> implements ApiStreamObserver<T> {

	StreamObserver<SpeechResponse> speechResponseObserver;

	public GoogleResponseObserver(StreamObserver<SpeechResponse> speechResponseObserver) {
		this.speechResponseObserver = speechResponseObserver;
	}

	@Override
	public void onNext(T message) {
		System.out.println(message);
		SpeechRecognitionAlternative alternative = ((StreamingRecognizeResponse) message).getResultsList().get(0)
				.getAlternativesList().get(0);
		ByteString content = ByteString.copyFrom(alternative.getTranscript(), Charset.defaultCharset());
		
		SpeechResponse response = SpeechResponse.newBuilder().setMessage(content).build();
		
		speechResponseObserver.onNext(response);
	}

	@Override
	public void onError(Throwable e) {
		System.out.println(" Error while receving from google " + e.getMessage());
	}

	@Override
	public void onCompleted() {
		System.out.println("Receiving From google completed");
	}
}