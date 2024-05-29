package com.example.todolistproject;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DoneDialog extends Dialog implements View.OnClickListener{

    Button remove, cancel;
    String description;
    TextView item;
    Context context;

    public DoneDialog(Context context,String description) {
        super(context);
        this.context=context;
        this.description=description;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.remove_dialog);
        remove = (Button) findViewById(R.id.donebutton);
        cancel = (Button) findViewById(R.id.donecancelbutton);
        item=findViewById(R.id.removeitem);
        item.setText(description);
        remove.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.donebutton:
                DataBaseHandler db=new DataBaseHandler(context);
                db.doneToDo(description);
                this.dismiss();
                break;
            case R.id.donecancelbutton:
                this.dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
