package org.grpc.server;

import java.io.IOException;

import org.grpc.speech.SpeechRequest;
import org.grpc.speech.SpeechResponse;
import org.grpc.speech.SpeechServiceGrpc.SpeechServiceImplBase;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.StreamingRecognitionConfig;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;

import io.grpc.stub.StreamObserver;

public class SpeechServiceImpl extends SpeechServiceImplBase {

	@Override
	public StreamObserver<SpeechRequest> recognize(StreamObserver<SpeechResponse> speechResponseObserver) {

		// To observer google response ( receive results through onNext call)
		GoogleResponseObserver<StreamingRecognizeResponse> googleResponseObserver = new GoogleResponseObserver<StreamingRecognizeResponse>(
				speechResponseObserver);

		// To observe google request ( send requests to call when onNext is called)
		ApiStreamObserver<StreamingRecognizeRequest> googleRequestObserver = initGoogleClient(googleResponseObserver);

		RecognitionConfig recConfig = RecognitionConfig.newBuilder().setEncoding(AudioEncoding.LINEAR16)
				.setLanguageCode("en-US").setSampleRateHertz(16000).build();

		StreamingRecognitionConfig config = StreamingRecognitionConfig.newBuilder().setConfig(recConfig)
				.setInterimResults(true).build();

		// The first request must **only** contain the audio configuration:
		googleRequestObserver.onNext(StreamingRecognizeRequest.newBuilder().setStreamingConfig(config).build());

		// return Speech request observer which will be called ( i.e: through onNext) when this service receives a request
		return new SpeechRequestObserver(googleRequestObserver);
	}

	private ApiStreamObserver<StreamingRecognizeRequest> initGoogleClient(
			ApiStreamObserver<StreamingRecognizeResponse> googleResponseObserver) {
		try {
			SpeechClient speech = SpeechClient.create();

			BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse> callable = speech
					.streamingRecognizeCallable();

			return callable.bidiStreamingCall(googleResponseObserver);

		} catch (IOException e) {
			System.out.println(" can't connect to google");
			e.printStackTrace();
			return null;
		}
	}
}
