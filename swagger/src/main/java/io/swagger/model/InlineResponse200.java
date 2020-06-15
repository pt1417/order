package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-13T04:44:05.133Z[GMT]")
public class InlineResponse200   {
  @JsonProperty("customerNumber")
  private String customerNumber = null;

  @JsonProperty("orderNumber")
  private String orderNumber = null;

  @JsonProperty("orderMenuItems")
  private List orderMenuItems = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  public InlineResponse200 customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

  /**
   * Get customerNumber
   * @return customerNumber
  **/
  @ApiModelProperty(example = "CUST456", value = "")
  
    public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public InlineResponse200 orderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
    return this;
  }

  /**
   * Get orderNumber
   * @return orderNumber
  **/
  @ApiModelProperty(example = "ORDER123", value = "")
  
    public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public InlineResponse200 orderMenuItems(List orderMenuItems) {
    this.orderMenuItems = orderMenuItems;
    return this;
  }

  /**
   * Get orderMenuItems
   * @return orderMenuItems
  **/
  @ApiModelProperty(example = "[{\"menuItemNumber\":\"MENU-112\",\"quantityOfMenuItem\":2,\"menuName\":\"Salmon\",\"price\":12.95},{\"m                \\\"menuItemNumber\\\"\":\"MENU554\",\"quantityOfMenuItem\":1,\"menuName\":\"Salad\",\"”               \\\"price\\\"\":5.95}]", value = "")
  
    @Valid
    public List getOrderMenuItems() {
    return orderMenuItems;
  }

  public void setOrderMenuItems(List orderMenuItems) {
    this.orderMenuItems = orderMenuItems;
  }

  public InlineResponse200 price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(example = "31.85", value = "")
  
    @Valid
    public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.customerNumber, inlineResponse200.customerNumber) &&
        Objects.equals(this.orderNumber, inlineResponse200.orderNumber) &&
        Objects.equals(this.orderMenuItems, inlineResponse200.orderMenuItems) &&
        Objects.equals(this.price, inlineResponse200.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, orderNumber, orderMenuItems, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    orderNumber: ").append(toIndentedString(orderNumber)).append("\n");
    sb.append("    orderMenuItems: ").append(toIndentedString(orderMenuItems)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
