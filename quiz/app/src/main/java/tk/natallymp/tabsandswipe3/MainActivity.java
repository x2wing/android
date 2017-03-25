package tk.natallymp.tabsandswipe3;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    Context context;
    //public CharSequence[] CurrentAnswers;
    private static int pageNumber;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();
                //SelectDialog(CurrentAnswers);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

    }

    public  void SelectDialog(CharSequence[] Answer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //заголовок всплывающего окна
        builder.setTitle(R.string.message);


        //списко элеменотов всплывающего окна
        final CharSequence[] items = Answer;


        builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0: {

                                Toast.makeText(context, "1", Toast.LENGTH_LONG).show();
                                break;
                            }
                            case 1: {

                                Toast.makeText(context,  "2", Toast.LENGTH_LONG).show();
                                break;
                            }
                            case 2: {

                                Toast.makeText(context, "3", Toast.LENGTH_LONG).show();
                                break;
                            }
                        }


                    }
                }
        );

        AlertDialog alert = builder.create();
        alert.show();
    }





    /**
     * A placeholder fragment containing a simple view.
     */



    public static class FirstActivity extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final CharSequence [] CurrentAnswers = {
                "Лопос-темпл",
                "Кутуб-Минар",
                "Тадж-Махал",
                "Храм Кайласа"};

        public static CharSequence [] getCurrentAnswers(){return CurrentAnswers;}



        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FirstActivity newInstance(int sectionNumber) {
            FirstActivity fragment = new FirstActivity();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onStart(){
            super.onStart();
            pageNumber = getArguments().getInt(ARG_SECTION_NUMBER);

        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.first_tab, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label1);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


            return rootView;
        }
    }

    public static class SecondActivity extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";


        private static final CharSequence [] CurrentAnswers = {
                "Агра",
                "Джайпур",
                "Нью-Дели",
                "Калькутта"};

        public static CharSequence [] getCurrentAnswers(){return CurrentAnswers;}



        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static SecondActivity newInstance(int sectionNumber) {
            SecondActivity fragment = new SecondActivity();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onStart(){
            super.onStart();
            pageNumber = getArguments().getInt(ARG_SECTION_NUMBER);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.second_tab, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label2);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


            return rootView;
        }
    }

    public static class ThirdActivity extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        private static final CharSequence [] CurrentAnswers = {
                "18 лет",
                "25 лет",
                "21 год",
                "16 лет"};

        public static CharSequence [] getCurrentAnswers(){return CurrentAnswers;}



        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ThirdActivity newInstance(int sectionNumber) {
            ThirdActivity fragment = new ThirdActivity();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public void onStart(){
            super.onStart();
            pageNumber = getArguments().getInt(ARG_SECTION_NUMBER);

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.third_tab, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label3);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            Fragment fragment=null;
            Bundle args;
            switch (position) {
                case 0:
                    fragment = new FirstActivity();
                    args = new Bundle();
                    args.putInt(FirstActivity.ARG_SECTION_NUMBER, position + 1);
                    fragment.setArguments(args);
                    Toast.makeText(context, String.valueOf(position), Toast.LENGTH_SHORT).show();


                    break;
                case 1:
                    fragment = new SecondActivity();
                    args = new Bundle();
                    args.putInt(SecondActivity.ARG_SECTION_NUMBER, position + 1);
                    fragment.setArguments(args);
                    //Toast.makeText(context, position, Toast.LENGTH_SHORT).show();


                    break;
                case 2:
                    fragment = new ThirdActivity();
                    args = new Bundle();
                    args.putInt(ThirdActivity.ARG_SECTION_NUMBER, position + 1);
                    fragment.setArguments(args);
                    //Toast.makeText(context, position, Toast.LENGTH_SHORT).show();

                    break;
            }
            return fragment;
        }







        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.title_section1);
                case 1:
                    return getString(R.string.title_section2);
                case 2:
                    return getString(R.string.title_section3);
            }
            return null;
        }
    }
}
