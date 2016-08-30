package com.example.admin.testczytnikkodow;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class customAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] tab1;
    private final String[] tab2;
    private final String[] tab3;

    public customAdapter(Activity context,
                         String[] zma, String[] zma1, String[] zma2) {
        super(context, R.layout.custom_row, zma);
        this.context = context;
        this.tab1 = zma;
        this.tab2 = zma1;
        this.tab3 = zma2;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_row, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView2);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.textView3);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.textView4);

        txtTitle.setText(tab1[position]);
        txtTitle1.setText(tab2[position]);
        txtTitle2.setText(tab3[position]);

        return rowView;


    }
}
