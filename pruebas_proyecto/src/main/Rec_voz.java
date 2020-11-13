package main;

import java.util.concurrent.Future;

import javax.swing.JOptionPane;

import com.microsoft.cognitiveservices.speech.*;

public class Rec_voz {
	
	public boolean paso;
	
	public  String voz_reconocida (String voz) {
	       try {
	    	   
	    	   String Entrada = "";
	    	   paso =false;
	    	   
	            //Llave de subscripcion
	            String speechSubscriptionKey = "ef568f62015c4a50a113305c86dbc84e";
	            
	            //Region de cloud computing que nos da el servicio
	            String serviceRegion = "southcentralus";

	            int exitCode = 1;
	            SpeechConfig config = SpeechConfig.fromSubscription(speechSubscriptionKey, serviceRegion);
	            config.setSpeechRecognitionLanguage("es-mx");
	            assert(config != null);

	            SpeechRecognizer reco = new SpeechRecognizer(config);
	            assert(reco != null);

	            System.out.println("Di algo");

	            Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
	            assert(task != null);

	            SpeechRecognitionResult result = task.get();
	            assert(result != null);

	            if (result.getReason() == ResultReason.RecognizedSpeech) {
	                System.out.println(result.getText());
	               	Entrada=result.getText();
	                //Validacion para las palabras
	                Eliminar_Espacios delete = new Eliminar_Espacios();  
	              
	            
	              if (Entrada !=" ") {
	             	 
	             	 System.out.println("La letra pronunciada fue: "+delete.EliminarEspacios(Entrada));
	             	 paso=true;
	             	 
	             	 
	              }
	                
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
                 
              
            
                
	            //System.exit(exitCode);
	        } catch (Exception ex) {
	            System.out.println("Unexpected exception: " + ex.getMessage());

	            assert(false);
	            System.exit(1);
	            JOptionPane.showMessageDialog(null, "Entro mensaje");
	        }
	
	       
	    return voz;

	


	
	

	}
	}
