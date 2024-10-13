## **Medical Information App**

**Description:**

This Android application provides users with essential information regarding medications and lab results for specific health conditions. It features a simple login screen, personalized greetings, and detailed views of medication data.

**Key Features:**

  - **User Authentication:** A basic login screen (no validation required) to allow users to access the app.
  - **Personalized Greetings:** User greetings tailored to the time of day, enhancing the user experience.
  - **Medication Information:** Fetches medication details from a JSON API (or mock API) and displays them in a user-friendly format.
  - **Detailed Views:** Provides detailed information about each medication, including name, dose, and strength.
  - **Data Storage:** Uses Room Database for persistent data storage, allowing users to access their medication information offline.
  - **Unit Tests:** Comprehensive unit tests to ensure the app's reliability and accuracy.
  - **Dependency Injection:** Utilizes Hilt for dependency injection, improving code maintainability and testability.
  - **Navigation Graph:** Employs Navigation Graph for seamless navigation between app screens.

**Architecture:**

  - **MVVM (Model-View-ViewModel):** Separates concerns into distinct layers for better organization and maintainability.
  - **Kotlin:** Uses Kotlin for modern Android development with its concise syntax and features.
  - **Jetpack Compose:** Leverages Jetpack Compose for a declarative UI approach, simplifying UI development.
  - **Room:** Employs Room for efficient local data storage.
  - **Hilt:** Utilizes Hilt for dependency injection, reducing boilerplate code and improving testability.
  - **Navigation Graph:** Employs Navigation Graph for managing navigation between app screens.

**Usage:**

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/SyedHaseeb1/Arlib-Apps-Task.git](https://github.com/SyedHaseeb1/Arlib-Apps-Task.git)
    ```
2.  **Open the Project:**
    Open the project in Android Studio.
3.  **Run the App:**
    Build and run the app on an emulator or physical device.
    [Download TEST APK](https://github.com/SyedHaseeb1/Arlib-Apps-Task/blob/main/sample_apk/Arlib_Apps_(Task_Syed_Haseeb)-debug.apk).

##

**Additional Notes:**

By following these guidelines, you can create a well-structured and informative README for your medical information app project.