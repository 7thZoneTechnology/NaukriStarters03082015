package com.info.demo;
public class MyPojo
{
    private Reviews[] reviews;

    private String price;

    private String description;

    private String name;

    private String canPurchase;

    public Reviews[] getReviews ()
    {
        return reviews;
    }

    public void setReviews (Reviews[] reviews)
    {
        this.reviews = reviews;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCanPurchase ()
    {
        return canPurchase;
    }

    public void setCanPurchase (String canPurchase)
    {
        this.canPurchase = canPurchase;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [reviews = "+reviews+", price = "+price+", description = "+description+", name = "+name+", canPurchase = "+canPurchase+"]";
    }
}