Tutorial Examate

Overview

Tutorial Examate is an Android application built with Jetpack Compose to help users practice and prepare for exams efficiently. It offers multiple features such as study partner suggestions, question banks, tools for learning, and profile management. Users can sign in using Google authentication.

Features

Bottom Navigation: Five tabs (Home, Connect, Questions, Tools, Profile) for easy navigation.

Home Screen: Displays a welcome message and study resources.

Connect Screen: Suggests study partners with filtering options.

Questions Screen: Provides a list of questions and answers for practice.

Tools Screen: Offers various study tools in a grid format.

Profile Screen: Shows user details including avatar, name, email, and phone number.

Google Sign-In: Secure authentication with Firebase.

Technologies Used

Jetpack Compose: Modern UI toolkit for building native Android interfaces.

Navigation Component: Manages navigation between screens.

Firebase Authentication: Enables Google Sign-In functionality.

Clean Architecture: Ensures maintainability and separation of concerns.

Coil: Handles image loading efficiently.

Architecture

The app follows Clean Architecture principles:

Presentation Layer: Composables for UI.

Domain Layer: Business logic and use cases.

Data Layer: Handles authentication and other data operations.

Setup

Clone the repository:

git clone https://github.com/bassanthassanibrahim/RestartTask.git

Open the project in Android Studio.

Add your Google Services JSON file for Firebase authentication.

Run the app on an emulator or a physical device.
