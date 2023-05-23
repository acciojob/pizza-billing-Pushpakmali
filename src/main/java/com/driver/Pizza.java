package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;

    public static int vegPizzaBasePrice = 300;
    public static int nonVegPizzaBasePrice = 400;
    public static int cheesePrice = 80;
    public static int toppingPriceForVeg = 70;
    public static int toppingPriceForNonVeg = 120;
    private boolean isCheeseAdded = false;
    private boolean isToppingAdded = false;
    private boolean isTakeAwayAdded = false;
    public static int takeAwayPrice = 20;
    private int myToppingPrice = 0;

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        this.price = isVeg ? vegPizzaBasePrice : nonVegPizzaBasePrice;
        this.bill = "Base Price Of The Pizza: "+this.price+"\n";
        this.isCheeseAdded = false;
        this.isToppingAdded = false;
        this.isTakeAwayAdded = false;
    }

    public int getPrice(){
        if(isCheeseAdded){
            this.price += cheesePrice;
        }

        if(isToppingAdded){
            this.price += this.myToppingPrice;
        }

        if(isTakeAwayAdded){
            this.price += takeAwayPrice;
        }

        return this.price;
    }

    public void addExtraCheese(){
        if(isCheeseAdded == false){
            isCheeseAdded = true;
        }
    }

    public void addExtraToppings(){
        if(isToppingAdded == false){
            isToppingAdded = true;
            this.myToppingPrice = isVeg ? toppingPriceForVeg : toppingPriceForNonVeg;
        }
    }

    public void addTakeaway(){
        if(isTakeAwayAdded == false){
            isTakeAwayAdded = true;
        }
    }

    public String getBill(){
        String bill = this.bill;

        if(isCheeseAdded){
            bill += "Extra Cheese Added: "+this.cheesePrice+"\n";
        }

        if(isToppingAdded){
            bill += "Extra Toppings Added: "+this.myToppingPrice+"\n";
        }

        if(isTakeAwayAdded){
            bill += "Paperbag Added: "+takeAwayPrice+"\n";
        }

        bill += "Total Price: "+this.price+"\n";

        this.bill = bill;

        return this.bill;
    }
}
