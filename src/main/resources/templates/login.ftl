<#import "customer/templ_customer.ftl" as p>
<@p.pages>

    <h2> Auth </h2>

    <form action="/login" method="post">

        <label for="username">User</label>
        <input type="text" name="username" placeholder="username"><br>

        <label for="password">Pass</label>
        <input type="text" name="password" placeholder="password"><br>

        <button type="submit">Add</button>

    </form>

    <a href="/registration">Go to Registration</a>

</@p.pages>