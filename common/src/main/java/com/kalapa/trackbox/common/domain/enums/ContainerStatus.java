package com.kalapa.trackbox.common.domain.enums;

/**
 * The {@code ContainerStatus} enum represents the possible states of a container
 * within the system. Each status denotes a specific lifecycle or operational
 * condition of the container, allowing for effective tracking and management.
 *
 * The statuses include:
 *
 * - {@code AVAILABLE}: Indicates that the container is ready for use and not currently occupied.
 * - {@code RESERVED}: Indicates that the container is reserved for future use and is not available for other operations.
 * - {@code IN_USE}: Indicates that the container is actively being used.
 * - {@code DAMAGED}: Indicates that the container has been reported as damaged and is unfit for regular operations.
 * - {@code MAINTENANCE}: Indicates that the container is undergoing maintenance procedures and is temporarily out of service.
 * - {@code DECOMMISSIONED}: Indicates that the container is no longer in use and has been permanently retired from service.
 */
public enum ContainerStatus {
    /**
     * Indicates that the container is ready for use and not currently occupied.
     * This status implies that the container is in a functional state and can
     * be assigned to tasks or operations without any restrictions.
     */
    AVAILABLE,

    /**
     * Indicates that the container is reserved for future use and is not
     * available for other operations. This status is typically assigned to containers
     * that have been allocated or designated for a specific purpose and are awaiting
     * their intended utilization.
     */
    RESERVED,

    /**
     * Indicates that the container is actively being used.
     * This status implies that the container is currently allocated
     * to an ongoing operation or task and is unavailable for other purposes
     * until the operation is completed or the container becomes free.
     */
    IN_USE,

    /**
     * Indicates that the container has been reported as damaged
     * and is unfit for regular operations. This status is used to
     * mark containers that require inspection, repair, or replacement
     * before they can be made available for operational use again.
     */
    DAMAGED,

    /**
     * Indicates that the container is undergoing maintenance procedures
     * and is temporarily out of service. This status is used to mark containers
     * that require scheduled or unscheduled maintenance, ensuring they are not
     * used until the maintenance tasks are completed and the container is verified
     * to be in proper working condition.
     */
    MAINTENANCE,

    /**
     * Indicates that the container is no longer in use and has been permanently
     * retired from service. This status is used to classify containers that have
     * reached the end of their lifecycle and are no longer considered operational
     * or maintainable within the system.
     */
    DECOMMISSIONED
}
