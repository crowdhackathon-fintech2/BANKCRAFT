package eu.ptriantafyllopoulos.bankcraft.View.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eu.ptriantafyllopoulos.bankcraft.R;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class TransactionsListViewAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<TransactionItemViewModel> items = new ArrayList<>();


//    SETTERs - GETTERs

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<TransactionItemViewModel> getItems() {
        return items;
    }

    public void setItems(List<TransactionItemViewModel> items) {
        this.items = items;
    }

    //Constructors
    public TransactionsListViewAdapter(Context context, List<TransactionItemViewModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutRes = R.layout.transaction_row_item;
        View itemView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(layoutRes, parent, false);
        return new TransactionsListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        TransactionsListViewHolder viewHolder = (TransactionsListViewHolder) holder;

        TransactionItemViewModel item = items.get(position);

        if(item.getDescreption() != null) {
            viewHolder.description.setVisibility(View.VISIBLE);
            viewHolder.description.setText(item.getDescreption());

        }
        if(item.getDescreption() != null) {
            viewHolder.amount.setVisibility(View.VISIBLE);
            viewHolder.amount.setText(item.getDate());

        }
        if(item.getDescreption() != null) {
            viewHolder.date.setVisibility(View.VISIBLE);
            viewHolder.date.setText(String.valueOf(item.getAmount()));

        }
        if(item.getDescreption() != null) {
            viewHolder.investAmount.setVisibility(View.VISIBLE);
            viewHolder.investAmount.setText(String.valueOf(item.getInvestAmount()));

        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class TransactionsListViewHolder extends RecyclerView.ViewHolder {

        TextView description;
        TextView date;
        TextView amount;
        TextView investAmount;

        public TransactionsListViewHolder(View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.transaction_description);
            date = itemView.findViewById(R.id.transaction_date);
            amount = itemView.findViewById(R.id.transaction_amount);
            investAmount = itemView.findViewById(R.id.transaction_invest_amount);
        }
    }

    public void setUpdatedList(ArrayList<TransactionItemViewModel> listItems){
        this.items = listItems;
    }
}
