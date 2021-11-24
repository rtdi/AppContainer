# Project Plan

The project is implemented following the Scrum philosophy of collecting backlog items, taking them on demand and implementing those in sprints. 
As such there are little dependencies between the items and some are marked as stretch goal.

## Project phases

```mermaid
gantt
    title Database CI/CD (274h)
    dateFormat  YYYY-MM-DD
    axisFormat  %Y-%m
    section PM (24h)
        Project planning (8h)             :active,    PP,          2021-11-14,          140d
        Scrum process (16h)               :           SCRUM,       2021-11-14,          120d
    section Concept (70h)
        Architecture (20h)                :active,    ARCH,        2021-11-14,           14d
        UI Design Thinking (10h)          :           UI,          after SPRINT04,        7d
        Documentation (40h)               :           DOC,         2022-03-01,           30d
    section Implement (180h)
        Sprint 1 (20h)                    :           SPRINT01,    after ARCH,           14d
        Sprint 2 (20h)                    :           SPRINT02,    after SPRINT01,       14d
        Sprint 3 (20h)                    :           SPRINT03,    after SPRINT02,       14d
        Sprint 4 (20h)                    :           SPRINT04,    after SPRINT03,       14d
        Sprint 5 (20h)                    :           SPRINT05,    after SPRINT04,       14d
        Sprint 6 (20h)                    :           SPRINT06,    after SPRINT05,       14d
        Sprint 7 (20h)                    :           SPRINT07,    after SPRINT06,       14d
        Sprint 8 (20h)                    :           SPRINT08,    after SPRINT07,       14d
        Sprint 9 (20h)                    :           SPRINT09,    after SPRINT08,       14d
```


## Time budget

For a two week task 20h of work are allocated.
Hence the entire time budget is 274h.

Time tracking is done using the Swipetimes app plus entered in the Gitlab issues as /spend comment.



