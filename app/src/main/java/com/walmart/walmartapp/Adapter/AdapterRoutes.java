package com.walmart.walmartapp.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.walmart.walmartapp.Entities.ClickInterface;
import com.walmart.walmartapp.Entities.ModelRoutes;
import com.walmart.walmartapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mints on 5/26/2016.
 */


public class AdapterRoutes extends
        RecyclerView.Adapter<RecyclerHolder> {// Recyclerview will extend to
    private List<ModelRoutes> arrayList;
    ClickInterface clickInterface;
    private Context context;
    public AdapterRoutes(Context context,
                         List<ModelRoutes> arrayList, ClickInterface clickInterface) {
        this.context = context;
        this.clickInterface=clickInterface;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, final int position) {
        final ModelRoutes model = arrayList.get(position);
        holder.tvTitle.setText(model.name);
        holder.header.setText(model.name);
        holder.txtDescription.setText(model.description);
        Glide.with(context).load(model.image).into(holder.image);
        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.getPosition(position);
            }
        });
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.row_route, viewGroup, false);
        RecyclerHolder listHolder = new RecyclerHolder(mainGroup,context);

        return listHolder;
    }
}

class RecyclerHolder extends RecyclerView.ViewHolder {
    // View holder for gridview recycler view as we used in listview
    public ImageView image;
    View mainView;
    TextView tvTitle,txtDescription,header;


    public RecyclerHolder(View view, final Context context)  {
        super(view);
        tvTitle= (TextView) itemView.findViewById(R.id.txtTitle);
        txtDescription= (TextView) itemView.findViewById(R.id.tvDesc);
        image=itemView.findViewById(R.id.image);
        header=itemView.findViewById(R.id.header);
        mainView= itemView.findViewById(R.id.mainView);
        // Find all views ids
    }
}
