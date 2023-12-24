create table if not exists seata.t_account(
  id serial not null,
  user_id varchar(255),
  amount numeric(14, 4),
  primary key(id)
)

create table if not exists seata.t_order(
  id serial not null,
  order_no varchar(255),
  user_id varchar(255),
  commodity_code varchar(255),
  "count" int4 default 0,
  amount numeric(14,2) default 0,
  primary key (id)
)


create table if not exists seata.t_stock(
  id serial not null,
  commodity_code varchar(255),
  name varchar(255),
  "count" int4 default 0,
  primary key(id),
  unique (commodity_code)
)

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

insert into seata.t_account(user_id, amount) values('1', 1000);

insert into seata.t_stock(commodity_code, "name", "count") values('1', '苹果', 100);


