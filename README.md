# Book Registration and Management System 📚

A dynamic web application built using **Java**, **JSP**, and **Bootstrap** that allows users to **register, view, update, and delete book records**. The application follows the **MVC architecture**, ensuring a clean separation of concerns for maintainability and scalability.

---

## ✨ Features

- 📖 **Book Registration**: Add new books with details like name, edition, author, genre, and price.
- 📋 **View Registered Books**: Display all registered books in a stylish, responsive table.
- ✏️ **Edit Book Details**: Update information of existing books.
- ❌ **Delete Books**: Remove books from the list effortlessly.
- 🔍 **No Records Found**: Displays a user-friendly message when no books are registered.

---

## 📂 Project Structure

```plaintext
BookShopProject/
│
├── src/
│   ├── com.bookshopproject.Entity/
│   │   └── BookData.java          # Entity class for book details
│   └── com.bookshopproject.Controller/
│       ├── RegisterServlet.java   # Handles book registration
│       ├── ShowDataServlet.java   # Displays all registered books
│       ├── FetchDataServlet.java  # Fetches book data for editing
│       ├── UpdateDataServlet.java # Updates book details
│       └── DeleteDataServlet.java # Deletes a book record
│
├── WebContent/
│   ├── css/
│   │   └── bootstrap.css           # Styling with Bootstrap
│   ├── display.jsp                 # Displays all registered books
│   ├── home.jsp                    # Book registration form
│   └── update.jsp                  # Edit existing book details
│
└── WEB-INF/
    ├── web.xml                     # Servlet mappings and configurations
    └── lib/                        # Required JAR files for the project
```

---

## ⚙️ Tech Stack

- **Frontend**: JSP, HTML, CSS (Bootstrap), JavaScript
- **Backend**: Java (Servlets), JSP
- **Database**: MySQL
- **Server**: Apache Tomcat

---

## 🎨 UI Design Highlights

- 🌈 **Modern Gradient Backgrounds**: Soft pink gradients for an elegant look.
- 🖋 **Stylish Fonts**: 'Quicksand' for content and 'Lobster' for headers.
- 🖱 **Interactive Elements**: Buttons with hover effects and slight animations.
- 📊 **Responsive Table Design**: Displays registered books in a well-structured table with hover effects.

---

## 🚀 Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/bookshopproject.git
   ```

2. **Import the Project**
   - Open **Eclipse** or **IntelliJ IDEA**.
   - Import the project as an **Existing Maven/Java Project**.

3. **Setup Database**
   - Create a MySQL database named `bookshop`.
   - Import the provided `bookshop.sql` file to set up the required tables.
   - Update database configurations in the `RegisterServlet.java` file.

4. **Build and Deploy**
   - Compile the project and deploy it on **Apache Tomcat**.
   - Access the application at `http://localhost:8080/bookshopproject/`.

---

## 📸 Screenshots

### 🎉 Home Page - Book Registration
<img src="screenshots/home.png" alt="Home Page" width="700">

### 📚 Registered Books
<img src="screenshots/display.png" alt="Registered Books" width="700">

### ✏️ Edit Book Details
<img src="screenshots/update.png" alt="Edit Book" width="700">

---

## 🛠️ Configuration Details

- **Database Connection**:
  - Update the connection settings in `RegisterServlet.java`:
    ```java
    String jdbcURL = "jdbc:mysql://localhost:3306/bookshop";
    String jdbcUsername = "root";
    String jdbcPassword = "your-password";
    ```

- **Required Dependencies**:
  - Add the following libraries to the `WEB-INF/lib/` folder:
    - `mysql-connector-java.jar`
    - `servlet-api.jar`
    - `jsp-api.jar`

---

## 📈 Future Enhancements

- 🔐 **User Authentication**: Implement login and registration for users.
- 📊 **Advanced Search Filters**: Allow users to search by genre, author, or price range.
- 📱 **Responsive Design**: Optimize the UI for mobile devices.


---

## 📧 Contact

For any queries or suggestions, feel free to reach out:

- **Email**: pulivathi.paripurnachari@gmail.com
- **LinkedIn**: linkedin.com/in/𝘗𝘢𝘳𝘪𝘱𝘶𝘳𝘯𝘢𝘊𝘩𝘢𝘳𝘪-𝘗𝘶𝘭𝘪𝘷𝘢𝘳𝘵𝘩𝘪-893717250
- **GitHub**: github.com/Paripurnachari284858


---

## ⭐ Acknowledgments

- Special thanks to **Bootstrap** for the responsive and stylish UI components.
- Inspired by modern web application design trends.

---

## 🙏 Support

If you found this project helpful, please ⭐ the repository to show your support! Your feedback and support inspire me to create more awesome projects.

---

🎉 **Happy Coding!** 🎉
