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
    private static final int QTY_START = 0;

    //Price for a single coffee
    private static  final int PRICE_FOR_SINGLE_COFFEE = 5;

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
        int price = calculatePrice();

        displayMessage(createOrderSummary(price));
    }

    /**
     * This method returns a summary message when an order is submitted
     * @param price Price of all ordered coffees
     * @return Return a formatted message
     */
    private String createOrderSummary(int price){
        String message;

        if(price<=0){
            message = "Nothing to pay \nThank you!";
        } else {
            message = "Name : Kaptain Kunal";
            message += "\nQuantity : " + quantity;
            message += "\nTotal: " + NumberFormat.getCurrencyInstance().format(price);
            message +="\nThank you!";
        }

        return message;
    }

    /**
     * This methods calculates the total price for a quantity of ordered coffees
     * @param quantity
     * @return
     */
    private int calculatePrice(int quantity){

        if(quantity<= 0){
            return 0;
        }

        return PRICE_FOR_SINGLE_COFFEE * quantity;
    }

    /**
     * This method returns the total price for the number of ordered coffees
     * @param quantity Number of coffees
     * @param price Price for a single coffee
     * @return Return the total price of the coffees
     */
    private int calculatePrice(int quantity, int price){
        int totalPrice;

        if((quantity <= 0)||(price <= 0)){
            return 0;
        }

        totalPrice = quantity * price;

        return totalPrice;
    }

    /**
     * Calculate the total price of all ordered coffees, assuming the unit price is PRICE_FOR_SINGLE_COFFEE
     * @return Returns the total price (quantity * unit_price)
     */
    private int calculatePrice(){
        int totalPrice;

        if(this.quantity <= 0){
            return 0;
        }

        totalPrice = this.quantity * PRICE_FOR_SINGLE_COFFEE;

        return totalPrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called when when the plus button is clicked
     */
    public void increment(View view){
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked
     */
    public void decrement(View view){

        //This code checks if the value is not zero, before to update the global value quantity
        if(!(quantity == QTY_START)){
            quantity -= 1;
            displayQuantity(quantity);
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
        TextView orderSummaryTextView;

        price = quantity * 5;
        orderSummaryTextView= findViewById(R.id.order_summary_text_view);
        priceMessage = price + NumberFormat.getCurrencyInstance().format(price);

        orderSummaryTextView.setText(priceMessage);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}