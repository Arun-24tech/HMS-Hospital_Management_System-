package dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillingDAO {

    public boolean generateBill(int patientId, double amount) {

        String sql = "INSERT INTO billing (patient_id, amount) VALUES (?, ?)";

        Connection con = null;

        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false); // 🔴 START TRANSACTION

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, patientId);
                ps.setDouble(2, amount);
                ps.executeUpdate();
            }

            con.commit(); // ✅ COMMIT
            return true;

        } catch (SQLException e) {

            try {
                if (con != null) con.rollback(); // ❌ ROLLBACK
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
            return false;

        } finally {

            try {
                if (con != null) con.close(); // 🔒 CLOSE
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
