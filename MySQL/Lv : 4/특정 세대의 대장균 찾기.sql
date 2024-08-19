-- SELECT 특정 세대의 대장균 찾기

WITH RECURSIVE Generation_CTE AS (
    SELECT
        ID,
        1 AS GENERATION
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT
        E.ID,
        G.GENERATION + 1 AS GENERATION
    FROM
        ECOLI_DATA E
    INNER JOIN
        Generation_CTE G
    ON
        E.PARENT_ID = G.ID
)
SELECT
    ID
FROM
    Generation_CTE
WHERE
    GENERATION = 3
ORDER BY
    ID;
