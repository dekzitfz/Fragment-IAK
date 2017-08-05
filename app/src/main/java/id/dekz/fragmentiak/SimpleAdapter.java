package id.dekz.fragmentiak;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEKZ on 8/5/2017.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewholder> {

    private List<String> data = new ArrayList<>();
    OnItemClickListener clickListener;

    public interface OnItemClickListener{
        void onItemClick(String text);
    }

    public SimpleAdapter() {}

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public SimpleViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleViewholder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_rv, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(SimpleViewholder holder, int position) {
        final String txt = data.get(position);
        holder.text.setText(txt);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(txt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SimpleViewholder extends RecyclerView.ViewHolder{

        TextView text;

        public SimpleViewholder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
