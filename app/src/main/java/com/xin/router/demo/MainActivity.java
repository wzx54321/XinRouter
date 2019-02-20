package com.xin.router.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.xin.router.XinRouter;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById( R.id.btn_todo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("a", MainActivity.this);
                map.put("name", "hahahahahahhaha");
                String str = (String) XinRouter.getInstance().to("module_test.com").call("getTest", map);

              //  Log.e("--------------Router",""+str);
            }
        });
    }
}
