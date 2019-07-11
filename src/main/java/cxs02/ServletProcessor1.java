package cxs02;


import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

class ServletProcessor1 {
    void process(Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;

        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);

            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator))
                    .toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
