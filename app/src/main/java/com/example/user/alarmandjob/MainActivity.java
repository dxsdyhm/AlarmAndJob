package com.example.user.alarmandjob;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dxs.autostart.utils.AutoStartUtils;
import com.dxs.autostart.utils.BatteryJumpUtils;
import com.dxs.autostart.utils.PhoneUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_setting)
    Button btnSetting;
    @BindView(R.id.tx_phoneinfo)
    TextView txPhoneinfo;
    @BindView(R.id.btn_toast)
    Button btnToast;
    @BindView(R.id.btn_battery)
    Button btnBattery;

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
        boolean isFind= AutoStartUtils.newInstance(context).isTargetActivityFinded();
        Log.e("dxsTest","isFind:"+isFind);
        try {
            AutoStartUtils.newInstance(context).toTargetActivity();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context,"无法自动跳转！",Toast.LENGTH_LONG).show();
            txPhoneinfo.setText(PhoneUtils.getPhoneInfo());
        }
    }

    @OnClick(R.id.btn_toast)
    public void onToastTest() {
        Toast.makeText(this, "Toast Test", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_battery)
    public void onBatterySet() {
        toBattery(this);
    }

    private void toBattery(Context context){
        boolean isFind= BatteryJumpUtils.newInstance(context).isTargetActivityFinded();
        Log.e("dxsTest","isFind:"+isFind);
        try {
            BatteryJumpUtils.newInstance(context).toTargetActivity();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context,"无法自动跳转！",Toast.LENGTH_LONG).show();
            txPhoneinfo.setText(PhoneUtils.getPhoneInfo());
        }
    }
}
