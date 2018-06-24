SELECT id, count(*) AS num
FROM
    (SELECT requester_id as id FROM request_accepted
    UNION ALL
    SELECT accepter_id FROM request_accepted
    ) AS t1
GROUP BY id
ORDER BY num DESC
LIMIT 1;