# Jetpack Compose Login Page Sample
---

## What's this?
---

- This is a simple Login Page with SplashScreen;
- Learned:
    - Custom Composables;
    - LaunchedEffect to make the SplashScreen animation;
    - NavController for navigation;
    - Brush to make gradients backgrounds;
    - keyboardController to hide keyboard in imeAction;
    - relocationRequester to bring Into View some composable;
- Made CI workflow with GitHub Actions;
---

## How can I use it?
---

- If you want to check the App just download the APK on the GitHub Actions Tab;
- Drag the .apk into the emulator;
- And be happy!

## GitHub Actions
---

- Every "push" or "pull_request" on master branch will trigger this workflow;

- Created `.github/workflows/build.yml` with the following steps:
    - Checkout;
    - Setup Java JDK with `java-version: 1.8`;
    - Give permission to Gradle;
    - Build with Gradle;
    - and Upload APK (The uploaded APK will be in main Actions Tab);
