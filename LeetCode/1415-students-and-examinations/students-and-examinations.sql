WITH StudentSubject AS (
    SELECT 
        s.student_id, 
        s.student_name, 
        sub.subject_name
    FROM 
        Students s, 
        Subjects sub
),
ExamCount AS (
    SELECT 
        student_id, 
        subject_name, 
        COUNT(*) AS exam_count
    FROM 
        Examinations
    GROUP BY 
        student_id, subject_name
)

SELECT 
    ss.student_id, 
    ss.student_name, 
    ss.subject_name, 
    SUM(CASE WHEN ec.exam_count IS NULL THEN 0 ELSE ec.exam_count END)  AS attended_exams
FROM 
    StudentSubject ss
LEFT JOIN 
    ExamCount ec ON ss.student_id = ec.student_id AND ss.subject_name = ec.subject_name
GROUP BY
    ss.student_id, ss.student_name, ss.subject_name 
ORDER BY 
    ss.student_id, ss.subject_name;

