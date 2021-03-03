package edu.qc.seclass.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("81SKyXPr8RgPmssCGfRLB0ixHtmTTXwA4fV0YFNs")
                .clientKey("nm5d1xU9GlmqeBXHuNDmvKuQNphJeeyAf4MBnhr0")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}
