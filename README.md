# Yandex Algorithm Training 9.0

My solutions for [Yandex Algorithm Training 9.0](https://yandex.ru/yaintern/training/algorithm-training) «Тренировки: от алгоритмов к стажировке».

## Progress

| № | Task 1 | Task 2 | Penalty |
|---|--------|--------|---------|
| Next goal | ≤ 28:00 | ≤ 59:00 | 2 (≤ 87) |
| [Contest 2](https://new.contest.yandex.ru/contests/89534) | +<br>[00:10](src/block1/contest2/task1/Main.java) | +<br>[00:25](src/block1/contest2/task2/Main.java) | 2 (35) |
| [Contest 4](https://new.contest.yandex.ru/contests/89536) | +<br>[00:16](src/block2/contest4/task1/Main.java) | +<br>[00:35](src/block2/contest4/task2/Main.java) | 2 (52) |
| [Contest 1](https://new.contest.yandex.ru/contests/89533) | +<br>[00:12](src/block1/contest1/task1/Main.java) | +<br>[00:44](src/block1/contest1/task2/Main.java) | 2 (57) |
| [Contest 8](https://new.contest.yandex.ru/contests/89540) | +<br>[00:10](src/block3/contest8/task1/Main.java) | +<br>[00:48](src/block3/contest8/task2/Main.java) | 2 (59) |
| [Contest 7](https://new.contest.yandex.ru/contests/89539) | +<br>[00:46](src/block3/contest7/task1/Main.java) | +<br>[00:27](src/block3/contest7/task2/Main.java) | 2 (73) |
| [Contest 6](https://new.contest.yandex.ru/contests/89538) | +<br>[00:32](src/block2/contest6/task1/Main.java) | +<br>[00:56](src/block2/contest6/task2/Main.java) | 2 (88) |
| Result | — | — | 12 (364) |
| [Contest 10](https://new.contest.yandex.ru/contests/89542) | +<br>[00:33](src/block4/contest10/task1/Main.java) | +<br>[00:59](src/block4/contest10/task2/Main.java) | 2 (93) |
| [Contest 5](https://new.contest.yandex.ru/contests/89537) | +<br>[00:08](src/block2/contest5/task1/Main.java) | -<br>[failed](src/block2/contest5/task2/Main.java) | 1 (8) |
| [Contest 3](https://new.contest.yandex.ru/contests/89535) | +<br>[00:10](src/block1/contest3/task1/Main.java) | -<br>[failed](src/block1/contest3/task2/Main.java) | 1 (10) |
| [Contest 11](https://new.contest.yandex.ru/contests/89543) | +<br>[00:20](src/block4/contest11/task1/Main.java) | -<br>[failed](src/block4/contest11/task2/Main.java) | 1 (20) |
| [Contest 9](https://new.contest.yandex.ru/contests/89541) | +<br>[00:31](src/block3/contest9/task1/Main.java) | -<br>[failed](src/block3/contest9/task2/Main.java) | 1 (31) |
| Contest 12 | — | — | — |

### Warmup

**0.1.0** ✅

**Test contest:** [Yandex Contest](https://new.contest.yandex.ru/contests/89606)

**Editorial:** [VK Video](https://vkvideo.ru/video-220652761_456240094) (from 36:00)

| # | Task link | Live solution | Refined solution |
|---|------|---------------|------------------|
| Task 1 | [Decode the string](https://new.contest.yandex.ru/contests/89606/problems?id=30404%2F2023_02_12%2FLiYbwI4iG4) | [Main.java](src/warmup/task1/Main.java) | [MainRefined.java](src/warmup/task1/MainRefined.java) |
| Task 2 | [Oligopoly](https://new.contest.yandex.ru/contests/89606/problems?id=30404%2F2026_02_06%2F1U5A7PMMJk) | [Main.java](src/warmup/task2/Main.java) | [MainRefined.java](src/warmup/task2/MainRefined.java) |

### Block 1: Complexity, testing, edge cases

[**Theory**](https://vkvideo.ru/video-220652761_456240094)

| Status | # | Topic | 1st task | 2nd task | 3rd task | 4th task |
|--------|---|-------|----------|----------|----------|----------|
| ✅ | 0.1.1 | [1.1 Algorithm complexity](https://disk.yandex.ru/d/iQbfEuLDTFOjqg/B1_T_1_L_draft3.mp4)<br>[Practice](https://new.contest.yandex.ru/contests/89513) \| [Editorial](https://disk.yandex.ru/d/iQbfEuLDTFOjqg/B1_T_1_Z_draft3.mp4) | **A:** [Tree painting](https://new.contest.yandex.ru/contests/89513/problems?id=30404%2F2019_04_20%2F0vHYYXV4gG)<br>[solution](src/block1/taska/Main.java) | **B:** [Ambulance](https://new.contest.yandex.ru/contests/89513/problems?id=56057%2F2015_11_22%2F76mwS29eYw)<br>[solution](src/block1/taskb/Main.java) | — | — |
| ✅ | 0.1.2 | [1.2 Testing your own program](https://disk.yandex.ru/d/iQbfEuLDTFOjqg/B1_T_2_L_draft3.mp4)<br>[Practice](https://new.contest.yandex.ru/contests/89514) \| [Editorial](https://disk.yandex.ru/d/iQbfEuLDTFOjqg/B1_T_2_Z_draft4.mp4) | **C:** [Air conditioner (tests)](https://new.contest.yandex.ru/contests/89514/problems?id=30404%2F2024_10_20%2FOfoOm3Naao)<br>[solution](src/block1/taskc/Main) | **D:** [Air conditioner](https://new.contest.yandex.ru/contests/89514/problems?id=30404%2F2021_05_13%2FrFKSEzJqpU)<br>[solution](src/block1/taskd/Main.java) | **E:** [Maximum product of two numbers (tests)](https://new.contest.yandex.ru/contests/89514/problems?id=30404%2F2024_10_20%2FHAb5mBblNi)<br>[solution](src/block1/taske/Main) | **F:** [Maximum product of two numbers](https://new.contest.yandex.ru/contests/89514/problems?id=175943%2F2016_10_02%2FaTZNpVtH2V)<br>[solution](src/block1/taskf/Main.java) |
| ✅ | 0.1.3 | [1.3 Test automation](https://disk.yandex.ru/d/iQbfEuLDTFOjqg/B1_T_3_L_draft3.mp4)<br>[Practice](https://new.contest.yandex.ru/contests/89515) \| [Editorial](https://disk.yandex.ru/d/iQbfEuLDTFOjqg/B1_T_3_Z_draft3.mp4) | **G:** [Houses and shops](https://new.contest.yandex.ru/contests/89515/problems?id=30404%2F2021_08_20%2FivtVjWoF0V&contestId=89515)<br>[solution](src/block1/taskg/Main.java) | **H:** [Equation with square root](https://new.contest.yandex.ru/contests/89515/problems?id=30404%2F2020_09_26%2FE0bUCqDLBR&contestId=89515)<br>[solution](src/block1/taskh/Main.java) | **I:** [T-shirts and socks](https://new.contest.yandex.ru/contests/89515/problems?id=30404%2F2024_10_19%2FGleLWiHsN0&contestId=89515)<br>[solution](src/block1/taski/Main.java) | **J:** [Parallelogram](https://new.contest.yandex.ru/contests/89515/problems?id=30404%2F2021_08_19%2FQ28VmrWEnn&contestId=89515)<br>[solution](src/block1/taskj/Main.java) |

**Contests**

**Editorial:** [VK Video](https://vkvideo.ru/video-220652761_456240128)

**0.1.4** ✅

**Contest 1:** [Yandex Contest](https://new.contest.yandex.ru/contests/89533)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Domino placement](https://new.contest.yandex.ru/contests/89533/problems?id=30404%2F2026_03_01%2FddXXToAYxk&contestId=89533) | [Main.java](src/block1/contest1/task1/Main.java) | [MainRefined.java](src/block1/contest1/task1/MainRefined.java) |
| Task 2 | [Standing wave](https://new.contest.yandex.ru/contests/89533/problems?id=30404%2F2026_03_01%2FP9YvSLqof7&contestId=89533) | [Main.java](src/block1/contest1/task2/Main.java) | [MainRefined.java](src/block1/contest1/task2/MainRefined.java) |

**0.1.5** ✅

**Contest 2:** [Yandex Contest](https://new.contest.yandex.ru/contests/89534)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Ahaha](https://new.contest.yandex.ru/contests/89534/problems?id=30404%2F2026_03_01%2FlSDcPWTDzA&contestId=89534) | [Main.java](src/block1/contest2/task1/Main.java) | [MainRefined.java](src/block1/contest2/task1/MainRefined.java) |
| Task 2 | [Sheet packing](https://new.contest.yandex.ru/contests/89534/problems?id=30404%2F2026_03_01%2F2ND2RB8F4R&contestId=89534) | [Main.java](src/block1/contest2/task2/Main.java) | [MainRefined.java](src/block1/contest2/task2/MainRefined.java) |

**0.2.0** ✅

**Contest 3:** [Yandex Contest](https://new.contest.yandex.ru/contests/89535)

| # | Task link | Live solution | Refined solution | Bonus |
|---|-----------|---------------|------------------|-------|
| Task 1 | [Rebus](https://new.contest.yandex.ru/contests/89535/problems?id=30404%2F2026_03_01%2FPbJ66A8D1W&contestId=89535) | [Main.java](src/block1/contest3/task1/Main.java) | [MainRefined.java](src/block1/contest3/task1/MainRefined.java) | — |
| Task 2 | [Bunker exam](https://new.contest.yandex.ru/contests/89535/problems?id=30404%2F2026_03_01%2FaTLZNKrRRU&contestId=89535) | [Main.java](src/block1/contest3/task2/Main.java) | [MainRefined.java](src/block1/contest3/task2/MainRefined.java) | [YouTube](https://youtu.be/RoU_Du18Uh8) |

### Block 2: Sets and dictionaries

**Theory**

| Status | # | Topic | 1st task | 2nd task | 3rd task | 4th task |
|--------|---|-------|----------|----------|----------|----------|
| ✅ | 0.2.1 | [2.1 How a set works](https://vkvideo.ru/video-220652761_456240112)<br>[Practice](https://new.contest.yandex.ru/contests/89518) \| [Editorial](https://vkvideo.ru/video-220652761_456240113) | **A:** [Number of distinct numbers](https://new.contest.yandex.ru/contests/89518/problems?id=175943%2F2016_10_05%2FNepkmQOKvw)<br>[solution](src/block2/taska/Main.java) | **B:** [Has the number been seen before](https://new.contest.yandex.ru/contests/89518/problems?id=175943%2F2016_10_05%2FUMhQ1iX3LS)<br>[solution](src/block2/taskb/Main.java) | **C:** [Intersection of sets](https://new.contest.yandex.ru/contests/89518/problems?id=175943%2F2016_10_05%2FLq0Bt3dLjD)<br>[solution](src/block2/taskc/Main.java) | — |
| ✅ | 0.2.2 | [2.2 Problems on sets](https://vkvideo.ru/video-220652761_456240114)<br>[Practice](https://new.contest.yandex.ru/contests/89519) \| [Editorial](https://vkvideo.ru/video-220652761_456240115) | **D:** [Polyglots](https://new.contest.yandex.ru/contests/89519/problems?id=175943%2F2016_10_05%2FDuMNHdcUda)<br>[solution](src/block2/taskd/Main.java) | **E:** [Turtles](https://new.contest.yandex.ru/contests/89519/problems?id=175943%2F2016_10_12%2FuEI76U0GdB)<br>[solution](src/block2/taske/Main.java) | — | — |
| ✅ | 0.2.3 | [2.3 Problems on dictionaries](https://vkvideo.ru/video-220652761_456240121)<br>[Practice](https://new.contest.yandex.ru/contests/89520) \| [Editorial](https://vkvideo.ru/video-220652761_456240117) | **F:** [Dictionary of synonyms](https://new.contest.yandex.ru/contests/89520/problems?id=175943%2F2016_10_09%2FDsLn6vwVnE)<br>[solution](src/block2/taskf/Main.java) | **G:** [Sales](https://new.contest.yandex.ru/contests/89520/problems?id=175943%2F2016_10_09%2F92iLVtk3Sf)<br>[solution](src/block2/taskg/Main.java) | **H:** [Bank accounts](https://new.contest.yandex.ru/contests/89520/problems?id=175943%2F2016_10_09%2FFhWFF22cXL)<br>[solution](src/block2/taskh/Main.java) | — |
| ✅ | 0.2.4 | [2.4 Counting occurrences](https://vkvideo.ru/video-220652761_456240118)<br>[Practice](https://new.contest.yandex.ru/contests/89521) \| [Editorial](https://vkvideo.ru/video-220652761_456240119) | **I:** [Palindrome](https://new.contest.yandex.ru/contests/89521/problems?id=30404%2F2018_03_12%2F2oXhUy1rrL)<br>[solution](src/block2/taski/Main.java) | **J:** [Maya writing decryption](https://new.contest.yandex.ru/contests/89521/problems?id=30404%2F2018_03_13%2F3WMjhWoEpY)<br>[solution](src/block2/taskj/Main.java) | — | — |

**Contests**

**Editorial:** [VK Video](https://vkvideo.ru/video-220652761_456240096?sh=4&list=8e70a4abc73530f61e)

**0.2.5** ✅

**Contest 4:** [Yandex Contest](https://new.contest.yandex.ru/contests/89536)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Desktop basketball](https://new.contest.yandex.ru/contests/89536/problems?id=30404%2F2026_03_01%2FsI2vS9YmUm) | [Main.java](src/block2/contest4/task1/Main.java) | [MainRefined.java](src/block2/contest4/task1/MainRefined.java) |
| Task 2 | [Paired k-prefixes](https://new.contest.yandex.ru/contests/89536/problems?id=30404%2F2026_03_01%2Fxu67mpn1rH) | [Main.java](src/block2/contest4/task2/Main.java) | [MainRefined.java](src/block2/contest4/task2/MainRefined.java) |

**0.2.6** ✅

**Contest 5:** [Yandex Contest](https://new.contest.yandex.ru/contests/89537)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Rover search](https://new.contest.yandex.ru/contests/89537/problems?id=30404%2F2026_03_01%2F3aTS4WcGaP) | [Main.java](src/block2/contest5/task1/Main.java) | [MainRefined.java](src/block2/contest5/task1/MainRefined.java) |
| Task 2 | [Non-overlapping substrings](https://new.contest.yandex.ru/contests/89537/problems?id=30404%2F2026_03_01%2FQa3Z4KPTDR) | [Main.java](src/block2/contest5/task2/Main.java) | [MainRefined.java](src/block2/contest5/task2/MainRefined.java) |

**0.3.0** ✅

**Contest 6:** [Yandex Contest](https://new.contest.yandex.ru/contests/89538)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Big and divisible by three](https://new.contest.yandex.ru/contests/89538/problems?id=30404%2F2026_03_01%2FGcSoXQkF3S) | [Main.java](src/block2/contest6/task1/Main.java) | [MainRefined.java](src/block2/contest6/task1/MainRefined.java) |
| Task 2 | [Not in your own plate](https://new.contest.yandex.ru/contests/89538/problems?id=30404%2F2026_03_01%2F9c8kDjsgHV) | [Main.java](src/block2/contest6/task2/Main.java) | [MainRefined.java](src/block2/contest6/task2/MainRefined.java) |

### Block 3: Prefix sums and two pointers

**Theory**

| Status | # | Topic | 1st task | 2nd task | 3rd task | 4th task | 5th task |
|--------|---|-------|----------|----------|----------|----------|----------|
| ✅ | 0.3.1 | [3.1 Prefix sums](https://vkvideo.ru/video-220652761_456240132)<br>[Practice](https://new.contest.yandex.ru/contests/89523) \| [Editorial](https://vkvideo.ru/video-220652761_456240124) | **A:** [Prefix sums](https://new.contest.yandex.ru/contests/89523/problems?id=30404%2F2023_02_12%2FFjysFo4AwB)<br>[solution](src/block3/taska/Main.java) | **B:** [Range sum without updates](https://new.contest.yandex.ru/contests/89523/problems?id=928%2F2026_02_18%2F6ruPHNt9QT)<br>[solution](src/block3/taskb/Main.java) | **C:** [Maximal Sum](https://new.contest.yandex.ru/contests/89523/problems?id=7%2F2020_11_06%2FoQhYgpLhih)<br>[solution](src/block3/taskc/Main.java) | **D:** [Sum of numbers](https://new.contest.yandex.ru/contests/89523/problems?id=30404%2F2019_04_20%2FX5XQ74CADd)<br>[solution](src/block3/taskd/Main.java) | **E:** [Sum of triple products](https://new.contest.yandex.ru/contests/89523/problems?id=30404%2F2024_10_27%2F2rqPnG0bip)<br>[solution](src/block3/taske/Main.java) |
| ✅ | 0.3.2 | [3.2 Two pointers](https://vkvideo.ru/video-220652761_456240123)<br>[Practice](https://new.contest.yandex.ru/contests/89524) \| [Editorial](https://vkvideo.ru/video-220652761_456240125) | **F:** [Stylish clothes](https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2018_11_06%2FiKSicqI2LF)<br>[solution](src/block3/taskf/Main.java) | **G:** [City Che](https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2021_06_01%2Fw4VP0pHEF6)<br>[solution](src/block3/taskg/Main.java) | **H:** [Friendship won](https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2025_08_24%2FAdlDZ8GJ7Q)<br>[solution](src/block3/taskh/Main.java) | **I:** [Beauty above all](https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2021_06_01%2F7yFSb8a0Zt)<br>[solution](src/block3/taski/Main.java) | **J:** [Substring](https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2021_06_01%2FBx8AwMAiv3)<br>[solution](src/block3/taskj/Main.java) |

**Contests**

**0.3.3** ✅

**Contest 7:** [Yandex Contest](https://new.contest.yandex.ru/contests/89539)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Dance school](https://new.contest.yandex.ru/contests/89539/problems?id=30404%2F2025_06_18%2F36Q7seV1id) | [Main.java](src/block3/contest7/task1/Main.java) | [MainRefined.java](src/block3/contest7/task1/MainRefined.java) |
| Task 2 | [Candy subsegment](https://new.contest.yandex.ru/contests/89539/problems?id=30404%2F2026_03_01%2FQbex9H1n9L) | [Main.java](src/block3/contest7/task2/Main.java) | [MainRefined.java](src/block3/contest7/task2/MainRefined.java) |

**0.3.4** ✅

**Contest 8:** [Yandex Contest](https://new.contest.yandex.ru/contests/89540)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Cell painting](https://new.contest.yandex.ru/contests/89540/problems?id=30404%2F2026_03_01%2FZSSos64DZz) | [Main.java](src/block3/contest8/task1/Main.java) | [MainRefined.java](src/block3/contest8/task1/MainRefined.java) |
| Task 2 | [Cafeteria queue](https://new.contest.yandex.ru/contests/89540/problems?id=30404%2F2026_02_21%2F1KdDEqxsEa) | [Main.java](src/block3/contest8/task2/Main.java) | [MainRefined.java](src/block3/contest8/task2/MainRefined.java) |

**0.4.0** ✅

**Contest 9:** [Yandex Contest](https://new.contest.yandex.ru/contests/89541)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Final grade](https://new.contest.yandex.ru/contests/89541/problems?id=30404%2F2026_03_01%2F4wKqIj2wx0) | [Main.java](src/block3/contest9/task1/Main.java) | [MainRefined.java](src/block3/contest9/task1/MainRefined.java) |
| Task 2 | [Vasya's unlucky number](https://new.contest.yandex.ru/contests/89541/problems?id=30404%2F2025_04_26%2Fp1ZF4rAZuN) | [Main.java](src/block3/contest9/task2/Main.java) | [MainRefined.java](src/block3/contest9/task2/MainRefined.java) |

### Block 4: Stacks, queues, deques

**Theory**

| Status | # | Topic | 1st task | 2nd task |
|--------|---|-------|----------|----------|
| ✅ | 0.4.1 | [4.1 Stack and function call mechanism](https://vkvideo.ru/video-220652761_456240133)<br>[Practice](https://new.contest.yandex.ru/contests/89528) \| [Editorial](https://vkvideo.ru/video-220652761_456240141) | **A:** [Stack with error protection](https://new.contest.yandex.ru/contests/89528/problems?id=175943%2F2016_11_22%2FF1DnicRrIx)<br>[solution](src/block4/taska/Main.java) | **B:** [Wagon sorting lite](https://new.contest.yandex.ru/contests/89528/problems?id=30404%2F2021_12_13%2F2EeqSEdSfr)<br>[solution](src/block4/taskb/Main.java) |
| ✅ | 0.4.2 | [4.2 Balanced parentheses](https://vkvideo.ru/video-220652761_456240135)<br>[Practice](https://new.contest.yandex.ru/contests/89529) \| [Editorial](https://vkvideo.ru/video-220652761_456240146) | **C:** [Valid bracket sequence](https://new.contest.yandex.ru/contests/89529/problems?id=175943%2F2016_11_22%2FeSUHFTjBwZ)<br>[solution](src/block4/taskc/Main.java) | **D:** [Minimum valid bracket sequence](https://new.contest.yandex.ru/contests/89529/problems?id=30404%2F2024_11_02%2FmyVIGk5VNm)<br>[solution](src/block4/taskd/Main.java) |
| ✅ | 0.4.4 | [4.3 Postfix notation (YouTube)](https://youtu.be/ZohRrd1Chfo)<br>[Practice](https://new.contest.yandex.ru/contests/89530) \| [Editorial](https://vkvideo.ru/video-220652761_456240143) | **E:** [Postfix notation](https://new.contest.yandex.ru/contests/89530/problems?id=30404%2F2023_01_18%2FqS3OsBniXH)<br>[solution](src/block4/taske/Main.java) | **F:** [Arithmetic expression value](https://new.contest.yandex.ru/contests/89530/problems?id=30404%2F2023_01_18%2FHgDt2DvsLq)<br>[solution](src/block4/taskf/Main.java) |
| ⬜ | 0.4.6 | 4.4 Record stack<br>Practice \| Editorial | — | — |
| ⬜ | 0.4.8 | 4.5 Queue and deque<br>Practice \| Editorial | — | — |

**Contests**

**0.4.3** ✅

**Contest 10:** [Yandex Contest](https://new.contest.yandex.ru/contests/89542)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Counting squares](https://new.contest.yandex.ru/contests/89542/problems?id=30404%2F2026_03_01%2F4ZbscdEIOI) | [Main.java](src/block4/contest10/task1/Main.java) | [MainRefined.java](src/block4/contest10/task1/MainRefined.java) |
| Task 2 | [Telemetry](https://new.contest.yandex.ru/contests/89542/problems?id=30404%2F2026_03_01%2FiIkWLqxwqb) | [Main.java](src/block4/contest10/task2/Main.java) | [MainRefined.java](src/block4/contest10/task2/MainRefined.java) |

**0.4.5** ✅

**Contest 11:** [Yandex Contest](https://new.contest.yandex.ru/contests/89543)

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | [Bracket cyclic shift](https://new.contest.yandex.ru/contests/89543/problems?id=30404%2F2026_03_01%2FaWLgjLfK6L) | [Main.java](src/block4/contest11/task1/Main.java) | [MainRefined.java](src/block4/contest11/task1/MainRefined.java) |
| Task 2 | [Practice tests](https://new.contest.yandex.ru/contests/89543/problems?id=30404%2F2026_03_01%2Fsmt8Z50leS) | [Main.java](src/block4/contest11/task2/Main.java) | [MainRefined.java](src/block4/contest11/task2/MainRefined.java) |

**0.4.7** ⬜

**Contest 12:** Yandex Contest

| # | Task link | Live solution | Refined solution |
|---|-----------|---------------|------------------|
| Task 1 | — | — | — |
| Task 2 | — | — | — |

**1.0.0** ⬜

**Finishing pass:** polish documentation and presentation, align README with final state, tighten changelog and version hygiene, optional repo cosmetics — final step for the first repository version (v1.0).

## Technologies

- Java 23 (Eclipse Temurin)
- IntelliJ IDEA

## How to run

The project includes IntelliJ IDEA configuration files (`.iml`, `.idea/`). Open in IntelliJ and run any `Main.java` directly.

Since each task is a standalone algorithm problem, you can also run without IDE:

```bash
javac src/block1/contest1/task1/Main.java
java -cp src block1.contest1.task1.Main
```
