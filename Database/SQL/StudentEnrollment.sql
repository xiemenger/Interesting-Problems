
/**
 
 */

 SELECT StudentName, Students.StudentID, cnt
 FROM
   (
       SELECT Students.StudentID, count(StudentCourses.ID) as cnt
       FROM Students LEFT JOIN StudentCourses
       ON Students.StudentID = StudentCourses.StudentID
       GROUP BY Students.StudentID

   ) T INNER JOIN Students 
     ON T.StudentID = Students.StudentID;