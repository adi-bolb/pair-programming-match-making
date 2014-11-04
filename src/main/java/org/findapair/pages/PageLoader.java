package org.findapair.pages;

import org.findapair.ThisShouldNeverHappenException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PageLoader {
    public String loadPage(String pageName) {
        try {
            URI pageUri = getPageResource(pageName);
            Path pagePath = Paths.get(pageUri);
            return new String(Files.readAllBytes(pagePath));

        } catch (URISyntaxException | IOException e) {
            throw new ThisShouldNeverHappenException(e);
        }
    }

    private URI getPageResource(String pageName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("pages/" + pageName);
        if(resource != null)  return resource.toURI();
        return new URI("");
    }
}
