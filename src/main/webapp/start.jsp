<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page import="config.Statements" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
          crossorigin="anonymous"/>
    <title>Andventure</title>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>

<c:set var="questionID" value="${requestScope.questionID}"/>
<c:set var="questionText" value="${requestScope.questionText}"/>
<c:set var="numberOfWins" value="${requestScope.numberOfWins}"/>
<c:set var="numberOfLoses" value="${requestScope.numberOfLoses}"/>

<c:choose>
    <c:when test="${questionID == Statements.PROLOGUE}">
        <h1> Пролог - долгий путь домой</h1>
    </c:when>
    <c:when test="${questionID == Statements.WIN}">
        <h1> ПОБЕДА! </h1>
    </c:when>
    <c:when test="${questionID == Statements.LOSE}">
        <h1> ТЫ ПРОИГРАЛ! </h1>
    </c:when>
    <c:otherwise>
        <h1>Дилемма № ${questionID}</h1>
    </c:otherwise>
</c:choose>

<br/>${questionText}<br/>
<br/>
<form class="form-horizontal">
    <fieldset>
        <legend>Выберите варианты ответа:</legend>
    </fieldset>
</form>


<c:if test="${questionID == Statements.WIN || questionID == Statements.LOSE}">
    <form class="form-horizontal">
        <fieldset>
            <legend>Начать сначала?</legend>
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button name="restart" class="btn btn-primary" onclick="restart();">Старт!</button>
                </div>
            </div>
        </fieldset>
    </form>
</c:if>

<c:if test="${questionID == Statements.PROLOGUE}">
    <form class="form-horizontal">
        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button type="submit" name="id" value="${questionID}" class="btn btn-primary"
                            onclick="location.href='/first'">Начать!
                    </button>
                </div>
            </div>
        </fieldset>
    </form>
</c:if>

<c:forEach var="answer" items="${answers}">
    <form class="form-horizontal">
        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button type="submit" name="id" value="${answer.id}" class="btn btn-primary"
                            onclick="location.href='/first'">${answer.text}</button>

                </div>
            </div>
        </fieldset>
    </form>
</c:forEach>
<br/>
<br/>
<br/>
IP-адресс: <% out.print(request.getRemoteAddr());%>
<br/>
Твоё количество неудач, простофиля: ${numberOfLoses}

<script>
    function restart() {
        $.ajax({
            url: '/restart',
            type: 'POST',
            async: false,
            success: function () {
                location.reload();
            }
        });
    }

    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
    integrity = "sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
    crossorigin = "anonymous"

</script>

</body>
</html>
