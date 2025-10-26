# Pluralsight Java SE Foundations: Exception Handling

Demo code for the "Java SE Foundations: Exception Handling" course on Pluralsight

## Project Structure

This repository is organized into modules, where each module corresponds to a section of the course. Each module is structured as its own independent Maven project.

### Module Organization

```
pluralsight-java-foundations-exception-handling/
├── m1/                          # Module 1 - Exception Foundamentals
│   ├── m1-before/              # Starting point code
│   ├── m1-complete/            # Completed code with solutions
│   └── pom.xml                 # Parent POM for module 1
├── m2/                          # Module 2 - Exception Handling Basics
│   ├── m1-before/              # Starting point code
│   ├── m1-complete/            # Completed code with solutions
│   └── pom.xml                 # Parent POM for module 2
├── m3/                          # Module 3 - Exception Propagation and Creation
│   ├── m1-before/              # Starting point code
│   ├── m1-complete/            # Completed code with solutions
│   └── pom.xml                 # Parent POM for module 3
├── m4/                          # Module 4 - Exception Propagation and Creation
│   ├── m1-before/              # Starting point code
│   ├── m1-complete/            # Completed code with solutions
│   └── pom.xml                 # Parent POM for module 4
├── m5/                          # Module 5 - Best Practices and Patterns
│   ├── m1-before/              # Starting point code
│   ├── m1-complete/            # Completed code with solutions
│   └── pom.xml                 # Parent POM for module 5
```

### Before and Complete Directories

Each module contains two sub-modules:

- **`before`** - Starting point code that you can work with while following along with the course
- **`complete`** - Finished code showing the completed implementation after the module

## Dependencies

To run the applications in this repository, you need:

### Required Software

- **Java Development Kit (JDK) 24** or higher
- **Maven 3.6+** for building and running the projects

### Verify Installation

```bash
# Check Java version
java -version

# Check Maven version
mvn -version
```

## Running the Applications

### Build a Specific Module

```bash
cd m1
mvn clean install
```

### Run a Specific Sub-module

#### Using Maven

```bash
cd m1/m1-complete
mvn clean compile exec:java
```

#### Using IDE

- Go to `Application` class
- Run `main` method

## Notes

- Each module is self-contained with its own POM configuration
- The `before` directories are designed to be edited as you follow the course
- The `complete` directories serve as reference implementations
