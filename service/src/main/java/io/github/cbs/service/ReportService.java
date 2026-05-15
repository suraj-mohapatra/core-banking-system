package io.github.cbs.service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;


@Service
public class ReportService {

    public byte[] generateBranchesReport(Connection connection) {

        try (InputStream inputStream =
                     new ClassPathResource("reports/branches.jasper").getInputStream()) {

            JasperReport jasperReport =
                    (JasperReport) JRLoader.loadObject(inputStream);

            Map<String, Object> parameters = new HashMap<>();

            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(
                            jasperReport,
                            parameters,
                            connection
                    );

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate branches report", e);
        }
    }
}