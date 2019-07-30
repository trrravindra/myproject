
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductCompound complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductCompound">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActiveIngredient" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Order" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Product" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Product"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductCompound", propOrder = {
    "activeIngredient",
    "order",
    "product",
    "quantity"
})
public class ProductCompound {

    @XmlElement(name = "ActiveIngredient")
    protected boolean activeIngredient;
    @XmlElement(name = "Order")
    protected short order;
    @XmlElement(name = "Product", required = true, nillable = true)
    protected Product product;
    @XmlElement(name = "Quantity")
    protected int quantity;

    /**
     * Gets the value of the activeIngredient property.
     * 
     */
    public boolean isActiveIngredient() {
        return activeIngredient;
    }

    /**
     * Sets the value of the activeIngredient property.
     * 
     */
    public void setActiveIngredient(boolean value) {
        this.activeIngredient = value;
    }

    /**
     * Gets the value of the order property.
     * 
     */
    public short getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     */
    public void setOrder(short value) {
        this.order = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

}
