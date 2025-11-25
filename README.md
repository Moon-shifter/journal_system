# Journal System

A simple Java web application for managing personal journal entries.

## Features

- Create, read, update, and delete journal entries
- Clean and responsive user interface
- In-memory storage (entries are reset on server restart)

## Technology Stack

- Java 11
- Servlet API 4.0
- JSP with JSTL
- Maven for build management

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/journal/
│   │       ├── model/          # Data models
│   │       ├── dao/            # Data Access Objects
│   │       └── servlet/        # Servlet controllers
│   └── webapp/
│       ├── WEB-INF/
│       │   ├── views/          # JSP views
│       │   └── web.xml         # Web configuration
│       ├── css/                # Stylesheets
│       └── index.jsp           # Entry point
```

## Build and Run

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- A servlet container (e.g., Apache Tomcat 9+)

### Build

```bash
mvn clean package
```

### Deploy

Copy the generated `target/journal-system-1.0-SNAPSHOT.war` to your servlet container's deployment directory.

For Apache Tomcat:
```bash
cp target/journal-system-1.0-SNAPSHOT.war $CATALINA_HOME/webapps/journal.war
```

Then access the application at: `http://localhost:8080/journal/`

## Usage

1. **View Entries**: The home page displays all journal entries
2. **Create Entry**: Click "New Entry" to create a new journal entry
3. **Edit Entry**: Click "Edit" on any entry to modify it
4. **Delete Entry**: Click "Delete" to remove an entry
5. **View Details**: Click on an entry title to see its full content
