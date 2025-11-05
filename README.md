# 📚 Library Management System

A comprehensive console-based Java application designed to streamline library operations. This system provides efficient management of books, library members, and borrowing activities with persistent data storage.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

---

## ✨ Features

### 📖 Book Management
- Add new books to the library collection
- View all available books with detailed information
- Track book availability status
- Store book details including title, author, and ISBN

### 👥 Member Management
- Register new library members
- Maintain member records with contact information
- View complete member list
- Track member borrowing history

### 🔄 Borrowing System
- Borrow books with automatic availability updates
- Return books with status tracking
- Interface-based borrowable item implementation
- Real-time inventory management

### 💾 Data Persistence
- File-based storage system using `.txt` files
- Automatic data saving and loading
- No database setup required
- Persistent data across application sessions


---

## 🛠️ Technologies & Concepts

| Technology | Purpose |
|------------|---------|
| **Java SE** | Core programming language |
| **File I/O (java.io)** | Data persistence and file handling |
| **OOP Principles** | Inheritance, Encapsulation, Abstraction |
| **Interface Implementation** | Borrowable contract for items |
| **Collections Framework** | Data structure management |

---

## 🚀 Getting Started

### Prerequisites

Before running this application, ensure you have:

- **Java Development Kit (JDK)** 8 or higher installed
- **IntelliJ IDEA** (Community or Ultimate Edition) or any Java IDE
- **Git** for version control (optional)

### Installation & Setup

1. **Clone the repository**
   git clone https://github.com/nabilnko/library-management-system.git
   cd library-management-system

2. **Open in IntelliJ IDEA**
- Launch IntelliJ IDEA
- Select `File` → `Open`
- Navigate to the `librarymanagement` folder
- Click `OK`

3. **Build the project**
- IntelliJ will automatically detect the Java files
- Wait for indexing to complete

4. **Run the application**
- Navigate to `src/librarymanagement/Main.java`
- Right-click on the file
- Select `Run 'Main.main()'`

---

## 📖 How to Use

### Main Menu Options

When you run the application, you'll see this interactive menu:


Library Management System v1.0


Add Book

Add Member

Borrow Book

Return Book

View All Books

View All Members

Exit

Enter your choice:

### Example Workflow

#### Adding a Book
Enter your choice: 1
Enter Book Title: The Great Gatsby
Enter Author Name: F. Scott Fitzgerald
Enter ISBN: 978-0-7432-7356-5
✓ Book added successfully!


#### Registering a Member
Enter your choice: 2
Enter Member Name: John Doe
Enter Email Address: john.doe@email.com
✓ Member registered successfully!


#### Borrowing a Book
Enter your choice: 3
Enter Book ID: 1
Enter Member ID: 1
✓ Book borrowed successfully!


---

## 📁 Data Storage Format

### books.txt
1,The Great Gatsby,F. Scott Fitzgerald,978-0-7432-7356-5,available
2,1984,George Orwell,978-0-452-28423-4,borrowed


### members.txt
1.John Doe,john.doe@email.com
2.Jane Smith,jane.smith@email.com
---

## 🎯 Key Object-Oriented Concepts

### Inheritance Hierarchy
LibraryItem (Abstract Class)
└── Book (Concrete Class)


### Interface Implementation
Borrowable (Interface)
└── Implemented by Book class


### Encapsulation
- Private fields with public getter/setter methods
- Data hiding and controlled access

---

## 🔮 Future Enhancements

- [ ] **Search Functionality**: Find books by title, author, or ISBN
- [ ] **Due Date System**: Track borrowed book return dates
- [ ] **Fine Calculator**: Automatic late fee calculation
- [ ] **Database Integration**: Migrate from file storage to MySQL
- [ ] **GUI Interface**: Develop a JavaFX or Swing interface
- [ ] **Book Categories**: Organize books by genre
- [ ] **Advanced Reporting**: Generate borrowing statistics
- [ ] **Multi-user Support**: Admin and user role separation
- [ ] **Book Reservation**: Allow members to reserve borrowed books
- [ ] **Email Notifications**: Automated reminders for due dates

---

## 🤝 Contributing

Contributions are welcome! If you'd like to improve this project:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Your Name**
- GitHub: [https://github.com/nabilnko](https://github.com/nabilnko)
- Email: nabilnko11@gmail.com

---

## 🙏 Acknowledgments

- Thanks to the Java community for excellent documentation
- Inspired by real-world library management systems
- Built as a learning project to demonstrate OOP principles
