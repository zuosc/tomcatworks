package cxs02;

import java.io.IOException;

class StaticResourceProcessor {
    void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
