## Declaration of Design Decisions

As software developers we should be open to learn and use any language, tool, or framework best suited for the problem at hand.

We should document architecture decisions and keep design lightweight yet actionable.
Prefer modular services with clear domain boundaries and fail-fast validation.
Use CI to enforce code quality, security scanning, and dependency checks.

## Design Decisions

### Backend

I have chosen to use Java and Kotlin for the core banking system. Java is a mature and widely used language with a large ecosystem, while Kotlin offers modern features and improved developer productivity. Both languages are interoperable, allowing us to leverage the strengths of each.

Spring Boot is a good choice for rapid development and microservices architecture. It provides a wide range of features and integrations out of the box, which can speed up development and reduce boilerplate code.

We are using org.jackson for JSON serialization, still keeping Serializable implemented as it can be helpful in session persistence. I may remove it in future.

How to use Maven profiles to run different sets of tests (e.g., skipping slow integration tests in the dev profile)?

How well can I use below plugin ?

```
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
```

Java -- domain entities, infrastructure securities

Kotlin -- service layer, common, dto

in the service module I have to add spring-doc-openapi-maven-plugin

Spring Security (VERY COMMON ISSUE)

If you use Spring Security, you MUST allow /cbs paths:

```
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
```

disable swagger in prod

I need to integrate reporting engine to the cbs. is jasperstudio a good choice
jasperstudio + itext pdf or openpdf. or eclipse birt.. whichever is safe and works as intended I should use.

learn and apply conceptual, logical, physical data modelling.

jpa/ sql alchemy

### Relational tables:

Planning below tables for the core banking system: Will create a schema document and refer to it for details.

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

### CI/CD

currently planning it this way. This is not final yet and subject to change.

```
Developer creates MR
        |
        v
GitLab Pipeline starts
        |
        v
+-------------------+
| mvn clean verify  |
+-------------------+
        |
        | tests pass
        v
+-------------------+
| Build Docker image|
+-------------------+
        |
        v
+-------------------+
| Push image        |
| to registry       |
+-------------------+
        |
        v
+----------------------------+
| Deploy stage connects      |
| to target server via SSH   |
+----------------------------+
        |
        v
Target Server

```

```
Current situation:

+-----------------------------+
| Target Server               |
|                             |
|  old container running      |
|  name: cbs-app              |
|  image: cbs:old-version     |
|  port: 8080                 |
+-----------------------------+
```

```
+------------------+
| Pull new image   |
+------------------+
         |
         v
+--------------------------+
| Stop old container       |
| docker stop cbs-app      |
+--------------------------+
         |
         v
+--------------------------+
| Remove old container     |
| docker rm cbs-app        |
+--------------------------+
         |
         v
+--------------------------+
| Start new container      |
| docker run -d ...        |
+--------------------------+
         |
         v
+--------------------------+
| Check /actuator/health   |
+--------------------------+
         |
     healthy?
      /   \
    yes   no
    /       \
 success   rollback
```

### Container

Docker
