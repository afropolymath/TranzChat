/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tranzchat;

import com.gtranslate.Language;

/**
 *
 * @author Chidi
 */
public class TranzChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vars.init();
        // TODO code application logic here
        // Language.getInstance().getNameLanguage("en")
        //System.out.println(Vars.getLanguagePrefix("Good boy"));
        System.out.println(Vars.SpeakWords("Good morning son", null, Language.POLISH, true));
        new MainScreen().setVisible(true);
    }
    
}
