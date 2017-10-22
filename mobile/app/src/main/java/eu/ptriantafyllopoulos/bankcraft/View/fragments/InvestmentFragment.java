package eu.ptriantafyllopoulos.bankcraft.View.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.utils.ServiceCallsKeys;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InvestmentFragment.OnInvestmentFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InvestmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InvestmentFragment extends Fragment implements View.OnClickListener {


    private OnInvestmentFragmentInteractionListener mListener;

    public InvestmentFragment() {
        // Required empty public constructor
    }

    public static InvestmentFragment newInstance() {
        return new InvestmentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        CardView lowCard,mediumCard,highCard,bitCard,ethCard,goldCard,platCard;
        View v = inflater.inflate(R.layout.fragment_investment, container, false);
        lowCard= v.findViewById(R.id.card_low_risk);
        mediumCard= v.findViewById(R.id.card_medium_risk);
        highCard= v.findViewById(R.id.card_high_risk);
        bitCard= v.findViewById(R.id.card_bitcoin);
        ethCard= v.findViewById(R.id.card_etherium);
        goldCard= v.findViewById(R.id.card_gold);
        platCard= v.findViewById(R.id.card_platinum);

        lowCard.setOnClickListener(this);
        mediumCard.setOnClickListener(this);
        highCard.setOnClickListener(this);
        bitCard.setOnClickListener(this);
        ethCard.setOnClickListener(this);
        goldCard.setOnClickListener(this);
        platCard.setOnClickListener(this);



        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInvestmentFragmentInteractionListener) {
            mListener = (OnInvestmentFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //Todo delete when recycler view is implemented
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_low_risk:
                mListener.onOptionClicked(ServiceCallsKeys.InvestOptionAliases.LOW_RISK);
                break;
            case R.id.card_medium_risk:
                mListener.onOptionClicked(ServiceCallsKeys.InvestOptionAliases.MEDIUM_RISK);
                break;
            case R.id.card_high_risk:
                mListener.onOptionClicked(ServiceCallsKeys.InvestOptionAliases.HIGH_RISK);
                break;
            case R.id.card_bitcoin:
                mListener.onOptionClicked(ServiceCallsKeys.InvestOptionAliases.BITCOIN);
                break;
            case R.id.card_etherium:
                mListener.onOptionClicked(ServiceCallsKeys.InvestOptionAliases.ETHERIUM);
                break;
            case R.id.card_gold:
                mListener.onOptionClicked(ServiceCallsKeys.InvestOptionAliases.GOLD);
                break;
            case R.id.card_platinum:
                mListener.onOptionClicked(ServiceCallsKeys.InvestOptionAliases.PLATINUM);
                break;
        }
    }

    public interface OnInvestmentFragmentInteractionListener {

        void onOptionClicked(int optKey);
    }
}
