package programs.java8;

public class PurchaseOrder {
	String name;
	int amount;
	public PurchaseOrder(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "\nPurchaseOrder [name=" + name + ", amount=" + amount + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
