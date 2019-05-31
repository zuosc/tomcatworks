package com.z.cxs01;

import java.io.InputStream;

class Request {

    private InputStream input;
    private String uri;

    Request(InputStream input) {
        this.input = input;
    }

    void parse() {

        int i;
        byte[] buffer = new byte[2048];
        try {
            i = input.read(buffer);
        } catch (Exception ex) {
            ex.printStackTrace();
            i = -1;
        }

        StringBuffer request = new StringBuffer(2048);
        for (int j = 0; j <i ; j++) {
            request.append((char)buffer[j]);
        }
        System.out.print(request.toString());
        uri = parseUri(request.toString());
    }

    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }

    String getUri() {
        return uri;
    }
}
