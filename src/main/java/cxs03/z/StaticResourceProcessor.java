package cxs03.z;

import cxs03.z.connector.http.HttpRequest;
import cxs03.z.connector.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {
    public void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
