package com.example.learningapp_forkids;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class MyAdapter extends FragmentStateAdapter {

    public MyAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 : return new AlphabetFragment();
            case 1 : return new ShapeFragment();
            case 2 : return new AnimalFragment();
            case 3 : return new ColorFragment();
            case 4 : return new videosFragment();

        }
        return new videosFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
