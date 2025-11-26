<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${empty entry ? 'New Entry' : 'Edit Entry'} - My Journal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>📔 My Journal</h1>
            <p class="subtitle">
                <c:choose>
                    <c:when test="${empty entry}">Create a new journal entry</c:when>
                    <c:otherwise>Edit your journal entry</c:otherwise>
                </c:choose>
            </p>
        </header>

        <nav class="actions">
            <a href="${pageContext.request.contextPath}/journal" class="btn">← Back to List</a>
        </nav>

        <main>
            <form action="${pageContext.request.contextPath}/journal" method="post" class="entry-form">
                <c:choose>
                    <c:when test="${empty entry}">
                        <input type="hidden" name="action" value="insert">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="id" value="${entry.id}">
                    </c:otherwise>
                </c:choose>

                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title" 
                           value="<c:out value='${entry.title}'/>" 
                           placeholder="Enter entry title..." required>
                </div>

                <div class="form-group">
                    <label for="content">Content</label>
                    <textarea id="content" name="content" rows="12" 
                              placeholder="Write your thoughts here..." required><c:out value='${entry.content}'/></textarea>
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">
                        ${empty entry ? '📝 Create Entry' : '💾 Save Changes'}
                    </button>
                    <a href="${pageContext.request.contextPath}/journal" class="btn">Cancel</a>
                </div>
            </form>
        </main>

        <footer>
            <p>&copy; 2024 My Journal System</p>
        </footer>
    </div>
</body>
</html>
