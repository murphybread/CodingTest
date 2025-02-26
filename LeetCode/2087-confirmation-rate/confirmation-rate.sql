# Write your MySQL query statement below
with
confirmCount as (
    select
        user_id,
        SUM(case when action = 'confirmed' then 1 else 0 end) confirmCount
    from
        Confirmations 
    group by
        user_id 
),
allCount as (
    select
        s.user_id,
        ifnull(cc.confirmCount,0) allCount
    from
        Signups s
    left join 
        confirmCount cc
        on s.user_id = cc.user_id
)
select
    a.user_id,
    round(a.allCount /count(*) ,2)confirmation_rate
from
    Confirmations c
right join
    allCount a
    on a.user_id = c.user_id
group by
    a.user_id


