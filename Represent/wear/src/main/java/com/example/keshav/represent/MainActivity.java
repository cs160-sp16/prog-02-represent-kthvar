package com.example.keshav.represent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends WearableActivity {

    //    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
//            new SimpleDateFormat("HH:mm", Locale.US);
//
    public TextView candidate;
    public String zipCodeEntry;
    public String nameEntry;
    public String partyEntry;
    public String[] names;
    public String[] parties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();
        Intent wintent = getIntent();
        Bundle extras = wintent.getExtras();
        Log.d("extras", String.valueOf(extras));
        if (extras != null) {
            zipCodeEntry = extras.getString("zipcode");
            nameEntry=extras.getString("name");
            partyEntry=extras.getString("party");

        }
        Log.d("names",nameEntry);
        names=nameEntry.split("^");
        Log.d("name",names[0]);
        parties=partyEntry.split("^");
        ViewPager candidatePager = new ViewPager(this);
        candidatePager.setId(R.id.pager_id);
        CandidatePagerAdapter pagerAdapter = new CandidatePagerAdapter(getFragmentManager());
        pagerAdapter.setZipCode(zipCodeEntry);
        pagerAdapter.setNames(names);
        pagerAdapter.setParties(parties);
        candidatePager.setAdapter(pagerAdapter);

        FrameLayout pagerContainer = (FrameLayout) findViewById(R.id.pager_container);
        pagerContainer.addView(candidatePager);

        //mContainerView = (RelativeLayout) findViewById(R.id.container);
        /*candidate = (TextView) findViewById(R.id.rep_party);
        candidate.setText("Barbara Boxer" +
                "       DEMOCRAT");


        candidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(getBaseContext(), WatchToPhoneService.class); //phone
                startService(phoneIntent);

                Intent electionIntent = new Intent(MainActivity.this, obamaromney.class); //watch
                if (zipCodeEntry != null) {
                    electionIntent.putExtra("ZIP_CODE", zipCodeEntry);
                }
                startActivity(electionIntent);
            }
        });*/
    }
}