package me.ivt.com.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.List;

public class RecyclerItemTouchHelperActivity extends AppCompatActivity implements StartDragListener{
    
    private ItemTouchHelper mItemTouchHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_item_touch_helper);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        
        List<QQMessage> init = DataUtils.init();
        QQAdapter qqAdapter = new QQAdapter(this, init);
        recyclerView.setAdapter(qqAdapter);
        mItemTouchHelper = new ItemTouchHelper(new MyItemTouchHelperCallback(qqAdapter));
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        
    }
    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
