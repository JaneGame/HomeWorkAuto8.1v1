package ru.netology;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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



    }
