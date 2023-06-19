CREATE TABLE IF NOT EXISTS public.project
(
    id bigint NOT NULL DEFAULT nextval('project_id_seq'::regclass),
    consumed_hours integer NOT NULL,
    name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    description character varying(256) COLLATE pg_catalog."default",p
    leader_id bigint,
    start_date date NOT NULL,
    end_date date,
    state smallint NOT NULL,
    CONSTRAINT project_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.project
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.task
(
    id bigint NOT NULL DEFAULT nextval('task_id_seq'::regclass),
    project_id bigint NOT NULL,
    priority smallint NOT NULL,
    state smallint NOT NULL,
    consumed_hours integer NOT NULL DEFAULT 0,
    due_date date,
    name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    description character varying(256) COLLATE pg_catalog."default",
    resource_id bigint,
    CONSTRAINT task_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.task
    OWNER to postgres;