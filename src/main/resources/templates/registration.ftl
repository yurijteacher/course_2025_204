<#import "customer/templ_customer.ftl" as p>
<#import "/spring.ftl" as s>

<@p.pages>

    <h2> Registration </h2>


    <@s.bind "users"/>

    <form method="post" action="/registration">
    <label for="username">Username</label>
    <@s.formInput "users.username"/>
    <@s.showErrors "<br>"/><br>

    <label for="password">Password</label>
    <@s.formInput "users.password"/>
    <@s.showErrors "<br>"/><br>

    <@s.bind "customer"/>
        <label for="firstName">firstName</label>
        <@s.formInput "customer.firstName"/>
        <@s.showErrors "<br>"/><br>

        <label for="lastName">lastName</label>
        <@s.formInput "customer.lastName"/>
        <@s.showErrors "<br>"/><br>

        <label for="phone">phone</label>
        <@s.formInput "customer.phone"/>
        <@s.showErrors "<br>"/><br>

        <label for="email">email</label>
        <@s.formInput "customer.email"/>
        <@s.showErrors "<br>"/><br>

        <label for="address">address</label>
        <@s.formInput "customer.address"/>
        <@s.showErrors "<br>"/><br>

        <button type="submit">Add</button>
    </form>
</@p.pages>