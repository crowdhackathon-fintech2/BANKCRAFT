package eu.ptriantafyllopoulos.bankcraft.View;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import eu.ptriantafyllopoulos.bankcraft.View.fragments.LoaderFragment;

/**
 * Created by p.triantafyllopoulos on 20/10/2017.
 */

public class AppLoader {



    LoaderFragment loader;

    public void showLoader(Activity a,@DrawableRes int  res) {
        loader = LoaderFragment.getLoader(res);
        FragmentManager fm = a.getFragmentManager();
        loader.setCancelable(false);
        loader.show(fm, "Loader");
    }

    public void dismissLoader(Activity a) {
        FragmentManager fm = a.getFragmentManager();
        loader.dismiss();
    }
}
