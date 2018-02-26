package bhardwaj.prashant.wishfie;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private String topic[], name[];
    private Bitmap pic[], DP[];
    Adapter(String trending_topic[], String trending_name[], Bitmap trending_pic[], Bitmap circleDP[]) {
        this.topic = trending_topic;
        this.name = trending_name;
        this.pic = trending_pic;
        this.DP = circleDP;
    }
    @Override
    public long getItemId(int position) {return position;}
    public class Holder extends RecyclerView.ViewHolder {
        ImageView trending_pic, circleDP;
        TextView trending_topic, trending_name;

        public Holder(View view) {
            super(view);
            trending_pic = view.findViewById(R.id.trending_pic);
            circleDP = view.findViewById(R.id.circleDP);
            trending_topic = view.findViewById(R.id.trending_topic);
            trending_name = view.findViewById(R.id.trending_name);
        }
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_items, parent, false);
        return new Holder(itemView);
    }
    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.trending_pic.setImageBitmap(pic[position]);
        holder.circleDP.setImageBitmap(DP[position]);
        holder.trending_topic.setText(topic[position]);
        holder.trending_name.setText(name[position]);
    }
    @Override
    public int getItemCount() {return topic.length;}
}