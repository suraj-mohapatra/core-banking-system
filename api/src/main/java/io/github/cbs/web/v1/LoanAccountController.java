package io.github.cbs.web.v1;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/loan-accounts")
@Tag(name = "Loan Accounts", description = "Loan account management APIs")
public class LoanAccountController {
}
