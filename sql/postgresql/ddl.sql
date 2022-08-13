CREATE TABLE "user_tbl" (
    "id" bigserial not null,
    "name" character varying(1024) not null,
    "age" smallint,
    "memo" text,
    CONSTRAINT user_id_pkc PRIMARY KEY ("id")
);
