package main;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import com.microsoft.cognitiveservices.speech.*;


public class Main {
	
    public static void main (String []args) throws InterruptedException, ExecutionException {
    	int exitCode =1;
      SpeechConfig config = SpeechConfig.fromSubscription("0bd856412b344270a717b95fc36a0245","southcentralus");
    	config.setSpeechRecognitionLanguage("es-mx");
    	
    	assert(config !=null);
        
    	SpeechRecognizer reco = new SpeechRecognizer(config);
    	assert (reco != null);
    	
    	System.out.println("Di algo: ");
    	
    	Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
    	assert (task!= null);
    	SpeechRecognitionResult result = task.get();
    	
    	switch (result.getReason()) {
        case RecognizedSpeech:
            System.out.println("We recognized: " + result.getText());
            exitCode = 0;
            break;
        case NoMatch:
            System.out.println("NOMATCH: Speech could not be recognized.");
            break;
        case Canceled: {
                CancellationDetails cancellation = CancellationDetails.fromResult(result);
                System.out.println("CANCELED: Reason=" + cancellation.getReason());

                if (cancellation.getReason() == CancellationReason.Error) {
                    System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
                    System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
                    System.out.println("CANCELED: Did you update the subscription info?");
                }
            }
            break;
    }
    	
    	
    	
    }
	
}
