package com.vi.lavenganza20.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vi.lavenganza20.R;
import com.vi.lavenganza20.view.fragment.HomeFragment;
import com.vi.lavenganza20.view.fragment.ProfileFragment;
import com.vi.lavenganza20.view.fragment.SearchFragment;

@SuppressWarnings("ALL")
public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemReselectedListener(
                new BottomNavigationView.OnNavigationItemReselectedListener() {
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {
                        Fragment selectedFragment=null;
                        switch (item.getItemId()){
                            case R.id.search:
                                selectedFragment=new SearchFragment();
                                break;
                            case R.id.home:
                                selectedFragment=new HomeFragment();
                                break;
                            case R.id.profile:
                                selectedFragment=new ProfileFragment();
                                break;
                        }
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_frame,selectedFragment)
                                .commit();
                    }
                }
        );
    }
}