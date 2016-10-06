package com.baekcedar.android.fragment_listpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentDetail extends Fragment {

    Data data;
    TextView textTitle;
    TextView textContents;
    public FragmentDetail() {
        // Required empty public constructor
    }
    public void setData(int position) {
        data = MainActivity.datas.get(position);
        textTitle.setText(data.title);
        textContents.setText(data.contents);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_detail, container, false);

        textTitle = (TextView) view.findViewById(R.id.textTitle);
        textContents = (TextView) view.findViewById(R.id.textContents);

        return view;
    }

}
