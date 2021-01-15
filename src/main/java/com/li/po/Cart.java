package com.li.po;

/**
 * 购物车实体
 */
public class Cart {
     private int cartId;    //` int(5) NOT NULL COMMENT '购物车id',
    private String  cartUid;   //` int(5) NOT NULL COMMENT '用户id',
    private int  cartPid;   //` int(5) NOT NULL COMMENT '产品id',
    private String  cartPFilename;   //` varchar(50) NOT NULL COMMENT '产品图片',
    private int cartPQuantity;//` int(6) NOT NULL COMMENT '购买产品数量',
    private int cartPCount;//` int(8) NOT NULL COMMENT '产品库存',
    private String   cartPName;//` varchar(50) NOT NULL COMMENT '产品名字',
    private double cartPPrice;//` double(6,2) NOT NULL COMMENT '产品价格',
    private int   cartValid;//` int(1) NOT NULL COMMENT '标识为',

    public Cart(int cartId, String cartUid, int cartPid, String cartPFilename, int cartPQuantity, int cartPCount, String cartPName, double cartPPrice, int cartValid) {
        this.cartId = cartId;
        this.cartUid = cartUid;
        this.cartPid = cartPid;
        this.cartPFilename = cartPFilename;
        this.cartPQuantity = cartPQuantity;
        this.cartPCount = cartPCount;
        this.cartPName = cartPName;
        this.cartPPrice = cartPPrice;
        this.cartValid = cartValid;
    }

    public Cart() {
    }

    public Cart(String cartUid, int cartPid, String cartPFilename, int cartPQuantity, int cartPCount, String cartPName, double cartPPrice, int cartValid) {
        this.cartUid = cartUid;
        this.cartPid = cartPid;
        this.cartPFilename = cartPFilename;
        this.cartPQuantity = cartPQuantity;
        this.cartPCount = cartPCount;
        this.cartPName = cartPName;
        this.cartPPrice = cartPPrice;
        this.cartValid = cartValid;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCartUid() {
        return cartUid;
    }

    public void setCartUid(String cartUid) {
        this.cartUid = cartUid;
    }

    public int getCartPid() {
        return cartPid;
    }

    public void setCartPid(int cartPid) {
        this.cartPid = cartPid;
    }

    public String getCartPFilename() {
        return cartPFilename;
    }

    public void setCartPFilename(String cartPFilename) {
        this.cartPFilename = cartPFilename;
    }

    public int getCartPQuantity() {
        return cartPQuantity;
    }

    public void setCartPQuantity(int cartPQuantity) {
        this.cartPQuantity = cartPQuantity;
    }

    public int getCartPCount() {
        return cartPCount;
    }

    public void setCartPCount(int cartPCount) {
        this.cartPCount = cartPCount;
    }

    public String getCartPName() {
        return cartPName;
    }

    public void setCartPName(String cartPName) {
        this.cartPName = cartPName;
    }

    public double getCartPPrice() {
        return cartPPrice;
    }

    public void setCartPPrice(double cartPPrice) {
        this.cartPPrice = cartPPrice;
    }

    public int getCartValid() {
        return cartValid;
    }

    public void setCartValid(int cartValid) {
        this.cartValid = cartValid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", cartUid=" + cartUid +
                ", cartPid=" + cartPid +
                ", cartPFilename='" + cartPFilename + '\'' +
                ", cartPQuantity=" + cartPQuantity +
                ", cartPCount=" + cartPCount +
                ", cartPName='" + cartPName + '\'' +
                ", cartPPrice=" + cartPPrice +
                ", cartValid=" + cartValid +
                '}';
    }
}
