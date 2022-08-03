package com.example.learningapp_forkids;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    int color[] = {R.drawable.b0,R.drawable.b1, R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,};
    MediaPlayer mp = new MediaPlayer();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ColorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ColorFragment newInstance(String param1, String param2) {
        ColorFragment fragment = new ColorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_animal, container, false);

        ImageView iv = v.findViewById(R.id.imageView3);
        iv.setImageResource(color[0]);

        GridView gv = v.findViewById(R.id.gridview2);
        gv.setNumColumns(color.length);
        gv.setAdapter(new ColorFragment.ImageAdapter(getContext()));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(color[position]);

                int mid = getResources().getIdentifier("b"+position,"raw",getActivity().getPackageName());

                if(mp.isPlaying())
                    mp.stop();
                mp = MediaPlayer.create(getContext(), mid);
                mp.start();

            }
        });

        return v;


    }

    class ImageAdapter extends BaseAdapter {
        Context context;
        public ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return color.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView iv = new ImageView(context);
            iv.setImageResource(color[position]);
            iv.setLayoutParams(new ViewGroup.LayoutParams(200,200));

            return iv;
        }
    }
}