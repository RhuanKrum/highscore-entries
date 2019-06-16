<!DOCTYPE html>
<html>
<head>
    <title>Cities</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>List of highscores</h2>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Score</th>
        </tr>

        <#list highscores as highscore>
            <tr>
                <td>${highscore.id}</td>
                <td>${highscore.name}</td>
                <td>${highscore.score}</td>
            </tr>
        </#list>
    </table>
</body>
</html>