package com.walmart.walmartapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.walmart.walmartapp.Entities.ClickInterface;
import com.walmart.walmartapp.Entities.ModelRoutes;
import com.walmart.walmartapp.R;

import java.util.List;

/**
 * Created by Mints on 5/26/2016.
 */


public class AdapterStops extends
        RecyclerView.Adapter<StopsHolder> {// Recyclerview will extend to
    private List<ModelRoutes.Stops> arrayList;
    private Context context;
    public AdapterStops(Context context,
                        List<ModelRoutes.Stops> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(StopsHolder holder, final int position) {
        final ModelRoutes.Stops model = arrayList.get(position);
        holder.routeName.setText(model.name);

        if(position==arrayList.size()-1){
            holder.verticalView.setVisibility(View.INVISIBLE);
        }else{
            holder.verticalView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public StopsHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.row_route_row, viewGroup, false);
        StopsHolder listHolder = new StopsHolder(mainGroup);

        return listHolder;
    }
}

class StopsHolder extends RecyclerView.ViewHolder{
    TextView routeName;
    View verticalView;

    public StopsHolder(View itemView) {
        super(itemView);
        routeName=itemView.findViewById(R.id.routeName);
        verticalView=itemView.findViewById(R.id.verticalView);
    }
}

