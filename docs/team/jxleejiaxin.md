---
layout: page
title: <Lee Jia Xin> Project Portfolio Page
---

### Project: HMHero

### What should be included

- [x] Code contributed
- [x] Enhancements implemented
- [x] Contributions to the UG (Optional)
- [x] Contributions to the DG (Optional)
- [x] Contributions to team-based tasks
- [x] Review/mentoring contributions
- [x] Contributions beyond the project team

(**Overview**)

HMHero is an Applicant Managing System designed to be used by human resource professionals, hiring managers,
  and recruiters who want to streamline the recruitment process and make it more efficient,
  helping their organizations manage job applications and hiring processes more effectively.

## **Summary of Contributions**

**Code contributed**: [RepoSense link](https://nus-cs2103-ay2223s2.github.io/tp-dashboard/?search=jxleejiaxin&breakdown=true)

#### **Enhancements implemented**

- **New Features Added**:

  - Interview Command which displays all shortlisted applicants sorted by interview date.

- **Enhancements to existing features**:

  - Create `Status` class and add corresponding field to Person class and updating `JsonAdaptedPerson`.
  - For all subsequent fields added (interview date, applied date), update `AddCommandParser`, `AddCommand`, `EditCommand`, `EditCommandParser`, `JsonAdaptedPerson`.
  - Add `NoteContainsKeywordsPredicate` to facilitate finding based on note prefix.
  - Improve find command's code quality by implementing single `Predicate<Person>` field as previously it had `NameContainsKeywordpredicate`, `PhoneContainsKeywordsPredicate` and `NamePhoneNumberPredicate` all as separate fields.
  - Update `FindCommand` and `FindCommandParser` to create and use `NoteContainsKeywordsPredicate` to find `Person` based on their notes.
This has since been adapted to `SkillCommand` as we decided to create a separate command for this feature.

- **Test Cases**:
  
  - Wrote test cases for FindCommand 

- **Documentation**:

  - Wrote the `About HMHero` and `Features` section in the User Guide.
  - Wrote and ensured correctness of Feature implementation section in Developer Guide.
  - Drew add, edit, find, advance command activity diagrams and find command sequence diagram.
  - Fixed some bugs found during PE-dryrun.
  - Fixed some bugs personally found in DG (links not working)

- **Community**:

  - Reviewed PRs from team members. Link to PRs reviewed: [PRs](https://github.com/AY2223S2-CS2103T-W14-4/tp/pulls?q=is%3Apr+is%3Aclosed+reviewed-by%3AJxleejiaxin)
  - Created some issues for TODOs.
  - Assisted members in debugging.

- **Tools**:

  - Git & Github
  - Java (IntelliJ)
  - PlantUML

