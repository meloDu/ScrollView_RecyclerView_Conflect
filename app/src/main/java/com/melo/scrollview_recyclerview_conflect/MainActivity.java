package com.melo.scrollview_recyclerview_conflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerCoverFlow mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList =findViewById(R.id.list);
        //        mList.setFlatFlow(true); //平面滚动
//        CoverFlowLayoutManger linearLayoutManager = new CoverFlowLayoutManger(this, CoverFlowLayoutManger.HORIZONTAL, false);
//        mList.setLayoutManager(linearLayoutManager);
        mList.setAdapter(new Adapter(this));
        mList.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
//                ((TextView)findViewById(R.id.index)).setText((position+1)+"/"+mList.getLayoutManager().getItemCount());
            }
        });
    }
}
