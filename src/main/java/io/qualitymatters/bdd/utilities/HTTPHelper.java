package io.qualitymatters.bdd.utilities;

public interface HTTPHelper {

    String get(String url);
    String get(String url, String username, String password);
    
    String post(String url, String jsonBody);
    String post(String url, String jsonBody, String username, String password);
    
    String put(String url, String jsonBody);
    String put(String url, String jsonBody, String username, String password);
    
    String delete(String url);
    String delete(String url, String username, String password);

    void logResponseTime(String url);
    
}