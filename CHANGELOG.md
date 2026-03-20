# Changelog

This file records the main changes in the project. The current roadmap is in [README](README.md).

**Recording policy:** VERSION is the record of plan completion (roadmap versions). CHANGELOG documents only changes beyond the plan — refactoring that touches other zones, structural or convention updates.

## Versioning

Version numbers follow the training structure.

| Component | Meaning |
|-----------|---------|
| **Major** | Training completion. Increments when the entire training is finished. |
| **Minor** | Block/section progression. Increments when moving to the next block. |
| **Patch** | Individual lessons and contests within a block. |

---

## [0.1.4] - 2026-03-20

### Changed
- README: redesign of contest display for Warmup and Block 1.
- README: contest rating table at top of Progress (№, Task 1, Task 2, Penalty).

---

## [0.1.3] - 2026-03-19

### Changed
- CHANGELOG: fix 0.1.1 date (2025-03-16 → 2025-03-17)

---

## [0.1.2] - 2026-03-18

### Changed
- README: progress table conventions updated (task letter formatting `**A:**`, explicit `1st/2nd/3rd/4th task` columns, consistent naming for test-design tasks via `(tests)`).
- Block 1 practice: package/paths normalized from `block1.practice1.*` to `block1.practice.*`.

---

## [0.1.1] - 2025-03-17

### Changed
- CHANGELOG: removed plan completion summary lines; recording policy documented above.
- Minor Javadoc refactor in warmup task2: constraints notation (1e5/1e9 → 10<sup>5</sup>/10<sup>9</sup>).

---

## [0.1.0] - 2025-03-16

### Added
- Contest workflow: for each contest problem keep two variants of the solution:
  - contest-time version in `Main`;
  - refined, documented version in `MainRefined`.

### Changed
- README rework: Status column moved to first position in all progress tables; added links to contest, problem statements, and solution files (contest / refined).
- IntelliJ inspection profile (optional local IDE setting; safe to ignore): restrict duplicate-code inspection to the same file only, because each solution must be fully self-contained.

---

## [0.0.0] - 2025-03-15

### Added
- Project setup: Java 23 (Eclipse Temurin), build and run via IntelliJ (JPS), [repository](https://github.com/nikdenalb/my-algo-practice)
- README with progress table and run instructions, VERSION and CHANGELOG (versioning by training blocks)
