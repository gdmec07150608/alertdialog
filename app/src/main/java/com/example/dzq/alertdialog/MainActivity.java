package com.example.dzq.alertdialog;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cn.edu.gdmec.s07150619.alertdialog.R;


/**
 * Created by acer-pc on 2016/10/8.
 */
public class MainActivity extends Activity {
    private AlertDialog dialog;
    private AlertDialog.Builder bulider;
    private TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.activity.alertdialog);
        tView=(TextView) this.findViewById(R.id.textView1);
        Button button1=(Button)this.findViewById(R.id.button1);
        Button button2=(Button)this.findViewById(R.id.button2);
        Button button3=(Button)this.findViewById(R.id.button3);
        Button button4=(Button)this.findViewById(R.id.button4);
        Button button5=(Button)this.findViewById(R.id.button5);
        Button button6=(Button)this.findViewById(R.id.button6);
        Button button7=(Button)this.findViewById(R.id.button7);
        View.OnClickListener listener=new View.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);

    }
    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确认退出吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
    }
    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){
            public  void onClick(DialogInterface dialog,int which){
                String str="";
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时轻松";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listener);
        dialog.show();
    }
    public void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit=new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog4(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListenter=new DialogInterface.OnMultiChoiceClickListener(){
            public void onClick(DialogInterface dialog,int which,boolean isChecked){
                bSelect[which]=isChecked;
            }
        };
        bulider=new AlertDialog.Builder(this);
        bulider.setMultiChoiceItems(item,null,mListenter);
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                String str="你选择了：";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog5(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListener=new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        bulider=new AlertDialog.Builder(this);
        bulider.setSingleChoiceItems(item,-1,sListener);
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog6(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListener=new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了："+item[which];
                tView.setText(str);
            }

        };
        bulider=new AlertDialog.Builder(this);
        bulider.setItems(item,sListener);
        dialog=bulider.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.alertdialog,null);
        //final EditText tEdit=(EditText)layout.findViewById(R.id.editText1);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // tView.setText("输入的是："+tEdit.getText().toString());

            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
