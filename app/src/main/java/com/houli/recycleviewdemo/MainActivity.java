package com.houli.recycleviewdemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipe_refresh;
    private ImageView title;
    private SmartRefreshLayout refreshLayout,refreshLayout2;
    private RecyclerView recyclerView,recyclerView2;
    private static ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化控件
    private void initView() {
        refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //接下来再设置adapter

        //这里可以设置刷新时的头和底部
        refreshLayout.setRefreshHeader(new ClassicsHeader(this).setSpinnerStyle(SpinnerStyle.Scale));
        //设置底部
        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));

        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(MainActivity.this,strings );
        recyclerView.setAdapter(myRecycleViewAdapter);

        /**
         * 2222222222222222222222
         */
       /* refreshLayout2 = (SmartRefreshLayout) findViewById(R.id.refreshLayout2);
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        //接下来再设置adapter
        //这里可以设置刷新时的头和底部
        refreshLayout2.setRefreshHeader(new ClassicsHeader(this).setSpinnerStyle(SpinnerStyle.Scale));
        //设置底部
        refreshLayout2.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));

        MyRecycleViewAdapter myRecycleViewAdapter2 = new MyRecycleViewAdapter(MainActivity.this,strings );
        recyclerView2.setAdapter(myRecycleViewAdapter2);
*/
    }

    static  {
        strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("测试专用:" + i);
        }
    }
}
