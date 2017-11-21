# javaee.cadastro.cliente.hibernate
CRUD de cliente com Hibernate.

Projeto Maven - Web Application do Netbeans.

Tabela utilizada no projeto:
```sql
CREATE TABLE public.cliente
(
    id serial NOT NULL,
    nome character varying(100),
    telefone character varying(30),
    CONSTRAINT pk_cliente PRIMARY KEY (id)
)
```
