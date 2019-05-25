
package com.example.saba.finalproject.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.saba.finalproject.R;
import com.example.saba.finalproject.model.IntermediateModel;
import java.util.List;
public class InterAdapter extends RecyclerView.Adapter<InterAdapter.ProductViewHolder> {
    private Context context;
    private List<IntermediateModel> interList;

    public InterAdapter(Context context, List<IntermediateModel> interList) {
        this.context = context;
        this.interList = interList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.intermediate_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        IntermediateModel product = interList.get(position);
        holder.textViewyear.setText(product.getYear());
        holder.textViewforms.setText(product.getForms_date());
        holder.textViewfees.setText(String.valueOf(product.getFee_date()));
        holder.textViewclasses.setText(String.valueOf(product.getClasses_date()));
    }

    @Override
    public int getItemCount() {
        return interList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewyear, textViewforms, textViewfees, textViewclasses;
        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewyear = itemView.findViewById(R.id.edit_year);
            textViewforms = itemView.findViewById(R.id.edit_forms);
            textViewfees = itemView.findViewById(R.id.edit_fees);
            textViewclasses = itemView.findViewById(R.id.edit_classes);
        }
    }
}


