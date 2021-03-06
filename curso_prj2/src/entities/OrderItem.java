package entities;

public class OrderItem {
	private Integer quantity;
	
	private Product product;
	
	public OrderItem() {
		super();
	}
	
	public OrderItem(Product product, Integer quantity) {
		super();
		
		this.product = product;
		this.quantity = quantity;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return quantity * product.getPrice();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(product + ", ");
		sb.append("Quantity: " + quantity + ", ");
		sb.append("Subtotal: $" + String.format("%.2f", subTotal()));
		
		return sb.toString();
	}
}
