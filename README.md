# Cucumber - Parallel - Scenarios

In general, Cucumber Parallel Execution happens from Feature file level and doesn't execute test scenarios in Parallel within feature files. Which means, if there are 4 feature files and each feature file contains 10 sceanrios, it becomes 40 scenarios in total. Using the fork count and other parallel execution artifacts from Cucumber, it brings up 4 browsers and executes the scenarios one-by-one.

# How can we achive this?

Using TestNG's parallel function we can execute the scenarios in parallel. This sample project contains the code that executes the scenarios in parallel within the same feature file.

## License

This project is licensed under the MIT License - see [here](https://mit-license.org/) for details

## Author
Giridhar Rajkumar
