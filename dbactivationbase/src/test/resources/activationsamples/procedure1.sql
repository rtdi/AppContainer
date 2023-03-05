create or replace procedure return_greater(number_1 integer, number_2 integer, out result integer)
language sqlscript
as
begin
  if (:number_1 > :number_2) then
    result = :number_1;
  else
    result = :number_2;
  end if;
end;