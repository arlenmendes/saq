-- Table: colaborador

-- DROP TABLE colaborador;

CREATE TABLE colaborador
(
  nome character varying(50),
  email character varying(50),
  id serial NOT NULL,
  CONSTRAINT pk_colaborador PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);