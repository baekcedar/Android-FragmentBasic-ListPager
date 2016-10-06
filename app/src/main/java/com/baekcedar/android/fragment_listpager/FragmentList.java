package com.baekcedar.android.fragment_listpager;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentList extends Fragment {
    ListView listView;
    final int DETAILPAGE = 1;

    MainActivity main = (MainActivity)getActivity();
    public FragmentList() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_list, container, false);
        listView = (ListView) view.findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //TODO 아이템 클릭시 디테일 화면 이동
                Log.i("Test","click");
                MainActivity main = (MainActivity)getActivity();
                main.setData(position);
                main.pager.setCurrentItem(DETAILPAGE);

            }
        });

        return view;


    }

}
class CustomAdapter extends BaseAdapter{

    Context context;
    LayoutInflater inflater;

    public CustomAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return MainActivity.datas.size();
    }

    @Override
    public Object getItem(int position) {
        return MainActivity.datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = inflater.inflate(R.layout.fragment_item, null);

        TextView title = (TextView) convertView.findViewById(R.id.textView);
        title.setText(MainActivity.datas.get(position).title);

        return convertView;
    }
}

