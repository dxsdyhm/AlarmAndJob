package com.example.user.alarmandjob;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.SettingUtils;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_setting)
    Button btnSetting;
    @BindView(R.id.tx_phoneinfo)
    TextView txPhoneinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_setting)
    public void onViewClicked() {
        toSetting(this);
    }

    private void toSetting(Context context) {
        SettingUtils.jumpStartInterface(context);
    }
}
