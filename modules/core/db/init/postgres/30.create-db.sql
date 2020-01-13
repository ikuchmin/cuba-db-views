CREATE EXTENSION plpython3u;


-- backup useful function based on arrays
-- create or replace function contains_in_array(json_array json, val varchar) returns boolean as
-- $$
-- select array[val::uuid] <@ array(select json_array_elements_text(json_array::json)::uuid)
-- $$ language sql;

create or replace function contains_in_array(json_array json, val uuid) returns boolean as
$$
select json_array::jsonb ? val::text
$$ language sql;