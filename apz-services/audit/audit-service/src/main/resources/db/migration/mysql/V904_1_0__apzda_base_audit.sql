CREATE TABLE `apzda_audit_log`
(
    id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created_at BIGINT UNSIGNED NULL     DEFAULT NULL,
    created_by VARCHAR(32)     NULL COMMENT 'Create User Id',
    updated_at BIGINT UNSIGNED NULL     DEFAULT NULL,
    updated_by VARCHAR(32)     NULL COMMENT 'Last updated by who',
    deleted    BIT             NOT NULL DEFAULT FALSE COMMENT 'Soft Deleted Flag',
    tenant_id  VARCHAR(32)     NULL COMMENT 'the id of the tenant to which this setting belongs',
    user_id    VARCHAR(32)     NOT NULL COMMENT 'User Id',
    log_time   BIGINT UNSIGNED NOT NULL COMMENT 'log timestamp',
    template   BIT             NOT NULL DEFAULT false COMMENT 'the message is template',
    activity   varchar(64)     NOT NULL COMMENT 'activity',
    runas      varchar(32)     null comment 'the userid of the user who performed this activity',
    level      varchar(12)     NULL     DEFAULT 'info' COMMENT 'log level',
    ip         varchar(126)    NULL     DEFAULT NULL COMMENT 'ip',
    device     varchar(64)     null comment 'the device on which the activity performed',
    message    TEXT            NULL     DEFAULT NULL COMMENT 'message',
    args       LONGTEXT        NULL     DEFAULT NULL COMMENT 'args of message',
    old_value  LONGTEXT        NULL     DEFAULT NULL COMMENT 'old json value',
    new_value  LONGTEXT        NULL     DEFAULT NULL COMMENT 'new value',
    index idx_log_time (log_time asc),
    index idx_user_id (user_id, log_time asc),
    index idx_tenant_id (tenant_id),
    index idx_activity_user_id (activity, user_id),
    index idx_activity_log_time (activity, log_time),
    index idx_runas (runas, activity)
) ENGINE = InnoDB COMMENT 'Audit Logs';
