import dao.BillingDAO;

public class Main {
    public static void main(String[] args) {

        BillingDAO dao = new BillingDAO();
        boolean success = dao.generateBill(1, 1500);

        if (success) {
            System.out.println("Bill generated successfully");
        } else {
            System.out.println("Billing failed");
        }
    }
}
