package bhardwaj.prashant.wishfie;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CreatorAdapter extends RecyclerView.Adapter<CreatorAdapter.Holder> {
    private MainActivity context;
    private String opinion[], name[];
    private Bitmap DP[];
    private LayoutInflater inflater=null;
    CreatorAdapter(MainActivity context, Bitmap DP[],String name[],String opinion[]) {
        this.context = context;
        this.opinion = opinion;
        this.name = name;
        this.DP = DP;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public long getItemId(int position) {return position;}
    public class Holder extends RecyclerView.ViewHolder {
        ImageView creatorDP;
        TextView creator_name, opinion_count;

        public Holder(View view) {
            super(view);
            creatorDP = view.findViewById(R.id.creatorDP);
            creator_name = view.findViewById(R.id.creator_name);
            opinion_count = view.findViewById(R.id.opinion_count);
        }
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_creators, parent, false);
        return new Holder(itemView);
    }
    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        View view = inflater.inflate(R.layout.trending_items, null);
        view.setTag(position);
        holder.creatorDP.setImageBitmap(DP[position]);
        holder.creator_name.setText("#"+(position+1)+" "+name[position]);
        holder.opinion_count.setText(opinion[position]+" Opinions");
    }
    @Override
    public int getItemCount() {return name.length;}
}