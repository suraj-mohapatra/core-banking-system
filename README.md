# core-banking-system

## About :
cbs is my dream project

## Project Requirement

## Project Structure

## Liquibase :

### File Naming Convention

All Liquibase changesets must follow the naming convention below to maintain consistency and avoid conflicts.

### Format

YYYYMMDD_{DEVELOPER}_{SQL_TYPE}_{SEQUENCE}

### Details
- **YYYYMMDD** – Date when the changeset is created
- **DEVELOPER** – Developer name or identifier (use uppercase)
- **SQL_TYPE** – Type of change (`DDL` or `DML`)
- **SEQUENCE** – Two-digit sequence number, unique per developer per day

### Examples

20200225_JOHN_DDL_01  
20200225_JOHN_DML_02

### Rules
- Sequence must be unique for the same developer on the same date
- Use `DDL` for schema changes and `DML` for data changes
- This convention must be followed for all Liquibase changesets
