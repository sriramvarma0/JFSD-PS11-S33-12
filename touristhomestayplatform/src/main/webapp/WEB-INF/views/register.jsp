<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h2>Register</h2>
    <form action="/users/register" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br>

        <label>Email:</label>
        <input type="email" name="email" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>
