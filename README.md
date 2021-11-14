# Bachelor

_Continuous Integration/Continuous Delivery (CI/CD) in the context of database applications_

## Design Thinking Goal

The user is able to deploy database applications equally to CI/CD pipelines in classic software development. Must support the initial creation of a database application, non-destructive upgrade from each version at the customer, automated testing and git integration.

## Project phases

```mermaid
gantt
    title Database CI/CD
    dateFormat  YYYY-MM-DD
    section PM
        Project planning            :active,    PP,          2021-11-14,          140d
        Scrum process               :           SCRUM,       2021-11-14,          120d
    section Concept
        Architecture                :active,    ARCH,        2021-11-14,           14d
        UI Design Thinking          :           UI,          after SPRINT04,        7d
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
