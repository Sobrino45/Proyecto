class App {
    constructor() {
        this.init();
    }

    init() {
        this.setupEventListeners();
        this.loadSavedPreferences();
    }

    setupEventListeners() {
        const loginForm = document.getElementById("loginForm");
        if (loginForm) {
            loginForm.addEventListener("submit", (event) => this.handleLoginFormSubmit(event));
        }

        const deleteButtons = document.querySelectorAll(".deleteButton");
        deleteButtons.forEach(button => {
            button.addEventListener("click", () => this.handleDeleteButtonClick(button));
        });

        const themeToggle = document.getElementById("themeToggle");
        if (themeToggle) {
            themeToggle.addEventListener("change", () => this.handleThemeToggle(themeToggle));
        }
    }

    handleLoginFormSubmit(event) {
        event.preventDefault();
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        if (this.validateLoginForm(username, password)) {
            event.target.submit();
        } else {
            alert("Por favor, completa todos los campos correctamente.");
        }
    }

    validateLoginForm(username, password) {
        if (username.trim() === "" || password.trim() === "") {
            return false;
        }
        if (password.length < 6) {
            return false;
        }
        return true;
    }

    handleDeleteButtonClick(button) {
        const listItem = button.parentElement;
        listItem.remove();
    }

    handleThemeToggle(themeToggle) {
        const theme = themeToggle.checked ? "dark" : "light";
        document.body.className = theme;
        this.saveThemePreference(theme);
    }

    saveThemePreference(theme) {
        localStorage.setItem("theme", theme);
    }

    loadSavedPreferences() {
        const savedTheme = localStorage.getItem("theme");
        if (savedTheme) {
            document.body.className = savedTheme;
            const themeToggle = document.getElementById("themeToggle");
            if (themeToggle) {
                themeToggle.checked = savedTheme === "dark";
            }
        }
    }

    loadEvents() {
        const eventList = document.getElementById("eventList");
        if (eventList) {
            fetch("/api/eventos")
                .then(response => response.json())
                .then(data => {
                    data.forEach(evento => {
                        const listItem = document.createElement("li");
                        listItem.textContent = evento.nombre;
                        eventList.appendChild(listItem);
                    });
                })
                .catch(error => console.error("Error al cargar eventos:", error));
        }
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const app = new App();
    app.loadEvents();
});