# Write your MySQL query statement below

--  each machine_id of process_id timestamp(end - start)
with endtime as (
    select
        machine_id,
        process_id,
        timestamp as endtimestamp
    from
        Activity 
    where
        activity_type = "end"
)

select
    
    a.machine_id,
    ROUND(sum(e.endtimestamp - a.timestamp) / count(*), 3) processing_time 
from
    Activity a
join
    endtime e
    on a.machine_id = e.machine_id
    and a.process_id = e.process_id
where
    a.activity_type  != 'end'
group by
    a.machine_id
