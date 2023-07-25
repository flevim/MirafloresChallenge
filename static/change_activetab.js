$(document).ready(function () {
    // Obtener la URL actual
    var currentURL = window.location.pathname;

    // Remover la clase "is-active" de todos los enlaces
    $(".menu-list-item").removeClass("is-active");

    // Agregar la clase "is-active" al enlace correspondiente
    $("#" + currentURL.replace("/", "")).addClass("is-active");
});