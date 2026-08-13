package com.sgt;


import java.sql.*;
/**
 * @author ÀÔπŸÕ¡
 * @description TODO
 * @date 2024/2/27 17:25
 */
public class OracleTableStructureToObject {

    // Replace with your Oracle database connection details
    private static final String URL = "jdbc:oracle:thin:@192.168.8.133:1521:ncdb";
    private static final String USER = "ncc";
    private static final String PASSWORD = "ncc_20241012";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Registering the Oracle driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Get a connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // Get metadata about the table
            DatabaseMetaData dbmd = conn.getMetaData();
            // Replace 'YOUR_TABLE_NAME' with the actual name of your table
            ResultSet rs = dbmd.getColumns(null, null, "CMP_BANK_CLAIM_RECEIPT", null);

            StringBuilder classContent = new StringBuilder();
            classContent.append("import nc.vo.pub.SuperVO;\n" +
                    "import nc.vo.pub.lang.UFDateTime;\n");
            classContent.append("public class BankClaimReceiptVO extends SuperVO {\n");

            while (rs.next()) {
                String name = rs.getString("COLUMN_NAME");
                String type = rs.getString("TYPE_NAME");
                int size = rs.getInt("COLUMN_SIZE");

                // Translate Oracle types to Java types, customize this method if needed
                String javaType = translateTypeToJava(type, size);
                classContent.append("    private " + javaType + " " + name.toLowerCase() + ";\n");
            }

            classContent.append("}\n");

            System.out.println(classContent.toString());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String translateTypeToJava(String sqlType, int size) {
        switch (sqlType) {
            case "VARCHAR2":
            case "CHAR":
            case "CLOB":
                return "String";
            case "NUMBER":
                if (size <= 10) return "int";
                else return "long";
                // Add more case mappings as needed
            default:
                return "Object";
        }
    }
}
