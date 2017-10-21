package eu.ptriantafyllopoulos.bankcraft.View.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.View.loadingWidget.WaveDrawable;

/**
 * Created by p.triantafyllopoulos on 20/10/2017.
 */

public class LoaderFragment extends android.app.DialogFragment {

    private static final String RES_TAG = "RES_TAG";
    WaveDrawable watermelonWave;
    ImageView loaderImageView ;
    @DrawableRes int loaderRes;
    public static LoaderFragment getLoader(@DrawableRes int loaderRes) {
        LoaderFragment fragment = new LoaderFragment();
        Bundle args = new Bundle();
        args.putInt(RES_TAG, loaderRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            loaderRes = getArguments().getInt(RES_TAG);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_loader, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        loaderImageView = (ImageView) v.findViewById(R.id.loader_image);
        watermelonWave = new WaveDrawable(getActivity(), loaderRes);
        loaderImageView.setImageDrawable(watermelonWave);
        watermelonWave.setIndeterminate(true);
        getDialog().setCanceledOnTouchOutside(false);


        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
