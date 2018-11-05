package fauzi.hilmy.basket_team;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fauzi.hilmy.basket_team.model.TeamsItem;

import static fauzi.hilmy.basket_team.DetailActivity.EXTRA_TEAM;

public class AdapterClub extends RecyclerView.Adapter<AdapterClub.MyViewHolder> {
    private List<TeamsItem> item;
    private Context context;

    public AdapterClub(List<TeamsItem> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterClub.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClub.MyViewHolder myViewHolder, final int i) {
        Picasso.get()
                .load(item.get(i).getStrTeamBadge())
                .fit()
                .into(myViewHolder.imgClub);

        myViewHolder.txtClub.setText(item.get(i).getStrTeam());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(EXTRA_TEAM, item.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgClub;
        TextView txtClub;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgClub = itemView.findViewById(R.id.imgClub);
            txtClub = itemView.findViewById(R.id.txtClub);
        }
    }
}
