package at.akmrg.springBootEmpty.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alex on 24/08/17.
 */
public class Order {

    @JsonProperty("orderID")
    public String orderID;
    @JsonProperty("orderValue")
    public String orderValue;

    public Order(String orderID, String orderValue){
        this.orderID = orderID;
        this.orderValue = orderValue;
    }

    public Order(){
    this.orderID = "";
    this.orderValue = "";
    }

    public String getOrderID(){
        return orderID;
    }

    public String getOrderValue(){
        return orderValue;
    }

    public void setOrderID(@JsonProperty("orderID") String orderID){
        this.orderID = orderID;
    }

    public void setOrderValue(@JsonProperty("orderValue") String orderValue){
        this.orderValue = orderValue;
    }
}
