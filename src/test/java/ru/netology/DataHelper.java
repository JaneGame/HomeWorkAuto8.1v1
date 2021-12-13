package ru.netology;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.TestInstance;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {


    @Value
    public static class VerificationCode {

        private String code;
    }

        @SneakyThrows
        public static VerificationCode getValidVerificationCode() {
            String codeSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1;";
            val runner = new QueryRunner();
            String code = null;
            try (
                    val conn = DriverManager.getConnection(
                            "jdbc:mysql://217.25.88.206:3306/app", "app", "pass")
            ) {
                code = runner.query(conn, codeSQL, new ScalarHandler<>());
            }
            return new VerificationCode(code);
        }

    @SneakyThrows
    public static void deleteInfo() {
        var deleteCards = "DELETE FROM cards;";
        var deleteAuth = "DELETE FROM auth_codes;";
        var deleteUserd = "DELETE FROM users;";
        val runner = new QueryRunner();

        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://217.25.88.206:3306/app", "app", "pass")
        ) {
            runner.update(conn, deleteCards);
            runner.update(conn, deleteAuth);
            runner.update(conn, deleteUserd);
        }

    }}


