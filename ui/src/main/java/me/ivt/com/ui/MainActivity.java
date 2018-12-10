package me.ivt.com.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private ArrayAdapter<String> mStringArrayAdapter;
    List<String> mStrings = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
            
        }
        mStringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mStrings);
    }
    
    public void go1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("女朋友");
        builder.setMessage("给我一个女朋友");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                
            }
        });
        builder.show();
        
    }
    
    public void go2(View view) {
        ListPopupWindow listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(mStringArrayAdapter);
        listPopupWindow.setAnchorView(view);
        listPopupWindow.setWidth(200);
        listPopupWindow.setHeight(500);
        listPopupWindow.show();
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, mStrings.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    public void go3(View view) {
        PopupMenu popupMenu=new PopupMenu(this,view);
        popupMenu.getMenuInflater().inflate(R.menu.main,popupMenu.getMenu());
        popupMenu.show();
        
    }
    
    public void go4(View view) {
        
        
    }
}
