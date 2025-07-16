package com.iara.educar.educarstats.util;

import com.iara.educar.educarstats.model.EnrollmentStats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class DataLoader {

    public CompletableFuture<List<EnrollmentStats>> loadEnrollmentData() {
        return CompletableFuture.supplyAsync(() -> {
            List<EnrollmentStats> statsList = new ArrayList<>();

            try(InputStream is = getClass().getResourceAsStream("/data/exportacion_migrantes.xlsx");
                Workbook workbook = new XSSFWorkbook(is)) {
                Sheet sheet = workbook.getSheetAt(0);
                boolean firstRow = true;

                for (Row row : sheet) {
                    if (firstRow) {
                        firstRow = false; // Skip header row
                        continue;
                    }

                    String province = getCellValue(row.getCell(2));
                    double enrollmentRate = Double.parseDouble(getCellValue(row.getCell(3)));

                    statsList.add(new EnrollmentStats(province, enrollmentRate));
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to load Excel data", e);
            }
            return statsList;
        });
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            default -> "";
        };
    }
}
