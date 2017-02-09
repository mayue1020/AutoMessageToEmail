package cc.simpleme.automessagetoemail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.lang.Exception;
import cc.simpleme.automessagetoemail.util.SendMail;



public class MainActivity extends AppCompatActivity {
    static Exception ex ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testButton = (Button) findViewById(R.id.testButton);

            testButton.setOnClickListener(new BtnClickListener());
    }
    class BtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            m1 m1=new m1();
            m1.start();
            Toast.makeText(MainActivity.this,"错误"+ex, Toast.LENGTH_SHORT).show();
        }
    }
    static class m1 extends Thread{
        public void run(){
            SendMail a = new SendMail();
            try {
                a.sendMail("869102550@163.com", "869102550@163.com", "mayue19951020.",
                        "869102550@qq.com",
                        "Java Mail 测试邮件",
                        "<a>html 元素</a>：<b>邮件内容</b>");
            }catch (Exception e){
                ex = e;
            }
        }
    }
}
