<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><c:out value="${entry.title}"/> - My Journal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>📔 My Journal</h1>
        </header>

        <nav class="actions">
            <a href="${pageContext.request.contextPath}/journal" class="btn">← Back to List</a>
            <a href="${pageContext.request.contextPath}/journal?action=edit&id=${entry.id}" class="btn btn-primary">✏️ Edit</a>
        </nav>

        <main>
            <article class="entry-detail">
                <h2 class="entry-title"><c:out value="${entry.title}"/></h2>
                
                <div class="entry-meta">
                    <span class="date">📅 Created: ${entry.formattedCreatedAt}</span>
                    <c:if test="${entry.formattedUpdatedAt != entry.formattedCreatedAt}">
                        <span class="date">📝 Updated: ${entry.formattedUpdatedAt}</span>
                    </c:if>
                </div>

                <div class="entry-content">
                    <c:out value="${entry.content}" escapeXml="true"/>
                </div>

                <div class="entry-actions">
                    <form action="${pageContext.request.contextPath}/journal" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${entry.id}">
                        <button type="submit" class="btn btn-danger"
                                onclick="return confirm('Are you sure you want to delete this entry?')">
                            🗑️ Delete Entry
                        </button>
                    </form>
                </div>
            </article>
        </main>

        <footer>
            <p>&copy; 2024 My Journal System</p>
        </footer>
    </div>
</body>
</html>
