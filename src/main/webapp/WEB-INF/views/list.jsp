<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Journal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>📔 My Journal</h1>
            <p class="subtitle">Document your thoughts and experiences</p>
        </header>

        <nav class="actions">
            <a href="${pageContext.request.contextPath}/journal?action=new" class="btn btn-primary">
                ✏️ New Entry
            </a>
        </nav>

        <main>
            <c:if test="${empty entries}">
                <div class="empty-state">
                    <p>No journal entries yet. Start writing your first entry!</p>
                </div>
            </c:if>

            <c:if test="${not empty entries}">
                <div class="entries-list">
                    <c:forEach var="entry" items="${entries}">
                        <article class="entry-card">
                            <h2 class="entry-title">
                                <a href="${pageContext.request.contextPath}/journal?action=view&id=${entry.id}">
                                    <c:out value="${entry.title}"/>
                                </a>
                            </h2>
                            <p class="entry-preview">
                                <c:out value="${entry.content.length() > 150 ? entry.content.substring(0, 150).concat('...') : entry.content}"/>
                            </p>
                            <div class="entry-meta">
                                <span class="date">📅 ${entry.formattedCreatedAt}</span>
                                <div class="entry-actions">
                                    <a href="${pageContext.request.contextPath}/journal?action=edit&id=${entry.id}" 
                                       class="btn btn-small">Edit</a>
                                    <a href="${pageContext.request.contextPath}/journal?action=delete&id=${entry.id}" 
                                       class="btn btn-small btn-danger"
                                       onclick="return confirm('Are you sure you want to delete this entry?')">Delete</a>
                                </div>
                            </div>
                        </article>
                    </c:forEach>
                </div>
            </c:if>
        </main>

        <footer>
            <p>&copy; 2024 My Journal System</p>
        </footer>
    </div>
</body>
</html>
