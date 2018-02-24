package com.example.tan.testgallery;

import java.io.Serializable;

/**
 * Created by Tan on 2/22/2018.
 */

public class Actor implements Serializable {
    private String name;
    private String url;

    public Actor(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
