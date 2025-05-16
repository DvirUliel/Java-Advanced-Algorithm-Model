# Java Advanced Project – Subarray Analysis System

## 📦 Part A: Algorithm Library (`AlgorithmModule`)

This module provides a reusable Java library for analyzing numeric sequences (e.g., stock price changes) using the **Subarray Sum** family of algorithms.

### ✅ Features:

* Interface `ISubarrayAnalyzer` defines the strategy for subarray analysis.
* Abstract class `AbstractSubarrayAnalyzer` implements shared logic.
* Two concrete algorithms:

  * `KadaneAnalyzer`: finds subarray with **maximum sum** (profit).
  * `PrefixSumAnalyzer`: finds the **longest subarray** with a given **target sum** (e.g., 0 for zero return).
* Output model: `SubarrayResult` (start index, end index, total sum).

### 🧪 Includes:

* Unit tests (JUnit 4) verifying correctness of each algorithm under edge cases and realistic input.

### 📁 Folder structure:

```
src/
├── AlgorithmModule/
│   ├── AbstractSubarrayAnalyzer.java
│   ├── ISubarrayAnalyzer.java
│   ├── KadaneAnalyzer.java
│   ├── PrefixSumAnalyzer.java
│   └── SubarrayResult.java
└── test/
    └── ISubarrayAnalyzerTest.java
```

---

© Developed as part of Java Advanced Course – Final Project
