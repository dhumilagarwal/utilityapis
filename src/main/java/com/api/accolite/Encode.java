package com.api.accolite;

public class Encode {

    public static void main(String args[]){

    }

    public String getDecryptedCode(String encodedText){
        int len = encodedText.length();
        if(len<=2) return encodedText;
        boolean isEven = false;
        if(len%2==0) isEven = true;
        else isEven = false;
        char decoded[] = new char[len];
        int index=1,offset=1;
        int mid = len/2;
        if(isEven){
            decoded[mid-1] = encodedText.charAt(0);
            decoded[mid] = encodedText.charAt(1);
            index = 2;
            while(index<len){
                decoded[mid-offset-1] = encodedText.charAt(index);
                decoded[mid+offset] = encodedText.charAt(index+1);
                index = index + 2;
                offset++;
            }
        } else {
            decoded[mid] = encodedText.charAt(0);
            while(index<len){
                decoded[mid-offset] = encodedText.charAt(index);
                decoded[mid+offset] = encodedText.charAt(index+1);
                index = index + 2;
                offset ++;
            }
        }
        String decodedText = String.valueOf(decoded);
        return decodedText;
    }
}
