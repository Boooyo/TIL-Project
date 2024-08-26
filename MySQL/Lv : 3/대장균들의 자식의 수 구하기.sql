SELECT
    e.ID,
    COUNT(c.ID) AS CHILD_COUNT
FROM
    ECOLI_DATA e
LEFT JOIN
    ECOLI_DATA c ON e.ID = c.PARENT_ID
GROUP BY
    e.ID
ORDER BY
    e.ID ASC;