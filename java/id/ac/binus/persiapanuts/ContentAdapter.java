package id.ac.binus.persiapanuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class ContentAdapter extends BaseAdapter {
    Context ctx;
    List<DataModel> shoesList;
    LayoutInflater inflater;

    public ContentAdapter(Context ctx, List<DataModel> shoesList) {
        this.ctx = ctx;
        this.shoesList = shoesList;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return shoesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.product_list,null);

        ImageView image = view.findViewById(R.id.imageData);
        TextView nama = view.findViewById(R.id.txtName);
        TextView harga = view.findViewById(R.id.txtPrice);

        image.setImageResource(shoesList.get(i).getImage());
        nama.setText(shoesList.get(i).getNama());
        harga.setText(shoesList.get(i).getHarga());

        return view;
    }
}
