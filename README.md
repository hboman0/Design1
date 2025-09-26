1. Architecture and Control of Depth/Allocations

MergeSort: Uses a reusable buffer to avoid repeated memory allocation during merges. Includes a small-n cut-off (insertion sort) for tiny subarrays.

QuickSort: Recurses on the smaller partition and iterates over the larger one to guarantee stack depth ≈ O(log n) on average.

Deterministic Select (Median-of-Medians): Recurses only into the necessary side, preferring the smaller partition to limit recursion depth.

Closest Pair (2D): Sorts points by x-coordinate, recursively splits, and checks the “strip” by y-coordinate. Recursion depth is tracked.


2. Recurrence Analysis
<img width="611" height="342" alt="image" src="https://github.com/user-attachments/assets/274e9ff9-9c2d-43ff-9ea4-ae05f0a146f1" />

3. Benchmark Results
<img width="257" height="302" alt="image" src="https://github.com/user-attachments/assets/f6996b39-66ac-435c-bed8-b53186fc7214" />

Graphs:
MergeSort:
Time:
<img width="482" height="286" alt="MergeSortTime" src="https://github.com/user-attachments/assets/e16a66b8-d437-4853-9192-4041680dcebc" />
Depth:
<img width="476" height="285" alt="MergeSortDepth" src="https://github.com/user-attachments/assets/49b2dcf6-b218-4336-aa55-89f8daec131a" />

QuickSort:
Time:
<img width="477" height="288" alt="QuickSortTime" src="https://github.com/user-attachments/assets/a4be56bd-3135-4e3f-b245-e27d4d640cd3" />
Depth:
<img width="477" height="287" alt="QuickSortDepth" src="https://github.com/user-attachments/assets/c44a8c15-0339-4258-a297-ef869cff8be6" />

DeterministicSelect:
Time:
<img width="478" height="291" alt="DeterministicSelectTime" src="https://github.com/user-attachments/assets/28b125fd-b8d7-41b6-bd27-e782e62823af" />
Depth:
<img width="480" height="289" alt="DeterministicSelectDepth" src="https://github.com/user-attachments/assets/e01844a1-9464-41b3-b68d-54279e922a19" />

ClosestPait:
Time:
<img width="481" height="288" alt="ClosestPairTime" src="https://github.com/user-attachments/assets/26b671b6-6ddf-4b47-acad-dcc1dbdc5f5c" />
Depth:
<img width="481" height="287" alt="ClosestPairDepth" src="https://github.com/user-attachments/assets/fbd7cd52-72e7-4edf-a1e8-fff13797492c" />

Time vs n: All algorithms scale roughly as n log n (linear for Select).

Recursion depth vs n: QuickSort and MergeSort ≈ log₂ n; Closest Pair behaves similarly.

Constant factor discussion: MergeSort is slower than QuickSort on small n due to merging; buffer reuse reduces memory overhead. Garbage collection impact is minimal.

4. Summary

Theory matches practice: All algorithms demonstrate the expected asymptotic behavior according to Master Theorem / Akra–Bazzi analysis.

QuickSort shows better constant factors but relies on randomized pivoting.

Deterministic Select scales linearly and correctly selects the k-th element.

Closest Pair works correctly for large n; validated against O(n²) naive approach for small n.







