package eu.ptriantafyllopoulos.bankcraft.View.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.View.adapters.TransactionItemViewModel;
import eu.ptriantafyllopoulos.bankcraft.View.adapters.TransactionsListViewAdapter;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.UserTransactionsDAO;
import eu.ptriantafyllopoulos.bankcraft.utils.RuntimeStorage;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TransactionListFragment.OnTransactionListFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TransactionListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransactionListFragment extends Fragment {
    // the fragment initialization parameters
    private static final String TRANSACTION_DAO = "TRANSACTION_DAO";

    //Data
    UserTransactionsDAO incomingDao ;
    List<TransactionItemViewModel> items = new ArrayList<>();

    //View Variables
    //View fragmentView;
    private TransactionsListViewAdapter adapter;

    //Interaction Listener
    private OnTransactionListFragmentInteractionListener mListener;

    public TransactionListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TransactionListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TransactionListFragment newInstance() {
        TransactionListFragment fragment = new TransactionListFragment();
//        Bundle args = new Bundle();
//        args.putParcelable(TRANSACTION_DAO);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //getArguments().getParcelable(TRANSACTION_DAO);
        }
        incomingDao = (UserTransactionsDAO) RuntimeStorage.getInstance().getObject(TRANSACTION_DAO);
        if(incomingDao!=null){
            transformDAOToViewModel(incomingDao);
        }

    }

    private void transformDAOToViewModel(UserTransactionsDAO incomingDao) {
        List<UserTransactionsDAO.Transactions> tran = incomingDao.getTransactions();
        for (UserTransactionsDAO.Transactions t : tran){
            TransactionItemViewModel item = new TransactionItemViewModel(
                    t.getDescription(),
                    t.getDatetime(),
                    t.getAmount(),
                    t.getInvestedAmount());
            items.add(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpListView(view);
    }

    private void setUpListView(View view) {
        RecyclerView listView =view.findViewById(R.id.fragment_transactions_listview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) {};

        listView.setLayoutManager(linearLayoutManager);

        if (listView.getAdapter() == null) {

            adapter = new TransactionsListViewAdapter(getContext(),items);
            listView.setAdapter(adapter);

            listView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    //TODO DETECT SWIPE DOWN TO REFRESh
                }
            });

        }else{
            adapter = (TransactionsListViewAdapter) listView.getAdapter();
            if (adapter.getItems() == null) {
                adapter.setItems(new ArrayList<TransactionItemViewModel>());
            } else {
                adapter.getItems().clear();
                adapter.getItems().addAll(items);
            }

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTransactionListFragmentInteractionListener) {
            mListener = (OnTransactionListFragmentInteractionListener) context;
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

    public UserTransactionsDAO getIncomingDao() {
        return incomingDao;
    }

    public void setIncomingDao(UserTransactionsDAO incomingDao) {
        this.incomingDao = incomingDao;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnTransactionListFragmentInteractionListener {

    }
}
