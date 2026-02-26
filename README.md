# 📝 Full Stack To-Do Application

A Full Stack To-Do application built using:

- ⚛️ React (Frontend)
- ☕ Spring Boot (Backend)
- 🗄️ MySQL (Database)

---

# 🚀 Features

- Add Task with Manual ID
- Edit Task (separate page)
- Delete Task
- Mark Task as Completed
- Status color (Pending / Completed)
- REST API integration
- MySQL database persistence

---

# 🖥️ Project Structure

```
todo-fullstack-app
 ┣ frontend   → React Application
 ┗ server     → Spring Boot Application
```

---

# ⚙️ Prerequisites

Make sure you have installed:

- Node.js (v18 or later recommended)
- Java 21
- Maven
- MySQL Server
- Git (optional for cloning)

---

# 🗄️ 1️⃣ Database Setup (MySQL)

### Step 1: Start MySQL server

### Step 2: Create Database

Login to MySQL and run:

```sql
CREATE DATABASE todo_db;
```

---

# ☕ 2️⃣ Run Backend (Spring Boot)

Open terminal and navigate to the server folder:

```bash
cd server
```

### Install dependencies and build:

```bash
mvn clean install
```

### Start the backend server:

```bash
mvn spring-boot:run
```

### If successful, you will see:

```
Tomcat started on port(s): 8080
Started TaskApplication
```

Backend will run on:

```
http://localhost:8080
```

Test API in browser:

```
http://localhost:8080/api/tasks
```

---

# ⚛️ 3️⃣ Run Frontend (React)

Open a new terminal and navigate to frontend folder:

```bash
cd frontend
```

### Install dependencies:

```bash
npm install
```

### Start React development server:

```bash
npm start
```

### If successful, you will see:

```
Compiled successfully!
```

Frontend runs on:

```
http://localhost:3000
```

---

# 🔄 How The Application Works

React (Port 3000)
⬇ API Calls
Spring Boot (Port 8080)
⬇
MySQL Database

---

# 🧪 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/tasks | Get all tasks |
| POST | /api/tasks | Add new task |
| PUT | /api/tasks/{id} | Update task |
| PUT | /api/tasks/{id}/complete | Mark as completed |
| DELETE | /api/tasks/{id} | Delete task |

---

# ❗ Common Issues & Fixes

### 1. Port 8080 already in use
Change port in `application.properties`:

```
server.port=8081
```

### 2. MySQL connection error
Check:

```
spring.datasource.username=root
spring.datasource.password=yourpassword
```

Make sure MySQL is running.

### 3. CORS Error
Ensure `@CrossOrigin(origins = "*")` is added in controller.

---

# 📦 Build For Production

### Build Backend:
```bash
mvn clean package
```

### Build Frontend:
```bash
npm run build
```

---

# 👨‍💻 Author

Mohamud sk

---

# ⭐ Future Improvements

- User Authentication (JWT)
- Search & Filter
- Due Date Feature
- Deploy to Cloud (Render + Vercel)
