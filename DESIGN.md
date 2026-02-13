As software developer we should never be a fanboy of any language, tool, framework.

We are using org.jackson for JSON serialization, still keeping Serializable implemented as it can be helpful in session persistence. I may remove it in future.

How to use Maven profiles to run different sets of tests (e.g., skipping slow integration tests in the dev profile)?

How well can I use below plugin ?

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-resources-plugin</artifactId>
    <configuration>
        <nonFilteredFileExtensions>
            <nonFilteredFileExtension>p12</nonFilteredFileExtension>
            <nonFilteredFileExtension>jks</nonFilteredFileExtension>
            <nonFilteredFileExtension>crt</nonFilteredFileExtension>
            <nonFilteredFileExtension>pem</nonFilteredFileExtension>
        </nonFilteredFileExtensions>
    </configuration>
</plugin>

learn and apply conceptual, logical, physical data modelling.

jpa//sql alchemy

branch_master
product_master
employee_master
customer_master
customer_kyc
customer_nominee
account_master
account_balance_history
loan_account_details
general_ledger
transaction_details
transaction_master
audit_trail
denominations_log
beneficiary_master

Java -- domain entities, infrastructure securities

Kotlin -- service layer, common, dto

in the service module I have to add spring-doc-openapi-maven-plugin

Spring Security (VERY COMMON ISSUE)

If you use Spring Security, you MUST allow /cbs paths:

@Bean
SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
http
.csrf(csrf -> csrf.disable())
.authorizeHttpRequests(auth -> auth
.requestMatchers(
"/cbs/swagger-ui/**",
"/cbs/v3/api-docs/**"
).permitAll()
.anyRequest().authenticated()
);
return http.build();
}

disable swagger in prod
