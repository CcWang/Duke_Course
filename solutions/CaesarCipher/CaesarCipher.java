import edu.duke.*;
import java.util.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabetU;
    private String alphabetL;
    private String shiftedAlphabet;
    private String shiftedAlphabetL;
    
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        alphabetU="ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        alphabetL="abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabetU.substring(key)+alphabetU.substring(0,key);
        shiftedAlphabetL = alphabetL.substring(key)+alphabetL.substring(0,key);
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
    };
    
    public String encryotTwoKeys(String input, int key1,int key2){
        StringBuilder sb = new StringBuilder(input);
        String albLower = "abcdefghijklmnopqrstuvwxyz";
        String albUpper = albLower.toUpperCase();
        String key1Lower = albLower.substring(key1)+albLower.substring(0,key1);
        String key1Upper = key1Lower.toUpperCase();
        String key2Lower = albLower.substring(key2)+albLower.substring(0,key2);
        String key2Upper = key2Lower.toUpperCase();
        for(int i=0;i<input.length();i++){
            char current = sb.charAt(i);
            if(Character.isLowerCase(current)){
                int idxL=albLower.indexOf(current);
                if(idxL!=-1){
                    if(i%2==0){
                        char newChar = key1Lower.charAt(idxL);
                        sb.setCharAt(i,newChar);
                    }else{
                        char newChar = key2Lower.charAt(idxL);
                        sb.setCharAt(i,newChar);
                    }
                }
            }else{
                int idxU=albUpper.indexOf(current);
                if(idxU !=-1){
                    if(i%2==0){
                        char newChar = key1Upper.charAt(idxU);
                        sb.setCharAt(i,newChar);
                    }else{
                        char newChar = key2Upper.charAt(idxU);
                        sb.setCharAt(i,newChar);
                    }
                };
            }
        };
        return sb.toString();
    };
    
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
