package com.kalapa.trackbox.common.domain.enums;

/**
 * The {@code ErrorType} enum represents a classification of errors that can occur within the application.
 * Each error type corresponds to a specific category of issues, aiding in consistent error management and handling.
 *
 * Categories include:
 * - OPERATIONAL: Errors that arise from operational processes, such as invalid states or logical constraints.
 * - VALIDATION: Errors related to data validation, such as invalid inputs or malformed data structures.
 * - TECHNICAL: Errors caused by system-level failures, such as database or server issues.
 * - SECURITY: Errors involving security violations, such as authentication or authorization failures.
 * - CONFIGURATION: Errors due to misconfigurations or missing configurations.
 * - DEPENDENCY: Errors arising from external service dependencies, such as failed integrations.
 */
public enum ErrorType {
    /**
     * Represents operational errors that occur due to issues in the application's
     * operational processes, such as invalid states or logical constraints.
     * This error type is used for categorizing and managing errors that are not
     * related to validation, technical failures, security violations, configuration
     * problems, or external dependencies.
     */
    OPERATIONAL,

    /**
     * Represents validation errors that occur when data does not meet predefined
     * rules or constraints. This error type is used to identify issues such as
     * invalid inputs, malformed data structures, missing parameters, or
     * mismatches in expected formats or data types.
     */
    VALIDATION,

    /**
     * Represents technical errors caused by system-level failures within the application.
     * These errors typically arise from issues such as database connection failures,
     * server malfunctions, or unhandled exceptions. This category is used to identify
     * and classify errors that occur due to technical infrastructure problems rather
     * than user input or business logic constraints.
     */
    TECHNICAL,

    /**
     * Represents security-related errors within the application.
     * This error type is used to identify and classify issues such as authentication failures,
     * authorization errors, or other security violations that may compromise the application's integrity
     * or access control mechanisms.
     */
    SECURITY,

    /**
     * Represents configuration-related errors within the application.
     * This error type is used to identify issues arising from incorrect or missing
     * configuration settings. These errors often indicate misconfigured application
     * parameters, missing environment variables, or invalid configuration values
     * that impact the application's functionality or behavior.
     */
    CONFIGURATION,

    /**
     * Represents errors arising from external service dependencies.
     * These include failures in communication, integration, or interactions with external systems,
     * such as APIs, microservices, or third-party services, on which the application relies.
     * This error type helps classify issues related to external dependencies,
     * enabling targeted management and troubleshooting of such errors.
     */
    DEPENDENCY
}
