package main;

import java.util.concurrent.Future;
import com.microsoft.cognitiveservices.speech.*;

public class Rec_voz {
	public static String voz_reconocida (String voz) {
	       try {
	    	   
	    	   
	            //Llave de subscripcion
	            String speechSubscriptionKey = "033d74d9b59040038cd22aa266351c97";
	            
	            //Region de cloud computing que nos da el servicio
	            String serviceRegion = "westus";

	            int exitCode = 1;
	            SpeechConfig config = SpeechConfig.fromSubscription(speechSubscriptionKey, serviceRegion);
	            assert(config != null);

	            SpeechRecognizer reco = new SpeechRecognizer(config);
	            assert(reco != null);

	            System.out.println("Di algo");

	            Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
	            assert(task != null);

	            SpeechRecognitionResult result = task.get();
	            assert(result != null);

	            if (result.getReason() == ResultReason.RecognizedSpeech) {
	                System.out.println("We recognized: " + result.getText());
	                voz =result.getText();
	                exitCode = 0;
	            }
	            else if (result.getReason() == ResultReason.NoMatch) {
	                System.out.println("NOMATCH: Speech could not be recognized.");
	            }
	            else if (result.getReason() == ResultReason.Canceled) {
	                CancellationDetails cancellation = CancellationDetails.fromResult(result);
	                System.out.println("CANCELED: Reason=" + cancellation.getReason());

	                if (cancellation.getReason() == CancellationReason.Error) {
	                    System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
	                    System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
	                    System.out.println("CANCELED: Did you update the subscription info?");
	                }
	            }

	            reco.close();

	            System.exit(exitCode);
	        } catch (Exception ex) {
	            System.out.println("Unexpected exception: " + ex.getMessage());

	            assert(false);
	            System.exit(1);
	        }
	       
	      
	       
	       return voz;
	    }
	
	

}
