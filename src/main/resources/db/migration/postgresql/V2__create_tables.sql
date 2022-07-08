SET client_encoding = 'UTF8';
SET TIME ZONE 'America/Sao_Paulo';

-- Cria sequence message_seq
CREATE SEQUENCE public.message_seq;
--ALTER SEQUENCE public.message_seq
--    OWNER to whatsapp_db_user;

-- Cria tabela message
CREATE TABLE public."message"
(
    id               bigint                 NOT NULL,
    message_to       character varying(255) NOT NULL,
    message_from     character varying(255) NOT NULL,
    message_body     character varying(255) NOT NULL,
    CONSTRAINT       message_pkey   PRIMARY KEY (id)
);

--ALTER TABLE public."message"
--    OWNER to whatsapp_db_user;
