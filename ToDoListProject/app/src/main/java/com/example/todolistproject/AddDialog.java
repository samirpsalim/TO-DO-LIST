package com.example.todolistproject;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class AddDialog extends Dialog implements View.OnClickListener
{
    Button add, cancel;
    EditText description;
    Context context;

    public AddDialog(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_dialog);
        add = (Button) findViewById(R.id.addbutton);
        cancel = (Button) findViewById(R.id.cancelbutton);
        description=findViewById(R.id.action_description);
        add.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addbutton:
                DataBaseHandler db=new DataBaseHandler(context);
                db.addTodo(description.getText().toString()) ;
                this.dismiss();
                break;
            case R.id.cancelbutton:
                this.dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
