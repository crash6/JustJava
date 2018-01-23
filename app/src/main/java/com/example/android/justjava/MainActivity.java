/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    //This value sets a low threshold for the quantity picker and it avoids a negative value
    // for the quantity of coffees
    static final int QTY_START = 0;

    //Global value which stores the quantity of ordered coffees
    int quantity = QTY_START;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetQuantityTextView();
        resetPriceTextView();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String messagePrice;
        int price;

        if(quantity != 0){

            price = quantity * 5;
            messagePrice = "Total: " + NumberFormat.getCurrencyInstance().format(price);
            messagePrice = messagePrice + "\n Thank you!";

        } else {

            messagePrice = "Nothing to pay \n Thank you!";

        }


        displayMessage(messagePrice);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called when when the plus button is clicked
     */
    public void increment(View view){
        quantity += 1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked
     */
    public void decrement(View view){

        //This code checks if the value is not zero, before to update the global value quantity
        if(!(quantity == QTY_START)){
            quantity -= 1;
            display(quantity);
        }
    }


    /**
     * This method initializes the TextView which shows the quantity of coffees
     */
    private void resetQuantityTextView(){
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(Integer.toString(quantity));
    }

    /**
     * This method initializes the TextView which shows the price of the initial ordered coffees
     */
    private void resetPriceTextView(){
        int price;
        String priceMessage;
        TextView priceTextView;

        price = quantity * 5;
        priceTextView= findViewById(R.id.price_text_view);
        priceMessage = price + NumberFormat.getCurrencyInstance().format(price);

        priceTextView.setText(priceMessage);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}