# Contributing to Bank Inc Marketplace

We love your input! We want to make contributing to Bank Inc Marketplace as easy and transparent as possible, whether it's:

- Reporting a bug
- Discussing the current state of the code
- Submitting a fix
- Proposing new features
- Becoming a maintainer

## We Develop with Github
We use GitHub to host code, to track issues and feature requests, as well as accept pull requests.

## Development Process
We use GitHub Flow, so all code changes happen through pull requests:

1. Fork the repo and create your branch from `main`
2. If you've added code that should be tested, add tests
3. If you've changed APIs, update the documentation
4. Ensure the test suite passes
5. Make sure your code lints
6. Issue that pull request!

## Pull Request Process

1. Update the README.md with details of changes to the interface, if applicable
2. Update the documentation with any new API endpoints or changes
3. The PR will be merged once you have the sign-off of two other developers

## Code Style Guidelines

### Backend (Java)
- Follow Java Code Conventions
- Use meaningful variable and method names
- Add JavaDoc comments for public methods
- Keep methods small and focused
- Use constructor injection for dependencies
- Handle exceptions appropriately

### Frontend (Angular)
- Follow Angular Style Guide
- Use standalone components
- Keep components small and focused
- Use TypeScript's strict mode
- Follow reactive programming patterns
- Write descriptive commit messages

## Testing Guidelines

### Backend Tests
- Write unit tests for all services
- Test edge cases and error scenarios
- Use meaningful test names
- Follow AAA (Arrange, Act, Assert) pattern

### Frontend Tests
- Test components in isolation
- Mock external dependencies
- Test user interactions
- Verify component state changes

## Git Commit Messages
- Use the imperative mood ("Add feature" not "Added feature")
- Limit the first line to 72 characters or less
- Reference issues and pull requests liberally
- Consider starting the commit message with an applicable emoji:
    * 🎨 `:art:` when improving the format/structure of the code
    * 🐛 `:bug:` when fixing a bug
    * 📝 `:memo:` when writing docs
    * ✨ `:sparkles:` when adding a new feature

## Running Tests
### Backend
```bash
./mvnw test
```

### Frontend
```bash
ng test
```

## Any contributions you make will be under the MIT Software License
In short, when you submit code changes, your submissions are understood to be under the same [MIT License](http://choosealicense.com/licenses/mit/) that covers the project. Feel free to contact the maintainers if that's a concern.

## Report bugs using Github's [issue tracker](https://github.com/yourusername/repository/issues)
We use GitHub issues to track public bugs. Report a bug by [opening a new issue](https://github.com/yourusername/repository/issues/new).

## License
By contributing, you agree that your contributions will be licensed under its MIT License.

## References
This document was adapted from the open-source contribution guidelines for [Facebook's Draft](https://github.com/facebook/draft-js/blob/a9316a723f9e918afde44dea68b5f9f39b7d9b00/CONTRIBUTING.md).