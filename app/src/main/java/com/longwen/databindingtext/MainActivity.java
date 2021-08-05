package com.longwen.databindingtext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.longwen.databindingtext.databinding.ActivityMainBinding;

/*
*
* 视图层和逻辑层数据分离
* 使用dataBinding{
            enabled true
        }
* */
public class MainActivity extends AppCompatActivity {

   //数据与视图层分离对象
    MyViewModel myViewModel;

    //和类同名的Binding对象
    ActivityMainBinding mainbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mainbinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        //获取数据层
        myViewModel= ViewModelProviders.of(this).get(MyViewModel.class);

        //获取控件层
        mainbinding.setData(myViewModel);

        //设置生命周期所有者
        mainbinding.setLifecycleOwner(this);

    }
}