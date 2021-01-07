package com.task.gnrgy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class FragmentA extends Fragment   {


    TextView editText;
    ImageView img;
    ListView listView;

    String[] listItem;

    Fragment fragment ;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listItem = getResources().getStringArray(R.array.Planets);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                FrangmentB fragment = new  FrangmentB();
                final Bundle bundle = new Bundle();
                bundle.putString("text", editText.getText().toString());
                bundle.putString("listItem",value);

                changeFragment(bundle);
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_a, container, false);
        editText=view.findViewById(R.id.edt_text);
        img=view.findViewById(R.id.img_color);
        listView=view.findViewById(R.id.list_item);


        TextView color=getActivity().findViewById(R.id.text_time);
        String color1=color.getText().toString();
        if(color1.equals("red")){
            img.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red));
        }

        if(color1.equals("green")){
            img.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.green));
        }
        return  view;
    }


    public void changeFragment(Bundle bundle){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fragment = fm.findFragmentByTag("myFragmentTag");

            FragmentTransaction ft = fm.beginTransaction();
            fragment =new FrangmentB();
            ft.replace(R.id.frame_container,fragment,"myFragmentTag");
            fragment.setArguments(bundle);
            ft.commit();

    }

}