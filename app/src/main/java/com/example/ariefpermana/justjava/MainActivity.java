package com.example.ariefpermana.justjava;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {

        quantity = quantity + 1;
        TextView viewQuantity = (TextView) findViewById(R.id.quantity_text_view);
        int intquantity = Integer.parseInt(String.valueOf(viewQuantity));

        //https://stackoverflow.com/questions/27230664/how-can-i-set-alert-dialogs-into-if-and-else-statement
        if(quantity == 10){
        Button btnAlert = (Button) findViewById(R.id.button_plus);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this);
                builder.setTitle("Contoh Alert");
                builder.setMessage("Alert dengan 1 Action Button ");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Log.e("info", "OK");
                            }
                        });
                builder.show();
            }
        });
        //}else{
            display(quantity);
        //}
    }
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }
    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


}
