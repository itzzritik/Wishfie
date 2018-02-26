package bhardwaj.prashant.wishfie;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.Holder> {
    private String name[], pin[];
    private Bitmap flag[];

    CountryListAdapter(String name[], String pin[], Bitmap flag[]) {
        this.pin = pin;
        this.name = name;
        this.flag = flag;
    }
    @Override
    public long getItemId(int position) {return position;}
    public class Holder extends RecyclerView.ViewHolder {
        ImageView country_flag;
        TextView country_name, country_pin;

        public Holder(View view) {
            super(view);
            country_flag = view.findViewById(R.id.flag);
            country_name = view.findViewById(R.id.country_name);
            country_pin = view.findViewById(R.id.phone_pin);
        }
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list, parent, false);
        return new Holder(itemView);
    }
    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.country_flag.setImageBitmap(flag[position]);
        holder.country_name.setText(name[position]);
        holder.country_pin.setText("+"+pin[position]);
    }
    @Override
    public int getItemCount() {return name.length;}
}