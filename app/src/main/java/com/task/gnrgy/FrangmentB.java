package com.task.gnrgy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FrangmentB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrangmentB extends Fragment {



    TextView textView,itemListText;
    public static FrangmentB newInstance(String param1, String param2) {
        FrangmentB fragment = new FrangmentB();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_frangment_b, container, false);
        textView=view.findViewById(R.id.text1);
        itemListText=view.findViewById(R.id.itemList);

        Bundle args = getArguments();


        if (args  != null){
            String text = args.getString("text");
            String itemList=args.getString("listItem");
            textView.setText(text);
            itemListText.setText(itemList);

            Log.e("onCreate","cre"+text+itemList);
        }
        return view;
    }
}