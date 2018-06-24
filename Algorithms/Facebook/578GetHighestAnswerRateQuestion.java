SELECT question_id as survey_log
FROM survey_log 
GROUP BY question_id
ORDER BY COUNT(answer_id) / COUNT(IF(action =  '', 1, 0)) DESC
LIMIT 1;