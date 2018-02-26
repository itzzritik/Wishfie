package bhardwaj.prashant.wishfie;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.Holder> {
    private MainActivity context;
    private String tag[];
    private LayoutInflater inflater=null;
    TagAdapter(MainActivity context, String tag[]) {
        this.context = context;
        this.tag=tag;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public long getItemId(int position) {return position;}
    public class Holder extends RecyclerView.ViewHolder {
        TextView tag_name;

        public Holder(View view) {
            super(view);
            tag_name = view.findViewById(R.id.tag_name);
        }
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_tags, parent, false);
        return new Holder(itemView);
    }
    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        View view = inflater.inflate(R.layout.trending_items, null);
        view.setTag(position);
        holder.tag_name.setText(tag[position]);
    }
    @Override
    public int getItemCount() {return tag.length;}
}