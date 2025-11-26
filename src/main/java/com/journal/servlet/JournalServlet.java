package com.journal.servlet;

import com.journal.dao.JournalDAO;
import com.journal.model.JournalEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet controller for managing journal entries.
 * Handles CRUD operations for the journal system.
 */
@WebServlet(urlPatterns = {"/journal", "/journal/*"})
public class JournalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JournalDAO journalDAO;

    @Override
    public void init() throws ServletException {
        journalDAO = JournalDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "view":
                viewEntry(request, response);
                break;
            default:
                listEntries(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            insertEntry(request, response);
        } else if ("update".equals(action)) {
            updateEntry(request, response);
        } else if ("delete".equals(action)) {
            deleteEntry(request, response);
        } else {
            listEntries(request, response);
        }
    }

    private void listEntries(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<JournalEntry> entries = journalDAO.getAllEntries();
        request.setAttribute("entries", entries);
        request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = parseId(request.getParameter("id"));
        if (id == -1) {
            response.sendRedirect(request.getContextPath() + "/journal");
            return;
        }
        JournalEntry entry = journalDAO.getEntryById(id);
        if (entry == null) {
            response.sendRedirect(request.getContextPath() + "/journal");
            return;
        }
        request.setAttribute("entry", entry);
        request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
    }

    private void viewEntry(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = parseId(request.getParameter("id"));
        if (id == -1) {
            response.sendRedirect(request.getContextPath() + "/journal");
            return;
        }
        JournalEntry entry = journalDAO.getEntryById(id);
        if (entry == null) {
            response.sendRedirect(request.getContextPath() + "/journal");
            return;
        }
        request.setAttribute("entry", entry);
        request.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(request, response);
    }

    private void insertEntry(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        JournalEntry entry = new JournalEntry();
        entry.setTitle(title);
        entry.setContent(content);
        journalDAO.addEntry(entry);

        response.sendRedirect(request.getContextPath() + "/journal");
    }

    private void updateEntry(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = parseId(request.getParameter("id"));
        if (id == -1) {
            response.sendRedirect(request.getContextPath() + "/journal");
            return;
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        JournalEntry entry = new JournalEntry();
        entry.setId(id);
        entry.setTitle(title);
        entry.setContent(content);
        journalDAO.updateEntry(entry);

        response.sendRedirect(request.getContextPath() + "/journal");
    }

    private void deleteEntry(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = parseId(request.getParameter("id"));
        if (id != -1) {
            journalDAO.deleteEntry(id);
        }
        response.sendRedirect(request.getContextPath() + "/journal");
    }

    /**
     * Safely parses an ID parameter.
     * @param idParam the ID parameter string
     * @return the parsed ID, or -1 if invalid
     */
    private int parseId(String idParam) {
        if (idParam == null || idParam.isEmpty()) {
            return -1;
        }
        try {
            return Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
