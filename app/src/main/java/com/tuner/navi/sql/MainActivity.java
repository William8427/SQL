package com.tuner.navi.sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final boolean LOGIN = false;
    public String[] funs;
    int[] icon = {
            R.drawable.i_balance,
            R.drawable.i_history,
            R.drawable.i_news,
            R.drawable.i_finance,
            R.drawable.i_exit,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!LOGIN)
        {
            startActivityForResult(new Intent(this,loginActivity.class), 100);
        }
        funs = getResources().getStringArray(R.array.functions);
        GridView gridView = findViewById(R.id.grid);
        IconAdapter adapter = new IconAdapter();
        gridView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK)
        {
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }
    }

    class IconAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return funs.length;
        }

        @Override
        public Object getItem(int i) {
            return funs[i];
        }

        @Override
        public long getItemId(int i) {
            return icon[i];
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View row = view;
            if (row == null)
            {
                row = getLayoutInflater().inflate(R.layout.icon, null);
            }
            ImageView imageView = findViewById(R.id.ig_icon);
            TextView textView = findViewById(R.id.tv_tit);
            imageView.setImageResource(icon[i]);
            textView.setText(funs[i]);
            return row;
        }
    }
}
