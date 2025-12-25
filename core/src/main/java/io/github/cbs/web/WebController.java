package io.github.cbs.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Web Controller", description = "Basic API for CBS")
@RestController
@RequestMapping("/api")
public class WebController {
    @Operation(
            summary = "Return a greeting message",
            description = "This endpoint returns a simple hello message for CBS.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully returned the message")
            }
    )
    @GetMapping({"/", ""})
    public String foo() {
        return "Hello from CBS!";
    }

}