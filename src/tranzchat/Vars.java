package tranzchat;
import com.firebase.client.Firebase;
import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import java.io.InputStream;

/**
 *
 * @author goodson
 */
public class Vars {
    
    public static Firebase dbcon = null;
    public static Translator gTranslate = null;
       
    public static void init() {
        gTranslate = Translator.getInstance();
        dbcon = new Firebase("https://tranzchat.firebaseio.com/");
    }
    public static String getLanguagePrefix(String textContent)
    {
        String languagePrefix = "";
        try
        {
            languagePrefix = gTranslate.detect(textContent);
        }
        catch(Exception e0)
        {
            e0.printStackTrace();
        }
        return languagePrefix;
    }
    public static String SpeakWords(String textContent, String inputLanguage, String outputLanguage, boolean speak)
    {
        String result = textContent;        
        try
        {
            inputLanguage = inputLanguage == null ? Language.ENGLISH : inputLanguage;
            result = gTranslate.translate(textContent, inputLanguage , outputLanguage);
            
            if(speak)
            {
                Audio audio = Audio.getInstance();
                InputStream sound  = audio.getAudio(result,outputLanguage);
                audio.play(sound);
            }
        }
        catch(Exception e0)
        {
            e0.printStackTrace();
        }
        return result;
    }
    
    
}
