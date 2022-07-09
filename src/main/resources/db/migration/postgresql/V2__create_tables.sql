SET client_encoding = 'UTF8';
SET TIME ZONE 'America/Sao_Paulo';

-- Cria sequence message_seq
CREATE SEQUENCE public.message_seq;

-- Cria tabela message
CREATE TABLE public."message"
(
    id               bigint                  NOT NULL,
    message_to       character varying(50)   NOT NULL,
    message_from     character varying(50)   NOT NULL,
    message_body     character varying(1000) NOT NULL,
    direction        character varying(3)    NOT NULL,
    channel          character varying(100)  NOT NULL,
    create_date_time timestamp               NOT NULL,
    CONSTRAINT message_pkey PRIMARY KEY (id)
);

-- Cria sequence webhook_message_seq
CREATE SEQUENCE public.webhook_message_seq;

-- Cria tabela webhook_message
CREATE TABLE public."webhook_message"
(
    id               bigint                    NOT NULL,
    content_body     character varying(999999) NOT NULL,
    create_date_time timestamp                 NOT NULL,
    CONSTRAINT webhook_message_pkey PRIMARY KEY (id)
);
