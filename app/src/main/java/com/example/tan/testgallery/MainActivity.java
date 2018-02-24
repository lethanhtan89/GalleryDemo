package com.example.tan.testgallery;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;

    public static MainActivity getInstance() {
        if (instance == null)
            instance = new MainActivity();
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        GalleryFragment galleryFragment = new GalleryFragment();
        fragmentManager.beginTransaction().replace(R.id.fr_main, galleryFragment).commit();
    }
}
