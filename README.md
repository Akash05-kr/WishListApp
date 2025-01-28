# WishList App

The **WishList App** is a feature-rich Android application developed using **Kotlin** and **Jetpack Compose**. It allows users to create, update, and manage a list of wishes with a clean and intuitive interface. Backed by a robust Room database implementation, the app ensures reliable data persistence. This project is ideal for understanding advanced Android concepts, including MVVM architecture, state management, navigation, and database handling.

---

## Key Features

### 1. **Add a Wish**
- Users can easily add a new wish by providing a title and description.
- Input fields are validated to ensure both title and description are non-empty.

### 2. **View All Wishes**
- Displays all the saved wishes in a scrollable list.
- Uses a `LazyColumn` for optimized rendering of large data sets.

### 3. **Edit a Wish**
- Existing wishes can be updated seamlessly.
- Pre-fills the input fields when editing a wish for better user experience.

### 4. **Delete a Wish**
- Users can delete wishes they no longer need, ensuring a clutter-free list.

### 5. **Navigation**
- Smooth navigation between screens using **Jetpack Navigation**.
- Screens include:
  - Home Screen
  - Add/Edit Wish Screen

### 6. **MVVM Architecture**
- Implements Model-View-ViewModel (MVVM) architecture for separation of concerns.
- ViewModel ensures UI and data logic are decoupled.

### 7. **Room Database**
- Persists user data locally using **Room Database**.
- DAO (Data Access Object) methods handle operations like add, update, delete, and fetch wishes.
- Schema includes:
  - Wish table with `id`, `title`, and `description` fields.

### 8. **Jetpack Compose**
- Fully developed using **Jetpack Compose** for modern UI development.
- Composables include:
  - `AppBarView`: Custom AppBar for navigation.
  - `WishTextField`: Reusable text input fields.

### 9. **Snackbar Notifications**
- Provides instant feedback using **Snackbar** for actions like adding or updating a wish.

### 10. **State Management**
- Utilizes `MutableStateFlow` and `State` for efficient state management.
- Ensures real-time UI updates when the data changes.

---

## Tech Stack

### **Frontend**
- **Kotlin**
- **Jetpack Compose**
- **Material Design Components**

### **Backend**
- **Room Database** for data persistence
- **Coroutines** for background tasks
- **Flow** for reactive programming

### **Architecture**
- **MVVM (Model-View-ViewModel)**

---

## How to Run

1. Clone the repository:
   ```bash
   git clone <https://github.com/Akash05-kr/WishListApp>
   ```

2. Open the project in **Android Studio**.

3. Build the project and ensure all dependencies are installed.

4. Run the app on an emulator or physical device.

---

## Project Structure

### 1. **MainActivity**
- Entry point of the app.
- Sets up Jetpack Compose and initializes navigation.

### 2. **Navigation**
- Manages the navigation graph.
- Handles routes for Home and Add/Edit screens.

### 3. **ViewModel**
- Manages UI-related data in a lifecycle-conscious way.
- Exposes flows for reactive updates.

### 4. **Repository**
- Abstracts the data layer by interacting with the DAO.

### 5. **Room Components**
- **Entity**: `Wish` represents the table schema.
- **DAO**: Handles database queries and updates.
- **Database**: Initializes the Room database.

---

## Future Enhancements

1. **Search Functionality**:
   - Add a search bar to filter wishes based on keywords.

2. **Category Tagging**:
   - Allow users to categorize wishes for better organization.

3. **Cloud Sync**:
   - Integrate cloud storage for multi-device synchronization.

4. **Theming**:
   - Add support for light and dark themes.

---

## License

This project is licensed under the MIT License. 

---

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue to discuss your ideas.

---

## Acknowledgments

- Special thanks to the Android developer community for providing invaluable resources and tutorials.
- Inspiration from various open-source projects and Jetpack Compose documentation.

---

## Contact

For any inquiries or feedback, please reach out to akashchaurasiya5904@gmail.com.

---

Enjoy managing your wishes with the **WishList App**! 🚀

