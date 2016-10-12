package com.example.zhanglei.denglu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edit_pass,edit_name;
    private Button btn1;
    private CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name=(EditText) findViewById(R.id.edit_name);
        edit_pass=(EditText) findViewById(R.id.edit_pass);
        check=(CheckBox) findViewById(R.id.check);
        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

            Map<String,String> map=save.readinfo();
            String savename=map.get("name");
            String savepass=map.get("pass");
            edit_name.setText(savename);
            edit_pass.setText(savepass);



    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn1:
                String name=edit_name.getText().toString().trim();
                String pass=edit_pass.getText().toString().trim();
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pass))
                    Toast.makeText(this,"用户名和密码不能为空",Toast.LENGTH_LONG).show();
                else
                {
                    boolean result=save.saveinfo(name,pass);
                    if (result)
                    {
                        Toast.makeText(this,"密码保存成功",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this,"密码保存失败",Toast.LENGTH_LONG).show();

                    }

                }
                break;
        }
    }

}
