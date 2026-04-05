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

Off-plan releases are denoted by a letter suffix (e.g. `0.2.0a`, `0.2.0b`).

---

## [0.3.5] - 2026-04-05

## [0.3.4] - 2026-04-03

### Changed
- README: roadmap tail — Contest 12 mapped to **0.5.0**; **1.0.0** is the **Finishing pass** milestone (documentation, changelog, and presentation polish for the first repository version); dropped the extra closing row that duplicated **1.0.0**.

---

## [0.3.3] - 2026-04-02

## [0.3.2] - 2026-04-01

---

## [0.3.1] - 2026-03-31

### Fixed
- README: reverted accidental propagation of Contest 6 Task 2 links into placeholder rows for Contests 7-12.
- README: aligned Block 3/4 theory roadmap with the updated training program (Block 3 has 2 theory topics; Block 4 has 5) and shifted contest version labels accordingly.
- README: added Editorial VK Video link for Block 2 contests section.

---

## [0.3.0] - 2026-03-30

## [0.2.6] - 2026-03-29

## [0.2.5] - 2026-03-28

---

## [0.2.4] - 2026-03-27

### Fixed
- README: corrected missed status checkmark for `0.2.3` (`⬜` -> `✅`).

---

## [0.2.3] - 2026-03-26

### Changed
- .gitignore: group local task files under a dedicated `Local task I/O` section (`/input.txt`, `/output.txt`).

---

## [0.2.2] - 2026-03-25

---

## [0.2.1] - 2026-03-24

### Changed
- Block 1: remove `practice` folder, move contents to `block1/` (packages `block1.practice.*` → `block1.*`).
- README: Block 2 theory aligned with [Yandex program](https://yandex.ru/yaintern/training/algorithm-training#programs__custom) — 4 topics (2.1 How a set works, 2.2 Problems on sets, 2.3 Problems on dictionaries, 2.4 Counting occurrences), contests renumbered (0.2.5, 0.2.6).
- README: update all Block 1 solution links.

---

## [0.2.0a] - 2026-03-23

### Added
- README: Editorial [VK Video](https://vkvideo.ru/video-220652761_456240128) for Block 1 contests.
- README: Bonus column for Contest 3 with [YouTube](https://youtu.be/RoU_Du18Uh8) for Task 2.

### Changed
- [MainRefined.java](src/block1/contest3/task2/MainRefined.java): simplified `checkDivs`, inlined `checkRows` logic.

---

## [0.2.0] - 2026-03-22

### Fixed
- CHANGELOG: align dates with commit dates (0.1.5 unreleased → 2026-03-21, 0.1.1/0.1.0/0.0.0 year 2025 → 2026).

---

## [0.1.5] - 2026-03-21

### Changed
- .gitignore: ignore `.cursor/`.
- README: full roadmap brought to the style established in 0.1.4 (theory and contests for Blocks 2–4); placeholder links removed.

---

## [0.1.4] - 2026-03-20

### Changed
- README: redesign of contest display for Warmup and Block 1.
- README: contest rating table at top of Progress (№, Task 1, Task 2, Penalty).

---

## [0.1.3] - 2026-03-19

### Changed
- CHANGELOG: fix 0.1.1 date (2026-03-16 → 2026-03-17)

---

## [0.1.2] - 2026-03-18

### Changed
- README: progress table conventions updated (task letter formatting `**A:**`, explicit `1st/2nd/3rd/4th task` columns, consistent naming for test-design tasks via `(tests)`).
- Block 1 practice: package/paths normalized from `block1.practice1.*` to `block1.practice.*`.

---

## [0.1.1] - 2026-03-17

### Changed
- CHANGELOG: removed plan completion summary lines; recording policy documented above.
- Minor Javadoc refactor in warmup task2: constraints notation (1e5/1e9 → 10<sup>5</sup>/10<sup>9</sup>).

---

## [0.1.0] - 2026-03-16

### Added
- Contest workflow: for each contest problem keep two variants of the solution:
  - contest-time version in `Main`;
  - refined, documented version in `MainRefined`.

### Changed
- README rework: Status column moved to first position in all progress tables; added links to contest, problem statements, and solution files (contest / refined).
- IntelliJ inspection profile (optional local IDE setting; safe to ignore): restrict duplicate-code inspection to the same file only, because each solution must be fully self-contained.

---

## [0.0.0] - 2026-03-15

### Added
- Project setup: Java 23 (Eclipse Temurin), build and run via IntelliJ (JPS), [repository](https://github.com/nikdenalb/my-algo-practice)
- README with progress table and run instructions, VERSION and CHANGELOG (versioning by training blocks)
