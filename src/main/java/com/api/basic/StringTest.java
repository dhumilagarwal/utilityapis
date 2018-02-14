package com.api.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class StringTest {

    public static void main(String args[]){
        String test = "vgvufegvu fvuefvu";
        char arr[] = test.toCharArray();
        int len=arr.length;
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
        }
        URL proxy_url = null;
        String http_Proxy_url = "http://web-proxy.ind.hp.com:8080";
        try {
            proxy_url = new java.net.URL(http_Proxy_url);
        } catch (MalformedURLException exception){
            exception.printStackTrace();
        }
        String hostname = proxy_url.getHost();
        int port = proxy_url.getPort();
        if(port==-1)
            port = proxy_url.getDefaultPort();
        String portNumber = String.valueOf(port);
        System.setProperty("http.proxyHost", hostname);
        System.setProperty("http.proxyPort",portNumber);
        System.out.println(System.getProperty("http.proxyHost"));
        System.out.println(System.getProperty("http.proxyPort"));
    }
}
