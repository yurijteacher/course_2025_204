<#import "customer/templ_customer.ftl" as c>

<@c.pages>

<h1> ${hello} </h1>

<#if categories??>
    <#list categories as category>
        ${category.name}
    </#list>

</#if>


<h2> Save New Category </h2>

<form method="post" action="saveNewCategory">

    <input type="text" name="name" placeholder="name">
    <input type="text" name="description" placeholder="descr">
    <input type="text" name="image" placeholder="image">

    <input type="submit" value="add">

</form>

</@c.pages>