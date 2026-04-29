# Mastermind AI - Java

Object-oriented implementation of the classic Mastermind code-breaking game featuring multiple game modes, custom grading logic, and an AI opponent using constraint-based deduction.

## Overview
This project recreates Mastermind in Java while focusing on software design, game logic, and algorithmic problem solving.

Players can:
- Guess computer-generated codes
- Play against another player
- Let the computer solve the user's code using deduction logic

The project emphasizes object-oriented programming, modular design, and state-driven game logic.

## Features
- Single-player mode
- Player vs Player mode
- Computer code-breaking AI
- Rule-based grading engine
- Duplicate color handling
- Constraint-driven guessing logic
- Multi-class OOP design

## Tech Stack
- Java
- Object-Oriented Programming
- Algorithms
- Constraint Logic
- State Management

## Project Architecture

### Main.java
Program entry point and game orchestration.

### Game.java
Handles game flow, turns, and mode selection.

### Creator.java
Generates hidden code combinations.

### Grader.java
Evaluates guesses and returns feedback:
- Correct color / correct position
- Correct color / wrong position

### Guesser.java
Computer deduction engine that narrows possibilities based on feedback.

## AI Guessing Logic
The AI opponent:
- Tracks incorrect colors
- Preserves known correct positions
- Adjusts guesses using feedback
- Narrows solution possibilities iteratively

This introduces constraint-solving concepts similar to search algorithms.

## Example Concepts Used
- Separation of concerns
- State management
- Search/deduction logic
- Object-oriented architecture
- Algorithmic problem solving

## Why I Built It
I built this project to strengthen Java fundamentals while exploring how game logic and deduction algorithms can be modeled through software.

## What I Learned
This project strengthened:
- Java OOP design
- Algorithm development
- State mutation handling
- Problem decomposition
- Class architecture
- Game logic implementation

## Future Improvements
Planned improvements:
- Implement Knuth's 5-guess algorithm
- GUI version
- JUnit test suite
- Refactor to enums and collections
- Difficulty modes
- Probability-based AI improvements

## Run Locally
```bash
git clone https://github.com/zachariahrichards/your-repo-name.git
cd your-repo-name
javac Main.java
java Main
```

## Example Skills Demonstrated
- Java Development
- OOP Design
- Algorithms
- Logic Programming
- Software Architecture
