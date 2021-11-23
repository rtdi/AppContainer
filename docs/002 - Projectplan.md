# Project Plan

The project is implemented following the Scrum philosophy of collecting backlog items, taking them on demand and implementing those in sprints. 
As such there are little dependencies between the items and some are marked as stretch goal.

## Project phases

```mermaid
gantt
    title Database CI/CD
    dateFormat  YYYY-MM-DD
    axisFormat  %Y-%m
    section PM
        Project planning            :active,    PP,          2021-11-14,          140d
        Scrum process               :           SCRUM,       2021-11-14,          120d
    section Concept
        Architecture                :active,    ARCH,        2021-11-14,           14d
        UI Design Thinking          :           UI,          after SPRINT04,        7d
        Documentation               :           DOC,         2022-03-01,           30d
    section Implement
        Sprint 1                    :           SPRINT01,    after ARCH,           14d
        Sprint 2                    :           SPRINT02,    after SPRINT01,       14d
        Sprint 3                    :           SPRINT03,    after SPRINT02,       14d
        Sprint 4                    :           SPRINT04,    after SPRINT03,       14d
        Sprint 5                    :           SPRINT05,    after SPRINT04,       14d
        Sprint 6                    :           SPRINT06,    after SPRINT05,       14d
        Sprint 7                    :           SPRINT07,    after SPRINT06,       14d
        Sprint 8                    :           SPRINT08,    after SPRINT07,       14d
        Sprint 9                    :           SPRINT09,    after SPRINT08,       14d
```