import edu.duke.*;
import java.util.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabetU="ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        String alphabetL="abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = alphabetU.substring(key)+alphabetU.substring(0,key);
        String shiftedAlphabetL = alphabetL.substring(key)+alphabetL.substring(0,key);
        for(int i=0; i<encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar)){
                int idxL=alphabetL.indexOf(currChar);
                if(idxL !=-1){
                    char newCharL=shiftedAlphabetL.charAt(idxL);
                    encrypted.setCharAt(i,newCharL);
                };
            }else{
                int idx = alphabetU.indexOf(currChar);
                if(idx !=-1){
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            };
            
        };
    return encrypted.toString();
    }
    
    public void testCaesar(){
        int key =17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message,key);
        System.out.println(encrypted);
        String decryted=encrypt(encrypted,26-key);
        System.out.println(decryted);
    };
}
