package org.grpc.speech;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.14.0-SNAPSHOT)",
    comments = "Source: google/myapis/speech.proto")
public final class SpeechServiceGrpc {

  private SpeechServiceGrpc() {}

  public static final String SERVICE_NAME = "speechService.SpeechService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.grpc.speech.SpeechRequest,
      org.grpc.speech.SpeechResponse> getRecognizeMethod;

  public static io.grpc.MethodDescriptor<org.grpc.speech.SpeechRequest,
      org.grpc.speech.SpeechResponse> getRecognizeMethod() {
    io.grpc.MethodDescriptor<org.grpc.speech.SpeechRequest, org.grpc.speech.SpeechResponse> getRecognizeMethod;
    if ((getRecognizeMethod = SpeechServiceGrpc.getRecognizeMethod) == null) {
      synchronized (SpeechServiceGrpc.class) {
        if ((getRecognizeMethod = SpeechServiceGrpc.getRecognizeMethod) == null) {
          SpeechServiceGrpc.getRecognizeMethod = getRecognizeMethod = 
              io.grpc.MethodDescriptor.<org.grpc.speech.SpeechRequest, org.grpc.speech.SpeechResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "speechService.SpeechService", "Recognize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.speech.SpeechRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.speech.SpeechResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SpeechServiceMethodDescriptorSupplier("Recognize"))
                  .build();
          }
        }
     }
     return getRecognizeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SpeechServiceStub newStub(io.grpc.Channel channel) {
    return new SpeechServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpeechServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SpeechServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SpeechServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SpeechServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class SpeechServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Streams a many greetings
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.grpc.speech.SpeechRequest> recognize(
        io.grpc.stub.StreamObserver<org.grpc.speech.SpeechResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getRecognizeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecognizeMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.grpc.speech.SpeechRequest,
                org.grpc.speech.SpeechResponse>(
                  this, METHODID_RECOGNIZE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SpeechServiceStub extends io.grpc.stub.AbstractStub<SpeechServiceStub> {
    private SpeechServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeechServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Streams a many greetings
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.grpc.speech.SpeechRequest> recognize(
        io.grpc.stub.StreamObserver<org.grpc.speech.SpeechResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRecognizeMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SpeechServiceBlockingStub extends io.grpc.stub.AbstractStub<SpeechServiceBlockingStub> {
    private SpeechServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeechServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SpeechServiceFutureStub extends io.grpc.stub.AbstractStub<SpeechServiceFutureStub> {
    private SpeechServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeechServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_RECOGNIZE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SpeechServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SpeechServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECOGNIZE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recognize(
              (io.grpc.stub.StreamObserver<org.grpc.speech.SpeechResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SpeechServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpeechServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.grpc.speech.SpeechProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SpeechService");
    }
  }

  private static final class SpeechServiceFileDescriptorSupplier
      extends SpeechServiceBaseDescriptorSupplier {
    SpeechServiceFileDescriptorSupplier() {}
  }

  private static final class SpeechServiceMethodDescriptorSupplier
      extends SpeechServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SpeechServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SpeechServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SpeechServiceFileDescriptorSupplier())
              .addMethod(getRecognizeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
