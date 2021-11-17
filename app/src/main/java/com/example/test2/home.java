package com.example.test2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {
    ListView listView;
    ViewPager pager;
    TabLayout tabLayout;
    List<Listitem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView = findViewById(R.id.listview);
        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab);
        list = new ArrayList<>();


        Listitem listitem = new Listitem("thane", "mulund", "8/11/2021");
        list.add(listitem);
        Listitem listitem1 = new Listitem("thane", "mulund", "8/11/2021");
        list.add(listitem1);

        ListAdapter adapter = new ListAdapter(home.this, R.layout.activity_row, list);
        listView.setAdapter(adapter);


        // view pager integrstion

        PagerAdaper pagerAdaper = new PagerAdaper(getSupportFragmentManager());
        pager.setAdapter(pagerAdaper);
        pager.setCurrentItem(1);
        tabLayout.setupWithViewPager(pager);


    }

    public class PagerAdaper extends FragmentPagerAdapter {

        public PagerAdaper(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

           /* if (position<3) return new Page1();
            else return new Page2();*/


/*
            switch (position) {
                case 0:
                    return new Page1();
                case 1:
                    return new Page2();
                case 3:
                    return new Page2();
                case 4:
                    return new Page1();
                case 5:
                    return new Page2();
                case 6:
                    return new Page2();
                case 7:
                    return new Page1();
                case 8:
                    return new Page2();
                case 9:
                    return new Page1();
                case 2:
                    return new Page1();
                default:
                    return null;

            }
*/

            return new Page1(position);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
//            return super.getPageTitle(position);

        return ""+position;
        }
    }

    public class ListAdapter extends ArrayAdapter<Listitem> {

        List<Listitem> list;
        Context context1;
        int resource;

        public ListAdapter(@NonNull Context context, int resource, @NonNull List<Listitem> objects) {
            super(context, resource, objects);
            this.list = objects;
            context1 = context;
            this.resource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = LayoutInflater.from(context1).inflate(resource, parent, false);
            TextView source = view.findViewById(R.id.source);
            source.setText(list.get(position).getSource());
            TextView destination = view.findViewById(R.id.destination);
            destination.setText(list.get(position).getDestination());
            TextView date = view.findViewById(R.id.date);
            date.setText(list.get(position).getDate());
            return view;
        }

        @Override
        public int getCount() {
            return list.size();
        }
        @Nullable
        @Override
        public Listitem getItem(int position) {
            return super.getItem(position);
        }
    }
}