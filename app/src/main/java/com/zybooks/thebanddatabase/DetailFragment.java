package com.zybooks.thebanddatabase;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    public static final String ARG_BAND_ID = "band_id";
    private Band mBand;
    public DetailFragment() {
        // Required empty public constructor
    }
    ///////////////////////
    public String urlStr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int bandId = 1;

        // Get the band ID from the fragment arguments
        Bundle args = getArguments();
        if (args != null) {
            bandId = args.getInt(ARG_BAND_ID);
        }

        // Get the selected band
        mBand = BandRepository.getInstance(requireContext()).getBand(bandId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        if (mBand != null) {
            TextView nameTextView = rootView.findViewById(R.id.band_name);
            nameTextView.setText(mBand.getName());

            TextView descriptionTextView = rootView.findViewById(R.id.band_description);
            descriptionTextView.setText(mBand.getDescription());

            String nameStr = mBand.getName();

            //String nameStr = mBand.getName();
            ImageView imgV = rootView.findViewById(R.id.imageViewID);
            if (nameStr.contains("BTS")) {
                WanVariables.getInstance().urlStr = "https://en.wikipedia.org/wiki/BTS";
                imgV.setImageResource(R.drawable.bts_image);
            }
            else if (nameStr.contains("Beatles"))
            {
                WanVariables.getInstance().urlStr = "https://www.thebeatles.com/";
                imgV.setImageResource(R.drawable.bettles);
            }
            else if (nameStr.contains("U2"))
            {
                WanVariables.getInstance().urlStr = "https://www.u2.com/";
                imgV.setImageResource(R.drawable.utwo);
            }
            else if (nameStr.contains("Nirva"))
            {
                WanVariables.getInstance().urlStr = "https://www.nirvana.com/";
                imgV.setImageResource(R.drawable.nirvana);
            }
        }
        return rootView;
    }

}