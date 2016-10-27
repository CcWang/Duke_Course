import edu.duke.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet="ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0; i<encrypted.length();i++){
            char currChar = encrypted.CharAt(i);
            
        }
    }
}
