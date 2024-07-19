CREATE EXTENSION plpythonu;

create or replace function square(val integer)
return integer as $$ return val * val $$ LANGUAGE plpythonu;