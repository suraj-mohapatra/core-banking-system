package io.github.cbs.web.v1;

import io.github.cbs.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private ReportService reportService;
    private DataSource dataSource;

    @GetMapping("/branches")
    public ResponseEntity<byte[]> generateBranchesReport() {

        try (Connection connection = dataSource.getConnection()) {

            byte[] pdfBytes = reportService.generateBranchesReport(connection);

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "inline; filename=branches-report.pdf"
                    )
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to generate branches report", e);
        }
    }
}