
------------
create table if not exists seata.t_account(
  id serial not null,
  user_id varchar(255),
  amount numeric(14, 4),
  primary key(id)
)

-- 日志表
CREATE TABLE IF NOT EXISTS seata.undo_log
(
    id            BIGINT   NOT NULL,
    branch_id     BIGINT   NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info bytea     NOT NULL,
    log_status    INT          NOT NULL,
    log_created   TIMESTAMP(6)     NOT NULL,
    log_modified  TIMESTAMP(6)     NOT NULL,
     CONSTRAINT pk_undo_log PRIMARY KEY (id)
);
CREATE SEQUENCE seata.undo_log_id_seq START 1;

-----------------------------------------


create table if not exists seata_order.order_tbl(
  id serial not null,
  order_no varchar(255),
  user_id varchar(255),
  commodity_code varchar(255),
  "count" int4 default 0,
  ammount numeric(14,2) default 0,
  primary key (id)
)

-- 日志表
CREATE TABLE IF NOT EXISTS seata_order.undo_log
(
    id            BIGINT   NOT NULL,
    branch_id     BIGINT   NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info bytea     NOT NULL,
    log_status    INT          NOT NULL,
    log_created   TIMESTAMP(6)     NOT NULL,
    log_modified  TIMESTAMP(6)     NOT NULL,
     CONSTRAINT pk_undo_log PRIMARY KEY (id)
);
CREATE SEQUENCE seata_order.undo_log_id_seq START 1;

----------------------------------------
create table if not exists seata_stock.stock_tbl(
  id serial not null,
  commodity_code varchar(255),
  name varchar(255),
  "count" int4 default 0,
  primary key(id),
  unique (commodity_code)
)
-- 日志表
CREATE TABLE IF NOT EXISTS seata_stock.undo_log
(
    id            BIGINT   NOT NULL,
    branch_id     BIGINT   NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info bytea     NOT NULL,
    log_status    INT          NOT NULL,
    log_created   TIMESTAMP(6)     NOT NULL,
    log_modified  TIMESTAMP(6)     NOT NULL,
     CONSTRAINT pk_undo_log PRIMARY KEY (id)
);
CREATE SEQUENCE seata_stock.undo_log_id_seq START 1;

------------------------------------------------

select * from seata.t_account;

select * from seata_stock.stock_tbl st ;

select * from seata_order.order_tbl ot ;