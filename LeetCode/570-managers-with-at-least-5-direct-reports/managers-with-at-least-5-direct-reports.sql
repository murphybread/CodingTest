# Write your MySQL query statement below
with five as (
    select
        managerId 
    from
        Employee 
    group by
        managerId
    having
        count(*) >=5

)
select
    e.name
from
    Employee e
join five f
    on e.id = f.managerId 