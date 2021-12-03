# This is a simple Android Jetpack Compose Template
---

## Why?
---

- This is a template for studies purposes, so it is easier to clone and start a new Study Project;
- Made CI workflow with GitHub Actions;
---

## How can I use it?
---

- As a template, you just have to click on "Use this template" button;
- Create your repository;
- Clone it;
- Be happy coding

## GitHub Actions
---

- Every "push" or "pull_request" on master branch will trigger this workflow;

- Created `.github/workflows/build.yml` with the following steps:
    - Checkout;
    - Setup Java JDK with `java-version: 1.8`;
    - Give permission to Gradle;
    - Build with Gradle;
    - and Upload APK (The uploaded APK will be in main Actions Tab);
