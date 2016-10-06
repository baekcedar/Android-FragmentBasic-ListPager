package com.baekcedar.android.fragment_listpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Data> datas = new ArrayList<>();
    FragmentList fragmentList;
    FragmentDetail fragmentDetail;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentList    = new FragmentList();
        fragmentDetail  = new FragmentDetail();
        // 데이터 삽입
        for (int i = 1; i <= 200; i++) {
            Data data = new Data();
            data.title = "Title" + i;
            data.contents = "context" + i;
            datas.add(data);
        }
        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

    }


    public void setData(int position){
        Log.i("test","111111");
        fragmentDetail.setData(position);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        private boolean enabled; //이 것이 스크롤을 막아주는 중요 변수!
        // 프레그먼트 아답터를 생성하기 위해 프래그먼트 매니저를 생성자에 넘겨주고
        // 부모 아답터가 초기화 하여야 한다.
        public PagerAdapter(FragmentManager fm) { //생성자
            super(fm); // 부모인 FragmentStatePagerAdapter 에 매니저를 넘김

        }


        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;

            return fragment;
        }


        @Override
        public int getCount() {
            return 2;
        }

    }

}
