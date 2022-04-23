package com.example.lab7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.nio.Buffer;


public class MainActivity extends AppCompatActivity
{
 DatabaseHelper myDb;
 EditText editName,editSurname,editMarks,editSemester,editGpa,editDepartment;
 Button btnAddData,btnShowData;
    private  Object StringBuffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);

        editName=(EditText) findViewById(R.id.editTextTextPersonName);
        editSurname=(EditText) findViewById(R.id.editTextTextPersonName2);
        editMarks=(EditText) findViewById(R.id.editTextTextPersonName3);
        editSemester=(EditText) findViewById(R.id.editTextTextPersonName4);
        editGpa=(EditText) findViewById(R.id.editTextTextPersonName5);
        editDepartment=(EditText) findViewById(R.id.editTextTextPersonName6);
        btnAddData=(Button) findViewById(R.id.button);
        btnShowData=(Button) findViewById(R.id.button2);




    }
    public void onclick(View view) {
        boolean isInserted =myDb.insertData(editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString(),
                editSemester.getText().toString(),
                editGpa.getText().toString(),
                editDepartment.getText().toString());
        if(isInserted=true)
            Toast.makeText(MainActivity.this," Data Inserted",Toast.LENGTH_LONG).show();
        else

            Toast.makeText(MainActivity.this," Data is not Inserted",Toast.LENGTH_LONG).show();



    }

    private void showMessage(String data, String toString) {
        AlertDialog d=new AlertDialog.Builder(MainActivity.this).setTitle(data).setMessage(toString).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
        d.show();


    }

    public void onClick(View view) {
        Cursor res = myDb.getAllData();
        String showMessage;
        if (res.getCount() == 0) {
            showMessage = (" Error Nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {

            buffer.append("Id: " + res.getString(0) + "\n");
            buffer.append("Name :" + res.getString(1) + "\n");
            buffer.append("Surname :" + res.getString(2) + "\n");
            buffer.append("Marks :" + res.getString(3) + "\n");
            buffer.append("Semester:" + res.getString(4) + "\n");
            buffer.append("Gpa:" + res.getString(5) + "\n");
            buffer.append("Department:" + res.getString(6) + "\n");


            showMessage("Data", buffer.toString());

        }
    }

}